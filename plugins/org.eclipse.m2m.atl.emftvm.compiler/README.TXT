EMFTVM Compiler README
======================
	
	Dennis Wagelaar <dennis.wagelaar@vub.ac.be>

How to bootstrap the ATL-to-EMFTVM compiler?
--------------------------------------------

1. Launch (or debug) a runtime Eclipse workbench.

2. Import the org.eclipse.m2m.atl.emftvm.compiler project into the workspace.

3. Run the "ATLtoEMFTVM_ATLCopy" ATL launch configuration using "Run -> Run Configurations...".
   This creates the ATLCopy.emftvm file for the next step using the bootstrap compiler.

4. Run "org.eclipse.m2m.atl.emftvm.compiler/compiler-copy/build.xml" (in the same JRE as Eclipse).
   This creates .xmi files for each .atl file that is part of the compiler (injection to XMI).

5. Run the "ATLtoEMFTVM_ATLtoEMFTVM" ATL launch configuration using "Run -> Run Configurations...".

6. Run the "ATLtoEMFTVM_EMFTVMCopy" ATL launch configuration using "Run -> Run Configurations...".

7. Run the "ATLtoEMFTVM_InlineCodeblocks" ATL launch configuration using "Run -> Run Configurations...".
   The last three steps create preliminary .emftvm files for each compiler transformation module using the bootstrap compiler.

8. Run "org.eclipse.m2m.atl.emftvm.compiler/compiler-compiler/build.xml" (in the same JRE as Eclipse).
   This compiles the .atl files that make up the compiler directly to .emftvm using the previously built preliminary compiler.

9. Run "org.eclipse.m2m.atl.emftvm.compiler/compiler-compiler/compiled-compiler-compiler/build.xml" (in the same JRE as Eclipse).
   This compiles the .atl files that make up the compiler directly to .emftvm using the compiler built in step 8.
   This step serves as a test: each generated .emftvm file has a .xmi version that can be compared to the generated files from the previous step using EMF compare.
   The generated .emftvm files from this step are copied back to "org.eclipse.m2m.atl.emftvm.compiler/transformations/".

You need to restart the Eclipse runtime workbench for the generated compiler to be loaded.
