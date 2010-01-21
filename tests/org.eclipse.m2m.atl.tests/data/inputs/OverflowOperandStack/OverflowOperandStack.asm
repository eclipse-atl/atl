<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="OverflowOperandStack"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchClass():V"/>
		<constant value="__exec__"/>
		<constant value="Class"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyClass(NTransientLink;):V"/>
		<constant value="seqTo"/>
		<constant value="I"/>
		<constant value="0"/>
		<constant value="J.&lt;(J):J"/>
		<constant value="10"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.+(J):J"/>
		<constant value="J.seqTo(J):J"/>
		<constant value="J.prepend(J):J"/>
		<constant value="5:5-5:9"/>
		<constant value="5:12-5:17"/>
		<constant value="5:5-5:17"/>
		<constant value="8:13-8:17"/>
		<constant value="8:3-8:18"/>
		<constant value="6:4-6:8"/>
		<constant value="6:11-6:12"/>
		<constant value="6:4-6:12"/>
		<constant value="6:20-6:25"/>
		<constant value="6:3-6:26"/>
		<constant value="6:36-6:40"/>
		<constant value="6:3-6:41"/>
		<constant value="5:2-9:7"/>
		<constant value="upper"/>
		<constant value="__matchClass"/>
		<constant value="Model"/>
		<constant value="UML"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="trigger"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="container"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="15:15-15:24"/>
		<constant value="15:3-15:24"/>
		<constant value="__applyClass"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="100"/>
		<constant value="4"/>
		<constant value=""/>
		<constant value="J.debug(J):J"/>
		<constant value="17:13-17:14"/>
		<constant value="17:22-17:25"/>
		<constant value="17:12-17:26"/>
		<constant value="18:4-18:5"/>
		<constant value="18:12-18:14"/>
		<constant value="18:4-18:16"/>
		<constant value="17:3-19:4"/>
		<constant value="16:2-20:3"/>
		<constant value="i"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<call arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<call arg="10"/>
			<call arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<call arg="15"/>
			<getasm/>
			<call arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="47"/>
			<load arg="19"/>
			<call arg="48"/>
			<if arg="49"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<call arg="50"/>
			<goto arg="26"/>
			<load arg="47"/>
			<pushi arg="19"/>
			<call arg="51"/>
			<load arg="19"/>
			<call arg="52"/>
			<load arg="47"/>
			<call arg="53"/>
		</code>
		<linenumbertable>
			<lne id="54" begin="0" end="0"/>
			<lne id="55" begin="1" end="1"/>
			<lne id="56" begin="0" end="2"/>
			<lne id="57" begin="7" end="7"/>
			<lne id="58" begin="4" end="8"/>
			<lne id="59" begin="10" end="10"/>
			<lne id="60" begin="11" end="11"/>
			<lne id="61" begin="10" end="12"/>
			<lne id="62" begin="13" end="13"/>
			<lne id="63" begin="10" end="14"/>
			<lne id="64" begin="15" end="15"/>
			<lne id="65" begin="10" end="16"/>
			<lne id="66" begin="0" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="67" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="68">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="69"/>
			<push arg="70"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<call arg="74"/>
			<dup/>
			<push arg="75"/>
			<load arg="19"/>
			<call arg="76"/>
			<dup/>
			<push arg="77"/>
			<push arg="69"/>
			<push arg="70"/>
			<new/>
			<call arg="78"/>
			<pusht/>
			<call arg="79"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="80" begin="21" end="23"/>
			<lne id="81" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="75" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="82">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="75"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="77"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<pop/>
			<pushi arg="19"/>
			<pushi arg="87"/>
			<call arg="52"/>
			<iterate/>
			<store arg="88"/>
			<load arg="88"/>
			<push arg="89"/>
			<pcall arg="90"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="81" begin="8" end="9"/>
			<lne id="91" begin="10" end="10"/>
			<lne id="92" begin="11" end="11"/>
			<lne id="93" begin="10" end="12"/>
			<lne id="94" begin="15" end="15"/>
			<lne id="95" begin="16" end="16"/>
			<lne id="96" begin="15" end="17"/>
			<lne id="97" begin="10" end="18"/>
			<lne id="98" begin="10" end="18"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="99" begin="14" end="17"/>
			<lve slot="3" name="77" begin="7" end="18"/>
			<lve slot="2" name="75" begin="3" end="18"/>
			<lve slot="0" name="17" begin="0" end="18"/>
			<lve slot="1" name="100" begin="0" end="18"/>
		</localvariabletable>
	</operation>
</asm>
