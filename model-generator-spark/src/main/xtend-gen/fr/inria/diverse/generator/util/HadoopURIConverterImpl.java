package fr.inria.diverse.generator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class HadoopURIConverterImpl extends ExtensibleURIConverterImpl {
  private Configuration conf;
  
  public HadoopURIConverterImpl(final Configuration _conf) {
    super();
    this.conf = _conf;
  }
  
  @Override
  public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
    try {
      return super.createInputStream(uri, options);
    } catch (final Throwable _t) {
      if (_t instanceof MalformedURLException) {
        final MalformedURLException e = (MalformedURLException)_t;
        String _string = uri.toString();
        final Path path = new Path(_string);
        java.net.URI _uri = path.toUri();
        final FileSystem fileSystem = FileSystem.get(_uri, this.conf);
        return fileSystem.open(path);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException {
    try {
      return super.createOutputStream(uri, options);
    } catch (final Throwable _t) {
      if (_t instanceof MalformedURLException) {
        final MalformedURLException e = (MalformedURLException)_t;
        String _string = uri.toString();
        final Path path = new Path(_string);
        java.net.URI _uri = path.toUri();
        final FileSystem fileSystem = FileSystem.get(_uri, this.conf);
        return fileSystem.create(path);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
