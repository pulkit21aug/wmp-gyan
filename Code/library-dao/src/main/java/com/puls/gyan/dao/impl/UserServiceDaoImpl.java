/**
 * 
 */
package com.puls.gyan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;



import com.puls.gyan.dao.UserServiceDao;
import com.puls.gyan.dao.entity.EmployeeEntity;
import com.puls.gyan.dao.entity.RolesEntity;
import com.puls.gyan.dao.entity.StudentEntity;

/**
 * @author Pulkit.Saxena
 *
 */
@Repository
public class UserServiceDaoImpl implements UserServiceDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * 
	 */
	public UserServiceDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.puls.gyan.dao.UserServiceDao#addEmp(com.puls.gyan.dao.entity.
	 * EmployeeEntity)
	 */
	@Override
	public void addEmp(EmployeeEntity empEntity) {
		entityManager.persist(empEntity);
		entityManager.flush();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.puls.gyan.dao.UserServiceDao#addStudent(com.puls.gyan.dao.entity.
	 * StudentEntity)
	 */
	@Override
	public void addStudent(StudentEntity stEntity) {
		entityManager.persist(stEntity);
		entityManager.flush();

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<RolesEntity> getAllRoles() {
		TypedQuery<RolesEntity> query = entityManager.createNamedQuery("RolesEntity.getAllRoles", RolesEntity.class);
		List<RolesEntity> results = query.getResultList();
		return results;
	}

	@Override
	public List<EmployeeEntity> getAllEmp() {
		TypedQuery<EmployeeEntity> query = entityManager.createNamedQuery("EmployeeEntity.getAllEmp",
				EmployeeEntity.class);
		return query.getResultList();
	}

	@Override
	public EmployeeEntity findByUserId(String userId) {
		TypedQuery<EmployeeEntity> query = entityManager.createNamedQuery("EmployeeEntity.findByUserId",
				EmployeeEntity.class);
		query.setParameter("userId", userId);
		return query.getSingleResult();
	}

	@Override
	public void updateEmp(EmployeeEntity empEnt) {
		entityManager.merge(empEnt);
		entityManager.flush();

	}

	@Override
	public List<StudentEntity> getAllStundent(String batchId) {
		TypedQuery<StudentEntity> query = entityManager.createNamedQuery("StudentEntity.getAllStudent",
				StudentEntity.class);
		query.setParameter("batchId", batchId);
		return query.getResultList();
	}

	@Override
	public StudentEntity findStudentByUserId(String userId) {
		TypedQuery<StudentEntity> query = entityManager.createNamedQuery("StudentEntity.findStudentByUserId",
				StudentEntity.class);
		query.setParameter("userId", userId);
		return query.getSingleResult();
	}

	@Override
	public void updateStudent(StudentEntity empEnt) {
		entityManager.merge(empEnt);
		entityManager.flush();

	}

	@Override
	public Integer isStudent(String userId) {
		Query q = entityManager.createNativeQuery("SELECT a.user_type FROM users a WHERE a.userid = ?");
		q.setParameter(1, userId);
		Integer userType = (Integer) q.getSingleResult();
		return userType;
	}

}
