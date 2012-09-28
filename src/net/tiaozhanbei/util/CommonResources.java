package net.tiaozhanbei.util;

import java.util.ResourceBundle;

public class CommonResources {

	private static ResourceBundle userTypeRolesBundle;
	private static ResourceBundle controlPanelTreeBundle;
	private static ResourceBundle environmentBundle;
	private static ResourceBundle newsCatagoryBundle;
	private static ResourceBundle projectCatagoryBundle;

	static{

		userTypeRolesBundle=ResourceBundle.getBundle("UserTypeRoles");
		controlPanelTreeBundle=ResourceBundle.getBundle("ControlPanelTree");
		environmentBundle=ResourceBundle.getBundle("Environment");
		newsCatagoryBundle=ResourceBundle.getBundle("NewsCatagory");
		projectCatagoryBundle=ResourceBundle.getBundle("ProjectCatagory");
	}
	public static ResourceBundle getEnvironmentBundle() {
		return environmentBundle;
	}
	public static ResourceBundle getUserTypeRolesBundle() {
		return userTypeRolesBundle;
	}
	public static ResourceBundle getControlPanelTreeBundle() {
		return controlPanelTreeBundle;
	}
	public static ResourceBundle getNewsCatagoryBundle() {
		return newsCatagoryBundle;
	}
	public static ResourceBundle getProjectCatagoryBundle() {
		return projectCatagoryBundle;
	}
}
