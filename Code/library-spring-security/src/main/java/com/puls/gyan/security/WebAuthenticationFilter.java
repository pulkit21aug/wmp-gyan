/**
 * 
 */
package com.puls.gyan.security;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.puls.gyan.common.Constants;
import com.puls.gyan.google.GoogleOauthHelperIfc;
import com.puls.gyan.google.GoogleUserInfo;

/**
 * @author pulkit1.s
 * 
 */
public class WebAuthenticationFilter extends GenericFilterBean {

	private AuthenticationEntryPoint authenticationEntryPoint;
	private AuthenticationManager authenticationManager;
	private GoogleOauthHelperIfc googleHelper;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String googleCode = request.getParameter("code");

		if(authentication!=null && authentication.isAuthenticated()) {
			chain.doFilter(request, response);
			return;
		}
		
		if (authentication == null) {
			if (googleCode == null) {
				chain.doFilter(request, response);
				return;
			}
		}

		// user returning from google

		try {
			GoogleUserInfo userInfo = googleHelper.getUserInfoJson(googleCode);
			if (userInfo.getVerified_email()) {
				String[] userId = userInfo.getEmail().split("@");
				UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userId[0].toLowerCase(),
						null);
				HashMap<String, GoogleUserInfo> customInfo = new HashMap<String, GoogleUserInfo>();
				customInfo.put(Constants.GOOGLE_USER_INFO, userInfo);
				authRequest.setDetails(customInfo);

				Authentication authResult = authenticationManager.authenticate(authRequest);
				SecurityContextHolder.getContext().setAuthentication(authResult);

			} else {
				chain.doFilter(request, response);
				return;
			}

		} catch (AuthenticationException failed) {
			SecurityContextHolder.clearContext();
			authenticationEntryPoint.commence(request, response, failed);
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		chain.doFilter(request, response);
		return;
	}

	public void afterPropertiesSet() {
		Assert.notNull(this.authenticationManager, "An AuthenticationManager is required");
		Assert.notNull(this.authenticationEntryPoint, "An AuthenticationEntryPoint is required");

	}

	public AuthenticationEntryPoint getAuthenticationEntryPoint() {
		return authenticationEntryPoint;
	}

	public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public GoogleOauthHelperIfc getGoogleHelper() {
		return googleHelper;
	}

	public void setGoogleHelper(GoogleOauthHelperIfc googleHelper) {
		this.googleHelper = googleHelper;
	}

}
