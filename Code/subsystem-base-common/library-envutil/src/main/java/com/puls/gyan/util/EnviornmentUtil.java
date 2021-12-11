/**
 *  Enviornment Utility class : to load system properties
 */
package com.puls.gyan.util;

import java.util.Map;

/**
 * @author pulkit1.s
 * 
 */
public class EnviornmentUtil {

	public static final String APP_HOME = "APP_HOME";

	public static String getEnvProperty(String key) {

		String sam_home = null;

		Map<String, String> envMap = System.getenv();

		sam_home = envMap.get(key);

		return sam_home;

	}
}
