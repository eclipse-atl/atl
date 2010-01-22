<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="sample"/>
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
		<constant value="A.__matchclass():V"/>
		<constant value="__exec__"/>
		<constant value="class"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyclass(NTransientLink;):V"/>
		<constant value="__matchclass"/>
		<constant value="Class"/>
		<constant value="UML"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="input"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="output1"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="output1_bus"/>
		<constant value="output2"/>
		<constant value="output3"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:13-11:22"/>
		<constant value="11:3-14:3"/>
		<constant value="16:17-16:26"/>
		<constant value="16:3-19:3"/>
		<constant value="21:13-21:22"/>
		<constant value="21:3-24:3"/>
		<constant value="26:13-26:22"/>
		<constant value="26:3-29:3"/>
		<constant value="__applyclass"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="6"/>
		<constant value="J.+(J):J"/>
		<constant value="visibility"/>
		<constant value="J.toString():J"/>
		<constant value="EnumLiteral"/>
		<constant value="private"/>
		<constant value="12:12-12:17"/>
		<constant value="12:12-12:22"/>
		<constant value="12:25-12:28"/>
		<constant value="12:12-12:28"/>
		<constant value="12:4-12:28"/>
		<constant value="13:18-13:23"/>
		<constant value="13:18-13:34"/>
		<constant value="13:4-13:34"/>
		<constant value="17:12-17:17"/>
		<constant value="17:12-17:22"/>
		<constant value="17:25-17:28"/>
		<constant value="17:12-17:28"/>
		<constant value="17:4-17:28"/>
		<constant value="18:18-18:23"/>
		<constant value="18:18-18:34"/>
		<constant value="18:18-18:45"/>
		<constant value="18:4-18:45"/>
		<constant value="22:12-22:17"/>
		<constant value="22:12-22:22"/>
		<constant value="22:25-22:28"/>
		<constant value="22:12-22:28"/>
		<constant value="22:4-22:28"/>
		<constant value="23:18-23:26"/>
		<constant value="23:4-23:26"/>
		<constant value="27:12-27:17"/>
		<constant value="27:12-27:22"/>
		<constant value="27:25-27:28"/>
		<constant value="27:12-27:28"/>
		<constant value="27:4-27:28"/>
		<constant value="28:18-28:27"/>
		<constant value="28:4-28:27"/>
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
			<push arg="52"/>
			<load arg="19"/>
			<call arg="53"/>
			<dup/>
			<push arg="54"/>
			<push arg="46"/>
			<push arg="47"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="56"/>
			<push arg="46"/>
			<push arg="47"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="57"/>
			<push arg="46"/>
			<push arg="47"/>
			<new/>
			<call arg="55"/>
			<dup/>
			<push arg="58"/>
			<push arg="46"/>
			<push arg="47"/>
			<new/>
			<call arg="55"/>
			<pusht/>
			<call arg="59"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="60" begin="21" end="23"/>
			<lne id="61" begin="19" end="24"/>
			<lne id="62" begin="27" end="29"/>
			<lne id="63" begin="25" end="30"/>
			<lne id="64" begin="33" end="35"/>
			<lne id="65" begin="31" end="36"/>
			<lne id="66" begin="39" end="41"/>
			<lne id="67" begin="37" end="42"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="44"/>
			<lve slot="0" name="17" begin="0" end="45"/>
		</localvariabletable>
	</operation>
	<operation name="68">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="69"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="70"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="71"/>
			<store arg="72"/>
			<load arg="19"/>
			<push arg="56"/>
			<call arg="71"/>
			<store arg="73"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="71"/>
			<store arg="74"/>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="71"/>
			<store arg="75"/>
			<load arg="72"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="19"/>
			<call arg="76"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="77"/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="19"/>
			<call arg="76"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="77"/>
			<call arg="78"/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
			<load arg="74"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="29"/>
			<call arg="76"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="79"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="80"/>
			<set arg="38"/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
			<load arg="75"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="72"/>
			<call arg="76"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="80"/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="81" begin="23" end="23"/>
			<lne id="82" begin="23" end="24"/>
			<lne id="83" begin="25" end="25"/>
			<lne id="84" begin="23" end="26"/>
			<lne id="85" begin="21" end="28"/>
			<lne id="86" begin="31" end="31"/>
			<lne id="87" begin="31" end="32"/>
			<lne id="88" begin="29" end="34"/>
			<lne id="61" begin="20" end="35"/>
			<lne id="89" begin="39" end="39"/>
			<lne id="90" begin="39" end="40"/>
			<lne id="91" begin="41" end="41"/>
			<lne id="92" begin="39" end="42"/>
			<lne id="93" begin="37" end="44"/>
			<lne id="94" begin="47" end="47"/>
			<lne id="95" begin="47" end="48"/>
			<lne id="96" begin="47" end="49"/>
			<lne id="97" begin="45" end="51"/>
			<lne id="63" begin="36" end="52"/>
			<lne id="98" begin="56" end="56"/>
			<lne id="99" begin="56" end="57"/>
			<lne id="100" begin="58" end="58"/>
			<lne id="101" begin="56" end="59"/>
			<lne id="102" begin="54" end="61"/>
			<lne id="103" begin="64" end="69"/>
			<lne id="104" begin="62" end="71"/>
			<lne id="65" begin="53" end="72"/>
			<lne id="105" begin="76" end="76"/>
			<lne id="106" begin="76" end="77"/>
			<lne id="107" begin="78" end="78"/>
			<lne id="108" begin="76" end="79"/>
			<lne id="109" begin="74" end="81"/>
			<lne id="110" begin="84" end="84"/>
			<lne id="111" begin="82" end="86"/>
			<lne id="67" begin="73" end="87"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="54" begin="7" end="87"/>
			<lve slot="4" name="56" begin="11" end="87"/>
			<lve slot="5" name="57" begin="15" end="87"/>
			<lve slot="6" name="58" begin="19" end="87"/>
			<lve slot="2" name="52" begin="3" end="87"/>
			<lve slot="0" name="17" begin="0" end="87"/>
			<lve slot="1" name="112" begin="0" end="87"/>
		</localvariabletable>
	</operation>
</asm>
