package com.puls.gyan.google;

import java.io.IOException;

public interface GoogleOauthHelperIfc {

	/**
	 * Builds a login URL based on client ID, secret, callback URI, and scope
	 */
	public  String buildLoginUrl(String callBackUrl);

	/**
	 * Expects an Authentication Code, and makes an authenticated request for
	 * the user's profile information
	 * 
	 * @return JSON formatted user profile information
	 * @param authCode
	 *            authentication code provided by google
	 */
	public  GoogleUserInfo getUserInfoJson(String authCode) throws IOException;

}