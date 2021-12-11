/**
 * Rest services authentication manager
 */
package com.puls.gyan.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.puls.gyan.exception.UserServiceException;
import com.puls.gyan.google.GoogleUserInfo;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.UserInfo;
import com.puls.gyan.user.UserService;

/**
 * @author pulkit saxena
 * 
 */
public class WebAuthenticationProvider implements AuthenticationProvider {

	BaseLoggger logger = BaseLogFactory.getLogger(WebAuthenticationProvider.class);

	private UserService userService;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		if (auth.getName() != null)

		{
			List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
			HashMap<String, GoogleUserInfo> customInfo = (HashMap<String, GoogleUserInfo>) auth.getDetails();

			try {
				UserInfo userInfo = userService.getUserDetail(auth.getName());
				for (String role : userInfo.getRoles()) {
					AUTHORITIES.add(new SimpleGrantedAuthority(role));
				}

			} catch (UserServiceException e) {
				logger.error("user details could not be fetched", e);
				throw new BadCredentialsException("Bad Credentials");
			}

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getName(),
					auth.getCredentials(), AUTHORITIES);
			token.setDetails(customInfo);

			return token;
		}

		throw new BadCredentialsException("Bad Credentials");
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
