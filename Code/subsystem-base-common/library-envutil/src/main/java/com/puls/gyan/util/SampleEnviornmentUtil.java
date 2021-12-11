/**
 *  Enviornment Utility sample usage
 */
package com.puls.gyan.util;


/**
 * @author pulkit1.s
 * 
 */
public class SampleEnviornmentUtil {

	public static void main(String[] args) {

		System.out.println("Puls Home is" + EnviornmentUtil.getEnvProperty("APP_HOME"));

	}

}
