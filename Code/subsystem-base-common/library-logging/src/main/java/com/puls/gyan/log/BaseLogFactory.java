/**
 * 
 */
package com.puls.gyan.log;


import java.util.HashMap;
/**
 * @author pulkit1.s
 * 
 */
@SuppressWarnings("PMD.VariableNamingConventions")
public class BaseLogFactory {

	public static final HashMap<String, BaseLoggger> INSTANCE_MAP = new HashMap<String, BaseLoggger>();

	public static BaseLoggger getLogger(Class clazz) {

		BaseLoggger instance = INSTANCE_MAP.get(clazz.getName());

		if (instance == null) {
			instance = new BaseLoggger(clazz);
			INSTANCE_MAP.put(clazz.getName(), instance);
		}

		return INSTANCE_MAP.get(clazz.getName());
	}
}
