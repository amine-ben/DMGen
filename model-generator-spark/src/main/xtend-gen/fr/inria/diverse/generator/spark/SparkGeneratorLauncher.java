package fr.inria.diverse.generator.spark;

import com.google.common.base.Objects;
import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import fr.inria.diverse.dmgen.GenConfig;
import fr.inria.diverse.dmgen.Generator;
import fr.inria.diverse.dmgen.impl.DMGenPackageImpl;
import fr.inria.diverse.generator.spark.DMGenMeatamodelGenerator;
import fr.inria.diverse.generator.util.HadoopURIConverterImpl;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
public class SparkGeneratorLauncher {
  private static class OptionComparator<T extends Option> implements Comparator<T> {
    private final String OPTS_ORDER = "hmgpd";
    
    @Override
    public int compare(final T o1, final T o2) {
      String _opt = o1.getOpt();
      int _indexOf = this.OPTS_ORDER.indexOf(_opt);
      String _opt_1 = o2.getOpt();
      int _indexOf_1 = this.OPTS_ORDER.indexOf(_opt_1);
      return (_indexOf - _indexOf_1);
    }
  }
  
  private final static Logger LOGGER = Logger.getLogger(SparkGeneratorLauncher.class);
  
  private final static String HDFS_MASTER = "h";
  
  private final static String METAMODEL_URL = "m";
  
  private final static String DMGEN_URL = "g";
  
  private final static String E_PACKAGE_CLASS = "p";
  
  private final static String HBASE_MASTER = "b";
  
  private final static String HDFS_MASTER_LONG = "hdfs-master";
  
  private final static String METAMODEL_URL_LONG = "metamodel-url";
  
  private final static String DMGEN_URL_LONG = "dmgen-url";
  
  private final static String E_PACKAGE_CLASS_LONG = "package";
  
  private final static String HBASE_MASTER_LONG = "hbase-master";
  
  private String ePackage;
  
  private Resource dmgenResource;
  
  private Resource metamodelResource;
  
  private String hbaseMaster;
  
  private String hdfsMaster;
  
  private Configuration fsConfiguration;
  
