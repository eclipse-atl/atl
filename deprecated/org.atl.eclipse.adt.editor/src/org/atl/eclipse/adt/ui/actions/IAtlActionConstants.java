/*
 * Created on 8 juil. 2004
 */
package org.atl.eclipse.adt.ui.actions;

/**
 * Action ids for standard actions, for groups in the menu bar, and
 * for actions in context menus of JDT views.
 */
public interface IAtlActionConstants {
	
	/**
	 * Source menu: name of standard Add ATLdoc Comment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.AddATLDocComment"</code>).
	 */
	//public static final String ADD_ATL_DOC_COMMENT= "org.atl.eclipse.adt.ui.actions.AddATLDocComment";
	
	/**
	 * Source menu: name of standard Block Comment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.AddBlockComment"</code>).
	 */
	//public static final String ADD_BLOCK_COMMENT= "org.atl.eclipse.adt.ui.actions.AddBlockComment";

	/**
	 * Source menu: name of standard Add Constructor From Superclass global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.AddConstructorFromSuperclass"</code>).
	 */
	//public static final String ADD_CONSTRUCTOR_FROM_SUPERCLASS= "org.atl.eclipse.adt.ui.actions.AddConstructorFromSuperclass";
	
	/**
	 * Source menu: name of standard Add Import global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.AddImport"</code>).
	 */
	//public static final String ADD_IMPORT= "org.atl.eclipse.adt.ui.actions.AddImport";

	/**
	 * Refactor menu: name of standard Generalize Type global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ChangeType"</code>).
	 */
	//public static final String CHANGE_TYPE= "org.atl.eclipse.adt.ui.actions.ChangeType";

	/**
	 * Source menu: name of standard Comment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Comment"</code>).
	 */
	//public static final String COMMENT= "org.atl.eclipse.adt.ui.actions.Comment";
	
	/**
	 * Edit menu: name of standard Code Assist global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ContentAssist"</code>).
	 */
	//public static final String CONTENT_ASSIST= "org.atl.eclipse.adt.ui.actions.ContentAssist";

	/**
	 * Refactor menu: name of standard Covert Anonymous to Nested global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ConvertAnonymousToNested"</code>).
	 */
	//public static final String CONVERT_ANONYMOUS_TO_NESTED= "org.atl.eclipse.adt.ui.actions.ConvertAnonymousToNested";

	/**
	 * Source menu: name of standardConvert Line Delimiters To Mac global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToMac"</code>).
	 */
	//public static final String CONVERT_LINE_DELIMITERS_TO_MAC= "org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToMac";

	/**
	 * Source menu: name of standard Convert Line Delimiters To UNIX global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToUNIX"</code>).
	 */
	//public static final String CONVERT_LINE_DELIMITERS_TO_UNIX= "org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToUNIX";
	
	/**
	 * Source menu: name of standard Convert Line Delimiters To Windows global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToWindows"</code>).
	 */
	//public static final String CONVERT_LINE_DELIMITERS_TO_WINDOWS= "org.atl.eclipse.adt.ui.actions.ConvertLineDelimitersToWindows";

	/**
	 * Refactor menu: name of standard global action to convert a local
	 * variable to a field (value <code>"org.atl.eclipse.adt.ui.actions.ConvertLocalToField"</code>).
	 */
	//public static final String CONVERT_LOCAL_TO_FIELD= "org.atl.eclipse.adt.ui.actions.ConvertLocalToField";

	/**
	 * Refactor menu: name of standard global action to convert a nested type to a top level type
	 * (value <code>"org.atl.eclipse.adt.ui.actions.MoveInnerToTop"</code>).
	 */
	//public static final String CONVERT_NESTED_TO_TOP= "org.atl.eclipse.adt.ui.actions.ConvertNestedToTop";
	
	/**
	 * Source menu: name of standard Externalize Strings global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ExternalizeStrings"</code>).
	 */
	//public static final String EXTERNALIZE_STRINGS= "org.atl.eclipse.adt.ui.actions.ExternalizeStrings";

