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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = ".modules=";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ".metamodels.";
  protected final String TEXT_6 = "=";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = ".libraries.";
  protected final String TEXT_9 = "=";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = ".options.";
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
 CreateRunnableData content = (CreateRunnableData) argument;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_2);
    for (int i = 0; i < content.getTransformationFiles().length; i++) {
    stringBuffer.append(content.getTransformationFiles()[i].getName());
    if (i < content.getTransformationFiles().length -1 ) {
    stringBuffer.append(TEXT_3);
    }
    }
    for (String metamodelName : content.getAllMetamodelsNames()) { String location = content.getMetamodelLocations().get(metamodelName); 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(metamodelName);
    stringBuffer.append(TEXT_6);
    if (location != null) {
    stringBuffer.append(location);
    }
    }
    for (String libraryName : content.getAllLibrariesNames()) { String location = content.getLibraryLocations().get(libraryName); 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(libraryName);
    stringBuffer.append(TEXT_9);
    if (location != null) {
    stringBuffer.append(new Path(location).lastSegment());
    }
    }
    for (Entry<String, String> entry : content.getOptions().entrySet()) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(content.getClassShortName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(entry.getValue());
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
