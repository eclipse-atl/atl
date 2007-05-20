package org.eclipse.m2m.atl.engine.vm.nativelib;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.engine.vm.ModelLoader;
import org.eclipse.m2m.atl.engine.vm.StackFrame;

/**
 * @author Frédéric Jouault
 */
public class ASMString extends ASMOclAny {

	public static ASMOclType myType = new ASMOclSimpleType("String", getOclAnyType());

	public ASMString(String s) {
		super(myType);
		this.s = s;
	}

	public String toString() {
		return "\'" + s + "\'";
	}

	public String getSymbol() {
		return s;
	}

	public boolean equals(Object o) {
		return (o instanceof ASMString) && (((ASMString)o).s.equals(s));
	}

	public int hashCode() {
		return s.hashCode();
	}

	public String cString() {
		StringBuffer ret = new StringBuffer();

		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			if(c == '\n') {
				ret.append("\\n");
			} else if(c == '\r') {
				ret.append("\\r");
			} else if(c == '\t') {
				ret.append("\\t");
			} else if(c == '\b') {
				ret.append("\\b");
			} else if(c == '\f') {
				ret.append("\\f");
			} else if((c < ' ') || ((c > '~') && (c < '¡'))) {
				ret.append("\\");
				if(c < 010)
					ret.append("0");
				if(c < 0100)
					ret.append("0");
				ret.append(java.lang.Integer.toOctalString(c));
			} else if(c == '\'') {
				ret.append("\\'");
			} else if(c == '\"') {
				ret.append("\\\"");
			} else if(c == '\\') {
				ret.append("\\\\");
			} else {
				ret.append(c);
			}
		}

