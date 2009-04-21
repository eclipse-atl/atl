/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: TCSRuntime.java,v 1.1 2009/04/21 14:12:26 wpiers Exp $
 */
package org.eclipse.m2m.atl.dsls.tcs.injector;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.m2m.atl.dsls.tcs.injector.wrappers.ParserWrapper;

/**
 * @author <a href="mailto:frederic.jouault@univ-nantes.fr">Frederic Jouault</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class TCSRuntime {

	// begin arguments
	private ModelAdapter targetModelAdapter;
	private ModelAdapter problemsModelAdapter;
		
	private boolean keepLocation;
	private boolean keepNL;
	private boolean keepComments;
	
	private Map locationByElement;
	private Map hyperlinks;
	private Map trace;
	// end arguments
		
	private ParserWrapper parserWrapper;
	private Context currentContext;
	private Map contextByElement;
	private Stack previousElement;
	private boolean lastWasCreation;
	private List refSettings;
	private Object lastToken;
	private CompletionInformation completionInformation = null;
	private int nbErrors = 0;


	public TCSRuntime(ModelAdapter targetModelAdapter, ParserWrapper parserWrapper, List refSettings, Map arguments) {
		this.targetModelAdapter = targetModelAdapter;	
		this.problemsModelAdapter = (ModelAdapter)arguments.get("problems");
		this.parserWrapper = parserWrapper;
		this.refSettings = refSettings;
		
		this.keepNL = ("true".equals(arguments.get("keepNL"))) ? true : false;
		this.keepLocation  = ("false".equals(arguments.get("keepLocation"))) ? false : true;
		this.keepComments = ("false".equals(arguments.get("keepComments"))) ? false : true;
		this.completionInformation = (CompletionInformation)arguments.get("completionInformation");
		
		// hyperlinks can be null
		this.hyperlinks = (Map)arguments.get("hyperlinks");
		// trace can be null
		this.trace = (Map)arguments.get("trace");
		this.locationByElement = arguments.get("locationByElement") == null ? new HashMap() : (Map)arguments.get("locationByElement");
		
		previousElement = new Stack();
		currentContext = new Context();
		contextByElement = new HashMap();
		
		lastWasCreation = true;
	}

	public int getNbErrors() {
		return nbErrors;
	}

	/**
	 * @return the targetModelAdapter
	 */
	public ModelAdapter getTargetModelAdapter() {
		return targetModelAdapter;
	}

	public boolean isKeepNL() {
		return keepNL;
	}

	public Object createEnumLiteral(String name) {
		return getTargetModelAdapter().createEnumLiteral(name);
	}

	public Object create(String name, boolean context, boolean addToContext) {
		Object ret = null;

		if(debug) debug("creating " + name);

		ret = getTargetModelAdapter().createElement(name);

		if(addToContext) currentContext.add(ret);
		if(context) currentContext = currentContext.enterContext(ret);
		if(lastWasCreation) {
			previousElement.push(null);
//			prevType.push(name);
		}/* else {
			prevType.pop();
			prevType.push(name);
		}*/
		lastWasCreation = true;

		return ret;
	}

	public void leaveContext(boolean leave) {
		if(leave) currentContext = currentContext.parent();
	}

	// Usefull? at least, it is called by grammars
	public void addToContext(Object ame, boolean addToContext) {
		if(addToContext) currentContext.add(ame);		
	}

	public void setLocation(Object ame, String location) {
		if(location.matches("^0:0-.+")) {
			location = location.split("-")[1];
			location = location + "-" + location;
		}
		locationByElement.put(ame, location);
		if(keepLocation) {
			try {
				getTargetModelAdapter().set(ame, "location", location);
			} catch(Exception e) {
				reportProblem("Warning", "could not set location of " + ame + ", disabling further location settings", location);
				keepLocation = false;
			}
		}
	}

	public void setCommentsBefore(Object ame, Object token) {
		parserWrapper.setCommentsBefore(ame, token);
	}

	public void setCommentsAfter(Object ame, Object token) {
		parserWrapper.setCommentsAfter(ame, token);
	}

	public void set(Object ame, String prop, Object value) {
		getTargetModelAdapter().set(ame, prop, value);
		if(trace != null) {
			ElementTrace et = (ElementTrace)trace.get(ame);
			if(et == null) {
				et = new ElementTrace(ame);
				trace.put(ame, et);
			}
			Object lastToken = parserWrapper.getLastToken();
			et.addPropertyLocation(prop, parserWrapper.getLocation(lastToken));
		}
	}

	public void setRef(Object object,
			String propertyName,
			String valueTypeName,
			String keyName,
			Object keyValue,
			String lookIn,
			String autoCreate,
			String createAs,
			boolean importContext,
			String createIn) {
		if(keyValue == null) return;

		new RefSetting(currentContext,
				object,
				propertyName,
				valueTypeName,
				keyName,
				keyValue,
				lookIn,
				autoCreate,
				createAs,
				importContext,
				createIn, lastToken);
	}

	public void reportProblem(String severity, String msg, Object ame) {
		String location = "<unknown location>";
//		if(keepLocation) {
//		try {
//		location = targetModelAdapter.getString(ame, "location");
//		} catch(Exception e) {
//		e.printStackTrace();
//		}
//		}
		if(locationByElement.containsKey(ame))
			location = (String)locationByElement.get(ame);
		reportProblem(severity, msg, location);
	}

	public void reportProblem(String severity, String msg, String location) {
		if("error".equals(severity.toLowerCase())) {
			nbErrors++;
		}
		if(problemsModelAdapter == null) {
			System.err.println(severity + ": " + location + ": " + msg + ".");
		} else {
			Object ame = problemsModelAdapter.createElement("Problem");
			problemsModelAdapter.set(ame, "severity", problemsModelAdapter.createEnumLiteral(severity.toLowerCase()));
			problemsModelAdapter.set(ame, "location", location);
			problemsModelAdapter.set(ame, "description", msg);
		}
	}

	public void reportError(Exception re) {
		parserWrapper.reportError(re);
	}

	public void reportError(String msg) {
		reportProblem("Error", msg, "?");
	}

	public void reportWarning(String msg) {
		reportProblem("Warning", msg, "?");
	}

	protected class Context {

		public Context enterContext(Object element) {
			Context ret = new Context(element, this);

			contextByElement.put(element, ret);

			return ret;
		}

		// Only for root Context
		public Context() {
			this.parent = null;
		}

		private Context(Object element, Context parent) {
			this.parent = parent;
			this.element = element;
		}

		// cannot be called once RefSettings have started populating mapByTypeAndKey,
		// add(Object, String, Object) must be called instead
		public void add(Object e) {
			if(debug) debug("adding " + e + "to context");
			contents.add(e);
		}

		// to add an element after population of mapByTypeAndKey has started,
		// Note that the element does not get added in imported contexts
		public void add(Object e, String valueTypeName, String keyName, Object keyVal) {
			add(e);	// might be necessary
			Map elementByVal = getElementByVal(valueTypeName, keyName);
			addElementByVal(elementByVal, e, keyVal);
		}

		private void addElementByVal(Map elementByVal, Object ame, Object val) {
			Object element = elementByVal.get(val);
			if(element == null) {
				elementByVal.put(val, ame);
			} else if(element instanceof Collection){
				((Collection)element).add(ame);
			} else {
				Collection c = new ArrayList();
				c.add(element);
				c.add(ame);
				elementByVal.put(val, c);
			}
		}
//		public ContextIterator iterator() {
//			return new ContextIterator(this, contents.iterator(), importedContexts);
//		}

//		public ContextIterator iterator(Set traversed) {
//			return new ContextIterator(traversed, this, contents.iterator(), importedContexts);
//		}

		public Context parent() {
			return parent;
		}

		public void importContext(Context c) {
			importedContexts.add(c);
		}

		public Object getElement() {
			return element;
		}

		private Object element;
		private Context parent;
		private Set contents = new HashSet();
		private Set importedContexts = new HashSet();

		private Map mapByTypeAndKey = new HashMap();
		/**
		 * @param valueTypeName
		 * @param keyName
		 * @param keyVal
		 */
		public Map getElementByVal(String valueTypeName, String keyName) {
			String key = "__" + valueTypeName + "_" + keyName;
			Map elementByVal = (Map)mapByTypeAndKey.get(key);
			if(elementByVal == null) {
				elementByVal = new HashMap();
				for(Iterator i = contents.iterator() ; i.hasNext() ; ) {
					Object ame = i.next();
//					if(debug) debug("\t" + ame + " : " + getTargetModelAdapter().get(getTargetModelAdapter().getType(ame), "name"));
					if(isCandidate(ame, valueTypeName)) {	// check type
						Object val = getTargetModelAdapter().get(ame, keyName);
						addElementByVal(elementByVal, ame, val);
					}
				}
				mapByTypeAndKey.put(key, elementByVal);
				for(Iterator i = importedContexts.iterator() ; i.hasNext() ; ) {
					Context importedContext = (Context)i.next();
					Map map = importedContext.getElementByVal(valueTypeName, keyName);
					for(Iterator j = map.entrySet().iterator() ; j.hasNext() ; ) {
						Map.Entry entry = (Map.Entry)j.next();
						if(!elementByVal.containsKey(entry.getKey())) {
							elementByVal.put(entry.getKey(), entry.getValue());
						}
					}
				}
			}
			return elementByVal;
		} 

		private boolean isCandidate(Object ame, String valueTypeName) {
			return getTargetModelAdapter().isCandidate(ame, valueTypeName);
		}
	}

