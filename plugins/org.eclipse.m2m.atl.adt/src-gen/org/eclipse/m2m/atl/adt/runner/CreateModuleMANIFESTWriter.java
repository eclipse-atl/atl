package org.eclipse.m2m.atl.adt.runner;

public class CreateModuleMANIFESTWriter
{
  protected static String nl;
  public static synchronized CreateModuleMANIFESTWriter create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateModuleMANIFESTWriter result = new CreateModuleMANIFESTWriter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: ATL ";
  protected final String TEXT_2 = " Transformation Runtime Plug-in" + NL + "Bundle-SymbolicName: ";
  protected final String TEXT_3 = NL + "Bundle-Version: 1.0.0.qualifier" + NL + "Bundle-Activator: ";
  protected final String TEXT_4 = ".Activator" + NL + "Bundle-Vendor: Eclipse Modeling Project" + NL + "Require-Bundle: org.eclipse.core.runtime, ";
  protected final String TEXT_5 = NL + " ";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = NL + " org.eclipse.m2m.atl.engine.emfvm" + NL + "Bundle-RequiredExecutionEnvironment: J2SE-1.5" + NL + "Bundle-ActivationPolicy: lazy" + NL + "Eclipse-LazyStart: true";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
 CreatePluginData content = (CreatePluginData) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(content.getProjectName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(content.getProjectName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(content.getProjectName());
    stringBuffer.append(TEXT_4);
    for(String dependency : content.getPluginDependencies()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dependency);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
