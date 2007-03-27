/*
 * Created on 14 juin 2004
 */
package org.eclipse.m2m.atl.adt.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * @author idrissi
 */
public class AtlPropertySourceProvider implements IPropertySourceProvider {
//	private Map readers = new HashMap();
	
//	private abstract class Reader {	  	
//		public abstract IPropertySource getPropertySource(EObject rule);
//	}
	
//	private Reader defaultReader = new Reader() {		
//		public IPropertySource getPropertySource(EObject object) {
//			return null;
//		}
//	};
	
//	private void initReaders() {
//		readers.put(AtlEMFConstants.clModule, new Reader() {
//			public IPropertySource getPropertySource(EObject rule) {
//				return null;
//			}
//		});
//		
//		readers.put(AtlEMFConstants.clHelper, new Reader() {
//			public IPropertySource getPropertySource(EObject rule) {
//				return null;
//			}
//		});
//		
//		readers.put(AtlEMFConstants.clMatchedRule, new Reader() {
//			public IPropertySource getPropertySource(EObject rule) {
//				return null;
//			}
//		});
//	}
	
//	private Reader getReader(EObject eo) {
//		Reader ret = null;	  	
//		ret = (Reader)readers.get(eo.eClass());	  	
//		if(ret == null) 
//			ret = defaultReader;	  	
//		return ret;
//	}
	
	/**
	 * @see org.eclipse.ui.views.properties.IPropertySourceProvider#getPropertySource(java.lang.Object)
	 */
	public IPropertySource getPropertySource(Object object)	{
		if (object instanceof EObject)
		{
			EObject eo = (EObject)object;
			return new AtlElementProperties(eo);
			/*Reader reader = getReader(eo);
			return reader.getPropertySource(eo);*/
		}
		return null;
	}
}
