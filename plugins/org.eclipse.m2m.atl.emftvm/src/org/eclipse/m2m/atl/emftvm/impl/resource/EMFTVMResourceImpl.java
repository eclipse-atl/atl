/*******************************************************************************
 * Copyright (c) 2011 Vrije Universiteit Brussel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dennis Wagelaar, Vrije Universiteit Brussel - initial API and
 *         implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.m2m.atl.emftvm.impl.resource;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.m2m.atl.emftvm.CodeBlock;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.EmftvmPackage;
import org.eclipse.m2m.atl.emftvm.Feature;
import org.eclipse.m2m.atl.emftvm.FeatureTag;
import org.eclipse.m2m.atl.emftvm.Field;
import org.eclipse.m2m.atl.emftvm.InputRuleElement;
import org.eclipse.m2m.atl.emftvm.Instruction;
import org.eclipse.m2m.atl.emftvm.LineNumber;
import org.eclipse.m2m.atl.emftvm.LocalVariable;
import org.eclipse.m2m.atl.emftvm.ModelDeclaration;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.NamedElement;
import org.eclipse.m2m.atl.emftvm.Opcode;
import org.eclipse.m2m.atl.emftvm.Operation;
import org.eclipse.m2m.atl.emftvm.OutputRuleElement;
import org.eclipse.m2m.atl.emftvm.Parameter;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.m2m.atl.emftvm.RuleMode;
import org.eclipse.m2m.atl.emftvm.TypedElement;


/**
 * EMF {@link ResourceImpl} for the EMFTVM binary module format.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class EMFTVMResourceImpl extends ResourceImpl {

	/**
	  * Magic header: "ETVM"
	  * http://www.asciitable.com/
	  */
	public static final int MAGIC = 0x4554564D;

	protected static final EmftvmFactory factory = EmftvmFactory.eINSTANCE;

	/**
	 * Creates a new {@link EMFTVMResourceImpl}.
	 */
	public EMFTVMResourceImpl() {
		super();
	}

	/**
	 * Creates a new {@link EMFTVMResourceImpl} from a URI.
	 * @param uri
	 */
	public EMFTVMResourceImpl(URI uri) {
		super(uri);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doLoad(java.io.InputStream, java.util.Map)
	 */
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		final DataInputStream in = new DataInputStream(inputStream);
		final int magic = in.readInt();
		if (magic != MAGIC) {
			throw new IOException("Wrong magic");
		}
		final ConstantPool constants = new ConstantPool();
		constants.read(in);
		final Module module = readModule(in, constants);
		getContents().add(module);
	}

	private static Module readModule(final DataInputStream in, 
			final ConstantPool constants) throws IOException {
		final Module module = factory.createModule();
		module.setName((String) constants.get(in.readInt()));
		module.setSourceName((String) constants.get(in.readInt()));
		readModelDeclarations(in, constants, module.getInputModels());
		readModelDeclarations(in, constants, module.getInoutModels());
		readModelDeclarations(in, constants, module.getOutputModels());
		final EList<String> imports = module.getImports();
		final int itsize = in.readInt();
		for (int i = 0; i < itsize; i++) {
			imports.add((String) constants.get(in.readInt()));
		}
		readFeatures(in, constants, module.getFeatures());
		readRules(in, constants, module.getRules());
		return module;
	}

	private static void readModelDeclarations(final DataInputStream in, 
			final ConstantPool constants, final EList<ModelDeclaration> models) throws IOException {
		final int msize = in.readInt();
		for (int i = 0; i < msize; i++) {
			ModelDeclaration model = factory.createModelDeclaration();
			models.add(model);
			model.setModelName((String) constants.get(in.readInt()));
			model.setMetaModelName((String) constants.get(in.readInt()));
		}
	}

	private static void readFields(final DataInputStream in, 
			final ConstantPool constants, final EList<Field> fields) throws IOException {
		final int fsize = in.readInt();
		for (int i = 0; i < fsize; i++) {
			Field f;
			int tag = in.readInt();
			switch (tag) {
			case FeatureTag.FIELD_VALUE:
				f = factory.createField();
				break;
			case FeatureTag.STATIC_FIELD_VALUE:
				f = factory.createField();
				f.setStatic(true);
				break;
			default:
				throw new UnsupportedEncodingException(String.format("Unsupported feature type: %d", tag));
			}
			fields.add(f); // first add feature, then parse
			readField(in, constants, (Field) f);
		}
	}

	private static void readFeatures(final DataInputStream in, 
			final ConstantPool constants, final EList<Feature> features) throws IOException {
		final int fsize = in.readInt();
		for (int i = 0; i < fsize; i++) {
			Feature f;
			int tag = in.readInt();
			switch (tag) {
			case FeatureTag.FIELD_VALUE:
				f = factory.createField();
				break;
			case FeatureTag.STATIC_FIELD_VALUE:
				f = factory.createField();
				f.setStatic(true);
				break;
			case FeatureTag.OPERATION_VALUE:
				f = factory.createOperation();
				break;
			case FeatureTag.STATIC_OPERATION_VALUE:
				f = factory.createOperation();
				f.setStatic(true);
				break;
			case FeatureTag.QUERY_OPERATION_VALUE:
				f = factory.createOperation();
				((Operation) f).setQuery(true);
				break;
			case FeatureTag.STATIC_QUERY_OPERATION_VALUE:
				f = factory.createOperation();
				f.setStatic(true);
				((Operation) f).setQuery(true);
				break;
			default:
				throw new UnsupportedEncodingException(String.format("Unsupported feature type: %d", tag));
			}
			features.add(f); // first add feature, then parse
			assert (f instanceof Field) || (f instanceof Operation);
			if (f instanceof Field) {
				readField(in, constants, (Field) f);
			} else {
				readOperation(in, constants, (Operation) f);
			}
		}
	}

	private static void readNamedElement(final DataInputStream in, 
			final ConstantPool constants, final NamedElement namedElement) throws IOException {
		namedElement.setName((String) constants.get(in.readInt()));
	}

	private static void readTypedElement(final DataInputStream in, 
			final ConstantPool constants, final TypedElement typedElement) throws IOException {
		readNamedElement(in, constants, typedElement);
		typedElement.setType((String) constants.get(in.readInt()));
		typedElement.setTypeModel((String) constants.get(in.readInt()));
	}

	private static void readFeature(final DataInputStream in, 
			final ConstantPool constants, final Feature feature) throws IOException {
		readTypedElement(in, constants, feature);
		feature.setContext((String) constants.get(in.readInt()));
		feature.setContextModel((String) constants.get(in.readInt()));
	}

	private static void readField(final DataInputStream in, 
			final ConstantPool constants, final Field field) throws IOException {
		readFeature(in, constants, field);
		final CodeBlock cb = factory.createCodeBlock();
		field.setInitialiser(cb);
		readCodeBlock(in, constants, cb);
	}

	private static void readOperation(final DataInputStream in, 
			final ConstantPool constants, final Operation op) throws IOException {
		readFeature(in, constants, op);
		readParameters(in, constants, op.getParameters());
		final CodeBlock cb = factory.createCodeBlock();
		op.setBody(cb);
		readCodeBlock(in, constants, cb);
	}

	private static void readCodeBlock(final DataInputStream in, 
			final ConstantPool constants, final CodeBlock cb) throws IOException {
		cb.setMaxLocals(in.readInt());
		cb.setMaxStack(in.readInt());
		readLocalVariables(in, constants, cb.getLocalVariables());
		readLineNumbers(in, cb.getLineNumbers());
		final int nestedSize = in.readInt();
		final EList<CodeBlock> nested = cb.getNested();
		for (int i = 0; i < nestedSize; i++) {
			CodeBlock nestedcode = factory.createCodeBlock();
			nested.add(nestedcode);
			readCodeBlock(in, constants, nestedcode);
		}
		readInstructions(in, constants, cb);
	}

	private static void readParameters(final DataInputStream in,
			final ConstantPool constants, final EList<Parameter> parameters) throws IOException {
		final int ptsize = in.readInt();
		for (int i = 0; i < ptsize; i++) {
			Parameter par = factory.createParameter();
			parameters.add(par);
			readTypedElement(in, constants, par);
		}
	}

	private static void readInstructions(final DataInputStream in,
			final ConstantPool constants, final CodeBlock cb) throws IOException {
		final LoadInstructionParametersSwitch loadParms = new LoadInstructionParametersSwitch(in, constants);
		final int isize = in.readInt();
		final EList<Instruction> code = cb.getCode();
		for (int i = 0; i < isize; i++) {
			int lineNumber = in.readInt();
			Instruction instr = factory.createInstruction(Opcode.get(in.readInt()));
			code.add(instr);
			if (lineNumber > -1) {
				instr.setLineNumber(cb.getLineNumbers().get(lineNumber));
			}
			loadParms.doSwitch(instr);
		}
	}

	private static void readLineNumbers(final DataInputStream in,
			final EList<LineNumber> lineNumbers) throws IOException {
		final int lnsize = in.readInt();
		for (int i = 0; i < lnsize; i++) {
			LineNumber ln = factory.createLineNumber();
			lineNumbers.add(ln);
			ln.setStartLine(in.readInt());
			ln.setStartColumn(in.readInt());
			ln.setEndLine(in.readInt());
			ln.setEndColumn(in.readInt());
			ln.setStartChar(in.readInt());
			ln.setEndChar(in.readInt());
		}
	}

	private static void readLocalVariables(final DataInputStream in,
			final ConstantPool constants, final EList<LocalVariable> localVars) throws IOException {
		final int lvsize = in.readInt();
		for (int i = 0; i < lvsize; i++) {
			LocalVariable lv = factory.createLocalVariable();
			localVars.add(lv);
			lv.setSlot(in.readInt());
			readTypedElement(in, constants, lv);
			lv.setStartInstructionIndex(in.readInt());
			lv.setEndInstructionIndex(in.readInt());
		}
	}

	private static void readRules(final DataInputStream in, 
			final ConstantPool constants, final EList<Rule> rules) throws IOException {
		final int rtsize = in.readInt();
		for (int i = 0; i < rtsize; i++) {
			Rule rule = factory.createRule();
			rules.add(rule);
			readNamedElement(in, constants, rule);
			rule.setMode(RuleMode.get(in.readInt()));
			rule.setAbstract(in.readInt() == 1); 
			rule.setDefault(in.readInt() == 1); 
			rule.setDistinctElements(in.readInt() == 1); 
			readInputRuleElements(in, constants, rule.getInputElements());
			readOutputRuleElements(in, constants, rule);
			readSuperRules(in, constants, rule.getSuperRules());
			readFields(in, constants, rule.getFields());
			//matcher
			if (in.readInt() > 0) {
				CodeBlock matcher = factory.createCodeBlock();
				rule.setMatcher(matcher);
				readCodeBlock(in, constants, matcher);
			}
			//applier
			if (in.readInt() > 0) {
				CodeBlock applier = factory.createCodeBlock();
				rule.setApplier(applier);
				readCodeBlock(in, constants, applier);
			}
			//post-apply
			if (in.readInt() > 0) {
				CodeBlock postApply = factory.createCodeBlock();
				rule.setPostApply(postApply);
				readCodeBlock(in, constants, postApply);
			}
		}
	}

	private static void readInputRuleElements(final DataInputStream in, 
			final ConstantPool constants, final EList<InputRuleElement> elements) throws IOException {
		final int esize = in.readInt();
		for (int i = 0; i < esize; i++) {
			InputRuleElement ire = factory.createInputRuleElement();
			elements.add(ire);
			readTypedElement(in, constants, ire);
			int iemsize = in.readInt();
			final EList<String> models = ire.getModels();
			for (int j = 0; j < iemsize; j++) {
				models.add((String) constants.get(in.readInt()));
			}
			if (in.readInt() > 0) {
				CodeBlock binding = factory.createCodeBlock();
				ire.setBinding(binding);
				readCodeBlock(in, constants, binding);
			}
		}
	}

	private static void readOutputRuleElements(final DataInputStream in, 
			final ConstantPool constants, final Rule rule) throws IOException {
		final EList<OutputRuleElement> elements = rule.getOutputElements();
		final int esize = in.readInt();
		for (int i = 0; i < esize; i++) {
			OutputRuleElement ore = factory.createOutputRuleElement();
			elements.add(ore);
			readTypedElement(in, constants, ore);
			ore.getModels().add((String) constants.get(in.readInt()));
			int index = in.readInt();
			if (index > -1) {
				String inputElementName = (String) constants.get(index);
				for (InputRuleElement ire : rule.getInputElements()) {
					if (inputElementName.equals(ire.getName())) {
						ore.setMapsTo(ire);
					}
				}
				if (ore.getMapsTo() == null) {
					throw new IOException(String.format(
							"Source element mapping %s not found for output element %s",
							inputElementName, ore));
				}
			}
		}
	}

	private static void readSuperRules(final DataInputStream in, 
			final ConstantPool constants, final EList<String> superRules) throws IOException {
		final int srsize = in.readInt();
		for (int i = 0; i < srsize; i++) {
			superRules.add((String) constants.get(in.readInt()));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doSave(java.io.OutputStream, java.util.Map)
	 */
	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		final DataOutputStream out = new DataOutputStream(outputStream);
		out.writeInt(MAGIC);
		final Module module = findModule();
		final ConstantPool constants = new ConstantPool();
		constants.createConstants(module);
		constants.write(out);
		writeModule(out, constants, module);
	}

	protected Module findModule() throws IOException {
		Module module = null;
		for (EObject object : getContents()) {
			if (object instanceof Module) {
				if (module == null) {
					module = (Module) object;
				} else {
					throw new IOException("More than one Module found in Resource");
				}
			}
		}
		if (module == null) {
			throw new IOException("No Module found in Resource");
		}
		return module;
	}

	private static void writeModule(final DataOutputStream out, 
			final ConstantPool constants, final Module module) throws IOException {
		out.writeInt(constants.indexOf(module.getName()));
		out.writeInt(constants.indexOf(module.getSourceName()));
		writeModelDeclarations(out, constants, module.getInputModels());
		writeModelDeclarations(out, constants, module.getInoutModels());
		writeModelDeclarations(out, constants, module.getOutputModels());
		final EList<String> imports = module.getImports();
		out.writeInt(imports.size());
		for (String i : imports) {
			out.writeInt(constants.indexOf(i));
		}
		final EList<Feature> features = module.getFeatures();
		writeFeatures(out, constants, features);
		writeRules(out, constants, module.getRules());
	}

	private static void writeModelDeclarations(final DataOutputStream out, 
			final ConstantPool constants, final EList<ModelDeclaration> models) throws IOException {
		out.writeInt(models.size());
		for (ModelDeclaration model : models) {
			out.writeInt(constants.indexOf(model.getModelName()));
			out.writeInt(constants.indexOf(model.getMetaModelName()));
		}
	}

	private static void writeFields(final DataOutputStream out, 
			final ConstantPool constants, final EList<Field> fields) throws IOException {
		out.writeInt(fields.size());
		for (Field field : fields) {
			out.writeInt(field.isStatic() ? FeatureTag.STATIC_FIELD_VALUE : FeatureTag.FIELD_VALUE);
			writeFeature(out, constants, field);
			if (field.getInitialiser() == null) {
				field.setInitialiser(factory.createCodeBlock()); // enforce multiplicity constraints
			}
			writeCodeBlock(out, constants, field.getInitialiser());
		}
	}

	private static void writeFeatures(final DataOutputStream out, 
			final ConstantPool constants, final EList<Feature> features) throws IOException {
		out.writeInt(features.size());
		for (Feature f : features) {
			switch (f.eClass().getClassifierID()) {
			case EmftvmPackage.FIELD:
				Field field = (Field) f;
				out.writeInt(f.isStatic() ? FeatureTag.STATIC_FIELD_VALUE : FeatureTag.FIELD_VALUE);
				writeFeature(out, constants, field);
				if (field.getInitialiser() == null) {
					field.setInitialiser(factory.createCodeBlock()); // enforce multiplicity constraints
				}
				writeCodeBlock(out, constants, field.getInitialiser());
				break;
			case EmftvmPackage.OPERATION:
				Operation op = (Operation) f;
				FeatureTag tag;
				int opflags = (f.isStatic() ? 1 : 0) + (((Operation) f).isQuery() ? 2 : 0);
				switch (opflags) {
				case 0: tag = FeatureTag.OPERATION; break;
				case 1:	tag = FeatureTag.STATIC_OPERATION; break;
				case 2: tag = FeatureTag.QUERY_OPERATION; break;
				case 3: tag = FeatureTag.STATIC_QUERY_OPERATION; break;
				default:
					throw new UnsupportedEncodingException();
				}
				out.writeInt(tag.getValue());
				writeFeature(out, constants, op);
				writeParameters(out, constants, op.getParameters());
				if (op.getBody() == null) {
					op.setBody(factory.createCodeBlock()); // enforce multiplicity constraints
				}
				writeCodeBlock(out, constants, op.getBody());
				break;
			default:
				throw new UnsupportedEncodingException(String.format("Unknown feature tag for feature %s", f));
			}
		}
	}

	private static void writeNamedElement(final DataOutputStream out, 
			final ConstantPool constants, final NamedElement namedElement) throws IOException {
		out.writeInt(constants.indexOf(namedElement.getName()));
	}

	private static void writeTypedElement(final DataOutputStream out, 
			final ConstantPool constants, final TypedElement typedElement) throws IOException {
		writeNamedElement(out, constants, typedElement);
		out.writeInt(constants.indexOf(typedElement.getType()));
		out.writeInt(constants.indexOf(typedElement.getTypeModel()));
	}

	private static void writeFeature(final DataOutputStream out, 
			final ConstantPool constants, final Feature feature) throws IOException {
		writeTypedElement(out, constants, feature);
		out.writeInt(constants.indexOf(feature.getContext()));
		out.writeInt(constants.indexOf(feature.getContextModel()));
	}

	private static void writeCodeBlock(final DataOutputStream out, 
			final ConstantPool constants, final CodeBlock cb) throws IOException {
		out.writeInt(cb.getMaxLocals());
		out.writeInt(cb.getMaxStack());
		writeLocalVariables(out, constants, cb);
		writeLineNumbers(out, cb);
		final EList<CodeBlock> nested = cb.getNested();
		out.writeInt(nested.size());
		for (CodeBlock nestedcode : nested) {
			writeCodeBlock(out, constants, nestedcode);
		}
		writeInstructions(out, constants, cb);
	}

	private static void writeParameters(final DataOutputStream out,
			final ConstantPool constants, final EList<Parameter> parameters) throws IOException {
		out.writeInt(parameters.size());
		for (Parameter p : parameters) {
			writeTypedElement(out, constants, p);
		}
	}

	private static void writeInstructions(final DataOutputStream out,
			final ConstantPool constants, final CodeBlock cb) throws IOException {
		final SaveInstructionParametersSwitch saveParms = new SaveInstructionParametersSwitch(out, constants);
		final EList<Instruction> code = cb.getCode();
		final EList<LineNumber> lns = cb.getLineNumbers();
		out.writeInt(code.size());
		for (Instruction i : code) {
			LineNumber ln = i.getLineNumber();
			if (ln != null) {
				out.writeInt(lns.indexOf(ln));
			} else {
				out.writeInt(-1);
			}
			out.writeInt(i.getOpcode().getValue());
			saveParms.doSwitch(i);
		}
	}

	private static void writeLineNumbers(final DataOutputStream out,
			final CodeBlock cb) throws IOException {
		final EList<LineNumber> lineNumbers = cb.getLineNumbers();
		out.writeInt(lineNumbers.size());
		for (LineNumber l : lineNumbers) {
			out.writeInt(l.getStartLine());
			out.writeInt(l.getStartColumn());
			out.writeInt(l.getEndLine());
			out.writeInt(l.getEndColumn());
			out.writeInt(l.getStartChar());
			out.writeInt(l.getEndChar());
		}
	}

	private static void writeLocalVariables(final DataOutputStream out,
			final ConstantPool constants, final CodeBlock cb) throws IOException {
		final EList<LocalVariable> localVars = cb.getLocalVariables();
		out.writeInt(localVars.size());
		for (LocalVariable lv : localVars) {
			out.writeInt(lv.getSlot());
			writeTypedElement(out, constants, lv);
			out.writeInt(lv.getStartInstructionIndex());
			out.writeInt(lv.getEndInstructionIndex());
		}
	}

	private static void writeRules(final DataOutputStream out, 
			final ConstantPool constants, final EList<Rule> rules) throws IOException {
		out.writeInt(rules.size());
		for (Rule r : rules) {
			writeNamedElement(out, constants, r);
			out.writeInt(r.getMode().getValue());
			out.writeInt(r.isAbstract() ? 1 : 0);
			out.writeInt(r.isDefault() ? 1 : 0);
			out.writeInt(r.isDistinctElements() ? 1 : 0);
			writeInputRuleElements(out, constants, r.getInputElements());
			writeOutputRuleElements(out, constants, r);
			writeSuperRules(out, constants, r.getSuperRules());
			writeFields(out, constants, r.getFields());
			//matcher
			if (r.getMatcher() == null) {
				out.writeInt(0);
			} else {
				out.writeInt(1);
				writeCodeBlock(out, constants, r.getMatcher());
			}
			//applier
			if (r.getApplier() == null) {
				out.writeInt(0);
			} else {
				out.writeInt(1);
				writeCodeBlock(out, constants, r.getApplier());
			}
			//post-apply
			if (r.getPostApply() == null) {
				out.writeInt(0);
			} else {
				out.writeInt(1);
				writeCodeBlock(out, constants, r.getPostApply());
			}
		}
	}

	private static void writeInputRuleElements(final DataOutputStream out, 
			final ConstantPool constants, final EList<InputRuleElement> elements) throws IOException {
		out.writeInt(elements.size());
		for (InputRuleElement ire : elements) {
			writeTypedElement(out, constants, ire);
			final EList<String> models = ire.getModels();
			out.writeInt(models.size());
			for (String model : models) {
				out.writeInt(constants.indexOf(model));
			}
			if (ire.getBinding() == null) {
				out.writeInt(0);
			} else {
				out.writeInt(1);
				writeCodeBlock(out, constants, ire.getBinding());
			}
		}
	}

	private static void writeOutputRuleElements(final DataOutputStream out, 
			final ConstantPool constants, final Rule rule) throws IOException {
		final EList<OutputRuleElement> elements = rule.getOutputElements();
		out.writeInt(elements.size());
		for (OutputRuleElement ore : elements) {
			writeTypedElement(out, constants, ore);
			if (ore.getModels().size() != 1) {
				throw new IOException(String.format(
						"Rule output element %s must have exactly one model",
						ore));
			}
			out.writeInt(constants.indexOf(ore.getModels().get(0)));
			if (ore.getMapsTo() != null) {
				if (ore.getMapsTo().getInputFor() != ore.getOutputFor()) {
					throw new IOException(String.format(
							"Source element mapping for output element %s must lie within the same rule",
							ore));
				}
				out.writeInt(constants.indexOf(ore.getMapsTo().getName()));
			} else {
				out.writeInt(-1);
			}
		}
	}

	private static void writeSuperRules(final DataOutputStream out, 
			final ConstantPool constants, final EList<String> superRules) throws IOException {
		out.writeInt(superRules.size());
		for (String sr : superRules) {
			out.writeInt(constants.indexOf(sr));
		}
	}

}
