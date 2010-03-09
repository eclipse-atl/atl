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
		<constant value="A.__matchtest():V"/>
		<constant value="__exec__"/>
		<constant value="test"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applytest(NTransientLink;):V"/>
		<constant value="__matchtest"/>
		<constant value="Class"/>
		<constant value="UML"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="input"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="output1_a"/>
		<constant value="UML_OUT1"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="output1_b"/>
		<constant value="output2_a"/>
		<constant value="UML_OUT2"/>
		<constant value="output2_b"/>
		<constant value="output3_a"/>
		<constant value="UML_OUT3"/>
		<constant value="output3_b"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="13:3-13:64"/>
		<constant value="14:3-14:64"/>
		<constant value="15:3-15:64"/>
		<constant value="16:3-16:64"/>
		<constant value="17:3-17:64"/>
		<constant value="18:3-18:64"/>
		<constant value="__applytest"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="5"/>
		<constant value="6"/>
		<constant value="7"/>
		<constant value="8"/>
		<constant value="_output1_a"/>
		<constant value="J.+(J):J"/>
		<constant value="_output1_b"/>
		<constant value="_output2_a"/>
		<constant value="_output2_b"/>
		<constant value="_output3_a"/>
		<constant value="_output3_b"/>
		<constant value="13:38-13:43"/>
		<constant value="13:38-13:48"/>
		<constant value="13:51-13:63"/>
		<constant value="13:38-13:63"/>
		<constant value="13:30-13:63"/>
		<constant value="14:38-14:43"/>
		<constant value="14:38-14:48"/>
		<constant value="14:51-14:63"/>
		<constant value="14:38-14:63"/>
		<constant value="14:30-14:63"/>
		<constant value="15:38-15:43"/>
		<constant value="15:38-15:48"/>
		<constant value="15:51-15:63"/>
		<constant value="15:38-15:63"/>
		<constant value="15:30-15:63"/>
		<constant value="16:38-16:43"/>
		<constant value="16:38-16:48"/>
		<constant value="16:51-16:63"/>
		<constant value="16:38-16:63"/>
		<constant value="16:30-16:63"/>
		<constant value="17:38-17:43"/>
		<constant value="17:38-17:48"/>
		<constant value="17:51-17:63"/>
		<constant value="17:38-17:63"/>
		<constant value="17:30-17:63"/>
		<constant value="18:38-18:43"/>
		<constant value="18:38-18:48"/>
		<constant value="18:51-18:63"/>
		<constant value="18:38-18:63"/>
		<constant value="18:30-18:63"/>
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
			<push arg="55"/>
			<new/>
			<call arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="46"/>
			<push arg="55"/>
			<new/>
			<call arg="56"/>
			<dup/>
			<push arg="58"/>
			<push arg="46"/>
			<push arg="59"/>
			<new/>
			<call arg="56"/>
			<dup/>
			<push arg="60"/>
			<push arg="46"/>
			<push arg="59"/>
			<new/>
			<call arg="56"/>
			<dup/>
			<push arg="61"/>
			<push arg="46"/>
			<push arg="62"/>
			<new/>
			<call arg="56"/>
			<dup/>
			<push arg="63"/>
			<push arg="46"/>
			<push arg="62"/>
			<new/>
			<call arg="56"/>
			<pusht/>
			<call arg="64"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="65" begin="19" end="24"/>
			<lne id="66" begin="25" end="30"/>
			<lne id="67" begin="31" end="36"/>
			<lne id="68" begin="37" end="42"/>
			<lne id="69" begin="43" end="48"/>
			<lne id="70" begin="49" end="54"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="52" begin="6" end="56"/>
			<lve slot="0" name="17" begin="0" end="57"/>
		</localvariabletable>
	</operation>
	<operation name="71">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="72"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="52"/>
			<call arg="73"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="54"/>
			<call arg="74"/>
			<store arg="75"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="74"/>
			<store arg="76"/>
			<load arg="19"/>
			<push arg="58"/>
			<call arg="74"/>
			<store arg="77"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="74"/>
			<store arg="78"/>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="74"/>
			<store arg="79"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="74"/>
			<store arg="80"/>
			<load arg="75"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="81"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="76"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="83"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="77"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="84"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="78"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="85"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="79"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="86"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
			<load arg="80"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<push arg="87"/>
			<call arg="82"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="88" begin="31" end="31"/>
			<lne id="89" begin="31" end="32"/>
			<lne id="90" begin="33" end="33"/>
			<lne id="91" begin="31" end="34"/>
			<lne id="92" begin="29" end="36"/>
			<lne id="65" begin="28" end="37"/>
			<lne id="93" begin="41" end="41"/>
			<lne id="94" begin="41" end="42"/>
			<lne id="95" begin="43" end="43"/>
			<lne id="96" begin="41" end="44"/>
			<lne id="97" begin="39" end="46"/>
			<lne id="66" begin="38" end="47"/>
			<lne id="98" begin="51" end="51"/>
			<lne id="99" begin="51" end="52"/>
			<lne id="100" begin="53" end="53"/>
			<lne id="101" begin="51" end="54"/>
			<lne id="102" begin="49" end="56"/>
			<lne id="67" begin="48" end="57"/>
			<lne id="103" begin="61" end="61"/>
			<lne id="104" begin="61" end="62"/>
			<lne id="105" begin="63" end="63"/>
			<lne id="106" begin="61" end="64"/>
			<lne id="107" begin="59" end="66"/>
			<lne id="68" begin="58" end="67"/>
			<lne id="108" begin="71" end="71"/>
			<lne id="109" begin="71" end="72"/>
			<lne id="110" begin="73" end="73"/>
			<lne id="111" begin="71" end="74"/>
			<lne id="112" begin="69" end="76"/>
			<lne id="69" begin="68" end="77"/>
			<lne id="113" begin="81" end="81"/>
			<lne id="114" begin="81" end="82"/>
			<lne id="115" begin="83" end="83"/>
			<lne id="116" begin="81" end="84"/>
			<lne id="117" begin="79" end="86"/>
			<lne id="70" begin="78" end="87"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="54" begin="7" end="87"/>
			<lve slot="4" name="57" begin="11" end="87"/>
			<lve slot="5" name="58" begin="15" end="87"/>
			<lve slot="6" name="60" begin="19" end="87"/>
			<lve slot="7" name="61" begin="23" end="87"/>
			<lve slot="8" name="63" begin="27" end="87"/>
			<lve slot="2" name="52" begin="3" end="87"/>
			<lve slot="0" name="17" begin="0" end="87"/>
			<lve slot="1" name="118" begin="0" end="87"/>
		</localvariabletable>
	</operation>
</asm>
