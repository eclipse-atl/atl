<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="Ecore2Class"/>
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
		<constant value="A.__matchAttribute():V"/>
		<constant value="A.__matchDataType():V"/>
		<constant value="__exec__"/>
		<constant value="Class"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyClass(NTransientLink;):V"/>
		<constant value="Attribute"/>
		<constant value="A.__applyAttribute(NTransientLink;):V"/>
		<constant value="DataType"/>
		<constant value="A.__applyDataType(NTransientLink;):V"/>
		<constant value="__matchClass"/>
		<constant value="EClass"/>
		<constant value="MOF"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="ic"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="oc"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:8-11:19"/>
		<constant value="11:3-15:4"/>
		<constant value="__applyClass"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="eStructuralFeatures"/>
		<constant value="attr"/>
		<constant value="eSuperTypes"/>
		<constant value="super"/>
		<constant value="12:12-12:14"/>
		<constant value="12:12-12:19"/>
		<constant value="12:4-12:19"/>
		<constant value="13:12-13:14"/>
		<constant value="13:12-13:34"/>
		<constant value="13:4-13:34"/>
		<constant value="14:13-14:15"/>
		<constant value="14:13-14:27"/>
		<constant value="14:4-14:27"/>
		<constant value="link"/>
		<constant value="__matchAttribute"/>
		<constant value="EAttribute"/>
		<constant value="ia"/>
		<constant value="oa"/>
		<constant value="22:8-22:23"/>
		<constant value="22:3-26:4"/>
		<constant value="__applyAttribute"/>
		<constant value="upperBound"/>
		<constant value="J.&gt;(J):J"/>
		<constant value="0"/>
		<constant value="J.-(J):J"/>
		<constant value="J.=(J):J"/>
		<constant value="J.or(J):J"/>
		<constant value="multiValued"/>
		<constant value="eType"/>
		<constant value="type"/>
		<constant value="23:12-23:14"/>
		<constant value="23:12-23:19"/>
		<constant value="23:4-23:19"/>
		<constant value="24:20-24:22"/>
		<constant value="24:20-24:33"/>
		<constant value="24:36-24:37"/>
		<constant value="24:20-24:37"/>
		<constant value="24:43-24:45"/>
		<constant value="24:43-24:56"/>
		<constant value="24:59-24:60"/>
		<constant value="24:61-24:62"/>
		<constant value="24:59-24:62"/>
		<constant value="24:43-24:62"/>
		<constant value="24:19-24:63"/>
		<constant value="24:4-24:63"/>
		<constant value="25:12-25:14"/>
		<constant value="25:12-25:20"/>
		<constant value="25:4-25:20"/>
		<constant value="__matchDataType"/>
		<constant value="EDataType"/>
		<constant value="idt"/>
		<constant value="odt"/>
		<constant value="33:9-33:23"/>
		<constant value="33:3-35:4"/>
		<constant value="__applyDataType"/>
		<constant value="34:12-34:15"/>
		<constant value="34:12-34:20"/>
		<constant value="34:4-34:20"/>
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
			<getasm/>
			<call arg="41"/>
			<getasm/>
			<call arg="42"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="5"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="50"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="44"/>
			<call arg="57"/>
			<dup/>
			<push arg="58"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="44"/>
			<push arg="44"/>
			<new/>
			<call arg="61"/>
			<pusht/>
			<call arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="63" begin="21" end="23"/>
			<lne id="64" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="58" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="70"/>
			<call arg="30"/>
			<set arg="71"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="72"/>
			<call arg="30"/>
			<set arg="73"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="74" begin="11" end="11"/>
			<lne id="75" begin="11" end="12"/>
			<lne id="76" begin="9" end="14"/>
			<lne id="77" begin="17" end="17"/>
			<lne id="78" begin="17" end="18"/>
			<lne id="79" begin="15" end="20"/>
			<lne id="80" begin="23" end="23"/>
			<lne id="81" begin="23" end="24"/>
			<lne id="82" begin="21" end="26"/>
			<lne id="64" begin="8" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="60" begin="7" end="27"/>
			<lve slot="2" name="58" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="83" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="85"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<call arg="57"/>
			<dup/>
			<push arg="86"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="87"/>
			<push arg="47"/>
			<push arg="44"/>
			<new/>
			<call arg="61"/>
			<pusht/>
			<call arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="88" begin="21" end="23"/>
			<lne id="89" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="86" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="90">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="86"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="87"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="91"/>
			<pushi arg="19"/>
			<call arg="92"/>
			<load arg="29"/>
			<get arg="91"/>
			<pushi arg="93"/>
			<pushi arg="19"/>
			<call arg="94"/>
			<call arg="95"/>
			<call arg="96"/>
			<call arg="30"/>
			<set arg="97"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="98"/>
			<call arg="30"/>
			<set arg="99"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="100" begin="11" end="11"/>
			<lne id="101" begin="11" end="12"/>
			<lne id="102" begin="9" end="14"/>
			<lne id="103" begin="17" end="17"/>
			<lne id="104" begin="17" end="18"/>
			<lne id="105" begin="19" end="19"/>
			<lne id="106" begin="17" end="20"/>
			<lne id="107" begin="21" end="21"/>
			<lne id="108" begin="21" end="22"/>
			<lne id="109" begin="23" end="23"/>
			<lne id="110" begin="24" end="24"/>
			<lne id="111" begin="23" end="25"/>
			<lne id="112" begin="21" end="26"/>
			<lne id="113" begin="17" end="27"/>
			<lne id="114" begin="15" end="29"/>
			<lne id="115" begin="32" end="32"/>
			<lne id="116" begin="32" end="33"/>
			<lne id="117" begin="30" end="35"/>
			<lne id="89" begin="8" end="36"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="87" begin="7" end="36"/>
			<lve slot="2" name="86" begin="3" end="36"/>
			<lve slot="0" name="17" begin="0" end="36"/>
			<lve slot="1" name="83" begin="0" end="36"/>
		</localvariabletable>
	</operation>
	<operation name="118">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="119"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="56"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<call arg="57"/>
			<dup/>
			<push arg="120"/>
			<load arg="19"/>
			<call arg="59"/>
			<dup/>
			<push arg="121"/>
			<push arg="49"/>
			<push arg="44"/>
			<new/>
			<call arg="61"/>
			<pusht/>
			<call arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="122" begin="21" end="23"/>
			<lne id="123" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="120" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="124">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="120"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="121"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="125" begin="11" end="11"/>
			<lne id="126" begin="11" end="12"/>
			<lne id="127" begin="9" end="14"/>
			<lne id="123" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="121" begin="7" end="15"/>
			<lve slot="2" name="120" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="83" begin="0" end="15"/>
		</localvariabletable>
	</operation>
</asm>
