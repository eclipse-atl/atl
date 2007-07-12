package org.eclipse.m2m.atl.drivers.mdr4atl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmi.reflect.InvalidCallException;
import javax.jmi.reflect.RefAssociation;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;
import javax.jmi.xmi.MalformedXMIException;

import org.eclipse.m2m.atl.engine.vm.ATLVMPlugin;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMCollection;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMString;
import org.netbeans.api.mdr.MDRManager;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIInputConfig;
import org.netbeans.api.xmi.XMIReader;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.netbeans.api.xmi.XMIReferenceResolver;
import org.netbeans.api.xmi.XMIWriter;
import org.netbeans.api.xmi.XMIWriterFactory;

/**
 * @author Frédéric Jouault
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class ASMMDRModel extends ASMModel {

	protected static Logger logger = Logger.getLogger(ATLVMPlugin.LOGGER);

	private static int verboseLevel = 1;
	private static boolean persist = false;

	private static MDRepository rep = null;
	private static XMIReader reader;
	private static XMIWriter writer;

	static {
		logger.info("Initializing MDR...");
//		System.out.println("Initializing MDR...");
		initMDR();
	}

	private ASMMDRModel(String name, RefPackage pack, ASMModel metamodel, boolean isTarget, ModelLoader ml) {
		super(name, metamodel, isTarget, ml);
		this.pack = pack;
	}

	private Map allModelElements = new HashMap(); 

	public ASMModelElement getASMModelElement(RefObject object) {
		ASMModelElement ret = null;
		
		synchronized(allModelElements) {
			ret = (ASMModelElement)allModelElements.get(object);
			if(ret == null) {
				ret = new ASMMDRModelElement(allModelElements, this, object);
			}
		}
		
		return ret;
	}

//	private Map modelElements = new HashMap();
    
    private Map classifiers = null;
    
    private ASMModelElement getClassifier(String name) {
        if(classifiers == null) {
            classifiers = new HashMap();
            RefClass cl = pack.refClass("Classifier");
            initClassifiers(cl.refAllOfType().iterator(), classifiers);
        }
        ASMModelElement ret = null;
        
        RefObject ro = (RefObject)classifiers.get(name);
        if(ro != null) {
            ret = getASMModelElement(ro);
        }
        
        return ret;
    }

    private static String baseName(RefObject o) {
        RefObject parent = (RefObject) o.refGetValue("container");
        if (parent != null) {
            String name = (String) parent.refGetValue("name");
            return baseName(parent) + name + "::";
        }
        return "";
    }
    
    private static void initClassifiers(Iterator i, Map classifiers) {
        while (i.hasNext()) {
            RefObject ro = (RefObject)i.next();
            String name = (String)ro.refGetValue("name");
            register(classifiers, name, ro);
            String base = baseName(ro);
            if (base.length() > 0) {
                register(classifiers, base + name, ro);
            }
        }
    }
    
    private static void register(Map classifiers, String name, RefObject classifier) {
    	if(classifiers.containsKey(name)) {
    		logger.warning("metamodel contains several classifiers with same name: " + name);
//    		System.out.println("Warning: metamodel contains several classifiers with same name: " + name);
    	}
    	classifiers.put(name, classifier);
    }

    public ASMModelElement findModelElement(String name) {
        ASMModelElement ret = null;
        
        ret = getClassifier(name);
            
        return ret;
    }

/*
	// only for metamodels...
	public ASMModelElement findModelElement(String name) {
//System.out.println(this + ".findModelElement(" + name + ")");
		ASMModelElement ret = (ASMModelElement)modelElements.get(name);

		if(ret == null) {
			RefObject retro = null;
			RefClass cl = pack.refClass("Classifier");
			for(Iterator i = cl.refAllOfType().iterator() ; i.hasNext() ; ) {
				RefObject ro = (RefObject)i.next();
				try {
					if(ro.refGetValue("name").equals(name)) {
						retro = ro;
						break;
					}
				} catch(Exception e) {
					retro = null;
				}
			}

			if(retro != null) {
				ret = getASMModelElement(retro);
				modelElements.put(name, ret);
			}
		}

		return ret;
	}
*/

	public Set getElementsByType(ASMModelElement ame) {
		Set ret = new HashSet();
		RefObject o = ((ASMMDRModelElement)ame).getObject();

//System.out.println(this + ".getElementsByType(" + o + ")");
		for(Iterator i = findRefClass(pack, o).refAllOfType().iterator() ; i.hasNext() ; ) {
			ret.add(getASMModelElement((RefObject)i.next()));
		}

		return ret;
	}

	public ASMModelElement newModelElement(ASMModelElement type) {
		ASMModelElement ret = null;

		ret = getASMModelElement(findRefClass(pack, ((ASMMDRModelElement)type).getObject()).refCreateInstance(null));

		return ret;
	}

	private RefClass findRefClass(RefPackage pack, RefObject object) {
		RefClass ret = null;

		try {
			ret = pack.refClass(object);
		} catch(InvalidCallException ice) {

		}

		if(ret == null) {
			for(Iterator i = pack.refAllPackages().iterator() ; i.hasNext() && (ret == null); ) {
				ret = findRefClass((RefPackage)i.next(), object);
			}
		}

		return ret;
	}

	protected RefAssociation findRefAssociation(RefObject object) {
		return findRefAssociation(pack, object);
	}

	private RefAssociation findRefAssociation(RefPackage pack, RefObject object) {
		RefAssociation ret = null;

		try {
			ret = pack.refAssociation(object);
		} catch(InvalidCallException ice) {

		}

		if(ret == null) {
			for(Iterator i = pack.refAllPackages().iterator() ; i.hasNext() && (ret == null); ) {
				ret = findRefAssociation((RefPackage)i.next(), object);
			}
		}

		return ret;
	}

	private void getAllAcquaintances() {

final boolean debug = false;

		if(getMetamodel().equals(getMOF())) {
			ASMMDRModelElement assoType = ((ASMMDRModelElement)getMOF().findModelElement("Association"));
			for(Iterator i = getElementsByType(assoType).iterator() ; i.hasNext() ; ) {
				ASMMDRModelElement asso = (ASMMDRModelElement)i.next();

if(debug) logger.info(asso.toString());
//if(debug) System.out.println(asso);

				ASMMDRModelElement type1 = null;
				String name1 = null;
				ASMModelElement ae1 = null;

				ASMMDRModelElement type2 = null;
				String name2 = null;
				ASMModelElement ae2 = null;
				for(Iterator j = ((ASMCollection)asso.get(null, "contents")).iterator() ; j.hasNext() ; ) {
					ASMModelElement ae = (ASMModelElement)j.next();
					if(ae.getMetaobject().get(null, "name").equals(new ASMString("AssociationEnd"))) {
						ASMMDRModelElement type = (ASMMDRModelElement)ae.get(null, "type");
						if(type1 == null) {
							type1 = type;
							name1 = ((ASMString)ae.get(null, "name")).getSymbol();
							ae1 = ae;
						} else {
							type2 = type;
							name2 = ((ASMString)ae.get(null, "name")).getSymbol();
							ae2 = ae;
						}
					}
				}
//				if(!((Boolean)ae1.refGetValue("isNavigable")).booleanValue()) {

if(debug) logger.info("\tAdding acquaintance \"" + name1 + "\" to " + type2);
//if(debug) System.out.println("\tAdding acquaintance \"" + name1 + "\" to " + type2);

					type2.addAcquaintance(name1, asso, ae1, true);
//				}
//				if(!((Boolean)ae2.refGetValue("isNavigable")).booleanValue()) {

if(debug) logger.info("\tAdding acquaintance \"" + name2 + "\" to " + type1);
//if(debug) System.out.println("\tAdding acquaintance \"" + name2 + "\" to " + type1);

					type1.addAcquaintance(name2, asso, ae2, false);
//				}
			}
		}
	}

    /**
     * Creates a new ASMMDRModel.
     * @param name The model name. Used as a basis for creating a new extent.
     * @param metamodel
     * @param ml
     * @return
     * @throws Exception
     */
    public static ASMMDRModel newASMMDRModel(String name, ASMMDRModel metamodel, ModelLoader ml) throws Exception {
        return newASMMDRModel(name, name, metamodel, ml);
    }

    /**
     * Creates a new ASMMDRModel.
     * @param name The model name. Used as a basis for creating a new extent.
     * @param uri The model URI. Not used by MDR.
     * @param metamodel
     * @param ml
     * @return
     * @throws Exception
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public static ASMMDRModel newASMMDRModel(String name, String uri, ASMMDRModel metamodel, ModelLoader ml) throws Exception {
        RefPackage mextent = null;
        String modifiedName = name;
        int id = 0;
        
        
        while(rep.getExtent(modifiedName) != null) {
            modifiedName = name + "_" + id++;
        }
        
        if(metamodel.getName().equals("MOF")) {
            mextent = rep.createExtent(modifiedName);
        } else {
            RefPackage mmextent = metamodel.pack;
            RefObject pack = null;
            for(Iterator it = mmextent.refClass("Package").refAllOfClass().iterator() ; it.hasNext() ; ) {
                pack = (RefObject)it.next();
                if(pack.refGetValue("name").equals(metamodel.getName())) {
                    break;
                }
            }       // mp now contains a package with the same name as the extent
            // or the last package
            mextent = rep.createExtent(modifiedName, pack);
        }

        return new ASMMDRModel(name, mextent, metamodel, true, ml);
    }

	public static ASMMDRModel loadASMMDRModel(String name, ASMMDRModel metamodel, String url, ModelLoader ml) throws Exception {
		return loadASMMDRModel(name, metamodel, new File(url).toURL(), ml);
	}

	public static ASMMDRModel loadASMMDRModel(String name, ASMMDRModel metamodel, URL url, ModelLoader ml) throws Exception {
		return loadASMMDRModel(name, metamodel, url.openStream(), ml);
	}
	
	public static ASMMDRModel loadASMMDRModel(String name, ASMMDRModel metamodel, InputStream in, ModelLoader ml) throws Exception {
		ASMMDRModel ret = newASMMDRModel(name, metamodel, ml);

		try {
			XMIInputConfig inputConfig = reader.getConfiguration();
			final XMIReferenceResolver originalReferenceResolver = inputConfig.getReferenceResolver();
			final Map elementByXmiId = new HashMap();
			final Map xmiIdByElement = new HashMap();
			inputConfig.setReferenceResolver(new XMIReferenceResolver() {

				public void register(String systemId, String xmiId, RefObject object) {
					elementByXmiId.put(xmiId, object);
					xmiIdByElement.put(object, xmiId);
					if(originalReferenceResolver != null)
						originalReferenceResolver.register(systemId, xmiId, object);
				}

				public void resolve(Client client, RefPackage extent, String systemId, XMIInputConfig configuration, Collection hrefs) throws MalformedXMIException, IOException {
					if(originalReferenceResolver != null)	// anyway, if we do nothing the default resolver will be used
						originalReferenceResolver.resolve(client, extent, systemId, configuration, hrefs);
				}
				
			});
			reader.read(in, null, ret.pack);
			inputConfig.setReferenceResolver(originalReferenceResolver);
			
			ret.elementByXmiId = elementByXmiId;
			ret.xmiIdByElement = xmiIdByElement;
		} catch(Exception e) {
			throw new Exception("Error while reading " + name + ":" + e.getLocalizedMessage(), e);
//			System.out.println("Error while reading " + name + ":");
			//e.printStackTrace(System.out);
		}
		ret.setIsTarget(false);
		ret.getAllAcquaintances();

		return ret;
	}

	public static ASMMDRModel createMOF(ModelLoader ml) {
		ASMMDRModel ret = null;

		try {
			ret = new ASMMDRModel("MOF", rep.getExtent("MOF"), null, false, ml);
			mofmm = ret;
		} catch(org.netbeans.mdr.util.DebugException de) {
			logger.log(Level.SEVERE, de.getLocalizedMessage(), de);
//			de.printStackTrace(System.out);
		}

		return ret;
	}

	public void save(String url) throws IOException {
		OutputStream out = new FileOutputStream(url);
		save(out);
	}

	public void save(OutputStream out) throws IOException {
		writer.write(out, pack, null);
	}

	public void save(String url, String xmiVersion) throws IOException {
		save(url, xmiVersion, null);
	}
	
	public void save(String url, String xmiVersion, String encoding) throws IOException {
		OutputStream out = new FileOutputStream(url);
		save(out, xmiVersion, encoding);
	}

	public void save(OutputStream out, String xmiVersion) throws IOException {
		save(out, xmiVersion, null);
	}
	
	public void save(OutputStream out, String xmiVersion, String encoding) throws IOException {
		if(encoding != null) {
			writer.getConfiguration().setEncoding(encoding);
		}
		writer.write(out, pack, xmiVersion);
	}

	private static void initMDR() {
		if(rep != null) return;

		if(verboseLevel < 1) {
			System.setProperty("org.netbeans.lib.jmi.Logger.fileName", "");
		}
		if(!persist) {
			System.setProperty("org.netbeans.mdr.storagemodel.StorageFactoryClassName", "org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl");
		}
		System.setProperty("org.openide.util.Lookup", "org.openide.util.lookup.ATLLookup");
		//
		// otherwise MDR does not find ATLLookup
		Thread.currentThread().setContextClassLoader(org.openide.util.lookup.ATLLookup.class.getClassLoader());

		rep = MDRManager.getDefault().getDefaultRepository();

		//reader = (XmiReader)Lookup.getDefault().lookup(XmiReader.class);
		//writer = (XmiWriter)Lookup.getDefault().lookup(XmiWriter.class);
		reader = XMIReaderFactory.getDefault().createXMIReader();
		writer = XMIWriterFactory.getDefault().createXMIWriter();
			rep.getExtent("MOF");
	}

	public RefPackage getPackage() {
		return pack;
	}

	public String xmiIdByElement(RefObject object) {
		return (String)xmiIdByElement.get(object);
	}
	
	public RefObject elementByXmiId(String xmiId) {
		return (RefObject)elementByXmiId.get(xmiId);
	}
	
	public static ASMModel getMOF() {
		return mofmm;
	}
	
	private RefPackage pack;
	private Map elementByXmiId;
	private Map xmiIdByElement;


	private static ASMMDRModel mofmm;

	public void dispose() {
        if (pack != null) {
            pack.refDelete();
            pack = null;
//            modelElements = null;
            allModelElements = null;
            elementByXmiId = null;
            xmiIdByElement = null;
            classifiers = null;
        }
	}
    
    public void finalize() {
        dispose();
    }
}

