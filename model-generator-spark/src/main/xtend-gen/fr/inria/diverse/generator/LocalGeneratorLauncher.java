package fr.inria.diverse.generator;

import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

@SuppressWarnings("all")
public class LocalGeneratorLauncher {
  private final static Logger LOGGER = Logger.getLogger(LocalGeneratorLauncher.class);
  
  private Resource dmgenResource;
  
  private Resource metamodelResource;
  
  private String ePackage;
  
  private final ResourceSet rst = new ResourceSetImpl();
  
  public LocalGeneratorLauncher(final URI dmgenURI, final URI metamodelURI, final String epckImpl) {
  }
  
  public Object launch() {
    Object _xblockexpression = null;
    {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      Resource.Factory.Registry _resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
      Map<String, Object> _protocolToFactoryMap = _resourceFactoryRegistry.getProtocolToFactoryMap();
      PersistentResourceFactory _instance = PersistentResourceFactory.getInstance();
      _protocolToFactoryMap.put(HBaseURI.SCHEME, _instance);
      Resource.Factory.Registry _resourceFactoryRegistry_1 = resourceSet.getResourceFactoryRegistry();
      Map<String, Object> _protocolToFactoryMap_1 = _resourceFactoryRegistry_1.getProtocolToFactoryMap();
      PersistentResourceFactory _instance_1 = PersistentResourceFactory.getInstance();
      _xblockexpression = _protocolToFactoryMap_1.put(BlueprintsURI.SCHEME, _instance_1);
    }
    return _xblockexpression;
  }
}
