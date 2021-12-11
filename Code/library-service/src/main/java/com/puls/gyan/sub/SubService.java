package com.puls.gyan.sub;

import java.util.List;


import com.puls.gyan.exception.SubServiceException;
import com.puls.gyan.model.SubjectInfo;


/**
 * Subject Service is used to manage subject in the system for a batch ; is the
 * Batch such as WMP18, WMP17
 * 
 * @author Pulkit.Saxena
 *
 */
/**
 * @author pulkit.saxena
 *
 */
public interface SubService {


	/**
	 * add subjects for a term
	 * @param subEntity
	 */
	public void addSub(SubjectInfo subInfo) throws SubServiceException;
	
	
	
	/**
	 * 
	 * Find all subjects for a term for a bacth
	 * @param tenantId
	 * @param termCode
	 * @return
	 */
	public List<SubjectInfo> findAllSub(String tenantId,String termCode) throws SubServiceException;



	/**
	 * Updates subject details
	 * @param subInfo
	 * @throws SubServiceException
	 */
	public void update(SubjectInfo subInfo) throws SubServiceException;



	
}
