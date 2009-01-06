<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">
	<cp>
		<constant value="atl"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="root"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="Sequence"/>
		<constant value="QJ.first():J"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="4:44-4:56"/>
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
		<constant value="A.__matchListe():V"/>
		<constant value="__exec__"/>
		<constant value="Liste"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyListe(NTransientLink;):V"/>
		<constant value="Object"/>
		<constant value="MUniqueLazyRule!Object;"/>
		<constant value="NTransientLinkSet;.getLinkByRuleAndSourceElement(SJ):QNTransientLink;"/>
		<constant value="11"/>
		<constant value="42"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="in_object"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="object"/>
		<constant value="UniqueLazyRule"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:14-11:23"/>
		<constant value="11:14-11:28"/>
		<constant value="11:6-11:28"/>
		<constant value="10:3-12:4"/>
		<constant value="__matchListe"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="in_liste"/>
		<constant value="liste"/>
		<constant value="20:11-20:31"/>
		<constant value="20:3-22:3"/>
		<constant value="__applyListe"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="J.allInstancesFrom(J):J"/>
		<constant value="4"/>
		<constant value="J.Object(J):J"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="contents"/>
		<constant value="21:16-21:37"/>
		<constant value="21:55-21:59"/>
		<constant value="21:16-21:60"/>
		<constant value="21:74-21:84"/>
		<constant value="21:92-21:93"/>
		<constant value="21:74-21:94"/>
		<constant value="21:16-21:95"/>
		<constant value="21:4-21:95"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<field name="5" type="4"/>
	<operation name="6">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="8"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="10"/>
			<call arg="11"/>
			<dup/>
			<push arg="12"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="13"/>
			<call arg="11"/>
			<call arg="14"/>
			<set arg="3"/>
			<getasm/>
			<push arg="15"/>
			<push arg="9"/>
			<new/>
			<call arg="16"/>
			<set arg="5"/>
			<getasm/>
			<push arg="17"/>
			<push arg="9"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<call arg="18"/>
			<getasm/>
			<call arg="19"/>
		</code>
		<linenumbertable>
			<lne id="20" begin="17" end="20"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="30"/>
		</localvariabletable>
	</operation>
	<operation name="22">
		<context type="7"/>
		<parameters>
			<parameter name="23" type="4"/>
		</parameters>
		<code>
			<load arg="23"/>
			<getasm/>
			<get arg="3"/>
			<call arg="24"/>
			<if arg="25"/>
			<getasm/>
			<get arg="1"/>
			<load arg="23"/>
			<call arg="26"/>
			<dup/>
			<call arg="27"/>
			<if arg="28"/>
			<load arg="23"/>
			<call arg="29"/>
			<goto arg="30"/>
			<pop/>
			<load arg="23"/>
			<goto arg="31"/>
			<push arg="15"/>
			<push arg="9"/>
			<new/>
			<load arg="23"/>
			<iterate/>
			<store arg="32"/>
			<getasm/>
			<load arg="32"/>
			<call arg="33"/>
			<call arg="34"/>
			<enditerate/>
			<call arg="35"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="36" begin="23" end="27"/>
			<lve slot="0" name="21" begin="0" end="29"/>
			<lve slot="1" name="37" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="38">
		<context type="7"/>
		<parameters>
			<parameter name="23" type="4"/>
			<parameter name="32" type="39"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="23"/>
			<call arg="26"/>
			<load arg="23"/>
			<load arg="32"/>
			<call arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="6"/>
			<lve slot="1" name="37" begin="0" end="6"/>
			<lve slot="2" name="41" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<call arg="43"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="21" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="44">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="45"/>
			<call arg="46"/>
			<iterate/>
			<store arg="23"/>
			<getasm/>
			<load arg="23"/>
			<call arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="36" begin="5" end="8"/>
			<lve slot="0" name="21" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="7"/>
		<parameters>
			<parameter name="23" type="49"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="48"/>
			<load arg="23"/>
			<call arg="50"/>
			<dup/>
			<call arg="27"/>
			<if arg="51"/>
			<load arg="23"/>
			<call arg="29"/>
			<goto arg="52"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="48"/>
			<call arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="23"/>
			<call arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="48"/>
			<push arg="58"/>
			<new/>
			<dup/>
			<store arg="32"/>
			<call arg="59"/>
			<pushf/>
			<call arg="60"/>
			<load arg="32"/>
			<dup/>
			<getasm/>
			<load arg="23"/>
			<get arg="41"/>
			<call arg="33"/>
			<set arg="41"/>
			<pop/>
			<load arg="32"/>
		</code>
		<linenumbertable>
			<lne id="61" begin="36" end="36"/>
			<lne id="62" begin="36" end="37"/>
			<lne id="63" begin="34" end="39"/>
			<lne id="64" begin="33" end="40"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="57" begin="29" end="41"/>
			<lve slot="0" name="21" begin="0" end="41"/>
			<lve slot="1" name="55" begin="0" end="41"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<push arg="45"/>
			<push arg="58"/>
			<findme/>
			<push arg="66"/>
			<call arg="67"/>
			<iterate/>
			<store arg="23"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="45"/>
			<call arg="54"/>
			<dup/>
			<push arg="68"/>
			<load arg="23"/>
			<call arg="56"/>
			<dup/>
			<push arg="69"/>
			<push arg="45"/>
			<push arg="58"/>
			<new/>
			<call arg="59"/>
			<pusht/>
			<call arg="60"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="70" begin="21" end="23"/>
			<lne id="71" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="68" begin="6" end="26"/>
			<lve slot="0" name="21" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="72">
		<context type="7"/>
		<parameters>
			<parameter name="23" type="73"/>
		</parameters>
		<code>
			<load arg="23"/>
			<push arg="68"/>
			<call arg="74"/>
			<store arg="32"/>
			<load arg="23"/>
			<push arg="69"/>
			<call arg="75"/>
			<store arg="76"/>
			<load arg="76"/>
			<dup/>
			<getasm/>
			<push arg="15"/>
			<push arg="9"/>
			<new/>
			<push arg="48"/>
			<push arg="58"/>
			<findme/>
			<push arg="66"/>
			<call arg="77"/>
			<iterate/>
			<store arg="78"/>
			<getasm/>
			<load arg="78"/>
			<call arg="79"/>
			<call arg="80"/>
			<enditerate/>
			<call arg="33"/>
			<set arg="81"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="82" begin="14" end="16"/>
			<lne id="83" begin="17" end="17"/>
			<lne id="84" begin="14" end="18"/>
			<lne id="85" begin="21" end="21"/>
			<lne id="86" begin="22" end="22"/>
			<lne id="87" begin="21" end="23"/>
			<lne id="88" begin="11" end="25"/>
			<lne id="89" begin="9" end="27"/>
			<lne id="71" begin="8" end="28"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="36" begin="20" end="24"/>
			<lve slot="3" name="69" begin="7" end="28"/>
			<lve slot="2" name="68" begin="3" end="28"/>
			<lve slot="0" name="21" begin="0" end="28"/>
			<lve slot="1" name="90" begin="0" end="28"/>
		</localvariabletable>
	</operation>
</asm>
