package org.eclipse.m2m.atl.adt.runner;

import org.eclipse.core.runtime.Path;
import java.util.Map.Entry;

public class CreateModulePropertiesWriter
{
  protected static String nl;
  public static synchronized CreateModulePropertiesWriter create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateModulePropertiesWriter result = new CreateModulePropertiesWriter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "# ==============================================================================" + NL + "# ";
  protected final String TEXT_2 = " properties" + NL + "# ==============================================================================" + NL + "" + NL + "# ATL modules: if several, by order of superimposition (the latter ones overrides the former ones)";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = ".modules = ";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = NL + NL + "# Metamodels paths or nsUris";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = ".metamodels.";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = NL + NL + "# Libraries paths";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = ".libraries.";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = NL + NL + "# ATL Launching options";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = ".options.";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
 CreateRunnableData content = (CreateRunnableData) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_4);
    for (int i = 0; i < content.getTransformationFiles().length; i++) {
    stringBuffer.append(content.getTransformationFiles()[i].getName());
    if (i < content.getTransformationFiles().length -1 ) {
    stringBuffer.append(TEXT_5);
    }
    }
    stringBuffer.append(TEXT_6);
    for (String metamodelName : content.getAllMetamodelsNames()) { String location = content.getMetamodelLocations().get(metamodelName); 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(metamodelName);
    stringBuffer.append(TEXT_9);
    if (location != null) {
    stringBuffer.append(location);
    }
    }
    stringBuffer.append(TEXT_10);
    for (String libraryName : content.getAllLibrariesNames()) { String location = content.getLibraryLocations().get(libraryName); 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(libraryName);
    stringBuffer.append(TEXT_13);
    if (location != null) {
    stringBuffer.append(new Path(location).lastSegment());
    }
    }
    stringBuffer.append(TEXT_14);
    for (Entry<String, String> entry : content.getOptions().entrySet()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(entry.getValue());
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
