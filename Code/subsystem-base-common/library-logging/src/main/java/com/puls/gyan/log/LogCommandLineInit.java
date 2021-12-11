
package com.puls.gyan.log;

import java.io.File;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.PropertyConfigurator;
import com.puls.gyan.util.EnviornmentUtil;


/**
 * Java class to initialize the logs for commmand line application
 * 
 */
public class LogCommandLineInit{

	/**
     * Initialize log4j when the application is being started
     */
     public static void logInitialize(){
        // initialize log4j here
    	String sam_home = EnviornmentUtil.getEnvProperty(EnviornmentUtil.APP_HOME);
    	if (sam_home == null) {

			System.out.println("LogI_1400243897832 Env K_HOME not defined: log4j initialisation will fail");

		} else {

			String log4jPropsPath = sam_home + File.separator + "etc" + File.separator + "log4j.properties";

			System.out.println("Loading lof4j configuration from :" +log4jPropsPath);
			
			File log4j = new File(log4jPropsPath);

			if (log4j.exists()) {
		        PropertyConfigurator.configure(log4jPropsPath);
				System.out.println("log4j configured");
				
			} else {
				System.out
						.println("LogI_1400243909915 log4j configuration file not found : log4j initialisation will fail");
			}

		}
         
    }
     

}