  /**
   * main method
   */
  public void main(final String... args) {
    try {
      final Options options = this.configureOptions();
      final GnuParser parser = new GnuParser();
      final CommandLine commandLine = parser.parse(options, args);
      String _optionValue = commandLine.getOptionValue(SparkGeneratorLauncher.HDFS_MASTER);
      this.hdfsMaster = _optionValue;
      boolean _contains = this.hdfsMaster.contains("hdfs");
      boolean _not = (!_contains);
      if (_not) {
        String _format = MessageFormat.format("Malformed URL {0}", this.hdfsMaster);
        throw new ParseException(_format);
      }
      Configuration _configuration = new Configuration();
      this.fsConfiguration = _configuration;
      this.fsConfiguration.set("fs.defaultFS", this.hdfsMaster);
      String _name = DistributedFileSystem.class.getName();
      this.fsConfiguration.set("fs.hdfs.impl", _name);
      String _name_1 = LocalFileSystem.class.getName();
      this.fsConfiguration.set("fs.file.impl", _name_1);
      this.fsConfiguration.set("dfs.permissions.enabled", "false");
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
                return new HadoopURIConverterImpl(SparkGeneratorLauncher.this.fsConfiguration);
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
                return new HadoopURIConverterImpl(SparkGeneratorLauncher.this.fsConfiguration);
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
      String _optionValue_1 = commandLine.getOptionValue(SparkGeneratorLauncher.E_PACKAGE_CLASS);
      this.ePackage = _optionValue_1;
      String metamodelUrl = commandLine.getOptionValue(SparkGeneratorLauncher.METAMODEL_URL);
      SparkGeneratorLauncher.LOGGER.info("Start loading the packages");
      if (((!Objects.equal(this.ePackage, null)) && (!this.ePackage.isEmpty()))) {
        ClassLoader _classLoader = SparkGeneratorLauncher.class.getClassLoader();
        final Class<?> clazz = _classLoader.loadClass(this.ePackage);
        Method _method = clazz.getMethod("init");
        _method.invoke(null);
      }
      if (((!Objects.equal(metamodelUrl, null)) && (!metamodelUrl.isEmpty()))) {
        URI _createURI = URI.createURI(metamodelUrl);
        Resource _resource = resourceSet.getResource(_createURI, true);
        this.metamodelResource = _resource;
      }
      SparkGeneratorLauncher.LOGGER.info("Finish loading the packages");
      String _optionValue_2 = commandLine.getOptionValue(SparkGeneratorLauncher.HBASE_MASTER);
      this.hbaseMaster = _optionValue_2;
      String dmgenUrl = commandLine.getOptionValue(SparkGeneratorLauncher.DMGEN_URL);
      if (((!Objects.equal(dmgenUrl, null)) && (!dmgenUrl.isEmpty()))) {
        DMGenPackageImpl.init();
        URI _createURI_1 = URI.createURI(dmgenUrl);
        Resource _resource_1 = resourceSet.getResource(_createURI_1, true);
        this.dmgenResource = _resource_1;
      }
      EList<EObject> _contents = this.dmgenResource.getContents();
      EObject _get = _contents.get(0);
      final EList<Generator> generators = ((GenConfig) _get).getGenerators();
      final int numberOfNodes = 0;
      final Consumer<Generator> _function = (Generator gen) -> {
        DMGenMeatamodelGenerator _dMGenMeatamodelGenerator = new DMGenMeatamodelGenerator(gen, 
          this.hbaseMaster, 
          this.metamodelResource, numberOfNodes);
        _dMGenMeatamodelGenerator.launch(resourceSet);
      };
      generators.forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Configures the program options
   * returns {@link Options} the CLI options
   */
  public Options configureOptions() {
    final Options options = new Options();
    final Option metamodel = OptionBuilder.create(SparkGeneratorLauncher.METAMODEL_URL);
    metamodel.setLongOpt(SparkGeneratorLauncher.METAMODEL_URL_LONG);
    metamodel.setArgName("the URL of the imported metamodel");
    metamodel.setDescription("The metamodel should be stored in HDFS (hdfs://)");
    metamodel.setArgs(1);
    metamodel.setRequired(true);
    final Option hbase = OptionBuilder.create(SparkGeneratorLauncher.HBASE_MASTER);
    hbase.setLongOpt(SparkGeneratorLauncher.HBASE_MASTER_LONG);
    hbase.setArgName("the base url of the Zookeeper in HBase. Used to Read/write from NeoEMF/Hbase");
    hbase.setDescription("the base url of Zookeeper. Comes in the form hostname:port");
    hbase.setArgs(1);
    hbase.setRequired(true);
    final Option hdfs = OptionBuilder.create(SparkGeneratorLauncher.HDFS_MASTER);
    hdfs.setLongOpt(SparkGeneratorLauncher.HDFS_MASTER_LONG);
    hdfs.setArgName("the hostname and port number of HDFS Namenode");
    hdfs.setDescription("Comes in the form (hdfs://hostname:port)");
    hdfs.setArgs(1);
    hdfs.setRequired(true);
    final Option dmgen = OptionBuilder.create(SparkGeneratorLauncher.DMGEN_URL);
    dmgen.setLongOpt(SparkGeneratorLauncher.DMGEN_URL_LONG);
    dmgen.setArgName("The URL of the dmgen module.");
    dmgen.setDescription("The metamodel should be stored in HDFS (hdfs://) on beforehand");
    dmgen.setArgs(1);
    dmgen.setRequired(true);
    final Option package_ = OptionBuilder.create(SparkGeneratorLauncher.E_PACKAGE_CLASS);
    package_.setLongOpt(SparkGeneratorLauncher.E_PACKAGE_CLASS_LONG);
    package_.setArgName("The package implementation corresponding to the imported metamodel");
    package_.setDescription("com.exmple.ecore.packageImpl");
    package_.setArgs(1);
    package_.setRequired(true);
    options.addOption(package_);
    options.addOption(dmgen);
    options.addOption(hdfs);
    options.addOption(hbase);
    options.addOption(metamodel);
    return options;
  }
}