	/**
	 * Refactor menu: name of standard Extract Constant global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ExtractConstant"</code>).
	 */
	//public static final String EXTRACT_CONSTANT= "org.atl.eclipse.adt.ui.actions.ExtractConstant";

	/**
	 * Refactor menu: name of standard Extract Interface global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ExtractInterface"</code>).
	 */
	//public static final String EXTRACT_INTERFACE= "org.atl.eclipse.adt.ui.actions.ExtractInterface";

	/**
	 * Refactor menu: name of standard Extract Method global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ExtractMethod"</code>).
	 */
	//public static final String EXTRACT_METHOD= "org.atl.eclipse.adt.ui.actions.ExtractMethod";
	
	/**
	 * Refactor menu: name of standard Extract Temp global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ExtractTemp"</code>).
	 */
	//public static final String EXTRACT_TEMP= "org.atl.eclipse.adt.ui.actions.ExtractTemp";

	/**
	 * Search menu: name of standard Find Declarations in Hierarchy global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.DeclarationsInHierarchy"</code>).
	 */
	//public static final String FIND_DECLARATIONS_IN_HIERARCHY= "org.atl.eclipse.adt.ui.actions.DeclarationsInHierarchy";

	/**
	 * Search menu: name of standard Find Declarations in Project global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.DeclarationsInProject"</code>).
	 */
	//public static final String FIND_DECLARATIONS_IN_PROJECT= "org.atl.eclipse.adt.ui.actions.DeclarationsInProject";
	
	/**
	 * Search menu: name of standard Find Declarations in Working Set global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.DeclarationsInWorkingSet"</code>).
	 */
	//public static final String FIND_DECLARATIONS_IN_WORKING_SET= "org.atl.eclipse.adt.ui.actions.DeclarationsInWorkingSet";



	/**
	 * Search menu: name of standard Find Declarations in Workspace global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.DeclarationsInWorkspace"</code>).
	 */
	//public static final String FIND_DECLARATIONS_IN_WORKSPACE= "org.atl.eclipse.adt.ui.actions.DeclarationsInWorkspace";
	
	/**
	 * Search menu: name of standard Find exception occurrences global action (value
	 * <code>"org.atl.eclipse.adt.ui.actions.ExceptionOccurrences"</code>).
	 */
	//public static final String FIND_EXCEPTION_OCCURRENCES= "org.atl.eclipse.adt.ui.actions.ExceptionOccurrences";		

	/**
	 * Search menu: name of standard Find Implementors in Project global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ImplementorsInProject"</code>).
	 */
	//public static final String FIND_IMPLEMENTORS_IN_PROJECT= "org.atl.eclipse.adt.ui.actions.ImplementorsInProject";

	/**
	 * Search menu: name of standard Find Implementors in Working Set global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ImplementorsInWorkingSet"</code>).
	 */
	//public static final String FIND_IMPLEMENTORS_IN_WORKING_SET= "org.atl.eclipse.adt.ui.actions.ImplementorsInWorkingSet";

	/**
	 * Search menu: name of standard Find Implementors in Workspace global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ImplementorsInWorkspace"</code>).
	 */
	//public static final String FIND_IMPLEMENTORS_IN_WORKSPACE= "org.atl.eclipse.adt.ui.actions.ImplementorsInWorkspace";
	
	/**
	 * Search menu: name of standard Occurrences in File global action (value
	 * <code>"org.atl.eclipse.adt.ui.actions.OccurrencesInFile"</code>).
	 */
	//public static final String FIND_OCCURRENCES_IN_FILE= "org.atl.eclipse.adt.ui.actions.OccurrencesInFile";

	/**
	 * Search menu: name of standard Find Read Access in Hierarchy global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReadAccessInHierarchy"</code>).
	 */
	//public static final String FIND_READ_ACCESS_IN_HIERARCHY= "org.atl.eclipse.adt.ui.actions.ReadAccessInHierarchy";

