package fr.inria.diverse.generator.util

import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import org.apache.hadoop.conf.Configuration
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.apache.hadoop.fs.Path
import org.apache.hadoop.fs.FileSystem
import java.net.MalformedURLException
import java.io.IOException
import java.io.OutputStream

class HadoopURIConverterImpl extends ExtensibleURIConverterImpl {
	var Configuration conf
	
	new (Configuration _conf) {
		super()
		conf = _conf
	}
	
	override InputStream createInputStream(URI uri, java.util.Map<?, ?> options) throws IOException {
		try {
			return super.createInputStream(uri, options);
		} catch (MalformedURLException e) {
			val path = new Path(uri.toString());
			val fileSystem = FileSystem.get(path.toUri(), conf);
			return fileSystem.open(path);
		}
	}
	
	override OutputStream createOutputStream (URI uri, java.util.Map<?, ?> options) throws IOException {
		try {
			return super.createOutputStream(uri, options);
		} catch (MalformedURLException e) {
			val path = new Path(uri.toString());
			val fileSystem = FileSystem.get(path.toUri(), conf);
			return fileSystem.create(path); 
		}
	}
}
	