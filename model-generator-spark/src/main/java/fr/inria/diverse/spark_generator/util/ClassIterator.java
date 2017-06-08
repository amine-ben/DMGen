package fr.inria.diverse.spark_generator.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class ClassIterator implements Iterator<String>, Serializable {
	
	/**
	 * default serial version UID
	 */
	private static final long serialVersionUID = 2684290457078570058L;
	private List<String> clazzes;
	int index = 0;
	
	public  ClassIterator(List<String> clazzes) {
		this.clazzes = clazzes;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	/**
	 * Cyclic iterator
	 */
	public String next() {
		if ( index == clazzes.size())
			return clazzes.get(index++);
		else{
			index= 0;
			return next();
		}
	}

}