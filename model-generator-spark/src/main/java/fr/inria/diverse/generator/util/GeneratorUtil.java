package fr.inria.diverse.generator.util;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
/**
 * this class should contain only serializable elements 
 * @author amine
 *
 */
public class GeneratorUtil implements Serializable {
	//TODO adding all abstractions needed to serialize Spark jobs 
	public static List<String> getAllClasseNames () {
		return null;
	}
	public static URI formatURI(String samplesPath, String modelPrefix, long maxElement, int index) {
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

		return URI.createURI(builder.toString());
	}
}
