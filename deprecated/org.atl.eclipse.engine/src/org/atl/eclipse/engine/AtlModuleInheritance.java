package org.atl.eclipse.engine;

import java.util.ArrayList;
import java.util.List;

import org.atl.engine.vm.ASM;
import org.atl.engine.vm.ASMExecEnv;
import org.atl.engine.vm.ASMInstruction;
import org.atl.engine.vm.ASMOperation;
import org.atl.engine.vm.nativelib.ASMModule;

/**
 * Implements ATL module inheritance by load-time adaptation
 * of the execution environment operations.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class AtlModuleInheritance {

    /**
     * General exception for applying ATL module inheritance.
     * Used in ASM adaptation sanity check.
     */
    public class AtlModuleInheritanceException extends Exception {
        
        static final long serialVersionUID = 20060904;
        
        /**
         * Creates a new AtlModuleInheritanceException.
         * @param msg Exception message
         */
        public AtlModuleInheritanceException(String msg) {
            super(msg);
        }
    }
    
    private ASMExecEnv env;
    private ASM asm;
    
    /**
     * Creates a new AtlModuleInheritance object.
     * @param env The execution environment to adapt
     * @param asm The ATL module to adapt
     */
    public AtlModuleInheritance(ASMExecEnv env, ASM asm) {
        this.env = env;
        this.asm = asm;
    }
    
    /**
     * Adapts any module-specific operations from a library.
     * The matcher and exec operations are adapted to include
     * any new ATL rules. Rules with the same name as an existing
     * rule will override the existing rule.
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    public void adaptModuleOperations() throws AtlModuleInheritanceException {
        adaptMain();
        removeOperation("main");
        adaptOperation("__matcher__", 2);
        removeOperation("__matcher__");
        adaptOperation("__exec__", 10);
        removeOperation("__exec__");
    }
    
    /**
     * Adapts main method instructions to include helper
     * attribute __init methods
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void adaptMain() throws AtlModuleInheritanceException {
        ASMOperation origOp = (ASMOperation) env.getOperation(ASMModule.myType, "main");
        ASMOperation newOp = asm.getOperation("main");
        if ((origOp != null) && (newOp != null)) {
            mainSanityCrossCheck(origOp, newOp);
            List origInit = getInstructions(origOp.getInstructions(), "call A.__init", 20, 1);
            List newInit = getInstructions(newOp.getInstructions(), "call A.__init", 20, 1);
            origOp.getInstructions().addAll(origInit.size()+21, newInit);
        }
    }
    
    /**
     * Performs sanity check and cross-check on main operations.
     * @param main1 The first main operation to check
     * @param main2 The second main operation to check
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void mainSanityCrossCheck(ASMOperation main1, ASMOperation main2) throws AtlModuleInheritanceException {
        mainSanityCheck(main1);
        mainSanityCheck(main2);
        for (int i = 0; i < 21; i++) {
            String ins1 = main1.getInstructions().get(i).toString();
            String ins2 = main2.getInstructions().get(i).toString();
            if (!ins1.equals(ins2)) {
                throw new AtlModuleInheritanceException(
                        "Pattern not equal for execution environment and module in main (" + 
                        ins1 + " != " + ins2 + " @ " + String.valueOf(i) + ")");
            }
        }
    }

    /**
     * Performs sanity check main operation.
     * @param main The main operation to check
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void mainSanityCheck(ASMOperation main) throws AtlModuleInheritanceException {
        if (main.getInstructions().size() < 21) {
            throw new AtlModuleInheritanceException(
                    "Unexpected instruction count in main (count = " +
                    String.valueOf(main.getInstructions().size()) + 
                    ", expected > 20)");
        }
        String instr21 = main.getInstructions().get(20).toString();
        if (!instr21.equals("set links")) {
            throw new AtlModuleInheritanceException(
                    "Unexpected instruction sequence in main (" +
                    instr21 + " @ 21)");
        }
    }
    
    /**
     * @param instr The list of instructions to search
     * @param prefix The instruction/operand prefix (startsWith)
     * @param start The instruction index to start searching
     * @param context The number of preceding instructions to include
     * @return list of instructions with given prefix and
     * context amount of preceding instructions for every match
     */
    private List getInstructions(List instr, String prefix, int start, int context) {
        List init = new ArrayList();
        for (int i = start+context; i < instr.size(); i++) {
            ASMInstruction ins = (ASMInstruction) instr.get(i);
            if (ins.toString().startsWith(prefix)) {
                init.addAll(instr.subList(i-context, i+1));
            }
        }
        return init;
    }
    
    /**
     * Adds the instructions of the given operation from asm to the
     * registered operation in env. Checks if instructions runs of
     * patternLength exist already in the registered operation and
     * only copies the instructions if not so. 
     * @param op The operation name
     * @param patternLength The length of the instruction pattern
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void adaptOperation(String op, int patternLength) throws AtlModuleInheritanceException {
        ASMOperation origOp = (ASMOperation) env.getOperation(ASMModule.myType, op);
        ASMOperation newOp = asm.getOperation(op);
        if ((origOp != null) && (newOp != null)) {
            sanityCrossCheck(origOp, newOp, patternLength);
            List newOpInstr = newOp.getInstructions();
            List origOpInstr = origOp.getInstructions();
            String origOpRun = serialise(origOpInstr, 0, origOpInstr.size());
            for (int i = 0; i < newOpInstr.size(); i+=patternLength) {
                String newOpRun = serialise(newOpInstr, i, patternLength);
                if (origOpRun.indexOf(newOpRun) == -1) {
                    for (int j = i; j < Math.min(i+patternLength, newOpInstr.size()); j++) {
                        origOp.addInstruction((ASMInstruction) newOpInstr.get(j));
                    }
                }
            }
        }
    }

    /**
     * Performs sanity check and cross-check on pattern repetition
     * and equality in op1 and op2.
     * @param op1 The first operation to check
     * @param op2 The second operation to check
     * @param patternLength The length of the instruction pattern
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void sanityCrossCheck(ASMOperation op1, ASMOperation op2, int patternLength) throws AtlModuleInheritanceException {
        sanityCheck(op1, patternLength);
        sanityCheck(op2, patternLength);
        List instr1 = op1.getInstructions();
        List instr2 = op2.getInstructions();
        int limit = Math.min(instr1.size(), instr2.size());
        limit = Math.min(limit, patternLength);
        for (int i = 0; i < limit; i++) {
            String i1 = ((ASMInstruction)instr1.get(i)).getMnemonic();
            String i2 = ((ASMInstruction)instr2.get(i)).getMnemonic();
            if (!i1.equals(i2)) {
                throw new AtlModuleInheritanceException(
                        "Pattern not equal for execution environment and module in " + 
                        op1.getName() + " (" + i1 + " != " + i2 + " @ " + String.valueOf(i) + ")");
            }
        }
    }

    /**
     * Performs sanity check on pattern repetition in op.
     * @param op The operation to check
     * @param patternLength The length of the instruction pattern
     * @throws AtlModuleInheritanceException if sanity check fails
     */
    private void sanityCheck(ASMOperation op, int patternLength) throws AtlModuleInheritanceException {
        List instr = op.getInstructions();
        if (instr.size() % patternLength > 0) {
            throw new AtlModuleInheritanceException("Instruction count is not a multiple of " + 
                    String.valueOf(patternLength) + " for " + op.getName());
        }
        for (int i = 0; i < instr.size()-patternLength; i++) {
            String i1 = ((ASMInstruction)instr.get(i)).getMnemonic();
            String i2 = ((ASMInstruction)instr.get(i+patternLength)).getMnemonic();
            if (!i1.equals(i2)) {
                throw new AtlModuleInheritanceException("Pattern does not repeat itself after " +
                        String.valueOf(patternLength) + " instructions in " + op.getName() +
                        " (" + i1 + " != " + i2 + " @ " + String.valueOf(i) + ")");
            }
        }
    }
    
    /**
     * Serialises a run of instructions.
     * @param instrs The list of instructions
     * @param start The starting index of the run
     * @param length The length of the run
     * @return The semi-colon-separated run of instructions
     */
    private static String serialise(List instrs, int start, int length) {
        StringBuffer ser = new StringBuffer();
        for (int i = Math.max(0, start); i < Math.min(instrs.size(), start+length); i++) {
            ser.append(instrs.get(i));
            ser.append(';');
        }
        return ser.toString();
    }
    
    /**
     * Removes the operation with the given name from the given module.
     * @param op The operation name
     */
    private void removeOperation(String op) {
        ASMOperation asmOp = asm.getOperation(op);
        if (asmOp != null) {
            asm.getOperations().remove(asmOp);
        }
    }

}