	/**
	 * Search menu: name of standard Find Read Access in Project global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReadAccessInProject"</code>).
	 */
	//public static final String FIND_READ_ACCESS_IN_PROJECT= "org.atl.eclipse.adt.ui.actions.ReadAccessInProject";
	
	/**
	 * Search menu: name of standard Find Read Access in Working Set global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReadAccessInWorkingSet"</code>).
	 */
	//public static final String FIND_READ_ACCESS_IN_WORKING_SET= "org.atl.eclipse.adt.ui.actions.ReadAccessInWorkingSet";

	/**
	 * Search menu: name of standard Find Read Access in Workspace global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReadAccessInWorkspace"</code>).
	 */
	//public static final String FIND_READ_ACCESS_IN_WORKSPACE= "org.atl.eclipse.adt.ui.actions.ReadAccessInWorkspace";

	/**
	 * Search menu: name of standard Find References in Hierarchy global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReferencesInHierarchy"</code>).
	 */
	//public static final String FIND_REFERENCES_IN_HIERARCHY= "org.atl.eclipse.adt.ui.actions.ReferencesInHierarchy";

	/**
	 * Search menu: name of standard Find References in Project global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReferencesInProject"</code>).
	 */
	//public static final String FIND_REFERENCES_IN_PROJECT= "org.atl.eclipse.adt.ui.actions.ReferencesInProject";
	
	/**
	 * Search menu: name of standard Find References in Working Set global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReferencesInWorkingSet"</code>).
	 */
	//public static final String FIND_REFERENCES_IN_WORKING_SET= "org.atl.eclipse.adt.ui.actions.ReferencesInWorkingSet";
	
	/**
	 * Search menu: name of standard Find References in Workspace global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ReferencesInWorkspace"</code>).
	 */
	//public static final String FIND_REFERENCES_IN_WORKSPACE= "org.atl.eclipse.adt.ui.actions.ReferencesInWorkspace";

	/**
	 * Source menu: name of standard Find Strings to Externalize global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.FindStringsToExternalize"</code>).
	 */
	//public static final String FIND_STRINGS_TO_EXTERNALIZE= "org.atl.eclipse.adt.ui.actions.FindStringsToExternalize";

	/**
	 * Search menu: name of standard Find Read Access in Hierarchy global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.WriteAccessInHierarchy"</code>).
	 */
	//public static final String FIND_WRITE_ACCESS_IN_HIERARCHY= "org.atl.eclipse.adt.ui.actions.WriteAccessInHierarchy";

	/**
	 * Search menu: name of standard Find Write Access in Project global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.WriteAccessInProject"</code>).
	 */
	//public static final String FIND_WRITE_ACCESS_IN_PROJECT= "org.atl.eclipse.adt.ui.actions.WriteAccessInProject";
	
	/**
	 * Search menu: name of standard Find Read Access in Working Set global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.WriteAccessInWorkingSet"</code>).
	 */
	//public static final String FIND_WRITE_ACCESS_IN_WORKING_SET= "org.atl.eclipse.adt.ui.actions.WriteAccessInWorkingSet";

	/**
	 * Search menu: name of standard Find Write Access in Workspace global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.WriteAccessInWorkspace"</code>).
	 */
	//public static final String FIND_WRITE_ACCESS_IN_WORKSPACE= "org.atl.eclipse.adt.ui.actions.WriteAccessInWorkspace";
	
	/**
	 * Source menu: name of standard Format global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Format"</code>).
	 */
	//public static final String FORMAT= "org.atl.eclipse.adt.ui.actions.Format";
	
	/**
	 * Source menu: name of standard Format Element global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.FormatElement"</code>).
	 */
	//public static final String FORMAT_ELEMENT= "org.atl.eclipse.adt.ui.actions.FormatElement";
	
	/**
	 * Source menu: name of standard Generate Constructor using Fields global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.GenerateConstructorUsingFields"</code>).
	 */
	//public static final String GENERATE_CONSTRUCTOR_USING_FIELDS= "org.atl.eclipse.adt.ui.actions.GenerateConstructorUsingFields";

