/**
 * 
 */
package com.puls.gyan.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.BatchInfo;
import com.puls.gyan.model.SubjectInfo;
import com.puls.gyan.sub.SubService;

/**
 * @author Pulkit.Saxena
 *
 */
@Controller
public class SubjectController {

	BaseLoggger logger = BaseLogFactory.getLogger(SubjectController.class);

	@Autowired
	private SubService subService;

	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
	public String addSubject(SubjectInfo subInfo, Model model) {
		String respMsg = "Success : Subject Details added ";
		try {
			subService.addSub(subInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add subject details";
			logger.error("Exception while adding subject details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "addSubject";
	}

	@RequestMapping(value = "/getAllSubForTerm", method = RequestMethod.GET)
	public @ResponseBody List<SubjectInfo> getAllSubForTerm(@RequestParam String tenantId, @RequestParam String termCode, Model model) {

		List<SubjectInfo> subjectList = null;

		String respMsg = "No Subject Defined / Error to load subject Details : Please contact system admin ";
		try {
			subjectList = subService.findAllSub(tenantId, termCode);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not find subjects details";
			logger.error("Exception while fetching subject details", ex);
		}

		if (subjectList != null && !(subjectList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return subjectList;
	}

	
	@RequestMapping(value = "/addSubject", method = RequestMethod.GET)
	public String getBatchForm(SubjectInfo batchInfo, Model model) {
		return "addSubject";
	}
	
	@RequestMapping(value = "/viewAllSubject", method = RequestMethod.GET)
	public String viewAllSubject(SubjectInfo batchInfo, Model model) {
		return "viewAllSubject";
	}
	
	@RequestMapping(value = "/vwSubTermBatch", method = RequestMethod.GET)
	public String vwSubTermBatch(String subName,String subCode, String batchName ,String termCode,Long id, Model model) {
		SubjectInfo subInfo = new SubjectInfo();
		subInfo.setId(id);
		subInfo.setSubName(subName);
		subInfo.setSubCode(subCode);
		subInfo.setBatchName(batchName);
		subInfo.setTermCode(termCode);
		model.addAttribute("subInfo",subInfo);
		return "vwSubTermBatch";
	}
	
	
	@RequestMapping(value = "/updateSubFrTermBatch", method = RequestMethod.POST)
	public String updateSubFrTermBatch(SubjectInfo subInfo, Model model) {
		String respMsg = "Success : Subject Details updated ";
		try {
			subService.update(subInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not Update subject details";
			logger.error("Exception while Update subject details", ex);
		}
		model.addAttribute("subInfo",subInfo);
		model.addAttribute("msg", respMsg);

		return "vwSubTermBatch";
	}

	
}
