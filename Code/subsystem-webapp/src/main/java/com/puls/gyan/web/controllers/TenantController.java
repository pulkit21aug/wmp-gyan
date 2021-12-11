/**
 * to manage batch : WMP18 etc
 */
package com.puls.gyan.web.controllers;

import java.util.ArrayList;
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
import com.puls.gyan.tenant.TenantService;
import com.puls.gyan.model.BatchInfo;
import com.puls.gyan.model.TermInfo;

/**
 * @author Pulkit.Saxena
 *
 */
@Controller
public class TenantController {

	@Autowired
	private TenantService tenantService;

	BaseLoggger logger = BaseLogFactory.getLogger(TenantController.class);

	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	public String addBatch(BatchInfo batchInfo, Model model) {
		String respMsg = "Success : Batch Details added ";
		try {
			tenantService.addTenant(batchInfo.getBatchName(), batchInfo.getBatchDesc());
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add batch details";
			logger.error("Exception while adding batch details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "addBatch";
	}
	
	@RequestMapping(value = "/updateBatch", method = RequestMethod.POST)
	public String updateBatch(BatchInfo batchInfo, Model model) {
		String respMsg = "Success : Batch Details added ";
		try {
			tenantService.updateTenant(batchInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not update batch details";
			logger.error("Exception while update batch details", ex);
		}
		model.addAttribute("batchInfo",batchInfo);
		model.addAttribute("msg", respMsg);

		return "updateBatch";
	}

	@RequestMapping(value = "/addBatch", method = RequestMethod.GET)
	public String getBatchForm(BatchInfo batchInfo, Model model) {
		return "addBatch";
	}

	@RequestMapping(value = "/getAllBatch", method = RequestMethod.GET)
	public @ResponseBody List<BatchInfo> getActiveBatch(Model model) {

		List<BatchInfo> batchList = null;

		String respMsg = "No Batch Defined / Error to load Batch Details : Please contact system admin ";
		try {
			batchList = tenantService.findAllBatches();
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add batch details";
			logger.error("Exception while adding batch details", ex);
		}

		if (batchList != null && !(batchList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return batchList;
	}

	
	@RequestMapping(value = "/viewAllBatch", method = RequestMethod.GET)
	public String viewAllBatch(Model model) {

		List<BatchInfo> batchList = null;

		String respMsg = "No Batch Defined / Error to load Batch Details : Please contact system admin ";
		try {
			batchList = tenantService.viewAllBatches();
			model.addAttribute("batchList", batchList);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not fetch batch details";
			logger.error("Exception while fetching batch details", ex);
		}

		if (batchList != null && !(batchList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return "viewAllBatch";
	}
	
	@RequestMapping(value = "/viewBatchById", method = RequestMethod.GET)
	public String viewBatchById(String batchName,String batchDesc, Model model) {
		BatchInfo batchInfo = new BatchInfo();
		batchInfo.setBatchName(batchName);
		batchInfo.setBatchDesc(batchDesc);
		model.addAttribute("batchInfo",batchInfo);
		return "viewBatchById";
	}

	
	
	@RequestMapping(value = "/addTerm", method = RequestMethod.POST)
	public String addTerm(TermInfo termInfo, Model model) {
		String respMsg = "Success : Term Details added ";
		try {
			tenantService.addTerm(termInfo.getBatchName(), termInfo.getTermCode());
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add term details";
			logger.error("Exception while adding term details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "addTerm";
	}
	
	
	@RequestMapping(value = "/getAllTerms", method = RequestMethod.GET)
	public @ResponseBody List<TermInfo> getAllTerms(@RequestParam String tenantId ,Model model) {

		List<TermInfo> termList = null;

		String respMsg = "No Term  Defined / Error to load Term Details : Please contact system admin ";
		try {
			termList = tenantService.findAllTermsForBatch(tenantId);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add batch details";
			logger.error("Exception while adding batch details", ex);
		}

		if (termList != null && !(termList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return termList;
	}

	@RequestMapping(value = "/addTerm", method = RequestMethod.GET)
	public String getAddTerm(BatchInfo batchInfo, Model model) {
		return "addTerm";
	}
	
	
	/**
	 * View Terms page
	 * @param batchInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewAllTerms", method = RequestMethod.GET)
	public String viewAllTerms(BatchInfo batchInfo, Model model) {
		return "viewAllTerms";
	}
}
