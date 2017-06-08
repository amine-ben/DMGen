/**
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.ui;

import fr.inria.diverse.dmgen.ui.AbstractDMGenUiModule;
import fr.inria.diverse.dmgen.ui.handlers.RunGenerationHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class DMGenUiModule extends AbstractDMGenUiModule {
  public Class<? extends AbstractHandler> bindAbstractHandler() {
    return RunGenerationHandler.class;
  }
  
  public DMGenUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
