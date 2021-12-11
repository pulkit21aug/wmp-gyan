/**
 * Main Logger : extends log4j logger
 */
package com.puls.gyan.log;

/**
 * @author pulkit1.s
 * 
 */
import org.apache.log4j.Logger;

public class BaseLoggger {

	private Logger	logger;

	public BaseLoggger(Class clazz) {
		logger = Logger.getLogger(clazz);

	}

	public void info(String msg) {
		String logTagId = LogContextHolder.getLogContext();
		logger.info(logTagId);
		logger.info(msg);

	}

	public void debug(String msg) {
		if (logger.isDebugEnabled()) {
			String logTagId = LogContextHolder.getLogContext();
			logger.debug(logTagId);
			logger.debug(msg);
		}

	}

	public void error(String msg) {
		String logTagId = LogContextHolder.getLogContext();
		logger.error(logTagId);
		logger.error(msg);

	}

	public void info(String classLogTagId, String msg) {
		String logTagId = LogContextHolder.getLogContext();
		logger.info(logTagId);
		logger.info(classLogTagId + "-" + msg);
	}

	public void debug(String classLogTagId, String msg) {
		if (logger.isDebugEnabled()) {
			String logTagId = LogContextHolder.getLogContext();
			logger.debug(logTagId);
			logger.debug(classLogTagId + "-" + msg);
		}

	}

	public void error(String classLogTagId, String msg) {
		String logTagId = LogContextHolder.getLogContext();
		logger.error(logTagId);
		logger.error(classLogTagId + "-" + msg);

	}
	
	public void error(String msg,Object obj) {
		String logTagId = LogContextHolder.getLogContext();
		logger.error(logTagId);
		logger.error(msg);
		logger.error(obj);

	}
	
	public void error(String classLogTagId ,String msg,Object obj) {
		String logTagId = LogContextHolder.getLogContext();
		logger.error(logTagId);
		logger.error(classLogTagId + "-" + msg);
		logger.error(obj);

	}

}
