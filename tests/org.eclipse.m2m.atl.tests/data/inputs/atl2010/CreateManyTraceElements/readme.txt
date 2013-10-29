This test case illustrates the problem reported in https://bugs.eclipse.org/bugs/show_bug.cgi?id=358678

This problem is triggered as soon as there are enough non-deletion refining trace elements to fill the operand stack,
because those were left on the stack by the deletion loop.

Remarks:
- This test fails when compiled with a bugged version of the ATL compiler only if the operand stack size is 100 or less.
To make it fail with larger operand stack sizes, additional classes can be added to the source model.
- The compiled version (.asm file) originally committed with this test cases was created by a bugged version of the ATL compiler.
