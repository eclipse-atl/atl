<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="Fibonacci"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="1000"/>
		<constant value="J.collectFib():J"/>
		<constant value="fib"/>
		<constant value="J.debug(J):J"/>
		<constant value="4:3-4:7"/>
		<constant value="4:2-4:21"/>
		<constant value="4:28-4:33"/>
		<constant value="4:2-4:34"/>
		<constant value="self"/>
		<constant value="I"/>
		<constant value="0"/>
		<constant value="2"/>
		<constant value="J.&lt;(J):J"/>
		<constant value="14"/>
		<constant value="1"/>
		<constant value="J.-(J):J"/>
		<constant value="J.fib():J"/>
		<constant value="J.+(J):J"/>
		<constant value="15"/>
		<constant value="7:9-7:13"/>
		<constant value="7:16-7:17"/>
		<constant value="7:9-7:17"/>
		<constant value="10:7-10:11"/>
		<constant value="10:12-10:13"/>
		<constant value="10:7-10:13"/>
		<constant value="10:6-10:20"/>
		<constant value="10:24-10:28"/>
		<constant value="10:29-10:30"/>
		<constant value="10:24-10:30"/>
		<constant value="10:23-10:37"/>
		<constant value="10:6-10:37"/>
		<constant value="8:3-8:7"/>
		<constant value="7:5-11:7"/>
		<constant value="collectFib"/>
		<constant value="20"/>
		<constant value="6765"/>
		<constant value="J.=(J):J"/>
		<constant value="16"/>
		<constant value="J.and(J):J"/>
		<constant value="17"/>
		<constant value="14:23-14:25"/>
		<constant value="14:22-14:32"/>
		<constant value="14:35-14:39"/>
		<constant value="14:22-14:39"/>
		<constant value="15:6-15:10"/>
		<constant value="15:13-15:14"/>
		<constant value="15:6-15:14"/>
		<constant value="18:3-18:6"/>
		<constant value="18:12-18:16"/>
		<constant value="18:19-18:20"/>
		<constant value="18:12-18:20"/>
		<constant value="18:11-18:34"/>
		<constant value="18:3-18:34"/>
		<constant value="16:3-16:6"/>
		<constant value="15:2-19:7"/>
		<constant value="14:2-19:7"/>
	</cp>
	<operation name="1">
		<context type="2"/>
		<parameters>
		</parameters>
		<code>
			<pushi arg="3"/>
			<call arg="4"/>
			<push arg="5"/>
			<call arg="6"/>
		</code>
		<linenumbertable>
			<lne id="7" begin="0" end="0"/>
			<lne id="8" begin="0" end="1"/>
			<lne id="9" begin="2" end="2"/>
			<lne id="10" begin="0" end="3"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="11" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="5">
		<context type="12"/>
		<parameters>
		</parameters>
		<code>
			<load arg="13"/>
			<pushi arg="14"/>
			<call arg="15"/>
			<if arg="16"/>
			<load arg="13"/>
			<pushi arg="17"/>
			<call arg="18"/>
			<call arg="19"/>
			<load arg="13"/>
			<pushi arg="14"/>
			<call arg="18"/>
			<call arg="19"/>
			<call arg="20"/>
			<goto arg="21"/>
			<load arg="13"/>
		</code>
		<linenumbertable>
			<lne id="22" begin="0" end="0"/>
			<lne id="23" begin="1" end="1"/>
			<lne id="24" begin="0" end="2"/>
			<lne id="25" begin="4" end="4"/>
			<lne id="26" begin="5" end="5"/>
			<lne id="27" begin="4" end="6"/>
			<lne id="28" begin="4" end="7"/>
			<lne id="29" begin="8" end="8"/>
			<lne id="30" begin="9" end="9"/>
			<lne id="31" begin="8" end="10"/>
			<lne id="32" begin="8" end="11"/>
			<lne id="33" begin="4" end="12"/>
			<lne id="34" begin="14" end="14"/>
			<lne id="35" begin="0" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="11" begin="0" end="14"/>
		</localvariabletable>
	</operation>
	<operation name="36">
		<context type="12"/>
		<parameters>
		</parameters>
		<code>
			<pushi arg="37"/>
			<call arg="19"/>
			<pushi arg="38"/>
			<call arg="39"/>
			<store arg="17"/>
			<load arg="13"/>
			<pushi arg="14"/>
			<call arg="15"/>
			<if arg="40"/>
			<load arg="17"/>
			<load arg="13"/>
			<pushi arg="17"/>
			<call arg="18"/>
			<call arg="4"/>
			<call arg="41"/>
			<goto arg="42"/>
			<load arg="17"/>
		</code>
		<linenumbertable>
			<lne id="43" begin="0" end="0"/>
			<lne id="44" begin="0" end="1"/>
			<lne id="45" begin="2" end="2"/>
			<lne id="46" begin="0" end="3"/>
			<lne id="47" begin="5" end="5"/>
			<lne id="48" begin="6" end="6"/>
			<lne id="49" begin="5" end="7"/>
			<lne id="50" begin="9" end="9"/>
			<lne id="51" begin="10" end="10"/>
			<lne id="52" begin="11" end="11"/>
			<lne id="53" begin="10" end="12"/>
			<lne id="54" begin="10" end="13"/>
			<lne id="55" begin="9" end="14"/>
			<lne id="56" begin="16" end="16"/>
			<lne id="57" begin="5" end="16"/>
			<lne id="58" begin="0" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="5" begin="4" end="16"/>
			<lve slot="0" name="11" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
