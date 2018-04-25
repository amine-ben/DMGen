package fr.inria.diverse.engine.generator.util;

import java.io.Serializable;

public class Edge implements Serializable {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 8482759375138687323L;
	
	/**
	 * Source element UID
	 */
	private long source;
	/**
	 * Target element UID
	 */
	private long target;
	
	/**
	 * The class name {@link String}
	 */
	private String clazz;
	/**
	 * The feature name
	 */
	private String feature;
	
	
	/**
	 * Default constructor
	 */
	public Edge() {
		super();
	}
	/**
	 * Full constructor
	 * @param source
	 * @param target
	 * @param clazz
	 * @param feature
	 */
	public Edge(long source, long target, String clazz, String feature) {
		super();
		this.source = source;
		this.target = target;
		this.clazz = clazz;
		this.feature = feature;
	}
	
	
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