//	protected class ContextIterator implements Iterator {
//
//		private Iterator i;
//		private ContextIterator currentIterator = null;
//		private Iterator importedContexts;
//		private Set traversed;
//		private boolean finishCurrent = false;
//
//		public void finishCurrent() {
//			finishCurrent = true;
//			if(currentIterator != null)
//				currentIterator.finishCurrent();
//		}
//
//		public ContextIterator(Context c, Iterator i, Set imported) {
//			this(new HashSet(), c, i, imported);
//		}
//
//		public ContextIterator(Set traversed, Context c, Iterator i, Set imported) {
//			this.traversed = traversed;
//			traversed.add(c);
//			this.i = i;
//			this.importedContexts = imported.iterator();
//		}
//
//		public boolean hasNext() {
//			while(importedContexts.hasNext() && (!i.hasNext()) && !finishCurrent){
//				Context c = (Context)importedContexts.next();
//				if(!traversed.contains(c)) {
//					traversed.add(c);
//					currentIterator = c.iterator(traversed);
//					i = currentIterator;
//				} else {
//					System.out.println("ERROR: recursive contexts");
//				}
//			}
//
//			return i.hasNext();
//		}
//
//		public Object next() {
//			return i.next();
//		}
//
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}
//	}

	protected class RefSetting {

		public RefSetting(
				Context currentContext,
				Object object,
				String propertyName,
				String valueTypeName,
				String keyName,
				Object keyValue,
				String lookIn,
				String autoCreate,
				String createAs,
				boolean importContext,
				String createIn,
				Object token) {
			this.currentContext = currentContext;
			this.object = object;
			this.propertyName = propertyName;
			this.valueTypeName = valueTypeName;
			this.keyName = keyName;
			this.keyValue = keyValue;
			this.lookIn = lookIn;
			this.autoCreate = autoCreate;
			this.createAs = createAs;
			this.importContext = importContext;
			this.createIn = createIn;
			this.token = token;

			refSettings.add(this);
		}

		private boolean doItForContext(Context context) {
			boolean done = false;
			Object keyVal = keyValue;

			Map elementByVal = context.getElementByVal(valueTypeName, keyName);

			int offset = -1;
			Collection proposals = null;
			if(completionInformation != null) {
				offset = completionInformation.getOffset();
				if(
						(offset >= parserWrapper.getStartOffset(token) - 1) &&
						(offset <= parserWrapper.getEndOffset(token))) {
					proposals = completionInformation.getProposals();
					proposals.addAll(elementByVal.keySet());
					if(completionInformation.getPrefix() == null) {
						if(keyVal instanceof String) {
							completionInformation.setPrefix(
								((String)keyVal).substring(0, offset - parserWrapper.getStartOffset(token) + 1)
							);
						}
					}
				}
			}

			Object ame = elementByVal.get(keyVal);
			if(ame instanceof Collection) {
				for(Iterator i = ((Collection)ame).iterator() ; i.hasNext() ; ) {
					reportProblem("Error", "found several " + valueTypeName + " with the same " + keyName + " equals to " + keyVal, i.next());
				}
				done = true;
			} else if(ame != null) {
				realValue = ame;
				getTargetModelAdapter().set(object, propertyName, ame);
//				if(keepLocation && (hyperlinks != null)) {
//					try {
//						String location = parserWrapper.getLocation(token);
//						hyperlinks.put(location, targetModelAdapter.getString(ame, "location"));
//					} catch(Exception e) {}
//				}
				if(hyperlinks != null) {
					String location = parserWrapper.getLocation(token);
					hyperlinks.put(location, locationByElement.get(ame));
				}
				if(trace != null) {
					ElementTrace et = (ElementTrace)trace.get(object);
					if(et == null) {
						et = new ElementTrace(object);
						trace.put(object, et);
					}
					ReferenceLocation location = new ReferenceLocation(parserWrapper.getLocation(token), ame);
					et.addPropertyLocation(propertyName, location);
				}
				done = true;
			}
			if(!done) {
				context = context.parent();
				if(context != null)
					done = doItForContext(context);
			}

			return done;
		}

		private void create() {
			Object ro = null;
			if(createAs != null) {
				ro = getTargetModelAdapter().createElement(createAs);
			} else {
				ro = getTargetModelAdapter().createElement(valueTypeName);
			}
			realValue = ro;
//			do not need this with the model handler
//			ASMOclAny realKeyValue = null;
//			if(keyValue instanceof String) {
//			realKeyValue = new ASMString((String)keyValue);
//			} else {
//			realKeyValue = (ASMOclAny)keyValue;
//			}
			getTargetModelAdapter().set(ro, keyName, keyValue);
			getTargetModelAdapter().set(object, propertyName, ro);
			try {
				String location = parserWrapper.getLocation(token);
				setLocation(ro, location);
			} catch(Exception e) {}

			if(createIn != null) {
				String path[] = createIn.split("\\.");
				Object e = navigateLookIn(path, false);
				if(e != null) {
					getTargetModelAdapter().set(e, path[path.length - 1], ro);
					currentContext.add(ro, valueTypeName, keyName, keyValue);
				}
			} else if((lookIn != null) &&  !lookIn.equals("#all")) {
				String path[] = lookIn.split("\\.");
				Object e = navigateLookIn(path, false);
				if(e != null) {
					getTargetModelAdapter().set(e, path[path.length - 1], ro);
					currentContext.add(ro, valueTypeName, keyName, keyValue);
				}
			}			
		}

		private Object navigateLookIn(String path[], boolean navigateLast) {
			Object ret = object;
			for(int i = 0 ; (i < path.length - (navigateLast ? 0 : 1)) && (ret != null) ; i++) {
				if(path[i].equals("#context")) {
					ret = currentContext.getElement();
				} else {
					Object v = getTargetModelAdapter().get(ret, path[i]);
					if(getTargetModelAdapter().isAModelElement(v)) {
						ret = v;
					} else {
						ret = null;
					}
				}
			}
			return ret;
		}

		public void doIt() {
			boolean done = false;

			if(debug) debug("setRef(" +
					currentContext + ", " +
					object + ", " +
					propertyName + ", " +
					valueTypeName + ", " +
					keyName + ", " +
					keyValue + ", " +
					lookIn + ", " +
					autoCreate + ") : "
			);

			if(autoCreate.equals("always")) {
				create();
				done = true;
			} else {
				Context context = currentContext;
				if("#all".equals(lookIn)) {
					Object val = null;
					for(Iterator i = getTargetModelAdapter().getElementsByType(valueTypeName).iterator() ; i.hasNext() && (val == null) ; ) {
						Object ame = i.next();
						if(debug) debug("\t" + ame + " : " + getTargetModelAdapter().get(getTargetModelAdapter().getType(ame), "name"));
						//if(targetModelAdapter.get(ame, keyName).equals(new ASMString((String)keyValue))) {
						// this may not work (we should have to override equals of ASMString to compare it to a String)
						if(getTargetModelAdapter().get(ame, keyName).equals(keyValue)) {
							val = ame;
						}
					}

					if(val != null) {
						realValue = val;
						getTargetModelAdapter().set(object, propertyName, val);
						done = true;
					}
				} else if((lookIn != null) && !lookIn.equals("#all")) {
					String path[] = lookIn.split("\\.");
					Object e = navigateLookIn(path, true);

					if(e != null) {
						context = (Context)contextByElement.get(e);
						done = doItForContext(context);
					}
				} else {
					done = doItForContext(context);				
				}
			}	
			if(!done) {
				if(debug) debug("not found");

				if(!autoCreate.equals("never")) {
					create();
				} else {
					reportProblem("Error", valueTypeName + " with " + keyName + " = " + keyValue + " was not found for " + propertyName + " of " + getTargetModelAdapter().getType(object), object);
				}
			}

			if(realValue != null) {
				Context context = (Context)contextByElement.get(realValue);
				if(importContext && (context != null)) {
					((Context)contextByElement.get(object)).importContext(context);
				}					
			}
		}

		private Context currentContext;
		private Object object;
		private String propertyName;
		private String valueTypeName;
		private String keyName;
		private Object keyValue;
		private String lookIn;
		private String autoCreate;
		private String createAs;
		protected boolean importContext;
		private String createIn;
		private Object token;

		private Object realValue = null;
	}

	public void setToken(Object token) {
		lastToken = token;
	}

	// TODO: remove once TCS-importer.jar is bootstrapped
