/**
 * 
 */
package com.puls.gyan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.puls.gyan.dao.ConfigServiceDao;
import com.puls.gyan.dao.entity.ConfigEntity;
import com.puls.gyan.dao.entity.RegEntity;

/**
 * @author Pulkit.Saxena
 *
 */
@Repository
public class ConfigServiceDaoImpl implements ConfigServiceDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public ConfigEntity findByName(String propertyName) {
		TypedQuery<ConfigEntity> query = entityManager.createNamedQuery("ConfigEntity.findByName", ConfigEntity.class);
		query.setParameter("propertyName", propertyName);
		return query.getSingleResult();
	}

}
