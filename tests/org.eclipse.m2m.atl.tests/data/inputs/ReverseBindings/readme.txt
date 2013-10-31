This test case illustrates the following problems:
- In refining mode:
	- the problem reported in https://bugs.eclipse.org/bugs/show_bug.cgi?id=332196
about reverse bindings not working on first target pattern elements. This problem
was already corrected as of writing this test, but there is no harm in making sure we will
notice it if it reappears.
- In non-refining mode:
	- the problem reported in https://bugs.eclipse.org/bugs/show_bug.cgi?id=411681
about no resolution taking place in non-refining mode
	- reverse bindings not applied at the right time: if reverse bindings
are executed in matching phase, elements created by rules matched after
(i.e., located after in source file) cannot be resolved. This is less of a
problem in refining mode, although it could happen (e.g., for newly created
elements that are resolved explicitly (i.e., using resolveTemp).
- In both modes:
	- reverse bindings with multivalued source not properly executed
	- reverse bindings not inherited


Remarks:
- This test fails when compiled with a bugged version of the ATL compiler. Failure
details (i.e., diff between actual and expected output) help diagnose which of the
above problems are present.
- The compiled version (.asm file) originally committed with this test case are correct
