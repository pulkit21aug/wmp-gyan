/**
 *  Log4j initialser : Listener
 */
package com.puls.gyan.log;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.puls.gyan.util.EnviornmentUtil;

/**
 * @author pulkit1.s
 * 
 */
public class LogInitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {

		String app_home = EnviornmentUtil.getEnvProperty(EnviornmentUtil.APP_HOME);

		if (app_home == null) {

			System.out.println("LogI_1400243897832 Env APP_HOME not defined: log4j initialisation will fail");

		} else {

			String log4jProps = app_home + File.separator + "etc" + File.separator + "log4j.properties";

			System.out.println("Loading lof4j configuration from :" +log4jProps);
			
			File log4j = new File(log4jProps);

			if (log4j.exists()) {
				PropertyConfigurator.configureAndWatch(log4jProps, 60000);
				System.out.println("log4j configured");
				
			} else {
				System.out
						.println("LogI_1400243909915 log4j configuration file not found : log4j initialisation will fail");
			}

		}

	}

}
