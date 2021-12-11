package com.puls.gyan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puls.gyan.dao.RegServiceDao;
import com.puls.gyan.dao.entity.RegEntity;
import com.puls.gyan.dao.entity.RegFormEntity;


@Repository
public class RegServiceDaoImpl implements RegServiceDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addReg(RegEntity empEntity) {
		entityManager.persist(empEntity);
		entityManager.flush();
        
	}

	@Override
	public List<RegEntity> findByBatch(String tenantId) {
		TypedQuery<RegEntity> query = entityManager.createNamedQuery("RegEntity.findByBatch", RegEntity.class);
		query.setParameter("tenantId", tenantId);
		List<RegEntity> results = query.getResultList();
		return results;
	}

	@Override
	public void updateReg(RegEntity empEnt) {
		entityManager.merge(empEnt);
		entityManager.flush();

	}
	
	public RegFormEntity updateRegForm(RegFormEntity empEnt) {
		RegFormEntity ent = 	entityManager.merge(empEnt);
		entityManager.flush();
		return ent;

	}

	@Override
	public RegEntity findById(Long id) {
		TypedQuery<RegEntity> query = entityManager.createNamedQuery("RegEntity.findById", RegEntity.class);
		query.setParameter("id", id);
		RegEntity results = query.getSingleResult();
		return results;
	}

	@Override
	public RegEntity findByBatchTerm(String tenantId, String termCode) {
		TypedQuery<RegEntity> query = entityManager.createNamedQuery("RegEntity.findByBatchTerm", RegEntity.class);
		query.setParameter("tenantId", tenantId);
		query.setParameter("termCode", termCode);
		RegEntity results = query.getSingleResult();
		return results;
	}

	@Override
	public void addStudentRegForm(RegFormEntity regEnt) {
		entityManager.persist(regEnt);
		entityManager.flush();
		
	}

	@Override
	public List<RegFormEntity> getRegFormTransaction(String bankTransactionId) {
		TypedQuery<RegFormEntity> query = entityManager.createNamedQuery("RegFormEntity.findByBanktransactionId", RegFormEntity.class);
		query.setParameter("bankTransactionId", bankTransactionId);
		List<RegFormEntity> results = query.getResultList();
		return results;
	}

	@Override
	public RegFormEntity findRegForm(Long id) {
		TypedQuery<RegFormEntity> query = entityManager.createNamedQuery("RegFormEntity.findById", RegFormEntity.class);
		query.setParameter("id", id);
		RegFormEntity results = query.getSingleResult();
		return results;
	}

	@Override
	public List<RegFormEntity> findByUserId(String userId) {
		TypedQuery<RegFormEntity> query = entityManager.createNamedQuery("RegFormEntity.findByUserId", RegFormEntity.class);
		query.setParameter("userId", userId);
		List<RegFormEntity> results = query.getResultList();
		return results;
	}

}
