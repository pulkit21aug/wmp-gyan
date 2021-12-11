/**
 * 
 */
package com.puls.gyan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puls.gyan.dao.TenantServiceDao;
import com.puls.gyan.dao.entity.TenantEntity;
import com.puls.gyan.dao.entity.TermEntity;

/**
 * @author Pulkit.Saxena
 *
 */
@Repository
public class TenantServiceDaoImpl implements TenantServiceDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.puls.gyan.dao.TenantServiceDao#addTenant(com.puls.gyan.dao.entity
	 * .TenantEntity)
	 */
	@Override
	public void addTenant(TenantEntity tntEntity) {
		entityManager.persist(tntEntity);
		entityManager.flush();
	}
	
	public void updateTenant(TenantEntity tntEntity) {
		entityManager.merge(tntEntity);
		entityManager.flush();
	}

	public List<TenantEntity> findAllBatches() {

		TypedQuery<TenantEntity> query = entityManager.createNamedQuery("TenantEntity.findAllActive", TenantEntity.class);
		List<TenantEntity> results = query.getResultList();
		return results;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addTerm(TermEntity trmEntity) {
		entityManager.persist(trmEntity);
		entityManager.flush();
		
	}

	@Override
	public List<TermEntity> findAllTermsForBatch(String tenantId) {
		TypedQuery<TermEntity> query = entityManager.createNamedQuery("TermEntity.findAllByBatchId", TermEntity.class);
		query.setParameter("tenantId", tenantId);
		List<TermEntity> results = query.getResultList();
		return results;
	}

	@Override
	public List<TenantEntity> viewAllBatches() {
		TypedQuery<TenantEntity> query = entityManager.createNamedQuery("TenantEntity.viewAll", TenantEntity.class);
		List<TenantEntity> results = query.getResultList();
		return results;
	}

	@Override
	public TenantEntity findByBatchId(String batchName) {
		TypedQuery<TenantEntity> query = entityManager.createNamedQuery("TenantEntity.findByBatchId", TenantEntity.class);
		query.setParameter("tenantId", batchName);
		return query.getSingleResult();
	}

}
