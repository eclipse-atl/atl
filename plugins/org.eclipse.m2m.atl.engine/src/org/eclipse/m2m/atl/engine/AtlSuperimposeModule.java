package org.eclipse.m2m.atl.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInstruction;
import org.eclipse.m2m.atl.engine.vm.ASMOperation;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;

/**
 * Implements ATL module superimposition by load-time adaptation
 * of the execution environment operations.
 * @author Dennis Wagelaar <dennis.wagelaar@vub.ac.be>
 */
public class AtlSuperimposeModule {

    /**
     * General exception for applying ATL module superimposition.
     * Used in ASM adaptation sanity check.
     */
    public class AtlSuperimposeModuleException extends Exception {
        
        static final long serialVersionUID = 20061201;
        
        /**
         * Creates a new AtlSuperimposeModuleException.
         * @param msg Exception message
         */
        public AtlSuperimposeModuleException(String msg) {
            super(msg);
        }
    }
    
    private ASMExecEnv env;
    private ASM asm;
    private boolean atl2006 = false;
    
    /**
     * Creates a new AtlSuperimposeModule object.
     * @param env The execution environment to adapt
     * @param asm The ATL module to adapt
     */
    public AtlSuperimposeModule(ASMExecEnv env, ASM asm) {
        this.env = env;
        this.asm = asm;
    }
    
