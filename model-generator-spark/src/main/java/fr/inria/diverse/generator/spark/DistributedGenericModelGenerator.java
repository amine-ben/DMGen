/*******************************************************************************
 * Copyright (c) 2015 Abel Gomez (AtlanMod) 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Abel Gomez (AtlanMod) - Additional modifications
 *     Amine Benelallam (AtlanMod) - Additional modifications      
 *******************************************************************************/

package fr.inria.diverse.generator.spark;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.logging.Logger;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.berkeleydb.BerkeleyDbPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.berkeleydb.util.BerkeleyDbURI;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.data.hbase.HBasePersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseResourceUtil;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI;
import fr.inria.atlanmod.neoemf.data.mapdb.MapDbPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.mapdb.util.MapDbURI;
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.generator.util.GenerationException;


/**
 * 
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <a href="mailto:amine.benelallam@inria.fr"> Amine Benelallam</a>
 *
 */
public class DistributedGenericModelGenerator {
	
	private final static Logger LOGGER = Logger.getLogger(DistributedGenericModelGenerator.class.getName());

	protected String samplesPath;
	
	protected ISpecimenConfiguration config;

	protected IGenerator generator;
	
	protected final SparkConf sc = new SparkConf().setAppName("Spark EMF models generator");
	
	protected final JavaSparkContext jsc = new JavaSparkContext(sc);
	
	public DistributedGenericModelGenerator(GenericMetamodelConfig config) throws IllegalArgumentException {
		
		super();
		this.config = config;
		this.generator = new DirectWriteSpecimenGenerator(config, config.getSeed());
		PersistenceBackendFactoryRegistry.register(HBaseURI.SCHEME, HBasePersistenceBackendFactory.getInstance());
		PersistenceBackendFactoryRegistry.register(BerkeleyDbURI.SCHEME, BerkeleyDbPersistenceBackendFactory.getInstance());
		PersistenceBackendFactoryRegistry.register(MapDbURI.SCHEME, MapDbPersistenceBackendFactory.getInstance());
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME, BlueprintsPersistenceBackendFactory.getInstance());

	}
	
	public DistributedGenericModelGenerator( IGenerator generator) {
		this.generator = generator;
		this.config = generator.getConfig();
	}
	
	public String getSamplesPath() {
		return samplesPath;
	}
	
	public void setSamplesPath(String samplesPath) {
		this.samplesPath = samplesPath;
	}
	
	public void runGeneration(ResourceSet resourceSet, int numberOfModels, int averageSize, float variation) throws GenerationException {
		
		try {
			LOGGER.info(MessageFormat.format("Creating {0} model{1} using as generator {2}", numberOfModels, numberOfModels > 1 ? 's' : "", generator.getClass().getName()));
			
			LOGGER.info(MessageFormat.format("Generator seed is ''{0}''", config.getSeed()));
			LOGGER.info(MessageFormat.format("Config parameters: range for models size is [{0}, {1}]", 
					config.getElementsRange().getMinimum(), config.getElementsRange().getMaximum()));
			LOGGER.info(MessageFormat.format("Config parameters: range for properties number is [{0}, {1}]", 
					config.getPropertiesRange().getMinimum(), config.getPropertiesRange().getMaximum()));
			LOGGER.info(MessageFormat.format("Config parameters: range for references number is [{0}, {1}]", 
					config.getReferencesRange().getMinimum(), config.getReferencesRange().getMaximum()));
			LOGGER.info(MessageFormat.format("Config parameters: range for values length is [{0}, {1}]", 
					config.getValuesRange().getMinimum(), config.getValuesRange().getMaximum()));
			
			for (int i = 0; i < numberOfModels; i++) {
				URI resourceURI = formatURI(getMetaModelResourceName(), i, averageSize);
				
				// deleting the resource is exists 
				HBaseResourceUtil.getInstance().deleteResourceIfExists(resourceURI);
				// creating the resource
				LOGGER.info(MessageFormat.format("Creating model with URI {0} ", resourceURI.toString()));
				Resource resource = resourceSet.createResource(resourceURI);
				resource.load(Collections.EMPTY_MAP);		
				LOGGER.info(MessageFormat.format("Start generation of resource {0} with an average size of {1} elements", 
						resource.getURI(), averageSize));
				
				generator.generate(resource);
			} 
			for (Resource resource :  resourceSet.getResources()) {
				if (resource.isModified()) {
					LOGGER.info(MessageFormat.format("Saving resource {0}", resource.getURI()));
					resource.save(Collections.emptyMap());
				}
			}
			LOGGER.info("All resources have been saved");
		} catch (IOException e) {
			LOGGER.severe(e.getLocalizedMessage());
			throw new GenerationException(e);
		} catch (Exception e) {
			LOGGER.severe(e.getLocalizedMessage());

		}
	}
	


	private String getMetaModelResourceName() {
//		URI metamodelURI = config.getMetamodelResource().getURI();
//		return metamodelURI.lastSegment().substring(0, metamodelURI.lastSegment().indexOf("."));
		return ((EPackage)config.getMetamodelResource().getContents().get(0)).getName();
	}

	protected URI formatURI(String modelPrefix, long maxElement, int index) {
		StringBuilder builder = new StringBuilder();
		builder.append(samplesPath);
		if (builder.charAt(builder.length()-1) != File.separatorChar) { 
		builder.append(File.separator);
		}
		builder.append(modelPrefix);
		builder.append(File.separator);
		builder.append("model");
		builder.append(maxElement);
		builder.append(File.separator);
		builder.append("gen");
		builder.append(maxElement);
		builder.append("_");
		builder.append(index);
//		builder.append(".");
//		builder.append(XMIResource.XMI_NS);;
		return URI.createURI(builder.toString());
	}

}
