package com.puls.gyan.dao;

import java.util.List;

import com.puls.gyan.dao.entity.SubjectEntity;




/**
 *  Manage subject for a term for a batch
 * 
 * @author Pulkit.Saxena
 *
 */
public interface SubjectServiceDao {


	/**
	 * Add subject information for a term for a batch
	 * @param subEntity
	 */
	public void addSub(SubjectEntity subEntity) ;
	
	
	/**
	 * 
	 * find all subjects for batch(tenant) and for a term
	 * @param tenantId
	 * @param termCode
	 * @return
	 */
	public List<SubjectEntity> findAllSub(String tenantId,String termCode);


	/**
	 * 
	 * Find subject details with id
	 * @param id
	 * @return
	 */
	public SubjectEntity findSubById(Long id);


	/**
	 * Used to update subject entity 
	 * @param subEnt
	 */
	public void updateSub(SubjectEntity subEnt);
	
	
	
}
