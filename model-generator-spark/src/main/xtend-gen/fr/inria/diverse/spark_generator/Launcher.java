package fr.inria.diverse.spark_generator;

import com.google.common.base.Objects;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import fr.inria.diverse.spark_generator.util.HadoopURIConverterImpl;
import java.util.Map;
import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Launcher {
  private final static Logger LOGGER = Logger.getLogger(Launcher.class);
  
  private final static String HDFS_MASTER = "hdfs-master";
  
  private final static String METAMODEL_URL = "metamodel-url";
  
  private final static String DMGEN_URL = "dmgen-url";
  
  private final static String E_PACKAGE_CLASS = "package";
  
  private final static String HBASE_MASTER = "hbase-master";
  
  private Configuration conf;
  
  public Object main(final String... args) {
    Object _xblockexpression = null;
    {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      {
        Resource.Factory.Registry _resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
        Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
        _extensionToFactoryMap.put(
          EcorePackage.eNS_PREFIX, new EcoreResourceFactoryImpl() {
          @Override
          public Resource createResource(final URI uri) {
            final XMIResourceImpl result = new XMIResourceImpl(uri) {
              @Override
              public boolean useIDs() {
                return ((!Objects.equal(this.eObjectToIDMap, null)) || (!Objects.equal(this.idToEObjectMap, null)));
              }
              
              @Override
              public URIConverter getURIConverter() {
                return new HadoopURIConverterImpl(Launcher.this.conf);
              }
            };
            result.setEncoding("UTF-8");
            Map<Object, Object> _defaultSaveOptions = result.getDefaultSaveOptions();
            _defaultSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
            Map<Object, Object> _defaultSaveOptions_1 = result.getDefaultSaveOptions();
            _defaultSaveOptions_1.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(80));
            Map<Object, Object> _defaultSaveOptions_2 = result.getDefaultSaveOptions();
            URIHandlerImpl.PlatformSchemeAware _platformSchemeAware = new URIHandlerImpl.PlatformSchemeAware();
            _defaultSaveOptions_2.put(XMLResource.OPTION_URI_HANDLER, _platformSchemeAware);
            return result;
          }
        });
        Resource.Factory.Registry _resourceFactoryRegistry_1 = resourceSet.getResourceFactoryRegistry();
        Map<String, Object> _extensionToFactoryMap_1 = _resourceFactoryRegistry_1.getExtensionToFactoryMap();
        _extensionToFactoryMap_1.put(
          Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl() {
          @Override
          public Resource createResource(final URI uri) {
            return new XMIResourceImpl(uri) {
              @Override
              public URIConverter getURIConverter() {
                return new HadoopURIConverterImpl(Launcher.this.conf);
              }
            };
          }
        });
        Resource.Factory.Registry _resourceFactoryRegistry_2 = resourceSet.getResourceFactoryRegistry();
        Map<String, Object> _protocolToFactoryMap = _resourceFactoryRegistry_2.getProtocolToFactoryMap();
        PersistentResourceFactory _instance = PersistentResourceFactory.getInstance();
        _protocolToFactoryMap.put(
          HBaseURI.SCHEME, _instance);
      }
      Object _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = null;
      } catch (final Throwable _t) {
        if (_t instanceof ClassNotFoundException) {
          final ClassNotFoundException e = (ClassNotFoundException)_t;
          String _message = e.getMessage();
          Launcher.LOGGER.error(_message, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
