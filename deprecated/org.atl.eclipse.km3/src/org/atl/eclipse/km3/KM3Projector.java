/*
 * Created on 4 mars 2005
 */
package org.atl.eclipse.km3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atl.eclipse.engine.AtlLauncher;
import org.atl.eclipse.engine.AtlModelHandler;
import org.atl.eclipse.engine.MarkerMaker;
import org.atl.engine.extractors.Extractor;
import org.atl.engine.extractors.ebnf.EBNFExtractor;
import org.atl.engine.injectors.ebnf.EBNFInjector2;
import org.atl.engine.injectors.ebnf.KM3Lexer;
import org.atl.engine.injectors.ebnf.KM3Parser;
import org.atl.engine.repositories.emf4atl.ASMEMFModelElement;
import org.atl.engine.vm.nativelib.ASMEnumLiteral;
import org.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Frédéric Jouault
 */
public class KM3Projector {
	
	private final static boolean stopOnError = !false;
	

	private URL MOF2KM3url = KM3Projector.class.getResource("resources/MOF2KM3.asm");
	private URL KM32MOFurl = KM3Projector.class.getResource("resources/KM32MOF.asm");
	private URL EMF2KM3url = KM3Projector.class.getResource("resources/EMF2KM3.asm");
	//private URL KM3_serializerurl = KM3Projector.class.getResource("resources/KM3-serializer.asm");
	private URL KM3_tcs = KM3Projector.class.getResource("resources/KM3-TCS.ecore");
	private URL TCS = KM3Projector.class.getResource("resources/TCS.ecore");
	private URL KM32EMFurl = KM3Projector.class.getResource("resources/KM32EMF.asm");
	private URL KM3WFRurl = KM3Projector.class.getResource("resources/KM3-WFR.asm");
	
	private AtlModelHandler emfamh = null;
	private ASMModel emfmm;

	private AtlModelHandler mdramh = null;
	private ASMModel mdrmm;

	private ASMModel pbmm;
	
	private ASMModel tcs = null;
	private ASMModel km3Tcs = null;
	
	private String mmName = "KM3";
	
	private MarkerMaker markerMaker;

	private KM3Projector() {
	}
	
