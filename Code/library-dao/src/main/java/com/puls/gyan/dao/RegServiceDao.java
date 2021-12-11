package com.puls.gyan.dao;

import java.util.List;

import com.puls.gyan.dao.entity.RegEntity;
import com.puls.gyan.dao.entity.RegFormEntity;

/**
 * Manage subject for a term for a batch
 * 
 * @author Pulkit.Saxena
 *
 */
public interface RegServiceDao {

	public void addReg(RegEntity empEntity);

	public List<RegEntity> findByBatch(String tenantId);

	public RegEntity findById(Long id);

	public void updateReg(RegEntity empEnt);
	
	public RegEntity findByBatchTerm(String tenantId ,String termCode);

	public void addStudentRegForm(RegFormEntity regEnt);

	public List<RegFormEntity> getRegFormTransaction(String bankTransactionId);
	
	public RegFormEntity findRegForm(Long id);

	public RegFormEntity updateRegForm(RegFormEntity regEnt);
	
	public List<RegFormEntity> findByUserId(String userId);
	

}
