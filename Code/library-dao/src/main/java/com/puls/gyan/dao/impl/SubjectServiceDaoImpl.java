package com.puls.gyan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puls.gyan.dao.SubjectServiceDao;
import com.puls.gyan.dao.entity.SubjectEntity;


@Repository
public class SubjectServiceDaoImpl implements SubjectServiceDao {

	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public SubjectServiceDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addSub(SubjectEntity subEntity) {
		entityManager.persist(subEntity);
		entityManager.flush();

	}

	@Override
	public List<SubjectEntity> findAllSub(String tenantId,String termCode) {
		TypedQuery<SubjectEntity> query = entityManager.createNamedQuery("SubjectEntity.findAllSubjectByTermBatch", SubjectEntity.class);
		query.setParameter("tenantId", tenantId);
		query.setParameter("termCode", termCode);		
		List<SubjectEntity> results = query.getResultList();
		return results;
	}

	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public SubjectEntity findSubById(Long id) {
		TypedQuery<SubjectEntity> query = entityManager.createNamedQuery("SubjectEntity.findSubById", SubjectEntity.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void updateSub(SubjectEntity subEnt) {
		entityManager.merge(subEnt);
		entityManager.flush();
		
	}
}