//	public void setToken(Token token) {
//	lastToken = token;
//	}

	public String unescapeString(String s, int delimLength) {
		StringBuffer ret = new StringBuffer();
		// get rid of the starting and ending delimiters (e.g., '\'', '"')
		s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));

		CharacterIterator ci = new StringCharacterIterator(s);
		char c = ci.first();
		while(c != CharacterIterator.DONE) {
			char tc = 0;
			switch(c) {
			case '\\':
				c = ci.next();
				switch(c) {
				case 'n':
					tc = '\n';
					break;
				case 'r':
					tc = '\r';
					break;
				case 't':
					tc = '\t';
					break;
				case 'b':
					tc = '\b';
					break;
				case 'f':
					tc = '\f';
					break;
				case '"':
					tc = '"';
					break;
				case '\'':
					tc = '\'';
					break;
				case '\\':
					tc = '\\';
					break;
				case '0':
				case '1':
				case '2':
				case '3':
					throw new RuntimeException("octal escape sequences not supported yet");
				default:
					throw new RuntimeException("unknown escape sequence: '\\" + c + "'");
				}
				break;
			default:
				tc = c;
			break;
			}
			ret.append(tc);
			c = ci.next();
		}
		return ret.toString();
	}
	
	
	private final static boolean debug = false;
	private void debug(String msg) {
		System.out.println(msg);
	}

	public void setKeepComments(boolean keepComments) {
		this.keepComments = keepComments;
	}

	public boolean isKeepComments() {
		return keepComments;
	}

	public void setLastWasCreation(boolean lastWasCreation) {
		this.lastWasCreation = lastWasCreation;
	}
}