    /**
     * Adapts any module-specific operations from a library.
     * The matcher and exec operations are adapted to include
     * any new ATL rules. Rules with the same name as an existing
     * rule will override the existing rule.
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    public void adaptModuleOperations() throws AtlSuperimposeModuleException {
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
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void adaptMain() throws AtlSuperimposeModuleException {
        ASMOperation origOp = (ASMOperation) env.getOperation(ASMModule.myType, "main");
        ASMOperation newOp = asm.getOperation("main");
        if ((origOp != null) && (newOp != null)) {
            mainSanityCrossCheck(origOp, newOp);
            if (atl2006) {
                insertHelperInits(newOp.getInstructions(), origOp.getInstructions());
            } else {
                List origInit = getInstructions(origOp.getInstructions(), "call A.__init", 20, 1);
                List newInit = getInstructions(newOp.getInstructions(), "call A.__init", 20, 1);
                origOp.getInstructions().addAll(origInit.size()+21, newInit);
            }
        }
    }
    
    /**
     * Performs sanity check and cross-check on main operations.
     * @param main1 The first main operation to check
     * @param main2 The second main operation to check
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void mainSanityCrossCheck(ASMOperation main1, ASMOperation main2) throws AtlSuperimposeModuleException {
        mainSanityCheck(main1);
        mainSanityCheck(main2);
        int preEnd = 21;
        if (atl2006) { preEnd = 16; }
        for (int i = 0; i < preEnd; i++) {
            String ins1 = main1.getInstructions().get(i).toString();
            String ins2 = main2.getInstructions().get(i).toString();
            if (!ins1.equals(ins2)) {
                throw new AtlSuperimposeModuleException(
                        "Pattern not equal for execution environment and module in main (" + 
                        ins1 + " != " + ins2 + " @ " + String.valueOf(i) + ")");
            }
        }
    }

    /**
     * Performs sanity check main operation.
     * @param main The main operation to check
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void mainSanityCheck(ASMOperation main) throws AtlSuperimposeModuleException {
        if (main.getInstructions().size() < 21) {
            throw new AtlSuperimposeModuleException(
                    "Unexpected instruction count in main (count = " +
                    String.valueOf(main.getInstructions().size()) + 
                    ", expected > 20)");
        }
        String instr16 = main.getInstructions().get(15).toString();
        if (!instr16.equals("set col")) {
            throw new AtlSuperimposeModuleException(
                    "Unexpected instruction sequence in main (" +
                    instr16 + " @ 16)");
        }
        if (indexOfInstruction(main.getInstructions(), "set links", 16) == -1) {
            throw new AtlSuperimposeModuleException(
                    "Instruction \"set links\" not found in main");
        }
//        String instr21 = main.getInstructions().get(20).toString();
//        if (!instr21.equals("set links")) {
//            throw new AtlSuperimposeModuleException(
//                    "Unexpected instruction sequence in main (" +
//                    instr21 + " @ 21)");
//        }
        String instr1 = main.getInstructions().get(0).toString();
        if (instr1.equals("getasm")) {
            atl2006 = true;
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
     * @param instr The list of instructions to search
     * @param prefix The instruction/operand prefix (startsWith)
     * @param start The instruction index to start searching
     * @return The index of the first instruction with given prefix,
     * -1 otherwise
     */
    private int indexOfInstruction(List instr, String prefix, int start) {
        for (int i = start; i < instr.size(); i++) {
            ASMInstruction ins = (ASMInstruction) instr.get(i);
            if (ins.toString().startsWith(prefix)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Adds the instructions of the given operation from asm to the
     * registered operation in env. Checks if instructions runs of
     * patternLength exist already in the registered operation and
     * only copies the instructions if not so. 
     * @param op The operation name
     * @param patternLength The length of the instruction pattern
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void adaptOperation(String op, int patternLength) throws AtlSuperimposeModuleException {
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
     * Copies the "from" helper init instructions that do not occur in "into" to "into".
     * @param from The list of instructions to copy the helper init code from.
     * @param into The list of instructions to augment.
     */
    private void insertHelperInits(List from, List into) {
        int endOfInitCode = indexOfInstruction(from, "set links", 16) - 4;
        List initInstr = from.subList(16, endOfInitCode);
        int pos = indexOfInstruction(into, "set links", 16) - 4;
        String intoRun = serialise(into, 0, into.size());
        int startIndex = 0;
        int setIndex = indexOfInstruction(initInstr, "set", startIndex);
        while (setIndex != -1) {
            String initInstrRun = serialise(initInstr, startIndex, setIndex-startIndex+1);
            if (intoRun.indexOf(initInstrRun) == -1) {
                for (int i = startIndex; i <= setIndex; i++) {
                    into.add(pos, initInstr.get(i));
                    pos++;
                }
            }
            startIndex = setIndex + 1;
            setIndex = indexOfInstruction(initInstr, "set", startIndex);
        }
    }

    /**
     * Performs sanity check and cross-check on pattern repetition
     * and equality in op1 and op2.
     * @param op1 The first operation to check
     * @param op2 The second operation to check
     * @param patternLength The length of the instruction pattern
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void sanityCrossCheck(ASMOperation op1, ASMOperation op2, int patternLength) throws AtlSuperimposeModuleException {
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
                throw new AtlSuperimposeModuleException(
                        "Pattern not equal for execution environment and module in " + 
                        op1.getName() + " (" + i1 + " != " + i2 + " @ " + String.valueOf(i) + ")");
            }
        }
    }

    /**
     * Performs sanity check on pattern repetition in op.
     * @param op The operation to check
     * @param patternLength The length of the instruction pattern
     * @throws AtlSuperimposeModuleException if sanity check fails
     */
    private void sanityCheck(ASMOperation op, int patternLength) throws AtlSuperimposeModuleException {
        List instr = op.getInstructions();
        if (instr.size() % patternLength > 0) {
            throw new AtlSuperimposeModuleException("Instruction count is not a multiple of " + 
                    String.valueOf(patternLength) + " for " + op.getName());
        }
        for (int i = 0; i < instr.size()-patternLength; i++) {
            String i1 = ((ASMInstruction)instr.get(i)).getMnemonic();
            String i2 = ((ASMInstruction)instr.get(i+patternLength)).getMnemonic();
            if (!i1.equals(i2)) {
                throw new AtlSuperimposeModuleException("Pattern does not repeat itself after " +
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
     * Removes the operation with the given name from the superimposed module.
     * @param op The operation name
     */
    private void removeOperation(String op) {
        ASMOperation asmOp = asm.getOperation(op);
        if (asmOp != null) {
            asm.getOperations().remove(asmOp);
        }
    }

}
