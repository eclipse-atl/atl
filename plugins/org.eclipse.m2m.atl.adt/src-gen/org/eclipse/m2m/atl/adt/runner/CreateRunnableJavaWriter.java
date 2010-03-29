package org.eclipse.m2m.atl.adt.runner;

import java.util.Iterator;

public class CreateRunnableJavaWriter
{
  protected static String nl;
  public static synchronized CreateRunnableJavaWriter create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateRunnableJavaWriter result = new CreateRunnableJavaWriter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*******************************************************************************" + NL + " * Copyright (c) 2010 Obeo." + NL + " * All rights reserved. This program and the accompanying materials" + NL + " * are made available under the terms of the Eclipse Public License v1.0" + NL + " * which accompanies this distribution, and is available at" + NL + " * http://www.eclipse.org/legal/epl-v10.html" + NL + " * " + NL + " * Contributors:" + NL + " *     Obeo - initial API and implementation" + NL + " *******************************************************************************/" + NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.IOException;" + NL + "import java.io.InputStream;" + NL + "import java.net.URL;" + NL + "import java.util.HashMap;" + NL + "import java.util.Map;" + NL + "import java.util.Properties;" + NL + "import java.util.Map.Entry;" + NL + "" + NL + "import org.eclipse.core.runtime.FileLocator;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.core.runtime.NullProgressMonitor;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.core.runtime.Platform;";
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EPackage;";
  protected final String TEXT_4 = NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;";
  protected final String TEXT_5 = NL + "import org.eclipse.m2m.atl.common.ATLExecutionException;" + NL + "import org.eclipse.m2m.atl.core.ATLCoreException;";
  protected final String TEXT_6 = NL + "import org.eclipse.m2m.atl.core.IExtractor;";
  protected final String TEXT_7 = NL + "import org.eclipse.m2m.atl.core.IInjector;" + NL + "import org.eclipse.m2m.atl.core.IModel;" + NL + "import org.eclipse.m2m.atl.core.IReferenceModel;" + NL + "import org.eclipse.m2m.atl.core.ModelFactory;";
  protected final String TEXT_8 = NL + "import org.eclipse.m2m.atl.core.emf.EMFExtractor;";
  protected final String TEXT_9 = NL + "import org.eclipse.m2m.atl.core.emf.EMFInjector;" + NL + "import org.eclipse.m2m.atl.core.emf.EMFModelFactory;";
  protected final String TEXT_10 = NL + "import org.eclipse.m2m.atl.core.launch.ILauncher;" + NL + "import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;" + NL + "" + NL + "/**" + NL + " * Entry point of the '";
  protected final String TEXT_11 = "' transformation module." + NL + " */" + NL + "public class ";
  protected final String TEXT_12 = " {" + NL + "" + NL + "\t/**" + NL + "\t * The property file. Stores module list, the metamodel and library locations." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Properties properties;" + NL + "\t";
  protected final String TEXT_13 = NL + "\t/**" + NL + "\t * The ";
  protected final String TEXT_14 = " model." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IModel ";
  protected final String TEXT_15 = "Model;\t" + NL + "\t";
  protected final String TEXT_16 = NL + "\t/**" + NL + "\t * The refining trace model." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IModel refiningTraceModel;" + NL + "\t";
  protected final String TEXT_17 = "\t" + NL + "\t/**" + NL + "\t * The main method." + NL + "\t * " + NL + "\t * @param args" + NL + "\t *            are the arguments" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void main(String[] args) {" + NL + "\t\ttry {";
  protected final String TEXT_18 = NL + "\t\t\tif (args.length < ";
  protected final String TEXT_19 = ") {" + NL + "\t\t\t\tSystem.out.println(\"Arguments not valid : {";
  protected final String TEXT_20 = "_model_path";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = "}.\");" + NL + "\t\t\t} else {";
  protected final String TEXT_23 = NL + "\t\t\t\t";
  protected final String TEXT_24 = " runner = new ";
  protected final String TEXT_25 = "();" + NL + "\t\t\t\trunner.loadModels(";
  protected final String TEXT_26 = "args[";
  protected final String TEXT_27 = "]";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t\t\tSystem.out.println(runner.do";
  protected final String TEXT_31 = "(new NullProgressMonitor()));";
  protected final String TEXT_32 = NL + "\t\t\t\trunner.do";
  protected final String TEXT_33 = "(new NullProgressMonitor());";
  protected final String TEXT_34 = NL + "\t\t\t\trunner.saveModels(";
  protected final String TEXT_35 = "args[";
  protected final String TEXT_36 = "]";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\tSystem.out.println(new ";
  protected final String TEXT_41 = "().do";
  protected final String TEXT_42 = "(new NullProgressMonitor()));";
  protected final String TEXT_43 = NL + "\t\t} catch (ATLCoreException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t} catch (ATLExecutionException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Constructor." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_44 = "() throws IOException {" + NL + "\t\tproperties = new Properties();" + NL + "\t\tproperties.load(getFileURL(\"";
  protected final String TEXT_45 = ".properties\").openStream());";
  protected final String TEXT_46 = NL + "\t\tEPackage.Registry.INSTANCE.put(getMetamodelUri(\"";
  protected final String TEXT_47 = "\"), ";
  protected final String TEXT_48 = ".eINSTANCE);";
  protected final String TEXT_49 = NL + "\t\tResource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\"ecore\", new EcoreResourceFactoryImpl());";
  protected final String TEXT_50 = NL + "\t}";
  protected final String TEXT_51 = NL + "\t" + NL + "\t/**" + NL + "\t * Load the input and input/output models, initialize output models." + NL + "\t * ";
  protected final String TEXT_52 = NL + "\t * @param ";
  protected final String TEXT_53 = "ModelPath" + NL + "\t *            the ";
  protected final String TEXT_54 = " model path";
  protected final String TEXT_55 = NL + "\t * @throws ATLCoreException" + NL + "\t *             if a problem occurs while loading models" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void loadModels(";
  protected final String TEXT_56 = "String ";
  protected final String TEXT_57 = "ModelPath";
  protected final String TEXT_58 = ", ";
  protected final String TEXT_59 = ") throws ATLCoreException {" + NL + "\t\tModelFactory factory = new EMFModelFactory();" + NL + "\t\tIInjector injector = new EMFInjector();";
  protected final String TEXT_60 = NL + "\t\tIReferenceModel ";
  protected final String TEXT_61 = "Metamodel = factory.getMetametamodel();";
  protected final String TEXT_62 = NL + "\t \tIReferenceModel ";
  protected final String TEXT_63 = "Metamodel = factory.newReferenceModel();" + NL + "\t\tinjector.inject(";
  protected final String TEXT_64 = "Metamodel, getMetamodelUri(\"";
  protected final String TEXT_65 = "\"));";
  protected final String TEXT_66 = NL + "\t\tthis.";
  protected final String TEXT_67 = "Model = factory.newModel(";
  protected final String TEXT_68 = "Metamodel);" + NL + "\t\tinjector.inject(";
  protected final String TEXT_69 = "Model, ";
  protected final String TEXT_70 = "ModelPath);";
  protected final String TEXT_71 = NL + "\t\tthis.";
  protected final String TEXT_72 = "Model = factory.newModel(";
  protected final String TEXT_73 = "Metamodel);" + NL + "\t\tinjector.inject(";
  protected final String TEXT_74 = "Model, ";
  protected final String TEXT_75 = "ModelPath);";
  protected final String TEXT_76 = NL + "\t\tthis.";
  protected final String TEXT_77 = "Model = factory.newModel(";
  protected final String TEXT_78 = "Metamodel);";
  protected final String TEXT_79 = NL + "\t\tIReferenceModel refiningTraceMetamodel = factory.getBuiltInResource(\"RefiningTrace.ecore\");" + NL + "\t\trefiningTraceModel = factory.newModel(refiningTraceMetamodel);";
  protected final String TEXT_80 = NL + "\t}";
  protected final String TEXT_81 = NL + "\t" + NL + "\t/**" + NL + "\t * Save the output and input/output models." + NL + "\t * ";
  protected final String TEXT_82 = NL + "\t * @param ";
  protected final String TEXT_83 = "ModelPath" + NL + "\t *            the ";
  protected final String TEXT_84 = " model path";
  protected final String TEXT_85 = NL + "\t * @throws ATLCoreException" + NL + "\t *             if a problem occurs while saving models" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveModels(";
  protected final String TEXT_86 = "String ";
  protected final String TEXT_87 = "ModelPath";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ") throws ATLCoreException {" + NL + "\t\tIExtractor extractor = new EMFExtractor();";
  protected final String TEXT_90 = NL + "\t\textractor.extract(";
  protected final String TEXT_91 = "Model, ";
  protected final String TEXT_92 = "ModelPath);";
  protected final String TEXT_93 = NL + "\t}";
  protected final String TEXT_94 = NL + NL + "\t/**" + NL + "\t * Transform the models." + NL + "\t * " + NL + "\t * @param monitor" + NL + "\t *            the progress monitor" + NL + "\t * @throws ATLCoreException" + NL + "\t *             if an error occurs during models handling" + NL + "\t * @throws IOException" + NL + "\t *             if a module cannot be read" + NL + "\t * @throws ATLExecutionException" + NL + "\t *             if an error occurs during the execution" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object do";
  protected final String TEXT_95 = "(IProgressMonitor monitor) throws ATLCoreException, IOException, ATLExecutionException {" + NL + "\t\tILauncher launcher = new EMFVMLauncher();" + NL + "\t\tMap<String, Object> launcherOptions = getOptions();" + NL + "\t\tlauncher.initialize(launcherOptions);";
  protected final String TEXT_96 = NL + "\t\tlauncher.addInModel(";
  protected final String TEXT_97 = "Model, \"";
  protected final String TEXT_98 = "\", \"";
  protected final String TEXT_99 = "\");";
  protected final String TEXT_100 = NL + "\t\tlauncher.addInOutModel(";
  protected final String TEXT_101 = "Model, \"";
  protected final String TEXT_102 = "\", \"";
  protected final String TEXT_103 = "\");";
  protected final String TEXT_104 = NL + "\t\tlauncher.addOutModel(";
  protected final String TEXT_105 = "Model, \"";
  protected final String TEXT_106 = "\", \"";
  protected final String TEXT_107 = "\");";
  protected final String TEXT_108 = NL + "\t\tlauncher.addOutModel(refiningTraceModel, \"refiningTrace\", \"RefiningTrace\");";
  protected final String TEXT_109 = NL + "\t\tlauncher.addLibrary(\"";
  protected final String TEXT_110 = "\", getLibraryAsStream(\"";
  protected final String TEXT_111 = "\"));";
  protected final String TEXT_112 = NL + "\t\treturn launcher.launch(\"run\", monitor, launcherOptions, (Object[]) getModulesList());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns an Array of the module input streams, parameterized by the" + NL + "\t * property file." + NL + "\t * " + NL + "\t * @return an Array of the module input streams" + NL + "\t * @throws IOException" + NL + "\t *             if a module cannot be read" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected InputStream[] getModulesList() throws IOException {" + NL + "\t\tInputStream[] modules = null;" + NL + "\t\tString modulesList = properties.getProperty(\"";
  protected final String TEXT_113 = ".modules\");" + NL + "\t\tif (modulesList != null) {" + NL + "\t\t\tString[] moduleNames = modulesList.split(\",\");" + NL + "\t\t\tmodules = new InputStream[moduleNames.length];" + NL + "\t\t\tfor (int i = 0; i < moduleNames.length; i++) {" + NL + "\t\t\t\tString asmModulePath = new Path(moduleNames[i].trim()).removeFileExtension().addFileExtension(\"asm\").toString();" + NL + "\t\t\t\tmodules[i] = getFileURL(asmModulePath).openStream();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn modules;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns the URI of the given metamodel, parameterized from the property file." + NL + "\t * " + NL + "\t * @param metamodelName" + NL + "\t *            the metamodel name" + NL + "\t * @return the metamodel URI" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getMetamodelUri(String metamodelName) {" + NL + "\t\treturn properties.getProperty(\"";
  protected final String TEXT_114 = ".metamodels.\" + metamodelName);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns the file name of the given library, parameterized from the property file." + NL + "\t * " + NL + "\t * @param libraryName" + NL + "\t *            the library name" + NL + "\t * @return the library file name" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected InputStream getLibraryAsStream(String libraryName) throws IOException {" + NL + "\t\treturn getFileURL(properties.getProperty(\"";
  protected final String TEXT_115 = ".libraries.\" + libraryName)).openStream();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns the options map, parameterized from the property file." + NL + "\t * " + NL + "\t * @return the options map" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Map<String, Object> getOptions() {" + NL + "\t\tMap<String, Object> options = new HashMap<String, Object>();" + NL + "\t\tfor (Entry<Object, Object> entry : properties.entrySet()) {" + NL + "\t\t\tif (entry.getKey().toString().startsWith(\"";
  protected final String TEXT_116 = ".options.\")) {" + NL + "\t\t\t\toptions.put(entry.getKey().toString().replaceFirst(\"";
  protected final String TEXT_117 = ".options.\", \"\"), " + NL + "\t\t\t\tentry.getValue().toString());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn options;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Finds the file in the plug-in. Returns the file URL." + NL + "\t * " + NL + "\t * @param fileName" + NL + "\t *            the file name" + NL + "\t * @return the file URL" + NL + "\t * @throws IOException" + NL + "\t *             if the file doesn't exist" + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static URL getFileURL(String fileName) throws IOException {" + NL + "\t\tfinal URL fileURL;" + NL + "\t\tif (isEclipseRunning()) {" + NL + "\t\t\tURL resourceURL = ";
  protected final String TEXT_118 = ".class.getResource(fileName);" + NL + "\t\t\tif (resourceURL != null) {" + NL + "\t\t\t\tfileURL = FileLocator.toFileURL(resourceURL);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfileURL = null;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tfileURL = ";
  protected final String TEXT_119 = ".class.getResource(fileName);" + NL + "\t\t}" + NL + "\t\tif (fileURL == null) {" + NL + "\t\t\tthrow new IOException(\"'\" + fileName + \"' not found\");" + NL + "\t\t} else {" + NL + "\t\t\treturn fileURL;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Tests if eclipse is running." + NL + "\t * " + NL + "\t * @return <code>true</code> if eclipse is running" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean isEclipseRunning() {" + NL + "\t\ttry {" + NL + "\t\t\treturn Platform.isRunning();" + NL + "\t\t} catch (Throwable exception) {" + NL + "\t\t\t// Assume that we aren't running." + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_120 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
 CreatePluginData pluginContent = (CreatePluginData) argument;
 CreateRunnableData content = pluginContent.getRunnableData();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(pluginContent.getBasePackage());
    stringBuffer.append(TEXT_2);
    if (!pluginContent.getPackageClassNames().isEmpty()) {
    stringBuffer.append(TEXT_3);
    }
    if (!content.getAllModelsNames().isEmpty()) {
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    if (!content.getModelsToSaveNames().isEmpty()) {
    stringBuffer.append(TEXT_6);
    }
    if (!content.getAllModelsNames().isEmpty()) {
    stringBuffer.append(TEXT_7);
    if (!content.getModelsToSaveNames().isEmpty()) {
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_12);
    for (Iterator<String> i = content.getAllModelsNames().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_15);
    }
    if (content.isRefining()) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    if (!content.getAllModelsNames().isEmpty()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(content.getAllModelsNames().size());
    stringBuffer.append(TEXT_19);
    for (Iterator<String> i = content.getAllModelsNames().iterator(); i.hasNext(); ) {
    stringBuffer.append(i.next());
    stringBuffer.append(TEXT_20);
    if (i.hasNext()) {
    stringBuffer.append(TEXT_21);
    }
    }
    stringBuffer.append(TEXT_22);
    if (!content.getModelsToLoadNames().isEmpty()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_25);
    for (Iterator<String> i = content.getModelsToLoadNames().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_26);
    stringBuffer.append(content.getAllModelsNames().indexOf(modelName));
    stringBuffer.append(TEXT_27);
    if (i.hasNext()) {
    stringBuffer.append(TEXT_28);
    }
    }
    stringBuffer.append(TEXT_29);
    }
    if (content.isQuery()) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_31);
    } else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_33);
    }
    if (!content.getModelsToSaveNames().isEmpty()) {
    stringBuffer.append(TEXT_34);
    for (Iterator<String> i = content.getModelsToSaveNames().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_35);
    stringBuffer.append(content.getAllModelsNames().indexOf(modelName));
    stringBuffer.append(TEXT_36);
    if (i.hasNext()) {
    stringBuffer.append(TEXT_37);
    }
    }
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_45);
    for (String metamodelName : content.getAllMetamodelsNames()) {
    String packageClassName = pluginContent.getPackageClassNames().get(metamodelName); if (!content.isMetametamodel(metamodelName) && packageClassName != null) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(metamodelName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(packageClassName);
    stringBuffer.append(TEXT_48);
    }
    }
    if (!content.getAllModelsNames().isEmpty()) {
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    if (!content.getModelsToLoadNames().isEmpty()) {
    stringBuffer.append(TEXT_51);
    for (Iterator<String> i = content.getModelsToLoadNames().iterator(); i.hasNext();) { String modelName = i.next();
    stringBuffer.append(TEXT_52);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    for (Iterator<String> i = content.getModelsToLoadNames().iterator(); i.hasNext(); ) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i.next().toLowerCase());
    stringBuffer.append(TEXT_57);
    if (i.hasNext()) {
    stringBuffer.append(TEXT_58);
    }
    }
    stringBuffer.append(TEXT_59);
    for (String metamodelName : content.getAllMetamodelsNames()) {
    if (content.isMetametamodel(metamodelName)) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(metamodelName.toLowerCase());
    stringBuffer.append(TEXT_61);
    } else {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(metamodelName.toLowerCase());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(metamodelName.toLowerCase());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(metamodelName);
    stringBuffer.append(TEXT_65);
    }
    }
    for (Iterator<String> i = content.getInModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_66);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(content.getInModels().get(modelName).toLowerCase());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_70);
    }
    for (Iterator<String> i = content.getInOutModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_71);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(content.getInOutModels().get(modelName).toLowerCase());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_75);
    }
    for (Iterator<String> i = content.getOutModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_76);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(content.getOutModels().get(modelName).toLowerCase());
    stringBuffer.append(TEXT_78);
    }
    if (content.isRefining()) {
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    }
    if (!content.getModelsToSaveNames().isEmpty()) {
    stringBuffer.append(TEXT_81);
    for (Iterator<String> i = content.getModelsToSaveNames().iterator(); i.hasNext();) { String modelName = i.next();
    stringBuffer.append(TEXT_82);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    for (Iterator<String> i = content.getModelsToSaveNames().iterator(); i.hasNext(); ) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i.next().toLowerCase());
    stringBuffer.append(TEXT_87);
    if (i.hasNext()) {
    stringBuffer.append(TEXT_88);
    }
    }
    stringBuffer.append(TEXT_89);
    for (Iterator<String> i = content.getModelsToSaveNames().iterator(); i.hasNext();) { String modelName = i.next();
    stringBuffer.append(TEXT_90);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_95);
    for (Iterator<String> i = content.getInModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_96);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(content.getInModels().get(modelName));
    stringBuffer.append(TEXT_99);
    }
    for (Iterator<String> i = content.getInOutModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_100);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(content.getInOutModels().get(modelName));
    stringBuffer.append(TEXT_103);
    }
    for (Iterator<String> i = content.getOutModels().keySet().iterator(); i.hasNext(); ) { String modelName = i.next();
    stringBuffer.append(TEXT_104);
    stringBuffer.append(modelName.toLowerCase());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(modelName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(content.getOutModels().get(modelName));
    stringBuffer.append(TEXT_107);
    }
    if (content.isRefining()) {
    stringBuffer.append(TEXT_108);
    }
    for (String libraryName : content.getAllLibrariesNames()) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(libraryName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(libraryName);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(TEXT_120);
    return stringBuffer.toString();
  }
}
