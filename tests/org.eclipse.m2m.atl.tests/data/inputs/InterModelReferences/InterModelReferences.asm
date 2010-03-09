<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="TestReferences"/>
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
		<constant value="A.__matchmodel():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="UML"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="container1"/>
		<constant value="UML_OUT_1"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="out1"/>
		<constant value="Class"/>
		<constant value="container2"/>
		<constant value="UML_OUT_2"/>
		<constant value="out2"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="12:3-14:4"/>
		<constant value="15:3-15:28"/>
		<constant value="17:3-19:4"/>
		<constant value="20:3-22:4"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="6"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="packagedElement"/>
		<constant value="superClass"/>
		<constant value="13:32-13:36"/>
		<constant value="13:23-13:37"/>
		<constant value="13:4-13:37"/>
		<constant value="18:32-18:36"/>
		<constant value="18:23-18:37"/>
		<constant value="18:4-18:37"/>
		<constant value="21:18-21:22"/>
		<constant value="21:4-21:22"/>
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
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="50"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<call arg="51"/>
			<dup/>
			<push arg="42"/>
			<load arg="19"/>
			<call arg="52"/>
			<dup/>
			<push arg="53"/>
			<push arg="46"/>
			<push arg="54"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="56"/>
			<push arg="57"/>
			<push arg="54"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="58"/>
			<push arg="46"/>
			<push arg="59"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="60"/>
			<push arg="57"/>
			<push arg="59"/>
			<new/>
			<call arg="55"/>
			<pusht/>
			<call arg="61"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="62" begin="19" end="24"/>
			<lne id="63" begin="25" end="30"/>
			<lne id="64" begin="31" end="36"/>
			<lne id="65" begin="37" end="42"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="42" begin="6" end="44"/>
			<lve slot="0" name="17" begin="0" end="45"/>
		</localvariabletable>
	</operation>
	<operation name="66">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="67"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="42"/>
			<call arg="68"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="53"/>
			<call arg="69"/>
			<store arg="70"/>
			<load arg="19"/>
			<push arg="56"/>
			<call arg="69"/>
			<store arg="71"/>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="69"/>
			<store arg="72"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="69"/>
			<store arg="73"/>
			<load arg="70"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="71"/>
			<call arg="74"/>
			<call arg="30"/>
			<set arg="75"/>
			<pop/>
			<load arg="71"/>
			<pop/>
			<load arg="72"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="73"/>
			<call arg="74"/>
			<call arg="30"/>
			<set arg="75"/>
			<pop/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="71"/>
			<call arg="30"/>
			<set arg="76"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="77" begin="26" end="26"/>
			<lne id="78" begin="23" end="27"/>
			<lne id="79" begin="21" end="29"/>
			<lne id="62" begin="20" end="30"/>
			<lne id="63" begin="31" end="32"/>
			<lne id="80" begin="39" end="39"/>
			<lne id="81" begin="36" end="40"/>
			<lne id="82" begin="34" end="42"/>
			<lne id="64" begin="33" end="43"/>
			<lne id="83" begin="47" end="47"/>
			<lne id="84" begin="45" end="49"/>
			<lne id="65" begin="44" end="50"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="53" begin="7" end="50"/>
			<lve slot="4" name="56" begin="11" end="50"/>
			<lve slot="5" name="58" begin="15" end="50"/>
			<lve slot="6" name="60" begin="19" end="50"/>
			<lve slot="2" name="42" begin="3" end="50"/>
			<lve slot="0" name="17" begin="0" end="50"/>
			<lve slot="1" name="85" begin="0" end="50"/>
		</localvariabletable>
	</operation>
</asm>
