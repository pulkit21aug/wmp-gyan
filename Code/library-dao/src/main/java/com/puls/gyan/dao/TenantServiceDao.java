package com.puls.gyan.dao;

import java.util.List;

import com.puls.gyan.dao.entity.TenantEntity;
import com.puls.gyan.dao.entity.TermEntity;


/**
 * Tenant Service is used to manage/onboard tenant in the system
 *  Tenant is the Batch such as WMP18, WMP17
 * 
 * @author Pulkit.Saxena
 *
 */
public interface TenantServiceDao {

	/**
	 * Persist the batch information
	 * @param tntEntity
	 */
	public void addTenant(TenantEntity tntEntity) ;
	
	public void updateTenant(TenantEntity tntEntity) ;
	
	public List<TenantEntity> findAllBatches();
	
	public void addTerm(TermEntity trmEntity) ;
	
	public List<TermEntity> findAllTermsForBatch(String tenantId ) ;

	public List<TenantEntity> viewAllBatches();
	
	public TenantEntity findByBatchId(String batchName);
	
}
