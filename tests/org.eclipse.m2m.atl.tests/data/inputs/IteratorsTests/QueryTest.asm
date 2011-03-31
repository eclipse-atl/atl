<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="test"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="3:32-3:36"/>
		<constant value="3:52-3:57"/>
		<constant value="3:42-3:46"/>
		<constant value="3:29-3:63"/>
		<constant value="self"/>
	</cp>
	<operation name="1">
		<context type="2"/>
		<parameters>
		</parameters>
		<code>
			<pusht/>
			<if arg="3"/>
			<pushf/>
			<goto arg="4"/>
			<pusht/>
		</code>
		<linenumbertable>
			<lne id="5" begin="0" end="0"/>
			<lne id="6" begin="2" end="2"/>
			<lne id="7" begin="4" end="4"/>
			<lne id="8" begin="0" end="4"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="9" begin="0" end="4"/>
		</localvariabletable>
	</operation>
</asm>
