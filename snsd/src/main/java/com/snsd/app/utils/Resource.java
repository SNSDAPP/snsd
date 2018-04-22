/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package com.snsd.app.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Resource class is a utility to provide the internationalization across the application.
 * 
 * @author adesh Reused from earlier project TSMC program
 */
public class Resource {

	private static ResourceBundle	resourceBundle	= null;

	static {
		initialize();
	}

	/**
	 * Initialize the resource bundle.
	 * 
	 * @throws java.lang.RuntimeException
	 */
	public static void initialize() throws RuntimeException {

		try {
			resourceBundle = ResourceBundle.getBundle("com.snsd.app.utils.config");
		} catch (MissingResourceException e) {
			throw new RuntimeException("no resource bundle found.");
		}
	}

	/**
	 * This method accept the key as parameter and returns the message for that message from
	 * properties file.
	 * 
	 * @param key
	 *            key of the property file.
	 * @return message.
	 */
	public static String getMessage(String key) {

		String message = "";

		try {
			if (resourceBundle != null) {
				message = new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (Exception e) {
			// message = "** BUNDLE KEY NOT FOUND **";
			e.printStackTrace();
		}

		return message;
	}
}
