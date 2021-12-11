package com.puls.gyan.tenant;

import java.util.List;

import com.puls.gyan.dao.entity.TermEntity;
import com.puls.gyan.exception.TenantServiceException;
import com.puls.gyan.model.BatchInfo;
import com.puls.gyan.model.TermInfo;

/**
 * Tenant Service is used to manage/onboard tenant in the system Tenant is the
 * Batch such as WMP18, WMP17
 * 
 * @author pulkit.saxena
 *
 */
public interface TenantService {

	/**
	 * Add batech details in the system
	 * 
	 * @param tenantId
	 * @param tenantDesc
	 * @throws TenantServiceException
	 */
	public void addTenant(String tenantId, String tenantDesc) throws TenantServiceException;

	/**
	 * Find all batches - Active
	 * 
	 * @return
	 * @throws TenantServiceException
	 */
	public List<BatchInfo> findAllBatches() throws TenantServiceException;

	
	/**
	 * Returns all batches - Active and Inactive ( Batched those are deleted )
	 * @return
	 * @throws TenantServiceException
	 */
	public List<BatchInfo> viewAllBatches() throws TenantServiceException;
	
	/**
	 * 
	 * Add term details for a batch(tenant)
	 * @param tenantId
	 * @param termCode
	 * @throws TenantServiceException
	 */
	public void addTerm(String tenantId, String termCode) throws TenantServiceException;
	
	

	/**
	 * Find all terms defined for a batch
	 * 
	 * @param tenantId
	 * @return
	 * @throws TenantServiceException
	 */
	public List<TermInfo> findAllTermsForBatch(String tenantId) throws TenantServiceException;

	/**
	 * Update batch details such as description or deactivate batch
	 * @param batchInfo
	 * @throws TenantServiceException 
	 */
	public void updateTenant(BatchInfo batchInfo) throws TenantServiceException;
}
