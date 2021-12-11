package com.puls.gyan.reg;

import java.util.List;

import com.puls.gyan.exception.RegServiceException;
import com.puls.gyan.model.RegInfo;

public interface RegService {

	
	public void openReg(RegInfo regInfo) throws RegServiceException;
	
	public void updateReg(RegInfo regInfo) throws RegServiceException;
	
	public List<RegInfo>  findByBatch (String batchName) throws RegServiceException;
	
	public RegInfo  findByBatchTerm(String tenantId ,String termCode) throws RegServiceException;

	public void smtRegForm(RegInfo regInfo)  throws RegServiceException;
	
	public List<RegInfo>  getRegFormTransaction(String bankTransactionId) throws RegServiceException;
	
	public RegInfo approveReg(RegInfo regInfo) throws RegServiceException;
	
	public RegInfo getRegFormById(Long id) throws RegServiceException;
	
	public List<RegInfo>  getRegFormUser(String userId) throws RegServiceException;
	
}
