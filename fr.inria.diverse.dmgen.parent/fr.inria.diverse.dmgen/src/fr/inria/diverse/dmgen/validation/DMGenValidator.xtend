/*
 * generated by Xtext 2.10.0
 */
package fr.inria.diverse.dmgen.validation

import fr.inria.diverse.dmgen.dMGen.Clazz
import fr.inria.diverse.dmgen.dMGen.DMGenPackage
import fr.inria.diverse.dmgen.dMGen.Metamodel
import fr.inria.diverse.dmgen.dMGen.Property
import fr.inria.diverse.dmgen.dMGen.URI
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.xtext.validation.Check
import org.eclipse.emf.ecore.EClass

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class DMGenValidator extends AbstractDMGenValidator {
	
	public static val INVALID_NAME = 'invalidName'
	public static val DUPLICATE_CLASS_NAME = 'duplicateClass'
	public static val DUPLICATE_PROPERTY_NAME = 'duplicateProperty'
	public static val CLASS_NOT_FOUND = 'ClassNotFound'
	public static val PROPERTY_NOT_FOUND = 'PropertyNotFound'
	public static val RANGE_NOT_REQUIED = ''

	
	public static Set<EPackage> importedPackages 
	
	@Check 
	def checkPropertyAttributeHasNoRange (Property property) {
		if(property.hasRange && property.isAttributeType)
			error('Attribute types should not have ranges "[a..b]". This range will be ignored!', 
					DMGenPackage.Literals.PROPERTY__RANGE,
					INVALID_NAME)
	}
	
	def hasRange(Property property) {
		return property.range != null 
	}
	
	/**
	 * Checking if class names do not start with Capital
	 */
	@Check
	def checkClassStartsWithCapital(Clazz clazz) {
		if (!Character.isUpperCase(clazz.name.charAt(0))) {
			warning('Name should start with a capital', 
					DMGenPackage.Literals.CLAZZ__NAME,
					INVALID_NAME)
		}
	}
	/**
	 * Checking if class names are not duplicated 
	 */
	@Check
	def checkDuplicateClazzNames(Clazz clazz) {
		
		val allClasses = clazz.eContainer.eGet(DMGenPackage.Literals.GENERATOR__CLASSES) as EList<Clazz>
		
		if (allClasses.filter[clz | clz.name.equals(clazz.name)].size > 1) {
			error('Duplicate class name', 
				DMGenPackage.Literals.CLAZZ__NAME, 
				DUPLICATE_CLASS_NAME
			)
		}
	}
	
	/**
	 * Checking if property names are not duplicated within the same Class
	 */
	@Check 
	def duplicatePropertyName (Property property) {
		val allProperties = property.eContainer.eGet(DMGenPackage.Literals.CLAZZ__PROPERTIES) as EList<Property>
		if (allProperties.filter[prop | prop.name.equals(property.name)].size > 1 ) {
			error('Duplicate property name', 
				DMGenPackage.Literals.PROPERTY__NAME, 
				DUPLICATE_PROPERTY_NAME
			)
		}
	}
	
	/**
	 * Checking if Class name exists in imported metamodel
	 */
	@Check 
	def checkClassNotFound (Clazz clazz) {
		val allClassNames = _importedPackages(clazz).map[ePck |ePck.EClassifiers]
													.flatten
													.map[eCls | eCls.name] as Iterable<String>

		if ( ! allClassNames.exists[str | str.equals(clazz.name)]) {
			error('Unable to find a class with name: '+clazz.name, DMGenPackage.Literals.CLAZZ__NAME, CLASS_NOT_FOUND)
		}
	}
	
	/**
	 * Checking if Property name exists in imported metamodel
	 */
	@Check 
	def checkPropertyNotFound (Property property) {
		val className = property.eGet(DMGenPackage.Literals.CLAZZ__NAME)
		
		val allProperties = _importedPackages(property).map[ePck |ePck.EClassifiers]
													   .flatten
													   .findFirst[eCls | eCls.name.equals(className)]
													   .eGet(DMGenPackage.Literals.CLAZZ__PROPERTIES) as EList<Property>
													   					 				   					
		if ( !allProperties.map[prop | prop.name].contains(property.name)) {
			error('Unable to find a property with name: '+ property.name, 
						DMGenPackage.Literals.PROPERTY__NAME, PROPERTY_NOT_FOUND
			)
		}
	}
	
	def isAttributeType(Property property) {
		val clazzName = (property.eContainer as Clazz).name
		val eClazz = _importedPackages(property).map[ePck |ePck.EClassifiers]
								   .flatten
								   .findFirst[eCls | eCls.name.equals(clazzName)] as EClass
								   
		return eClazz.EAllAttributes.map[eAttr | eAttr.name].contains(property.name)

	}
	/**
	 * Loading the  
	 */
	def _importedPackages(EObject model) {
		if ((importedPackages == null)) {
			var resource = model.eResource
			importedPackages = new HashSet<EPackage>
			resource.allContents
					.filter[e | e instanceof Metamodel]
					.map[e | e as Metamodel]
					.map[m | m.uri]
					.forEach[uri | importedPackages.addAll(loadAllpackagesOfURI(uri))]
			}
		return importedPackages
	}
	/**
	 * 
	 */
	def loadAllpackagesOfURI(URI uri) {
		
		val resourceSet = new ResourceSetImpl();
		{ // initializing the registry
			
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					EcorePackage.eNS_PREFIX, new EcoreResourceFactoryImpl());
		}
		
		val resource = resourceSet.getResource(
			org.eclipse.emf.common.util.URI.createURI(uri.toPrettyString), true);
		
		return resource.allContents.filter[e | e instanceof EPackage].map[pck | pck as EPackage].toList
	}
	/**
	 * 
	 */
	def String toPrettyString(URI uri) {
		var buff = new StringBuffer()
    
	    buff.append(uri.scheme);
	    //buff.append("://");
	    if (! uri.authority.isEmpty) {
	    	buff.append(uri.authority)
	    	buff.append('/')
	    }
	    for (String s : uri.fragments) {	
	    	buff.append(s)
	    	buff.append('/')
	    }
	   var result = buff.toString
	   
	   return result.substring(0, result.length - 1)
	}
	
}
