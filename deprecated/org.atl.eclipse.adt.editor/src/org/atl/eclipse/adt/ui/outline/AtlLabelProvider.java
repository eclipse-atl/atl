/*
 * Created on 14 avr. 2004
 */
package org.atl.eclipse.adt.ui.outline;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.eclipse.adt.ui.AtlUIPlugin;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;




/**
 * @author idrissi
 * 
 */
public class AtlLabelProvider extends LabelProvider {
	private boolean initialized = false;
	
	private Map readers = new HashMap();
	private Map imageCache = new HashMap();
	private Map classToImages = new HashMap();
	  
	  	 
	  
	  private Reader defaultReader = new Reader() {
	  	public String getText(EObject object) {
	  		return "<default> : " + object.eClass().getName();
	  	}
	  };
	  
	  private abstract class Reader {	  	
	  	
	  	public abstract String getText(EObject rule);
	  }
	  
	  public AtlLabelProvider() {
	  	initForImages();
	  }
	  
	  public void initReaders() {
	  	readers.put(AtlEMFConstants.clRule, new Reader() {
	  		private EStructuralFeature name = AtlEMFConstants.clRule.getEStructuralFeature("name");
	  		
	  		public String getText(EObject rule) {
	  			return (String)rule.eGet(name);
	  		}
	  	});
	  	readers.put(AtlEMFConstants.clMatchedRule, readers.get(AtlEMFConstants.clRule));
	  	readers.put(AtlEMFConstants.clCalledRule, readers.get(AtlEMFConstants.clRule));
	  	
	  	readers.put(AtlEMFConstants.clHelper, new Reader() {
	  		private EStructuralFeature sfFeature = AtlEMFConstants.clOclFeatureDefinition.getEStructuralFeature("feature");
	  		private EStructuralFeature sfName = AtlEMFConstants.clOclFeature.getEStructuralFeature("name");
	  		
	  		public String getText(EObject helper) {
	  			EObject featureDef = (EObject)helper.eGet(AtlEMFConstants.sfHelper_definition);
	  			EObject feature = (EObject)featureDef.eGet(sfFeature);
	  			return (String)feature.eGet(sfName);	  			
	  		}
	  	});
	  	
	  	readers.put(AtlEMFConstants.clLibraryRef, new Reader() {
	  		private EStructuralFeature sfName = AtlEMFConstants.clLibraryRef.getEStructuralFeature("name");
	  		
	  		public String getText(EObject libraryRef) {
	  			return (String)libraryRef.eGet(sfName);
	  		}
	  	});
	  	
	  	readers.put(AtlEMFConstants.clOclModel, new Reader() {
	  		private EStructuralFeature sfName = AtlEMFConstants.clOclModel.getEStructuralFeature("name");
	  		
	  		public String getText(EObject oclModel) {
	  			return (String)oclModel.eGet(sfName);
	  		}
	  	});
	  	
	  	readers.put(AtlEMFConstants.clVariableDeclaration, new Reader() {
	  		private EStructuralFeature sfVarName = AtlEMFConstants.clVariableDeclaration.getEStructuralFeature("varName");
	  		
			public String getText(EObject variableDeclaration) {
				return (String)variableDeclaration.eGet(sfVarName);
			}
	  	});
	  	
	  	readers.put(AtlEMFConstants.clUnit, new Reader() {
	  		private EStructuralFeature sfName = AtlEMFConstants.clUnit.getEStructuralFeature("name");
	  		
	  		public String getText(EObject unit) {
	  			return (String)unit.eGet(sfName);
	  		}
	  	});
	  	readers.put(AtlEMFConstants.clModule, readers.get(AtlEMFConstants.clUnit));
	  	readers.put(AtlEMFConstants.clLibrary, readers.get(AtlEMFConstants.clUnit));
	  	readers.put(AtlEMFConstants.clQuery, readers.get(AtlEMFConstants.clUnit));
	  	
	  	readers.put(AtlEMFConstants.clVariableDeclaration, new Reader() {		 
	  		public String getText(EObject rule) {
	  			return (String) rule.eGet(AtlEMFConstants.sfVarName);
	  		}
	  	}); 
	  	
	  	readers.put(AtlEMFConstants.clPatternElement, readers.get(AtlEMFConstants.clVariableDeclaration));
	  	readers.put(AtlEMFConstants.clRuleVariableDeclaration, readers.get(AtlEMFConstants.clVariableDeclaration));
	  	readers.put(AtlEMFConstants.clParameter, readers.get(AtlEMFConstants.clVariableDeclaration));
	  	readers.put(AtlEMFConstants.clInPatternElement, readers.get(AtlEMFConstants.clPatternElement));
	  	readers.put(AtlEMFConstants.clSimpleInPatternElement, readers.get(AtlEMFConstants.clInPatternElement));
	  	readers.put(AtlEMFConstants.clOutPatternElement, readers.get(AtlEMFConstants.clPatternElement));
	  	readers.put(AtlEMFConstants.clSimpleOutPatternElement, readers.get(AtlEMFConstants.clOutPatternElement));
	  	
	  }
	  
