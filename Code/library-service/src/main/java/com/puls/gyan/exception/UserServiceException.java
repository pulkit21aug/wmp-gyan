/**
 * Generic Exception class for Subject Flows
 */
package com.puls.gyan.exception;

/**
 * @author Pulkit.Saxena
 *
 */
public class UserServiceException extends Exception {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2408032156894402037L;

	/**
	 * 
	 */
	public UserServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public UserServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public UserServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UserServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public UserServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