	/**
	 * Source menu: name of standard delegate methods global action (value
	 * <code>"org.atl.eclipse.adt.ui.actions.GenerateDelegateMethods"</code>).
	 */
	//public static final String GENERATE_DELEGATE_METHODS= "org.atl.eclipse.adt.ui.actions.GenerateDelegateMethods";
	
	/**
	 * Source menu: name of standard Generate Getter and Setter global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.GenerateGetterSetter"</code>).
	 */
	//public static final String GENERATE_GETTER_SETTER= "org.atl.eclipse.adt.ui.actions.GenerateGetterSetter";
	
	/**
	 * Navigate menu: name of standard Goto Package global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.GoToPackage"</code>).
	 */
	//public static final String GOTO_PACKAGE= "org.atl.eclipse.adt.ui.actions.GoToPackage";

	/**
	 * Navigate menu: name of standard Goto Type global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.GoToType"</code>).
	 */
	//public static final String GOTO_TYPE= "org.atl.eclipse.adt.ui.actions.GoToType";
	
	/**
	 * Source menu: name of standard Indent global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Indent"</code>).
	 */
	public static final String INDENT= "org.atl.eclipse.adt.ui.actions.Indent";

	/**
	 * Refactor menu: name of standard Inline global action 
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Inline"</code>).
	 */
	//public static final String INLINE= "org.atl.eclipse.adt.ui.actions.Inline";
	
	/**
	 * Refactor menu: name of standard Inline Temp global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.InlineTemp"</code>).
	 * @deprecated Use INLINE
	 */
	//public static final String INLINE_TEMP= "org.atl.eclipse.adt.ui.actions.InlineTemp";

	/**
	 * Refactor menu: name of standard Introduce Factory global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.IntroduceFactory"</code>).
	 */
	//public static final String INTRODUCE_FACTORY= "org.atl.eclipse.adt.ui.actions.IntroduceFactory";

	/**
	 * Refactor menu: name of standard Introduce Parameter global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.IntroduceParameter"</code>).
	 */
	//public static final String INTRODUCE_PARAMETER= "org.atl.eclipse.adt.ui.actions.IntroduceParameter";
	
	/**
	 * Refactor menu: name of standard Modify Parameters global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ModifyParameters"</code>).
	 */
	//public static final String MODIFY_PARAMETERS= "org.atl.eclipse.adt.ui.actions.ModifyParameters";
	
	/**
	 * Refactor menu: name of standard Move Element global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Move"</code>).
	 */
	//public static final String MOVE= "org.atl.eclipse.adt.ui.actions.Move";
	
	/**
	 * Navigate menu: name of standard Open global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Open"</code>).
	 */
	//public static final String OPEN= "org.atl.eclipse.adt.ui.actions.Open";

    /**
     * Navigate menu: name of standard Open Call Hierarchy global action
     * (value <code>"org.atl.eclipse.adt.ui.actions.OpenCallHierarchy"</code>).
     */
    //public static final String OPEN_CALL_HIERARCHY= "org.atl.eclipse.adt.ui.actions.OpenCallHierarchy";

	/**
	 * Navigate menu: name of standard Open External ATLdoc global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.OpenExternalATLDoc"</code>).
	 */
	//public static final String OPEN_EXTERNAL_ATL_DOC= "org.atl.eclipse.adt.ui.actions.OpenExternalATLDoc";

	/**
	 * Navigate menu: name of standard Open Super Implementation global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.OpenSuperImplementation"</code>).
	 */
	//public static final String OPEN_SUPER_IMPLEMENTATION= "org.atl.eclipse.adt.ui.actions.OpenSuperImplementation";
	
	/**
	 * Navigate menu: name of standard Open Type Hierarchy global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.OpenTypeHierarchy"</code>).
	 */
	//public static final String OPEN_TYPE_HIERARCHY= "org.atl.eclipse.adt.ui.actions.OpenTypeHierarchy";
	
