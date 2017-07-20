package fr.inria.diverse.spark_generator;

import fr.inria.atlanmod.neoemf.data.hbase.util.HBaseResourceUtil;
import fr.inria.diverse.dmgen.Generator;
import fr.inria.diverse.spark_generator.DMGenGenerationConfig;
import fr.inria.diverse.spark_generator.EdgesGen2;
import fr.inria.diverse.spark_generator.IGenerator;
import fr.inria.diverse.spark_generator.VerticesGenToPair;
import fr.inria.diverse.spark_generator.specimen.ISpecimenConfiguration;
import fr.inria.diverse.spark_generator.util.GenerationException;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.Range;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class DMGenMeatamodelGenerator implements IGenerator {
  private final static Logger LOGGER = LogManager.getLogger("Generator");
  
  private final SparkConf sc = new SparkConf().setAppName("Spark EMF models generator");
  
  protected final JavaSparkContext jsc = new JavaSparkContext(this.sc);
  
  private String hbaseMaster;
  
  private Generator generator;
  
  private Resource metamodel;
  
  private ISpecimenConfiguration config;
  
  private int numberOfNodes;
  
  public DMGenMeatamodelGenerator(final Generator generator, final String hbaseMaster, final Resource metamodel, final int numberOfNodes) {
    super();
    this.generator = generator;
    this.hbaseMaster = hbaseMaster;
    this.metamodel = metamodel;
    this.numberOfNodes = numberOfNodes;
    Range<Integer> _between = Range.<Integer>between(Integer.valueOf(0), Integer.valueOf(IGenerator.DEFAULT_PROPERTIES_RANGE));
    long _seed = this.getSeed(generator);
    DMGenGenerationConfig _dMGenGenerationConfig = new DMGenGenerationConfig(metamodel, generator, _between, _seed);
    this.config = _dMGenGenerationConfig;
  }
  
  public long getSeed(final Generator generator) {
    Random _random = new Random();
    return _random.nextLong();
  }
  
  public void launch(final ResourceSet rs) {
    for (int i = 0; (i < this.generator.getNumber()); i++) {
      {
        final URI uri = this.formatURI(i);
        final Resource resource = rs.createResource(uri);
        this.generate(resource);
      }
    }
  }
  
  public URI formatURI(final int index) {
    final StringBuilder builder = new StringBuilder();
    String _prefix = this.generator.getPrefix();
    builder.append(_prefix);
    builder.append(File.separator);
    builder.append("model");
    int _size = this.generator.getSize();
    builder.append(_size);
    builder.append(File.separator);
    builder.append("gen");
    int _size_1 = this.generator.getSize();
    builder.append(_size_1);
    builder.append("_");
    builder.append(index);
    String _string = builder.toString();
    return URI.createURI(_string);
  }
  
  @Override
  public void generate(final Resource resource) {
    try {
      try {
        int _number = this.generator.getNumber();
        String _xifexpression = null;
        int _number_1 = this.generator.getNumber();
        boolean _greaterThan = (_number_1 > 1);
        if (_greaterThan) {
          _xifexpression = "s";
        } else {
          _xifexpression = "";
        }
        String _format = MessageFormat.format("Creating {0} model{1} using as generator {2}", Integer.valueOf(_number), _xifexpression, 
          "Spark Model Generator");
        DMGenMeatamodelGenerator.LOGGER.info(_format);
        long _seed = this.config.getSeed();
        String _format_1 = MessageFormat.format("Generator seed is \'\'{0}\'\'", Long.valueOf(_seed));
        DMGenMeatamodelGenerator.LOGGER.info(_format_1);
        Range<Integer> _elementsRange = this.config.getElementsRange();
        Integer _minimum = _elementsRange.getMinimum();
        Range<Integer> _elementsRange_1 = this.config.getElementsRange();
        Integer _maximum = _elementsRange_1.getMaximum();
        String _format_2 = MessageFormat.format("Config parameters: range for models size is [{0}, {1}]", _minimum, _maximum);
        DMGenMeatamodelGenerator.LOGGER.info(_format_2);
        Range<Integer> _propertiesRange = this.config.getPropertiesRange();
        Integer _minimum_1 = _propertiesRange.getMinimum();
        Range<Integer> _propertiesRange_1 = this.config.getPropertiesRange();
        Integer _maximum_1 = _propertiesRange_1.getMaximum();
        String _format_3 = MessageFormat.format("Config parameters: range for properties number is [{0}, {1}]", _minimum_1, _maximum_1);
        DMGenMeatamodelGenerator.LOGGER.info(_format_3);
        Range<Integer> _referencesRange = this.config.getReferencesRange();
        Integer _minimum_2 = _referencesRange.getMinimum();
        Range<Integer> _referencesRange_1 = this.config.getReferencesRange();
        Integer _maximum_2 = _referencesRange_1.getMaximum();
        String _format_4 = MessageFormat.format("Config parameters: range for references number is [{0}, {1}]", _minimum_2, _maximum_2);
        DMGenMeatamodelGenerator.LOGGER.info(_format_4);
        Range<Integer> _valuesRange = this.config.getValuesRange();
        Integer _minimum_3 = _valuesRange.getMinimum();
        Range<Integer> _valuesRange_1 = this.config.getValuesRange();
        Integer _maximum_3 = _valuesRange_1.getMaximum();
        String _format_5 = MessageFormat.format("Config parameters: range for values length is [{0}, {1}]", _minimum_3, _maximum_3);
        DMGenMeatamodelGenerator.LOGGER.info(_format_5);
        HBaseResourceUtil _instance = HBaseResourceUtil.getInstance();
        URI _uRI = resource.getURI();
        _instance.deleteResourceIfExists(_uRI);
        URI _uRI_1 = resource.getURI();
        String _string = _uRI_1.toString();
        String _format_6 = MessageFormat.format("Creating model with URI {0} ", _string);
        DMGenMeatamodelGenerator.LOGGER.info(_format_6);
        resource.load(Collections.EMPTY_MAP);
        URI _uRI_2 = resource.getURI();
        int _size = this.generator.getSize();
        String _format_7 = MessageFormat.format("Start generation of resource {0} with an average size of {1} elements", _uRI_2, Integer.valueOf(_size));
        DMGenMeatamodelGenerator.LOGGER.info(_format_7);
        LongStream _rangeClosed = LongStream.rangeClosed(1, this.numberOfNodes);
        Stream<Long> _boxed = _rangeClosed.boxed();
        Collector<Long, ?, List<Long>> _list = Collectors.<Long>toList();
        List<Long> _collect = _boxed.collect(_list);
        JavaRDD<Long> _parallelize = this.jsc.<Long>parallelize(_collect, this.numberOfNodes);
        final JavaRDD<Long> vertices = ((JavaRDD<Long>) _parallelize);
        int _size_1 = this.generator.getSize();
        int _divide = (_size_1 / this.numberOfNodes);
        VerticesGenToPair _verticesGenToPair = new VerticesGenToPair(this.config, _divide, resource);
        JavaRDD<String> _mapPartitions = vertices.<String>mapPartitions(_verticesGenToPair);
        EdgesGen2 _edgesGen2 = new EdgesGen2(this.config, resource);
        JavaRDD<Boolean> _mapPartitions_1 = _mapPartitions.<Boolean>mapPartitions(_edgesGen2);
        final long exitCode = _mapPartitions_1.count();
        URI _uRI_3 = resource.getURI();
        String _format_8 = MessageFormat.format("Saving resource {0}", _uRI_3);
        DMGenMeatamodelGenerator.LOGGER.info(_format_8);
        Map<Object, Object> _emptyMap = Collections.<Object, Object>emptyMap();
        resource.save(_emptyMap);
        DMGenMeatamodelGenerator.LOGGER.info("All resources have been saved");
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          String _localizedMessage = e.getLocalizedMessage();
          DMGenMeatamodelGenerator.LOGGER.error(_localizedMessage);
          throw new GenerationException(e);
        } else if (_t instanceof Exception) {
          final Exception e_1 = (Exception)_t;
          String _localizedMessage_1 = e_1.getLocalizedMessage();
          DMGenMeatamodelGenerator.LOGGER.error(_localizedMessage_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public ISpecimenConfiguration getConfig() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
