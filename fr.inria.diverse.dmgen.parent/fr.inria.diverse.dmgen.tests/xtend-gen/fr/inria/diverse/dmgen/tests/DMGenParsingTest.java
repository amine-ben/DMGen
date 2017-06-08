/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.tests;

import com.google.inject.Inject;
import fr.inria.diverse.dmgen.dMGen.GenConfig;
import fr.inria.diverse.dmgen.tests.DMGenInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DMGenInjectorProvider.class)
@SuppressWarnings("all")
public class DMGenParsingTest {
  @Inject
  private ParseHelper<GenConfig> parseHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Hello Xtext!");
      _builder.newLine();
      final GenConfig result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