	/**
	 * Source menu: name of standard Organize Imports global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.OrganizeImports"</code>).
	 */
	//public static final String ORGANIZE_IMPORTS= "org.atl.eclipse.adt.ui.actions.OrganizeImports";
	
	/**
	 * Source menu: name of standard Override Methods global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.OverrideMethods"</code>).
	 */
	//public static final String OVERRIDE_METHODS= "org.atl.eclipse.adt.ui.actions.OverrideMethods";
	
	/**
	 * Refactor menu: name of standard Pull Up global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.PullUp"</code>).
	 */
	//public static final String PULL_UP= "org.atl.eclipse.adt.ui.actions.PullUp";

	/**
	 * Refactor menu: name of standard Push Down global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.PushDown"</code>).
	 */
	//public static final String PUSH_DOWN= "org.atl.eclipse.adt.ui.actions.PushDown";
	
	/**
	 * Source menu: name of standard Block Uncomment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.RemoveBlockComment"</code>).
	 */
	//public static final String REMOVE_BLOCK_COMMENT= "org.atl.eclipse.adt.ui.actions.RemoveBlockComment";
	
	/**
	 * Refactor menu: name of standard Rename Element global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Rename"</code>).
	 */
	//public static final String RENAME= "org.atl.eclipse.adt.ui.actions.Rename";

	/**
	 * Refactor menu: name of standard Self Encapsulate Field global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.SelfEncapsulateField"</code>).
	 */
	//public static final String SELF_ENCAPSULATE_FIELD= "org.atl.eclipse.adt.ui.actions.SelfEncapsulateField";
	
	/**
	 * Source menu: name of standard Shift Left global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ShiftLeft"</code>).
	 */
	//public static final String SHIFT_LEFT= "org.atl.eclipse.adt.ui.actions.ShiftLeft";
	
	/**
	 * Source menu: name of standard Shift Right action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ShiftRight"</code>).
	 */
	//public static final String SHIFT_RIGHT= "org.atl.eclipse.adt.ui.actions.ShiftRight";

	/**
	 * Edit menu: name of standard Show ATLdoc global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ShowATLDoc"</code>).
	 */
	//public static final String SHOW_ATL_DOC= "org.atl.eclipse.adt.ui.actions.ShowATLDoc";

	/**
	 * Navigate menu: name of standard Show in Navigator View global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ShowInNaviagtorView"</code>).
	 */
	//public static final String SHOW_IN_NAVIGATOR_VIEW= "org.atl.eclipse.adt.ui.actions.ShowInNaviagtorView";
	
	/**
	 * Navigate menu: name of standard Show in Packages View global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ShowInPackagesView"</code>).
	 */
	//public static final String SHOW_IN_PACKAGE_VIEW= "org.atl.eclipse.adt.ui.actions.ShowInPackagesView";

	/**
	 * Source menu: name of standard Sort Members global action (value
	 * <code>"org.atl.eclipse.adt.ui.actions.SortMembers"</code>).
	 */
	//public static final String SORT_MEMBERS= "org.atl.eclipse.adt.ui.actions.SortMembers";
	
	/**
	 * Source menu: name of standard Surround with try/catch block global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.SurroundWithTryCatch"</code>).
	 */
	//public static final String SURROUND_WITH_TRY_CATCH= "org.atl.eclipse.adt.ui.actions.SurroundWithTryCatch";
	
	/**
	 * Source menu: name of standard ToggleComment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.ToggleComment"</code>).
	 */
	//public static final String TOGGLE_COMMENT= "org.atl.eclipse.adt.ui.actions.ToggleComment";
	
	/**
	 * Source menu: name of standard Uncomment global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.Uncomment"</code>).
	 */
	//public static final String UNCOMMENT= "org.atl.eclipse.adt.ui.actions.Uncomment";
	
	/**
	 * Refactor menu: name of standard Use Supertype global action
	 * (value <code>"org.atl.eclipse.adt.ui.actions.UseSupertype"</code>).
	 */
	//public static final String USE_SUPERTYPE= "org.atl.eclipse.adt.ui.actions.UseSupertype";
	
}
