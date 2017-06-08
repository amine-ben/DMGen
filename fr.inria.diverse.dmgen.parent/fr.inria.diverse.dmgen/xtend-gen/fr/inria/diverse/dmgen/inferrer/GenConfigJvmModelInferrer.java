package fr.inria.diverse.dmgen.inferrer;

import fr.inria.diverse.dmgen.dMGen.GenConfig;
import java.util.Arrays;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GenConfigJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final GenConfig generator, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    Resource _eResource = generator.eResource();
    URI _uRI = _eResource.getURI();
    URI _trimFileExtension = _uRI.trimFileExtension();
    final String className = _trimFileExtension.lastSegment();
    JvmGenericType _class = this._jvmTypesBuilder.toClass(generator, className);
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmMember> _members = it.getMembers();
      JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(Void.TYPE);
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmTypeReference _typeRef_1 = this._typeReferenceBuilder.typeRef(String.class);
        JvmTypeReference _addArrayTypeDimension = this._jvmTypesBuilder.addArrayTypeDimension(_typeRef_1);
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(generator, "args", _addArrayTypeDimension);
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        it_1.setStatic(true);
        it_1.setVarArgs(true);
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(generator, "main", _typeRef, _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    };
    acceptor.<JvmGenericType>accept(_class, _function);
  }
  
  public void infer(final EObject generator, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (generator instanceof GenConfig) {
      _infer((GenConfig)generator, acceptor, isPreIndexingPhase);
      return;
    } else if (generator != null) {
      _infer(generator, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(generator, acceptor, isPreIndexingPhase).toString());
    }
  }
}
