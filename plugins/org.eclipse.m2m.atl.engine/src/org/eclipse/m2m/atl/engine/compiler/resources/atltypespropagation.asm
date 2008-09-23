<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm name="0">						<!-- atltypespropagation -->
	<cp>
		<constant value="atltypespropagation"/>	<!-- 0 -->
		<constant value="resolveModel2Metamodel"/><!-- 1 -->
		<constant value="MATL!OclModelElement;"/><!-- 2 -->
		<constant value="Sequence"/>		<!-- 3 -->
		<constant value="#native"/>		<!-- 4 -->
		<constant value="Class"/>		<!-- 5 -->
		<constant value="MOF"/>			<!-- 6 -->
		<constant value="self"/>		<!-- 7 -->
		<constant value="model"/>		<!-- 8 -->
		<constant value="name"/>		<!-- 9 -->
		<constant value="J.allInstances(J):J"/>	<!-- 10 -->
		<constant value="e_1"/>			<!-- 11 -->
		<constant value="J.=(J):J"/>		<!-- 12 -->
		<constant value="B.not():B"/>		<!-- 13 -->
		<constant value="21"/>			<!-- 14 -->
		<constant value="CJ.including(J):CJ"/>	<!-- 15 -->
		<constant value="J.asSequence():J"/>	<!-- 16 -->
		<constant value="J.first():J"/>		<!-- 17 -->
		<constant value="resolveMetamodel2Model"/><!-- 18 -->
		<constant value="MMOF!PrimitiveType;"/>	<!-- 19 -->
		<constant value="String"/>		<!-- 20 -->
		<constant value="7"/>			<!-- 21 -->
		<constant value="TODO"/>		<!-- 22 -->
		<constant value="13"/>			<!-- 23 -->
		<constant value="StringType"/>		<!-- 24 -->
		<constant value="ATL"/>			<!-- 25 -->
		<constant value="J.allInstances():J"/>	<!-- 26 -->
		<constant value="lookupPropertyType"/>	<!-- 27 -->
		<constant value="S"/>			<!-- 28 -->
		<constant value="J.resolveModel2Metamodel():J"/><!-- 29 -->
		<constant value="J.lookupElementExtended(J):J"/><!-- 30 -->
		<constant value="type"/>		<!-- 31 -->
		<constant value="J.resolveMetamodel2Model():J"/><!-- 32 -->
		<constant value="MMOF!Class;"/>		<!-- 33 -->
		<constant value="OclModelElement"/>	<!-- 34 -->
		<constant value="e_5"/>			<!-- 35 -->
		<constant value="18"/>			<!-- 36 -->
		<constant value="getType"/>		<!-- 37 -->
		<constant value="MATL!BooleanExp;"/>	<!-- 38 -->
		<constant value="BooleanType"/>		<!-- 39 -->
		<constant value="MATL!IntegerExp;"/>	<!-- 40 -->
		<constant value="IntegerType"/>		<!-- 41 -->
		<constant value="MATL!RealExp;"/>	<!-- 42 -->
		<constant value="RealType"/>		<!-- 43 -->
		<constant value="MATL!IfExp;"/>		<!-- 44 -->
		<constant value="thenExpression"/>	<!-- 45 -->
		<constant value="MATL!VariableExp;"/>	<!-- 46 -->
		<constant value="referredVariable"/>	<!-- 47 -->
		<constant value="MATL!LetExp;"/>	<!-- 48 -->
		<constant value="in_"/>			<!-- 49 -->
		<constant value="MATL!IteratorExp;"/>	<!-- 50 -->
		<constant value="MATL!IterateExp;"/>	<!-- 51 -->
		<constant value="result"/>		<!-- 52 -->
		<constant value="MATL!OperationCallExp;"/><!-- 53 -->
		<constant value="MATL!NavigationOrAttributeCallExp;"/><!-- 54 -->
		<constant value="source"/>		<!-- 55 -->
		<constant value="J.lookupPropertyType(J):J"/><!-- 56 -->
		<constant value="MATL!OperatorCallExp;"/><!-- 57 -->
		<constant value="."/>			<!-- 58 -->
		<constant value="J.+(J):J"/>		<!-- 59 -->
		<constant value="operationName"/>	<!-- 60 -->
		<constant value="("/>			<!-- 61 -->
		<constant value=""/>			<!-- 62 -->
		<constant value="acc_6"/>		<!-- 63 -->
		<constant value="arguments"/>		<!-- 64 -->
		<constant value="e_7"/>			<!-- 65 -->
		<constant value="23"/>			<!-- 66 -->
		<constant value=", "/>			<!-- 67 -->
		<constant value="24"/>			<!-- 68 -->
		<constant value=")"/>			<!-- 69 -->
		<constant value="J.output():J"/>	<!-- 70 -->
		<constant value="a_10"/>		<!-- 71 -->
		<constant value="MATL!StringExp;"/>	<!-- 72 -->
	</cp>
	<operation name="1">				<!-- resolveModel2Metamodel -->
		<context type="2"/>			<!-- MATL!OclModelElement; -->
		<parameters>
		</parameters>
		<code>
			<push arg="3"/>			<!-- Sequence -->
			<push arg="4"/>			<!-- #native -->
			<new/>
			<push arg="5"/>			<!-- Class -->
			<push arg="6"/>			<!-- MOF -->
			<findme/>
			<load arg="7"/>			<!-- self -->
			<get arg="8"/>			<!-- model -->
			<get arg="9"/>			<!-- name -->
			<call arg="10"/>		<!-- J.allInstances(J):J -->
			<iterate/>
			<store arg="11"/>		<!-- e_1 -->
			<load arg="11"/>		<!-- e_1 -->
			<get arg="9"/>			<!-- name -->
			<load arg="7"/>			<!-- self -->
			<get arg="9"/>			<!-- name -->
			<call arg="12"/>		<!-- J.=(J):J -->
			<call arg="13"/>		<!-- B.not():B -->
			<if arg="14"/>			<!-- 21 -->
			<load arg="11"/>		<!-- e_1 -->
			<call arg="15"/>		<!-- CJ.including(J):CJ -->
			<enditerate/>
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="18">				<!-- resolveMetamodel2Model -->
		<context type="19"/>			<!-- MMOF!PrimitiveType; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="9"/>			<!-- name -->
			<push arg="20"/>		<!-- String -->
			<call arg="12"/>		<!-- J.=(J):J -->
			<if arg="21"/>			<!-- 7 -->
			<push arg="22"/>		<!-- TODO -->
			<goto arg="23"/>		<!-- 13 -->
			<push arg="24"/>		<!-- StringType -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="27">				<!-- lookupPropertyType -->
		<context type="2"/>			<!-- MATL!OclModelElement; -->
		<parameters>
			<parameter name="9" type="28"/>	<!-- name : S -->
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<call arg="29"/>		<!-- J.resolveModel2Metamodel():J -->
			<load arg="9"/>			<!-- name -->
			<call arg="30"/>		<!-- J.lookupElementExtended(J):J -->
			<get arg="31"/>			<!-- type -->
			<call arg="32"/>		<!-- J.resolveMetamodel2Model():J -->
		</code>
	</operation>
	<operation name="18">				<!-- resolveMetamodel2Model -->
		<context type="33"/>			<!-- MMOF!Class; -->
		<parameters>
		</parameters>
		<code>
			<push arg="3"/>			<!-- Sequence -->
			<push arg="4"/>			<!-- #native -->
			<new/>
			<push arg="34"/>		<!-- OclModelElement -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<iterate/>
			<store arg="35"/>		<!-- e_5 -->
			<load arg="35"/>		<!-- e_5 -->
			<get arg="9"/>			<!-- name -->
			<load arg="7"/>			<!-- self -->
			<get arg="9"/>			<!-- name -->
			<call arg="12"/>		<!-- J.=(J):J -->
			<call arg="13"/>		<!-- B.not():B -->
			<if arg="36"/>			<!-- 18 -->
			<load arg="35"/>		<!-- e_5 -->
			<call arg="15"/>		<!-- CJ.including(J):CJ -->
			<enditerate/>
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="38"/>			<!-- MATL!BooleanExp; -->
		<parameters>
		</parameters>
		<code>
			<push arg="39"/>		<!-- BooleanType -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="40"/>			<!-- MATL!IntegerExp; -->
		<parameters>
		</parameters>
		<code>
			<push arg="41"/>		<!-- IntegerType -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="42"/>			<!-- MATL!RealExp; -->
		<parameters>
		</parameters>
		<code>
			<push arg="43"/>		<!-- RealType -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="2"/>			<!-- MATL!OclModelElement; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="22"/>			<!-- TODO -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="44"/>			<!-- MATL!IfExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="45"/>			<!-- thenExpression -->
			<get arg="31"/>			<!-- type -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="46"/>			<!-- MATL!VariableExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="47"/>			<!-- referredVariable -->
			<get arg="31"/>			<!-- type -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="48"/>			<!-- MATL!LetExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="49"/>			<!-- in_ -->
			<get arg="31"/>			<!-- type -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="50"/>			<!-- MATL!IteratorExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="22"/>			<!-- TODO -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="51"/>			<!-- MATL!IterateExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="52"/>			<!-- result -->
			<get arg="31"/>			<!-- type -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="53"/>			<!-- MATL!OperationCallExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="22"/>			<!-- TODO -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="54"/>			<!-- MATL!NavigationOrAttributeCallExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="55"/>			<!-- source -->
			<get arg="31"/>			<!-- type -->
			<load arg="7"/>			<!-- self -->
			<get arg="9"/>			<!-- name -->
			<call arg="56"/>		<!-- J.lookupPropertyType(J):J -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="57"/>			<!-- MATL!OperatorCallExp; -->
		<parameters>
		</parameters>
		<code>
			<load arg="7"/>			<!-- self -->
			<get arg="55"/>			<!-- source -->
			<get arg="31"/>			<!-- type -->
			<get arg="9"/>			<!-- name -->
			<push arg="58"/>		<!-- . -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<load arg="7"/>			<!-- self -->
			<get arg="60"/>			<!-- operationName -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<push arg="61"/>		<!-- ( -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<push arg="62"/>		<!--  -->
			<store arg="63"/>		<!-- acc_6 -->
			<load arg="7"/>			<!-- self -->
			<get arg="64"/>			<!-- arguments -->
			<iterate/>
			<store arg="65"/>		<!-- e_7 -->
			<load arg="63"/>		<!-- acc_6 -->
			<push arg="62"/>		<!--  -->
			<call arg="12"/>		<!-- J.=(J):J -->
			<if arg="66"/>			<!-- 23 -->
			<push arg="67"/>		<!-- ,  -->
			<goto arg="68"/>		<!-- 24 -->
			<push arg="62"/>		<!--  -->
			<load arg="65"/>		<!-- e_7 -->
			<get arg="31"/>			<!-- type -->
			<get arg="9"/>			<!-- name -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<store arg="63"/>		<!-- acc_6 -->
			<enditerate/>
			<load arg="63"/>		<!-- acc_6 -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<push arg="69"/>		<!-- ) -->
			<call arg="59"/>		<!-- J.+(J):J -->
			<call arg="70"/>		<!-- J.output():J -->
			<store arg="71"/>		<!-- a_10 -->
			<load arg="7"/>			<!-- self -->
			<get arg="22"/>			<!-- TODO -->
		</code>
	</operation>
	<operation name="37">				<!-- getType -->
		<context type="72"/>			<!-- MATL!StringExp; -->
		<parameters>
		</parameters>
		<code>
			<push arg="24"/>		<!-- StringType -->
			<push arg="25"/>		<!-- ATL -->
			<findme/>
			<call arg="26"/>		<!-- J.allInstances():J -->
			<call arg="16"/>		<!-- J.asSequence():J -->
			<call arg="17"/>		<!-- J.first():J -->
		</code>
	</operation>
</asm>
