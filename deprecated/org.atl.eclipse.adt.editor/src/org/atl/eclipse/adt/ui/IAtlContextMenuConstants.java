/*
 * Created on 13 juil. 2004
 */
package org.atl.eclipse.adt.ui;


/**
 * Constants for menu groups used in context menus for views and editors.
 * 
 * @author C. MONTI for ATL team
 */
public interface IAtlContextMenuConstants {
    
    /**
     * Pop-up menu: name of group for additional actions (value <code>"additions"</code>).
     */	
    public static final String GROUP_ADDITIONS=	"additions";
    
    /**
     * Pop-up menu: name of group for build actions (value <code>"group.build"</code>).
     */
    //public static final String GROUP_BUILD=		"group.build";
    
    /**
     * Pop-up menu: name of group for code generation actions (
     * value <code>"group.generate"</code>).
     */	
    //public static final String GROUP_GENERATE=	"group.generate";
    
    
    /**
     * Pop-up menu: name of group for goto actions (value <code>"group.open"</code>).
     * <p>
     * Examples for open actions are:
     * <ul>
     *  <li>Go Into</li>
     *  <li>Go To</li>
     * </ul>
     * </p>
     */
    //public static final String GROUP_GOTO=		"group.goto";
    
    /**
     * Pop-up menu: name of group for new actions (value <code>"group.new"</code>).
     * <p>
     * Examples for new actions are:
     * <ul>
     *  <li>Create new class</li>
     *  <li>Create new interface</li>
     * </ul>
     * </p>
     */
    //public static final String GROUP_NEW=		"group.new";
    /**
     * Pop-up menu: name of group for open actions (value <code>"group.open"</code>).
     * <p>
     * Examples for open actions are:
     * <ul>
     *  <li>Open To</li>
     *  <li>Open With</li>
     * </ul>
     * </p>
     */
    //public static final String GROUP_OPEN=		"group.open";
    
    /**
     * Pop-up menu: name of group for properties actions (value <code>"group.properties"</code>).
     */	
    //public static final String GROUP_PROPERTIES=	"group.properties";
    
    /**
     * Pop-up menu: name of group for reorganize actions (value <code>"group.reorganize"</code>).
     */	
    //public static final String GROUP_REORGANIZE=	IWorkbenchActionConstants.GROUP_REORGANIZE;	
    
    /**
     * Pop-up menu: name of group for search actions (value <code>"group.search"</code>).
     */	
    //public static final String GROUP_SEARCH=		"group.search";
    
    /**
     * Pop-up menu: name of group for show actions (value <code>"group.show"</code>).
     * <p>
     * Examples for show actions are:
     * <ul>
     *  <li>Show in Navigator</li>
     *  <li>Show in Type Hierarchy</li>
     * </ul>
     * </p>
     */
    //public static final String GROUP_SHOW=		"group.show";
    
    /**
     * Pop-up menu: name of group for source actions. This is an alias for
     * <code>GROUP_GENERATE</code> to be more consistent with main menu
     * bar structure.
     * 
     * @since 2.0
     */	
    //public static final String GROUP_SOURCE=	GROUP_GENERATE;
    
    /**
     * Pop-up menu: name of group for viewer setup actions (value <code>"group.viewerSetup"</code>).
     */	
    //public static final String GROUP_VIEWER_SETUP=	"group.viewerSetup";
    
    /**
     * Type hierarchy view part: pop-up menu target ID for type hierarchy viewer
     * (value <code>"org.eclipse.jdt.ui.TypeHierarchy.typehierarchy"</code>).
     * 
     * @since 2.0
     */
    //public static final String TARGET_ID_HIERARCHY_VIEW= JavaUI.ID_TYPE_HIERARCHY + ".typehierarchy";	
    
    /**
     * Type hierarchy view part: pop-up menu target ID for the meber viewer
     * (value <code>"org.eclipse.jdt.ui.TypeHierarchy.members"</code>).
     * 
     * @since 2.0
     */
    //public static final String TARGET_ID_MEMBERS_VIEW= JavaUI.ID_TYPE_HIERARCHY + ".members";	
    
    /**
     * Type hierarchy view part: Pop-up menu target ID for the subtype hierarchy viewer
     * (value <code>"org.eclipse.jdt.ui.TypeHierarchy.subtypes"</code>).
     * 
     * @since 2.0
     */
    //public static final String TARGET_ID_SUBTYPES_VIEW= JavaUI.ID_TYPE_HIERARCHY + ".subtypes";	
    
    /**
     * Type hierarchy view part: pop-up menu target ID for supertype hierarchy viewer
     * (value <code>"org.eclipse.jdt.ui.TypeHierarchy.supertypes"</code>).
     * 
     * @since 2.0
     */
    //public static final String TARGET_ID_SUPERTYPES_VIEW= JavaUI.ID_TYPE_HIERARCHY + ".supertypes";	
    
}