		return "" + ret;
	}

	// Native Operations Below

	  // OCL Operations
	public static ASMInteger size(StackFrame frame, ASMString self) {
		return new ASMInteger(self.s.length());
	}

	public static ASMString concat(StackFrame frame, ASMString self, ASMString o) {
		return new ASMString(self.s + o.s);
	}

	public static ASMString substring(StackFrame frame, ASMString self, ASMInteger start, ASMInteger end) {
		return new ASMString(self.s.substring(start.getSymbol() - 1, end.getSymbol()));
	}

	public static ASMInteger toInteger(StackFrame frame, ASMString self) {
		return new ASMInteger(Integer.parseInt(self.s));
	}

	public static ASMReal toReal(StackFrame frame, ASMString self) {
		return new ASMReal(Double.parseDouble(self.s));
	}
	
	public static ASMBoolean toBoolean(StackFrame frame, ASMString self) throws Exception {
//		return new ASMBoolean(Boolean.parseBoolean(self.s.toLowerCase()));
		String s = self.s.toLowerCase(); 
		if (s.equals("true") || s.equals("yes"))
			return new ASMBoolean(true);
		else if (s.equals("false") || s.equals("no"))
			return new ASMBoolean(false);
		else
			throw new Exception("Cannot convert to Boolean the String "+ self + ", the value is different from true/false or yes/no");
	}

	public static ASMBoolean operatorEQ(StackFrame frame, ASMString self, ASMOclAny o) {
		if(o instanceof ASMString) {
			return new ASMBoolean(self.s.equals(((ASMString)o).s));
		} else {
			return new ASMBoolean(false);
		}
	}

	public static ASMBoolean operatorNE(StackFrame frame, ASMString self, ASMString o) {
		if(o instanceof ASMString) {
			return new ASMBoolean(!self.s.equals(((ASMString)o).s));
		} else {
			return new ASMBoolean(true);
		}
	}


	  // Additional Operations
	
	public static ASMSequence toSequence(StackFrame frame, ASMString self) {
		ASMSequence ret = new ASMSequence();

		for(int i = 0 ; i < self.s.length() ; i++)
			ret.add(new ASMString("" + self.s.charAt(i)));

		return ret;
	}

	    // Ordering Operations (using lexicographic order)
	public static ASMBoolean operatorLT(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.compareTo(o.s) < 0);
	}

	public static ASMBoolean operatorLE(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.compareTo(o.s) <= 0);
	}

	public static ASMBoolean operatorGT(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.compareTo(o.s) > 0);
	}

	public static ASMBoolean operatorGE(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.compareTo(o.s) >= 0);
	}

	     // Misc Operations
	public static ASMString operatorPlus(StackFrame frame, ASMString self, ASMString o) {
		return new ASMString(self.s + o.s);
	}

	public static ASMString toCString(StackFrame frame, ASMString self) {
		return new ASMString(self.cString());
	}

	public static ASMString toUpper(StackFrame frame, ASMString self) {
		return new ASMString(self.s.toUpperCase());
	}

	public static ASMString toLower(StackFrame frame, ASMString self) {
		return new ASMString(self.s.toLowerCase());
	}

	public static ASMString trim(StackFrame frame, ASMString self) {
		return new ASMString(self.s.trim());
	}

	public static ASMBoolean startsWith(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.startsWith(o.s));
	}

	public static ASMBoolean endsWith(StackFrame frame, ASMString self, ASMString o) {
		return new ASMBoolean(self.s.endsWith(o.s));
	}

	public static ASMInteger indexOf(StackFrame frame, ASMString self, ASMString o) {
		return new ASMInteger(self.s.indexOf(o.s));
	}

	public static ASMInteger lastIndexOf(StackFrame frame, ASMString self, ASMString o) {
		return new ASMInteger(self.s.lastIndexOf(o.s));
	}

	public static ASMString regexReplaceAll(StackFrame frame, ASMString self, ASMString a, ASMString b) {
		return new ASMString(self.s.replaceAll(a.s, b.s));
	}

	public static ASMSequence split(StackFrame frame, ASMString self, ASMString a) {
		ASMSequence ret = new ASMSequence();
		
		String s[] = self.s.split(a.s);
		for(int i = 0 ; i < s.length ; i++) {
			ret.add(new ASMString(s[i]));
		}
			
		return ret;
	}

	public static ASMString replaceAll(StackFrame frame, ASMString self, ASMString a, ASMString b) {
		return new ASMString(self.s.replace(a.s.charAt(0), b.s.charAt(0)));
	}

    // File input
	public static ASMOclAny readFrom(StackFrame frame, ASMString self) {
		ASMOclAny ret;
		
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader in = new BufferedReader(new FileReader(self.s));
			
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			
			ret = new ASMString(sb.toString());
		} catch(IOException ioe) {
			frame.printStackTrace("error: could not read from file " + self.s);
			ret = new ASMOclUndefined();;
		}
		
		return ret;
	}
	
    // File output
	public static ASMBoolean writeTo(StackFrame frame, ASMString self, ASMString fileName) {
		return writeToWithCharset(frame, self, fileName, null);
	}
	
	public static ASMBoolean writeToWithCharset(StackFrame frame, ASMString self, ASMString fileName, ASMString charset) {
		ASMBoolean ret = new ASMBoolean(false);

		try {
			File file = getFile(fileName.getSymbol());
			if(file.getParentFile() != null)
				file.getParentFile().mkdirs();
			PrintStream out = null;
			if(charset == null) {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true);
			} else {
				out = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true, charset.getSymbol());
			}
			out.print(self.s);
			out.close();
			ret = new ASMBoolean(true);
		} catch(IOException ioe) {
			frame.printStackTrace(ioe);
		}

		return ret;
	}

	public static void println(StackFrame frame, ASMString self) {
		System.out.println(self.s);
	}
          // End File output

	public static ASMString toString(StackFrame frame, ASMString self) {
		return self;
	}

	public static ASMOclAny inject(StackFrame frame, ASMString self, ASMString targetModelName, ASMString kind, ASMString params) {
		ASMOclAny ret = null;
		
		ASMModel tgt = frame.getExecEnv().getModel(targetModelName.getSymbol());
		if(tgt == null)
			frame.printStackTrace("Error: could not find model " + targetModelName);
		ModelLoader ml = tgt.getModelLoader();
		ret = ml.inject(tgt, kind.getSymbol(), params.getSymbol(), null, new ByteArrayInputStream(self.s.getBytes()));
		
		if(ret == null)
			ret = new ASMOclUndefined();
		
		return ret;
	}

	// Below: ATL Compiler specific operations.
	public static ASMOclAny evalSOTS(StackFrame frame, ASMString self, ASMTuple args) {	// TODO: en asm ou ocl
		ASMOclAny ret = new ASMOclUndefined();
		try {
			ret = new SOTSExpression2(self.s).exec(frame, args);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
		return ret;
	}

	public static ASMOclAny evalSOTSBrackets(StackFrame frame, ASMString self, ASMTuple args) {	// TODO: en asm ou ocl
boolean debug = false;
		StringBuffer ret = new StringBuffer();
		Reader in = new StringReader(self.s);
		int c;

if(debug) System.out.println("evalBrackets(\"" + self.s + "\")");
		try {
			boolean done = false;
			do {
				c = in.read();
				switch(c) {
					case -1:
						done = true;
						break;
					case '{':
						StringBuffer exp = new StringBuffer();
						while((c = in.read()) != '}') {
							exp.append((char)c);
						}
if(debug) System.out.println("\tEvaluating : " + exp);
						ASMOclAny result = new SOTSExpression2(exp.toString()).exec(frame, args);
if(debug) System.out.println("\t\t=>" + result);
						if(result instanceof ASMCollection) {
							result = (ASMOclAny)((ASMCollection)result).iterator().next();
						}
						if(result instanceof ASMString) {
							ret.append(((ASMString)result).s);
						} else {
							ret.append(result.toString());
						}
						break;
					default:
						ret.append((char)c);
						break;
				}
			} while(!done);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
if(debug) System.out.println("result = \"" + ret + "\"");

		return new ASMString(ret.toString());
	}
          // End ATL Compiler specific Operations

	private String s;
    
    
    /**
     * @param path The absolute or relative path to a file. 
     * @return The file in the workspace, or the file in the filesystem if
     * the workspace is not available.
     * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
     */
    public static File getFile(String path) {
        try {
            Class rp = Class.forName("org.eclipse.core.resources.ResourcesPlugin");
            Object ws = rp.getMethod("getWorkspace", null).invoke(null, null);
            Object root = ws.getClass().getMethod("getRoot", null).invoke(ws, null);
            Path wspath = new Path(path);
            Object wsfile = root.getClass().getMethod("getFile", 
                    new Class[]{IPath.class}).invoke(root, new Object[]{wspath});
            path = wsfile.getClass().getMethod("getLocation", null).invoke(
                    wsfile, null).toString();
        } catch (Throwable e) {
            //fall back to native java.io.File path resolution
        }
        return new File(path);
    }
}
