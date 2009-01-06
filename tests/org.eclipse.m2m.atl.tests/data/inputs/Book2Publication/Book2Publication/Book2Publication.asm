<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="Book2Publication"/>
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
		<constant value="A.__matchBook2Publication():V"/>
		<constant value="__exec__"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyBook2Publication(NTransientLink;):V"/>
		<constant value="getAuthors"/>
		<constant value="MBook!Book;"/>
		<constant value=""/>
		<constant value="0"/>
		<constant value="chapters"/>
		<constant value="author"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.asOrderedSet():J"/>
		<constant value="J.=(J):J"/>
		<constant value="25"/>
		<constant value=" and "/>
		<constant value="J.+(J):J"/>
		<constant value="26"/>
		<constant value="10:42-10:44"/>
		<constant value="8:8-8:12"/>
		<constant value="8:8-8:21"/>
		<constant value="8:35-8:36"/>
		<constant value="8:35-8:43"/>
		<constant value="8:8-8:44"/>
		<constant value="8:8-9:24"/>
		<constant value="11:24-11:27"/>
		<constant value="12:12-12:15"/>
		<constant value="12:18-12:20"/>
		<constant value="12:12-12:20"/>
		<constant value="14:15-14:22"/>
		<constant value="14:25-14:35"/>
		<constant value="14:15-14:35"/>
		<constant value="13:15-13:25"/>
		<constant value="12:9-15:14"/>
		<constant value="11:24-15:14"/>
		<constant value="8:8-15:15"/>
		<constant value="authorName"/>
		<constant value="acc"/>
		<constant value="getNbPages"/>
		<constant value="nbPages"/>
		<constant value="23:38-23:39"/>
		<constant value="22:3-22:7"/>
		<constant value="22:3-22:16"/>
		<constant value="22:28-22:29"/>
		<constant value="22:28-22:37"/>
		<constant value="22:3-22:38"/>
		<constant value="24:24-24:27"/>
		<constant value="24:30-24:35"/>
		<constant value="24:24-24:35"/>
		<constant value="22:3-24:36"/>
		<constant value="f"/>
		<constant value="pages"/>
		<constant value="getSumPages"/>
		<constant value="J.sum():J"/>
		<constant value="31:3-31:7"/>
		<constant value="31:3-31:16"/>
		<constant value="31:28-31:29"/>
		<constant value="31:28-31:37"/>
		<constant value="31:3-31:38"/>
		<constant value="31:3-31:44"/>
		<constant value="__matchBook2Publication"/>
		<constant value="Book"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="J.getSumPages():J"/>
		<constant value="J.&gt;(J):J"/>
		<constant value="B.not():B"/>
		<constant value="33"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="b"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="out"/>
		<constant value="Publication"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="38:4-38:5"/>
		<constant value="38:4-38:19"/>
		<constant value="38:22-38:23"/>
		<constant value="38:4-38:23"/>
		<constant value="42:9-42:32"/>
		<constant value="42:3-46:4"/>
		<constant value="__applyBook2Publication"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="title"/>
		<constant value="J.getAuthors():J"/>
		<constant value="authors"/>
		<constant value="43:22-43:23"/>
		<constant value="43:22-43:29"/>
		<constant value="43:13-43:29"/>
		<constant value="44:15-44:16"/>
		<constant value="44:15-44:29"/>
		<constant value="44:4-44:29"/>
		<constant value="45:15-45:16"/>
		<constant value="45:15-45:30"/>
		<constant value="45:4-45:30"/>
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
			<push arg="0"/>
			<call arg="42"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<call arg="43"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="44">
		<context type="45"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<store arg="19"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<get arg="49"/>
			<call arg="50"/>
			<enditerate/>
			<call arg="51"/>
			<iterate/>
			<store arg="29"/>
			<load arg="19"/>
			<load arg="19"/>
			<push arg="46"/>
			<call arg="52"/>
			<if arg="53"/>
			<push arg="54"/>
			<load arg="29"/>
			<call arg="55"/>
			<goto arg="56"/>
			<load arg="29"/>
			<call arg="55"/>
			<store arg="19"/>
			<enditerate/>
			<load arg="19"/>
		</code>
		<linenumbertable>
			<lne id="57" begin="0" end="0"/>
			<lne id="58" begin="5" end="5"/>
			<lne id="59" begin="5" end="6"/>
			<lne id="60" begin="9" end="9"/>
			<lne id="61" begin="9" end="10"/>
			<lne id="62" begin="2" end="12"/>
			<lne id="63" begin="2" end="13"/>
			<lne id="64" begin="16" end="16"/>
			<lne id="65" begin="17" end="17"/>
			<lne id="66" begin="18" end="18"/>
			<lne id="67" begin="17" end="19"/>
			<lne id="68" begin="21" end="21"/>
			<lne id="69" begin="22" end="22"/>
			<lne id="70" begin="21" end="23"/>
			<lne id="71" begin="25" end="25"/>
			<lne id="72" begin="17" end="25"/>
			<lne id="73" begin="16" end="26"/>
			<lne id="74" begin="0" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="8" end="11"/>
			<lve slot="2" name="75" begin="15" end="27"/>
			<lve slot="1" name="76" begin="1" end="29"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="77">
		<context type="45"/>
		<parameters>
		</parameters>
		<code>
			<pushi arg="47"/>
			<store arg="19"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<get arg="78"/>
			<call arg="50"/>
			<enditerate/>
			<iterate/>
			<store arg="29"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="55"/>
			<store arg="19"/>
			<enditerate/>
			<load arg="19"/>
		</code>
		<linenumbertable>
			<lne id="79" begin="0" end="0"/>
			<lne id="80" begin="5" end="5"/>
			<lne id="81" begin="5" end="6"/>
			<lne id="82" begin="9" end="9"/>
			<lne id="83" begin="9" end="10"/>
			<lne id="84" begin="2" end="12"/>
			<lne id="85" begin="15" end="15"/>
			<lne id="86" begin="16" end="16"/>
			<lne id="87" begin="15" end="17"/>
			<lne id="88" begin="0" end="20"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="89" begin="8" end="11"/>
			<lve slot="2" name="90" begin="14" end="18"/>
			<lve slot="1" name="76" begin="1" end="20"/>
			<lve slot="0" name="17" begin="0" end="20"/>
		</localvariabletable>
	</operation>
	<operation name="91">
		<context type="45"/>
		<parameters>
		</parameters>
		<code>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="47"/>
			<get arg="48"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="78"/>
			<call arg="50"/>
			<enditerate/>
			<call arg="92"/>
		</code>
		<linenumbertable>
			<lne id="93" begin="3" end="3"/>
			<lne id="94" begin="3" end="4"/>
			<lne id="95" begin="7" end="7"/>
			<lne id="96" begin="7" end="8"/>
			<lne id="97" begin="0" end="10"/>
			<lne id="98" begin="0" end="11"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="89" begin="6" end="9"/>
			<lve slot="0" name="17" begin="0" end="11"/>
		</localvariabletable>
	</operation>
	<operation name="99">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="100"/>
			<push arg="100"/>
			<findme/>
			<push arg="101"/>
			<call arg="102"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<call arg="103"/>
			<pushi arg="29"/>
			<call arg="104"/>
			<call arg="105"/>
			<if arg="106"/>
			<getasm/>
			<get arg="1"/>
			<push arg="107"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="0"/>
			<call arg="108"/>
			<dup/>
			<push arg="109"/>
			<load arg="19"/>
			<call arg="110"/>
			<dup/>
			<push arg="111"/>
			<push arg="112"/>
			<push arg="112"/>
			<new/>
			<call arg="113"/>
			<pusht/>
			<call arg="114"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="115" begin="7" end="7"/>
			<lne id="116" begin="7" end="8"/>
			<lne id="117" begin="9" end="9"/>
			<lne id="118" begin="7" end="10"/>
			<lne id="119" begin="27" end="29"/>
			<lne id="120" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="109" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="121">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="122"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="109"/>
			<call arg="123"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="111"/>
			<call arg="124"/>
			<store arg="125"/>
			<load arg="125"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="126"/>
			<call arg="30"/>
			<set arg="126"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="127"/>
			<call arg="30"/>
			<set arg="128"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="103"/>
			<call arg="30"/>
			<set arg="78"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="129" begin="11" end="11"/>
			<lne id="130" begin="11" end="12"/>
			<lne id="131" begin="9" end="14"/>
			<lne id="132" begin="17" end="17"/>
			<lne id="133" begin="17" end="18"/>
			<lne id="134" begin="15" end="20"/>
			<lne id="135" begin="23" end="23"/>
			<lne id="136" begin="23" end="24"/>
			<lne id="137" begin="21" end="26"/>
			<lne id="120" begin="8" end="27"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="111" begin="7" end="27"/>
			<lve slot="2" name="109" begin="3" end="27"/>
			<lve slot="0" name="17" begin="0" end="27"/>
			<lve slot="1" name="138" begin="0" end="27"/>
		</localvariabletable>
	</operation>
</asm>
