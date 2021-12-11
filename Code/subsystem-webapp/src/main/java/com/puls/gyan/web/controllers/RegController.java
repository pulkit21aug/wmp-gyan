/**
 * 
 */
package com.puls.gyan.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puls.gyan.exception.RegServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.RegInfo;
import com.puls.gyan.reg.RegService;

/**
 * @author Pulkit.Saxena
 *
 */
@Controller
public class RegController {

	BaseLoggger logger = BaseLogFactory.getLogger(RegController.class);

	@Autowired
	private RegService regService;

	@RequestMapping(value = "/openReg", method = RequestMethod.POST)
	public String openReg(RegInfo regInfo, Model model) {
		String respMsg = "Success : Registration Details added ";
		try {
			// first check whether there exists the registration or not
			regService.openReg(regInfo);

		} catch (Exception ex) {
			respMsg = "Failure : Could  not add registration details";
			logger.error("Exception while adding registration details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "openReg";
	}

	@RequestMapping(value = "/openReg", method = RequestMethod.GET)
	public String getRegForm(RegInfo regInfo, Model model) {
		return "openReg";
	}

	@RequestMapping(value = "/viewAllReg", method = RequestMethod.GET)
	public @ResponseBody List<RegInfo> viewAllReg(@RequestParam String tenantId, Model model) {
		List<RegInfo> regList = null;

		String respMsg = "No User Defined / Error to load user Details : Please contact system admin ";
		try {
			regList = regService.findByBatch(tenantId);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not find user details";
			logger.error("Exception while fetching user details", ex);
		}

		if (regList != null && !(regList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return regList;

	}

	@RequestMapping(value = "/viewReg", method = RequestMethod.GET)
	public String getAllRegistrations(Model model) {
		return "viewAllReg";
	}

	@RequestMapping(value = "/srhRegInfo", method = RequestMethod.GET)
	public String srhRegInfo(Model model) {
		return "srhRegInfo";
	}

	@RequestMapping(value = "/viewRegDetail", method = RequestMethod.GET)
	public String viewRegDetail(String batchName, String termCode, Long id, String status, Model model) {
		RegInfo regInfo = new RegInfo();
		regInfo.setBatchName(batchName);
		regInfo.setId(id);
		regInfo.setStatus(status);
		regInfo.setTermCode(termCode);
		model.addAttribute("regInfo", regInfo);

		return "viewRegDetail";
	}

	@RequestMapping(value = "/viewStudentRegFormDetail", method = RequestMethod.GET)
	public String viewStudentRegFormDetail(String batchName, String termCode, Long id, String status, Model model) {
		RegInfo regInfo = new RegInfo();
		regInfo.setBatchName(batchName);
		regInfo.setId(id);
		regInfo.setStatus(status);
		regInfo.setTermCode(termCode);
		model.addAttribute("regInfo", regInfo);

		return "viewStudentRegFormDetail";
	}

	@RequestMapping(value = "/updateReg", method = RequestMethod.POST)
	public String updateReg(RegInfo regInfo, Model model) {
		String respMsg = "Success : Registration Details updated ";

		try {
			regService.updateReg(regInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not Update Registration details";
			logger.error("Exception while Update Registration details", ex);
		}
		model.addAttribute("regInfo", regInfo);
		model.addAttribute("msg", respMsg);

		return "viewRegDetail";
	}

	@RequestMapping(value = "/viewRegForm", method = RequestMethod.GET)
	public String viewRegForm(Model model) {
		return "viewRegForm";
	}

	@RequestMapping(value = "/smtRegForm", method = RequestMethod.POST)
	public String smtRegForm(RegInfo regInfo, Model model) {
		String respMsg = "Success : Registration Details updated ";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		regInfo.setUserId(authentication.getName());

		try {
			regService.smtRegForm(regInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not Update Registration details/or you have previously submitted";
			logger.error("Exception while Update Registration details", ex);
		}
		model.addAttribute("regInfo", regInfo);
		model.addAttribute("msg", respMsg);

		return "viewRegDetail";
	}

	@RequestMapping(value = "/viewRegFormDetail", method = RequestMethod.GET)
	public @ResponseBody List<RegInfo> viewRegFormDetail(@RequestParam String tenantId, @RequestParam String termCode,
			Model model) {
		List<RegInfo> regInfoList = new ArrayList<RegInfo>();

		String respMsg = "No User Defined / Error to load user Details : Please contact system admin ";
		try {
			RegInfo regInfo = regService.findByBatchTerm(tenantId, termCode);
			regInfoList.add(regInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not find user details";
			logger.error("Exception while fetching user details", ex);
		}

		if (regInfoList != null && regInfoList.size() > 0) {
			model.addAttribute("msg", respMsg);
		}

		return regInfoList;

	}

	@RequestMapping(value = "/viewRegFormInfo", method = RequestMethod.GET)
	public String viewRegFormInfo(Model model) {
		return "viewRegFormInfo";
	}

	@RequestMapping(value = "/getRegFormTransaction", method = RequestMethod.GET)
	public String getRegFormTransaction(@RequestParam String bankTransactionId, Model model) {
		List<RegInfo> regInfoList = null;

		String respMsg = "No registration Defined / Error to load registration Details : Please contact system admin ";
		try {
			regInfoList = regService.getRegFormTransaction(bankTransactionId);
			model.addAttribute("regInfoList", regInfoList);

		} catch (Exception ex) {
			respMsg = "Failure : Could  not find registration details";
			logger.error("Exception while fetching registration details", ex);
		}

		if (regInfoList == null) {
			model.addAttribute("msg", respMsg);
		}

		return "srhRegInfo";

	}

	@RequestMapping(value = "/approveReg", method = RequestMethod.POST)
	public String approveReg(Long id, Model model) {
		String respMsg = "Success : Registration Details approved ";
		RegInfo regInfo = new RegInfo();
		regInfo.setId(id);
		try {
			regInfo = regService.approveReg(regInfo);
			model.addAttribute("regInfo", regInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not approve Registration details";
			logger.error("Exception while approve Registration details", ex);
		}
		model.addAttribute("regInfo", regInfo);
		model.addAttribute("msg", respMsg);

		return "approveReg";
	}

	@RequestMapping(value = "/approveReg", method = RequestMethod.GET)
	public String getApproveReg(Long id, Model model) {

		String respMsg = "Success : Registration Details found ";
		try {
			RegInfo regInfo = regService.getRegFormById(id);
			model.addAttribute("regInfo", regInfo);
		} catch (RegServiceException ex) {
			respMsg = "Failure : Could  not find Registration details";
			logger.error("Exception while find Registration details", ex);
			model.addAttribute("msg", respMsg);
		}
		
		return "approveReg";
	}
	
	
	@RequestMapping(value = "/srhRegOfUser", method = RequestMethod.GET)
	public String srhRegOfUser(Model model) {
		return "srhRegOfUser";
	}
	
	@RequestMapping(value = "/getRegFormUser", method = RequestMethod.GET)
	public String getRegFormUser(@RequestParam String userId, Model model) {
		List<RegInfo> regInfoList = null;

		String respMsg = "No registration Defined / Error to load registration Details : Please contact system admin ";
		try {
			regInfoList = regService.getRegFormUser(userId);
			model.addAttribute("regInfoList", regInfoList);

		} catch (Exception ex) {
			respMsg = "Failure : Could  not find registration details";
			logger.error("Exception while fetching registration details", ex);
		}

		if (regInfoList == null) {
			model.addAttribute("msg", respMsg);
		}

		return "srhRegOfUser";

	}
}
