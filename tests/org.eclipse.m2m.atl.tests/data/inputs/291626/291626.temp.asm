<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="TestAllInstancesCache"/>
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
		<constant value="A.Main():V"/>
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
		<constant value="__exec__"/>
		<constant value="Main"/>
		<constant value="Package"/>
		<constant value="UML"/>
		<constant value="before_"/>
		<constant value="Class"/>
		<constant value="OUT"/>
		<constant value="J.allInstancesFrom(J):J"/>
		<constant value="J.size():J"/>
		<constant value="J.toString():J"/>
		<constant value="J.+(J):J"/>
		<constant value="J.refSetValue(JJ):J"/>
		<constant value="J.newInstance():J"/>
		<constant value="after_"/>
		<constant value="10:2-10:4"/>
		<constant value="10:17-10:23"/>
		<constant value="10:25-10:34"/>
		<constant value="10:37-10:46"/>
		<constant value="10:64-10:69"/>
		<constant value="10:37-10:70"/>
		<constant value="10:37-10:77"/>
		<constant value="10:37-10:88"/>
		<constant value="10:25-10:88"/>
		<constant value="10:2-10:89"/>
		<constant value="10:2-10:90"/>
		<constant value="11:2-11:11"/>
		<constant value="11:2-11:25"/>
		<constant value="11:2-11:26"/>
		<constant value="12:2-12:4"/>
		<constant value="12:17-12:23"/>
		<constant value="12:25-12:33"/>
		<constant value="12:36-12:45"/>
		<constant value="12:63-12:68"/>
		<constant value="12:36-12:69"/>
		<constant value="12:36-12:76"/>
		<constant value="12:36-12:87"/>
		<constant value="12:25-12:87"/>
		<constant value="12:2-12:88"/>
		<constant value="12:2-12:89"/>
		<constant value="9:1-13:2"/>
		<constant value="p1"/>
		<constant value="p2"/>
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
			<getasm/>
			<call arg="17"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="18" begin="0" end="26"/>
		</localvariabletable>
	</operation>
	<operation name="19">
		<context type="6"/>
		<parameters>
			<parameter name="20" type="4"/>
		</parameters>
		<code>
			<load arg="20"/>
			<getasm/>
			<get arg="3"/>
			<call arg="21"/>
			<if arg="22"/>
			<getasm/>
			<get arg="1"/>
			<load arg="20"/>
			<call arg="23"/>
			<dup/>
			<call arg="24"/>
			<if arg="25"/>
			<load arg="20"/>
			<call arg="26"/>
			<goto arg="27"/>
			<pop/>
			<load arg="20"/>
			<goto arg="28"/>
			<push arg="29"/>
			<push arg="8"/>
			<new/>
			<load arg="20"/>
			<iterate/>
			<store arg="30"/>
			<getasm/>
			<load arg="30"/>
			<call arg="31"/>
			<call arg="32"/>
			<enditerate/>
			<call arg="33"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="34" begin="23" end="27"/>
			<lve slot="0" name="18" begin="0" end="29"/>
			<lve slot="1" name="35" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="36">
		<context type="6"/>
		<parameters>
			<parameter name="20" type="4"/>
			<parameter name="30" type="37"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="20"/>
			<call arg="23"/>
			<load arg="20"/>
			<load arg="30"/>
			<call arg="38"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="18" begin="0" end="6"/>
			<lve slot="1" name="35" begin="0" end="6"/>
			<lve slot="2" name="39" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="40">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="18" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="18" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="43"/>
			<push arg="44"/>
			<new/>
			<store arg="20"/>
			<push arg="43"/>
			<push arg="44"/>
			<new/>
			<store arg="30"/>
			<load arg="20"/>
			<pop/>
			<load arg="30"/>
			<pop/>
			<load arg="20"/>
			<push arg="39"/>
			<push arg="45"/>
			<push arg="46"/>
			<push arg="44"/>
			<findme/>
			<push arg="47"/>
			<call arg="48"/>
			<call arg="49"/>
			<call arg="50"/>
			<call arg="51"/>
			<call arg="52"/>
			<push arg="46"/>
			<push arg="44"/>
			<findme/>
			<call arg="53"/>
			<load arg="30"/>
			<push arg="39"/>
			<push arg="54"/>
			<push arg="46"/>
			<push arg="44"/>
			<findme/>
			<push arg="47"/>
			<call arg="48"/>
			<call arg="49"/>
			<call arg="50"/>
			<call arg="51"/>
			<call arg="52"/>
		</code>
		<linenumbertable>
			<lne id="55" begin="12" end="12"/>
			<lne id="56" begin="13" end="13"/>
			<lne id="57" begin="14" end="14"/>
			<lne id="58" begin="15" end="17"/>
			<lne id="59" begin="18" end="18"/>
			<lne id="60" begin="15" end="19"/>
			<lne id="61" begin="15" end="20"/>
			<lne id="62" begin="15" end="21"/>
			<lne id="63" begin="14" end="22"/>
			<lne id="64" begin="12" end="23"/>
			<lne id="65" begin="12" end="23"/>
			<lne id="66" begin="24" end="26"/>
			<lne id="67" begin="24" end="27"/>
			<lne id="68" begin="24" end="27"/>
			<lne id="69" begin="28" end="28"/>
			<lne id="70" begin="29" end="29"/>
			<lne id="71" begin="30" end="30"/>
			<lne id="72" begin="31" end="33"/>
			<lne id="73" begin="34" end="34"/>
			<lne id="74" begin="31" end="35"/>
			<lne id="75" begin="31" end="36"/>
			<lne id="76" begin="31" end="37"/>
			<lne id="77" begin="30" end="38"/>
			<lne id="78" begin="28" end="39"/>
			<lne id="79" begin="28" end="39"/>
			<lne id="80" begin="12" end="39"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="81" begin="3" end="39"/>
			<lve slot="2" name="82" begin="7" end="39"/>
			<lve slot="0" name="18" begin="0" end="39"/>
		</localvariabletable>
	</operation>
</asm>
