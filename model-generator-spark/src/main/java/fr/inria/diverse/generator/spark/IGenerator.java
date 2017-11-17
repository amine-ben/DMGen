package fr.inria.diverse.spark_generator;

import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;


public interface IGenerator {
	/**
	 * Default Properties Range
	 */
	static final int DEFAULT_PROPERTIES_RANGE = 8;
	/**
	 * Default Class Depth
	 */
	static final int DEFAULT_CLASS_DEPTH = 6;
	/**
	 * 
	 * Runs the genaration of a specific model ad stores in the specified resource {@code rsc}
	 * @param rsc
	 */
	public  void generate (Resource rsc);
	
	/**
	 * Returns the a SpecimenConfiguration
	 * @return
	 */
	public ISpecimenConfiguration getConfig();
}
