/**
 * Generic Exception class for Registration Flows
 */
package com.puls.gyan.exception;

/**
 * @author Pulkit.Saxena
 *
 */
public class ConfigServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8052429063980233610L;

	/**
	 * 
	 */
	public ConfigServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ConfigServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ConfigServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ConfigServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ConfigServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