	  private void initForText(EObject unit) {	
	  	if (!initialized) {	  		
	  		AtlEMFConstants.pkAtl = (EPackage)unit.eClass().getEPackage();
		  		AtlEMFConstants.clModule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Module") ;
		  		AtlEMFConstants.clLibrary = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Library");
		  		AtlEMFConstants.clQuery = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Query");
		  			AtlEMFConstants.sfModule_elements = AtlEMFConstants.clModule.getEStructuralFeature("elements");
		  		AtlEMFConstants.clRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Rule");
		  		AtlEMFConstants.clMatchedRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("MatchedRule");
		  		AtlEMFConstants.clCalledRule = (EClass)AtlEMFConstants.pkAtl.getEClassifier("CalledRule");
		  		AtlEMFConstants.clHelper = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Helper");
		  			AtlEMFConstants.sfHelper_definition = AtlEMFConstants.clHelper.getEStructuralFeature("definition");
		  		AtlEMFConstants.clLibraryRef = (EClass)AtlEMFConstants.pkAtl.getEClassifier("LibraryRef");
		  		AtlEMFConstants.clUnit = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Unit");
		  		AtlEMFConstants.clPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("PatternElement");
		  		AtlEMFConstants.clRuleVariableDeclaration = (EClass)AtlEMFConstants.pkAtl.getEClassifier("RuleVariableDeclaration");
		  		AtlEMFConstants.clInPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("InPatternElement");
		  		AtlEMFConstants.clOutPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("OutPatternElement");
		  		AtlEMFConstants.clSimpleInPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("SimpleInPatternElement");
		  		AtlEMFConstants.clSimpleOutPatternElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("SimpleOutPatternElement");
		  		AtlEMFConstants.clInPattern = (EClass)AtlEMFConstants.pkAtl.getEClassifier("InPattern");
		  		AtlEMFConstants.clOutPattern = (EClass)AtlEMFConstants.pkAtl.getEClassifier("OutPattern");
		  	AtlEMFConstants.pkOcl = AtlEMFConstants.sfHelper_definition.getEType().getEPackage();
		  		AtlEMFConstants.clOclFeatureDefinition = (EClass)AtlEMFConstants.pkOcl.getEClassifier("OclFeatureDefinition");
		  		AtlEMFConstants.clOclFeature = (EClass)AtlEMFConstants.pkOcl.getEClassifier("OclFeature");
		  		AtlEMFConstants.clOclModel = (EClass)AtlEMFConstants.pkOcl.getEClassifier("OclModel");
		  		AtlEMFConstants.clParameter = (EClass)AtlEMFConstants.pkOcl.getEClassifier("Parameter");
		  			AtlEMFConstants.clVariableDeclaration = (EClass)AtlEMFConstants.pkOcl.getEClassifier("VariableDeclaration");
		  				AtlEMFConstants.sfVarName = AtlEMFConstants.clVariableDeclaration.getEStructuralFeature("varName");
		  		AtlEMFConstants.clElement = (EClass)AtlEMFConstants.pkAtl.getEClassifier("Element");
		  			AtlEMFConstants.sfLocation = AtlEMFConstants.clElement.getEStructuralFeature("location");
		  	initReaders();
	  		initialized = true;
	  	}
	  }
	  