	protected void initEMF() {
		if(emfamh == null) {
			emfamh = AtlModelHandler.getDefault(AtlModelHandler.AMH_EMF);
			URL emfmmurl = KM3Projector.class.getResource("resources/" + mmName + ".ecore");
			try {
				emfmm = emfamh.loadModel(mmName, emfamh.getMof(), emfmmurl.openStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pbmm = emfamh.getBuiltInMetaModel("Problem");

		markerMaker = new MarkerMaker();
	}
	
	protected void initMDR() {
		if(mdramh == null) {
			mdramh = AtlModelHandler.getDefault("MDR");	// TODO: MDR projector
		}
		URL mdrmmurl = KM3Projector.class.getResource("resources/" + mmName + ".xmi");
		try {
			mdrmm = mdramh.loadModel(mmName, mdramh.getMof(), mdrmmurl.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		initEMF();
	}
	
	private static KM3Projector km3Projector = null;
	
	public static KM3Projector getKM3Projector() {
		if(km3Projector == null)
			km3Projector = new KM3Projector();
		
		return km3Projector;
	}
	
	public ASMModel getEMFKM3Metamodel() {
		initEMF();
		return emfmm;
	}
	
	public ASMModel getMDRKM3Metamodel() {
		initMDR();
		return mdrmm;
	}
	
	/**
	 * Transforms a MOF-1.4 metamodel into a KM3 model
	 * conforming to the KM3 metamodel. 
	 * @author jouault
	 *
	 * @param metamodel is the MOF-1.4 metamodel. It must have been created
	 * using AtlMDRModelHandler (or in an equivalent way).
	 * @return the KM3 model. It is created using AtlEMFModelHandler.
	 */
	public ASMModel getKM3FromMOF14(ASMModel metamodel) {
		initMDR();
		ASMModel ret = null;
		
		Map models = new HashMap();
		models.put("MOF", mdramh.getMof());
		models.put("IN", metamodel);
		models.put("KM3", emfmm);
		ret = emfamh.newModel("OUT", emfmm);
		models.put("OUT", ret);
		
		
		Map params = Collections.EMPTY_MAP;
		Map libs = Collections.EMPTY_MAP;
		AtlLauncher.getDefault().launch(MOF2KM3url, libs, models, params);
		
		return ret;
	}
	
	/**
	 * Transforms an Ecore metamodel into a KM3 model
	 * conforming to the KM3 metamodel. 
	 * @author jouault
	 *
	 * @param metamodel is the Ecore metamodel. It must have been created
	 * using AtlEMFModelHandler (or in an equivalent way).
	 * @return the KM3 model. It is created using AtlEMFModelHandler.
	 */
	public ASMModel getKM3FromEcore(ASMModel metamodel) {
		initEMF();
		ASMModel ret = null;
		
		Map models = new HashMap();
		models.put("MOF", emfamh.getMof());
		models.put("IN", metamodel);
		models.put("KM3", emfmm);
		ret = emfamh.newModel("OUT", emfmm);
		models.put("OUT", ret);
		
		
		Map params = Collections.EMPTY_MAP;
		Map libs = Collections.EMPTY_MAP;
		AtlLauncher.getDefault().launch(EMF2KM3url, libs, models, params);
		
		return ret;
	}
	
	/**
	 * Serializes a KM3 model into a String.
	 * @author jouault
	 *
	 * @param model is the KM3 model. It must have been created
	 * using AtlEMFModelHandler (or in an equivalent way).
	 * @return the serialized textual representation of the KM3 model.
	 */
	public String getStringFromKM3(ASMModel model) {
		String ret = null;
/*		
		Map models = new HashMap();
		models.put("KM3", emfmm);
		models.put("IN", model);
		Map params = Collections.EMPTY_MAP;
		Map libs = Collections.EMPTY_MAP;
		ASMString s = (ASMString)AtlLauncher.getDefault().launch(KM3_serializerurl, libs, models, params);
		
		return (s == null) ? null : s.getSymbol();
*/
		try {
			if(km3Tcs == null) {
				tcs = emfamh.loadModel("TCS", emfamh.getMof(), TCS.openStream());
				km3Tcs = emfamh.loadModel("KM3.tcs", tcs, KM3_tcs.openStream());
			}
			Extractor ext = new EBNFExtractor();
			Map params = new HashMap();
			params.put("format", km3Tcs);
			params.put("indentString", "\t");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				ext.extract(model, out, params);
			} catch(Exception e) {
				e.printStackTrace();
			}
			ret = out.toString();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Deserializes a KM3 model from a File.
	 * @author jouault
	 *
	 * @param file is the KM3 file.
	 * @return the KM3 model created using AtlEMFModelHandler.
	 */
	public ASMModel getEMFKM3FromFile(IFile file) throws CoreException, IOException {
		initEMF();
		ASMModel ret = emfamh.newModel("IN", emfmm);
		
		EBNFInjector2 ebnfi = new EBNFInjector2();
		InputStream in = file.getContents();

		ASMModel pbs = emfamh.newModel("pbs", pbmm);
		Class lexer = KM3Lexer.class;
		Class parser = KM3Parser.class;
		ebnfi.performImportation(emfmm, ret, in, mmName, lexer, parser, pbs);
		in.close();

		int nbPbs = markerMaker.applyMarkers(file, pbs);
		
		if((!stopOnError) || (nbPbs == 0)) {
			Map models = new HashMap();
			models.put("MOF", emfamh.getMof());
			models.put("KM3", emfmm);
			models.put("IN", ret);
			models.put("Problem", pbmm);
			models.put("OUT", pbs);

			Map params = Collections.EMPTY_MAP;
			
			Map libs = Collections.EMPTY_MAP;

			AtlLauncher.getDefault().launch(KM3WFRurl, libs, models, params);			

			nbPbs = markerMaker.applyMarkers(file, pbs);
		}
		
		if(stopOnError && (nbPbs != 0)) {
			ret = null;
		}
		
		return ret;
	}
	
	public ASMModel getMDRKM3FromFile(IFile file) throws CoreException, IOException {
		initMDR();
		ASMModel ret = mdramh.newModel("IN", mdrmm);
		
		EBNFInjector2 ebnfi = new EBNFInjector2();
		InputStream in = file.getContents();

		ASMModel pbs = null;//mdramh.newModel("pbs", pbmm);
		Class lexer = KM3Lexer.class;
		Class parser = KM3Parser.class;
		ebnfi.performImportation(mdrmm, ret, in, mmName, lexer, parser, pbs);
		in.close();
		System.err.println(ret);
		
		int nbPbs = 0;//markerMaker.applyMarkers(file, pbs);
		
//		if((!stopOnError) || (nbPbs == 0)) {
//			Map models = new HashMap();
//			models.put("MOF", mdramh.getMof());
//			models.put("KM3", mdrmm);
//			models.put("IN", ret);
//			models.put("Problem", pbmm);
//			models.put("OUT", pbs);
//
//			Map params = Collections.EMPTY_MAP;
//			
//			Map libs = Collections.EMPTY_MAP;
//
//			//AtlLauncher.getDefault().launch(KM3WFRurl, libs, models, params);			
//
//			//nbPbs = markerMaker.applyMarkers(file, pbs);
//		}
		
		if(stopOnError && (nbPbs != 0)) {
			ret = null;
		}
		
		return ret;
	}
	
	/**
	 * Transforms a KM3 file to an Ecore metamodel.
	 * @author jouault
	 *
	 * @param file is the KM3 file.
	 * @return the Ecore metamodel. It is created using AtlEMFModelHandler.
	 */
	public ASMModel getEcoreFromKM3File(IFile file) throws CoreException, IOException {
		ASMModel ret = null;
		
		ASMModel model = getEMFKM3FromFile(file);
		
		if(model != null)
			ret = getEcoreFromKM3(model);
		
		return ret;
	}

	/**
	 * Transforms a KM3 model into an Ecore metamodel.
	 * @author jouault
	 *
	 * @param model is the KM3 model. It must have been created
	 * using AtlEMFModelHandler (or in an equivalent way).
	 * @return the Ecore metamodel. It is created using AtlEMFModelHandler.
	 */
	public ASMModel getEcoreFromKM3(ASMModel model) throws CoreException, IOException {
		initEMF();
		ASMModel ret = null;
		
		Map models = new HashMap();
		models.put("MOF", emfamh.getMof());
		models.put("KM3", emfmm);
		models.put("IN", model);
		ret = emfamh.newModel("OUT", emfamh.getMof());
		models.put("OUT", ret);

		Map params = Collections.EMPTY_MAP;
		
		Map libs = Collections.EMPTY_MAP;

		AtlLauncher.getDefault().launch(KM32EMFurl, libs, models, params);

		return ret;
	}

	/**
	 * Transforms a KM3 file to a MOF-1.4 metamodel.
	 * @author jouault
	 *
	 * @param file is the KM3 file.
	 * @return the MOF-1.4 metamodel. It is created using AtlMDRModelHandler.
	 */
	public ASMModel getMOF14FromKM3File(IFile file) throws CoreException, IOException {
		ASMModel ret = null;
		
		ASMModel model = getMDRKM3FromFile(file);

		if(model != null)
			ret = getMOF14FromKM3(model);

		return ret;
	}

	/**
	 * Transforms a KM3 model into a MOF-1.4 metamodel.
	 * @author jouault
	 *
	 * @param model is the KM3 model. It must have been created
	 * using AtlEMFModelHandler (or in an equivalent way).
	 * @return the MOF-1.4 metamodel. It is created using AtlMDRModelHandler.
	 */
	public ASMModel getMOF14FromKM3(ASMModel model) throws CoreException, IOException {
		initMDR();
		ASMModel ret = null;

		Map models = new HashMap();
		models.put("MOF", mdramh.getMof());
		models.put("KM3", emfmm);
		models.put("IN", model);
		ret = mdramh.newModel("OUT", mdramh.getMof());
		models.put("OUT", ret);

		Map params = Collections.EMPTY_MAP;
		
		Map libs = Collections.EMPTY_MAP;

		AtlLauncher.getDefault().launch(KM32MOFurl, libs, models, params);

		return ret;
	}
}
