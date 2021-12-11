/**
 * Rest - Authentication Entry point : custom response code
 */
package com.puls.gyan.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.puls.gyan.google.GoogleOauthHelperIfc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author pulkit1.s
 * 
 */
public class WebAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private GoogleOauthHelperIfc googleHelper;
	
    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException,
            ServletException {
        response.sendRedirect("/login");
    }

	public GoogleOauthHelperIfc getGoogleHelper() {
		return googleHelper;
	}

	public void setGoogleHelper(GoogleOauthHelperIfc googleHelper) {
		this.googleHelper = googleHelper;
	}

}
