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

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.hbase.HBasePersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseResourceUtil;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI;
import fr.inria.diverse.generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.generator.util.GenerationException;
import fr.inria.diverse.generator.util.GeneratorUtil;
import fr.inria.diverse.generator.util.VerticesGenToPair;



/**
 * 
 * @author <a href="mailto:abel.gomez-llana@inria.fr">Abel Gomez</a>
 * @author <a href="mailto:amine.benelallam@inria.fr"> Amine Benelallam</a>
 */

public class GenericMetamodelGenerator {
	

	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.LogManager.getLogger("Generator");

	protected String samplesPath;
	
	protected int slices = 6;
	
	protected ISpecimenConfiguration config;

	
	protected final SparkConf sc = new SparkConf().setAppName("Spark EMF models generator").setMaster("local");
	
	protected final JavaSparkContext jsc = new JavaSparkContext(sc);

	public GenericMetamodelGenerator(GenericMetamodelConfig _config) throws IllegalArgumentException {
		
		super();
		config = _config;
		{// Initialize Persistence Factory Registry 
		PersistenceBackendFactoryRegistry.register(HBaseURI.SCHEME, HBasePersistenceBackendFactory.getInstance());
		}
	}
	
	public GenericMetamodelGenerator( IGenerator generator) {
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

			LOGGER.info(MessageFormat.format("Creating {0} model{1} using as generator {2}", numberOfModels, numberOfModels > 1 ? 's' : "", "Spark Model Generator"));
			
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
				
				URI resourceURI = GeneratorUtil.formatURI(samplesPath, getMetaModelResourceName(), i, averageSize);
				
				// deleting the resource if exists 
				HBaseResourceUtil.getInstance().deleteResourceIfExists(resourceURI);
				// creating the resource
				LOGGER.info(MessageFormat.format("Creating model with URI {0} ", resourceURI.toString()));
				Resource resource = resourceSet.createResource(resourceURI);
				resource.load(Collections.EMPTY_MAP);		
				LOGGER.info(MessageFormat.format("Start generation of resource {0} with an average size of {1} elements", 
						resource.getURI(), averageSize));			
				
				//VertexRDD<VD> vertices = 
 				//SerializableConfig configuration  = new SerializableConfig(config);
				JavaRDD<Long> vertices = jsc.parallelize(LongStream
						.rangeClosed(1, slices)
						.boxed()
						.collect(Collectors.toList()), slices);

				long exitCode = vertices.mapPartitions(new VerticesGenToPair (config, averageSize/slices, resource))
						.mapPartitions(new EdgesGen2(config, resource))
						.count();
				
				LOGGER.info(MessageFormat.format("Saving resource {0}", resource.getURI()));
				resource.save(Collections.emptyMap());
				
			} 
			
			LOGGER.info("All resources have been saved");
			
		} catch (IOException e) {
			LOGGER.error(e.getLocalizedMessage());
			throw new GenerationException(e);
			
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());

		}
	}
	
	private String getMetaModelResourceName() {
		return ((EPackage)config.getMetamodelResource().getContents().get(0)).getName();
	}


}
