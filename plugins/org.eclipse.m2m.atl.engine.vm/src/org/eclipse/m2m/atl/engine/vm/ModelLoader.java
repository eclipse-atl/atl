package org.eclipse.m2m.atl.engine.vm;

import org.eclipse.m2m.atl.engine.extractors.Extractor;
import org.eclipse.m2m.atl.engine.extractors.xml.XMLExtractor;
import org.eclipse.m2m.atl.engine.injectors.Injector;
import org.eclipse.m2m.atl.engine.injectors.xml.XMLInjector;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModelElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Model loading and saving facillity. Must be extended by concrete implementations
 * such as for EMF or MDR. This is only used in command-line mode at the present time.
 * @author Frédéric Jouault
 */
public abstract class ModelLoader {

	protected static Map loadedModels = new HashMap();
	
	private Map injectors = new HashMap();
	{
		injectors.put("xml", XMLInjector.class);
	}

	public void addInjector(String prefix, Class inj) {
		injectors.put(prefix, inj);
	}

	private Map extractors = new HashMap();
	{
		extractors.put("xml", XMLExtractor.class);
	}

	public void addExtractor(String prefix, Class ext) {
		extractors.put(prefix, ext);
	}

	public abstract ASMModel loadModel(String name, ASMModel metamodel, InputStream in);

	protected abstract ASMModel realLoadModel(String name, ASMModel metamodel, String href);

	public ASMModel loadModel(String name, ASMModel metamodel, String href) {
		ASMModel ret = null;

		href = href.replaceAll("\\\\:", "<colon>");
		String ss[] = href.split(":");
		for(int i = 0 ; i < ss.length ; i++)
			ss[i] = ss[i].replaceAll("<colon>", ":");
		if(ss.length == 1) {
			ret = realLoadModel(name, metamodel, ss[0]);
		} else if(ss[0].equals("xmi")) {
			String url = ss[ss.length - 1];
			ret = realLoadModel(name, metamodel, url);
		} else {
			ret = newModel(name, metamodel);
			inject(ret, ss[0], (ss.length == 3) ? ss[1] : null, ss[ss.length - 1], null);
		}
		
		loadedModels.put(name, ret);
		return ret;
	}
	
	public ASMModelElement inject(ASMModel ret, String kind, String params, String uri, InputStream in) {
		ASMModelElement root = null;
			try {
				Map paramsMap = new HashMap();
				if(uri != null) {
					try {
						in = new FileInputStream(uri);
					} catch(FileNotFoundException fnfe) {
						in = new URL(uri).openStream();
					}
				}

				Class injectorClass = (Class)injectors.get(kind);
				if(injectorClass != null) {
					Injector inj = (Injector)injectorClass.newInstance();
					if(params != null) {
						String sparams[] = params.split(",");
						Map args = new HashMap();
						for(int i = 0 ; i < sparams.length ; i++) {
							String p = sparams[i];
							String pair[] = p.split("=");
							if(pair.length == 1) {
								if(p.indexOf("=") == -1)
									args.put("name", pair[0]);
								else
									args.put(pair[0], "");
							} else {
								args.put(pair[0], pair[1]);
							}

						}
						Map types = inj.getParameterTypes();
						for(Iterator i = types.keySet().iterator() ; i.hasNext() ; ) {
							String pname = (String)i.next();
							String type = (String)types.get(pname);
							if(type.equals("String")) {
								String val = (String)args.get(pname);
								if(val != null) {
									paramsMap.put(pname, val);
								} else {
									System.err.println("Warning: could not find value for parameter \"" + pname + "\" : " + type + ".");
									//System.exit(1);
								}
							} else if(type.startsWith("Model:")) {
								paramsMap.put(pname, loadedModels.get(args.get(pname)));
							} else if(type.equals("RandomAccessFile") && (uri != null)) {
								paramsMap.put(pname, new RandomAccessFile(uri, "r"));
							} else {
								System.err.println("Warning: unknown parameter type \"" + type + "\" of \"" + pname + "\".");
							}
						}
					}
					//inj.performImportation(metamodel, ret, in, other);
					root = inj.inject(ret, in, paramsMap);
					ret.setIsTarget(false);
					//getAllAcquaintances ?
				} else {
					System.out.println("ERROR: could not find injector for \"" + kind + "\"");
				} 
 			} catch(Exception e) {
				e.printStackTrace();
			}
 			return root;
	}



	public abstract ASMModel newModel(String name, ASMModel metamodel);

	protected abstract void setParameter(String name, Object value);

	protected abstract void realSave(ASMModel model, String href);

	public void save(ASMModel model, String href) {
		String ss[] = href.split(":");
		if(ss.length == 1) {
			realSave(model, href);
		} else if(ss[0].equals("xmi")) {
			String url = ss[ss.length - 1];
			
			// setting default values
				// EMF-specific
			setParameter("useIDs", "false");
			setParameter("removeIDs", "false");
			setParameter("encoding", "ISO-8859-1");
			
				// for MDR-specific
			setParameter("xmiVersion", null);
			
			// parsing user-provided values
			if(ss.length == 3) {
				String sparams[] = ss[1].split(",");
				for(int i = 0 ; i < sparams.length ; i++) {
					String p = sparams[i];
					String pair[] = p.split("=");
					if(pair.length == 2) {
						setParameter(pair[0], pair[1]);
					}
				}				
			}
			realSave(model, url);
		} else {
			extract(model, ss[0], (ss.length == 3) ? ss[1] : null, ss[ss.length - 1], null);
		}
	}

	public void extract(ASMModel model, String kind, String params, String uri, OutputStream out) {
			try {
				Map paramsMap = new HashMap();
				if(uri != null) {
					out = new FileOutputStream(uri);
				}

				Class extractorClass = (Class)extractors.get(kind);
				if(extractorClass != null) {
					Extractor ext = (Extractor)extractorClass.newInstance();
					if(params != null) {
						String sparams[] = params.split(",");
						Map args = new HashMap();
						for(int i = 0 ; i < sparams.length ; i++) {
							String p = sparams[i];
							String pair[] = p.split("=");
							if(pair.length == 1) {
								if(p.indexOf("=") == -1)
									args.put("name", pair[0]);
								else
									args.put(pair[0], "");
							} else {
								args.put(pair[0], pair[1]);
							}
						}
						Map types = ext.getParameterTypes();
						for(Iterator i = types.keySet().iterator() ; i.hasNext() ; ) {
							String pname = (String)i.next();
							String type = (String)types.get(pname);
							if(type.equals("String")) {
								String val = (String)args.get(pname);
								if(val != null) {
									paramsMap.put(pname, val);
								} else {
									System.err.println("Warning: could not find value for parameter \"" + pname + "\" : " + type + ".");
									//System.exit(1);
								}
							} else if(type.startsWith("Model:")) {
								paramsMap.put(pname, loadedModels.get(args.get(pname)));
							} else {
								System.err.println("Warning: unknown parameter type \"" + type + "\" of \"" + pname + "\".");
							}
						}
					}
					ext.extract(model, out, paramsMap);
				} else {
					System.out.println("ERROR: could not find extractor for \"" + kind + "\"");
				} 
 			} catch(Exception e) {
				e.printStackTrace();
			}
	}

	public abstract ASMModel getMOF();
}