	  private void initForImages() {
	  	classToImages.put("Library", "libs.gif");
	  	classToImages.put("Module", "module.gif");
	  	classToImages.put("Query", "query.gif");
	  	classToImages.put("OclModel", "oclModel.gif");
	  	classToImages.put("LibraryRef", "libsreference.gif");
	  	classToImages.put("Helper", "helper.gif");
	  	classToImages.put("MatchedRule", "matchedRule.gif");
	  	classToImages.put("Operation", "operation.gif");
	  	classToImages.put("InPattern", "inPattern.gif");
	  	classToImages.put("OutPattern", "outPattern.gif");	  	
	  	classToImages.put("Binding", "binding.gif");
	  	classToImages.put("Iterator", "iterator.gif");
	  	
	  	// classToImages.put("OclFeatureDefinition", ".gif");
	  	// classToImages.put("OclContextDefinition", "helper.gif");	  	
	  	classToImages.put("SimpleInPatternElement", "element.gif");
	  	classToImages.put("SimpleOutPatternElement", "element.gif");
	  		  	
	  	classToImages.put("OperationCallExp", "expressionATL.gif");
	  	classToImages.put("OperatorCallExp", "expressionATL.gif");
	  	classToImages.put("NavigationOrAttributeCallExp", "expressionATL.gif");
	  	classToImages.put("EnumLiteralExp", "expressionATL.gif");
	  	classToImages.put("IteratorExp", "expressionATL.gif");
	  	classToImages.put("CollectionOperationCallExp", "expressionATL.gif");
	  	classToImages.put("IfExp", "expressionATL.gif");
	  	classToImages.put("StringExp", "expressionATL.gif");
	  	classToImages.put("VariableExp", "expressionATL.gif");
	  	
	  	classToImages.put("BooleanType", "type.gif");
	  	classToImages.put("OclModelElement", "type.gif");
	  	classToImages.put("StringType", "type.gif");
	  	classToImages.put("TupleType", "type.gif");
	  }
	  
	  /**
	   * returns the images descriptor for an element of the ATL AST
	   * @param className the class name for which to find the image descriptor
	   * @return the images descriptor for an element of the ATL AST
	   */
	  private ImageDescriptor getImage(String className) {
	  	String iconName = (String)classToImages.get(className);
	  	if (iconName != null) {
	  		return AtlUIPlugin.getImageDescriptor(iconName);
	  	}
	  	
  		return AtlUIPlugin.getImageDescriptor("test.gif");
	  }
	  
	  /**
	   * @see ILabelProvider#getImage(Object)
	   */
	  public Image getImage(Object element) {
	  	Image ret = null;
	  	
	  	if (!(element instanceof Root)) {
	  		EObject eo = (EObject)element;
	  		if (AtlEMFConstants.clUnit.isInstance(element)) {
	  			initForText(eo);	  			
	  		}
	  		String className = ((EObject)element).eClass().getName();
	  		ImageDescriptor descriptor = getImage(className);
	  		ret = (Image)imageCache.get(descriptor);
	  		if (ret == null) {
	  			ret = descriptor.createImage();
	  			imageCache.put(descriptor, ret);
	  		}
	  	}
	    return ret;
	  }
	  
	  private Reader getReader(EObject eo) {
	  	Reader ret = null;	  	
	  	ret = (Reader)readers.get(eo.eClass());	  	
	  	if(ret == null) 
	  		ret = defaultReader;	  	
	  	return ret;
	  }
	  
	  /**
	   * @see ILabelProvider#getText(Object)
	   */
	  public String getText(Object element) {	 
	  	String ret = "default";
	  	if (!(element instanceof Root)) {
	  		EObject eo = (EObject)element;
	  		initForText(eo);	  		
  			ret = getReader(eo).getText(eo);
  			ret += " : " + eo.eClass().getName();
	  	}	  	
	  	return ret;
	  }
	  
	  /**
	   * @see org.eclipse.jface.viewers.LabelProvider#dispose()
	   */
	  public void dispose() {
	  	for (Iterator images = imageCache.values().iterator(); images.hasNext();) 
	  		((Image)images.next()).dispose();
	  	imageCache.clear();	    
	  }
	  
	  protected RuntimeException unknownElement(Object element) {
	  	return new RuntimeException("Unknown type of element in tree of type " + element.getClass().getName());
	  }

}
