/**
 * 
 */
package com.puls.gyan.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puls.gyan.config.ConfigService;
import com.puls.gyan.exception.ConfigServiceException;
import com.puls.gyan.google.GoogleOauthHelper;
import com.puls.gyan.google.GoogleOauthHelperIfc;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.GenericInfo;
import com.puls.gyan.reg.RegService;

/**
 * @author Pulkit.Saxena
 *
 */
@Controller
public class LoginController {

	BaseLoggger logger = BaseLogFactory.getLogger(LoginController.class);
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value = "/getGoogleUrl", method = RequestMethod.GET)
	public @ResponseBody GenericInfo getHello(Model model) {

		GenericInfo info = new GenericInfo();
		try {
			GoogleOauthHelperIfc googleHelper = new GoogleOauthHelper();
			info = new GenericInfo();
			String callBackUrl = configService.findByName("CALLBACK_URI");
			info.setGoogleUrl(googleHelper.buildLoginUrl(callBackUrl));
		} catch (ConfigServiceException ex) {
			logger.error("Exception while getting  google info details", ex);
			
		}

		return info;
	}

	/**
	 * After user gets redirected from google on this page
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String redirectHome(Model model) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String redirectLogin(Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String redirectLogout(Model model) {
		SecurityContextHolder.getContext().setAuthentication(null);
		String respMsg = "Thank you for visiting ";
		model.addAttribute("msg", respMsg);
		return "login";
	}

}
