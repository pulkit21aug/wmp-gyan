package com.puls.gyan.dao;

import java.util.List;

import com.puls.gyan.dao.entity.EmployeeEntity;
import com.puls.gyan.dao.entity.RolesEntity;
import com.puls.gyan.dao.entity.StudentEntity;

/**
 * Manage subject for a term for a batch
 * 
 * @author Pulkit.Saxena
 *
 */
public interface UserServiceDao {

	/**
	 * Add employee information
	 * 
	 * @param subEntity
	 */
	public void addEmp(EmployeeEntity empEntity);

	/**
	 * Add student information
	 * 
	 * @param subEntity
	 */
	public void addStudent(StudentEntity stEntity);

	/**
	 * fetches all the defined roles in the system
	 * 
	 * @return
	 */
	public List<RolesEntity> getAllRoles();

	public List<EmployeeEntity> getAllEmp();

	public EmployeeEntity findByUserId(String userId);

	public void updateEmp(EmployeeEntity empEnt);

	public List<StudentEntity> getAllStundent(String batchId);

	public StudentEntity findStudentByUserId(String userId);

	public void updateStudent(StudentEntity empEnt);
	
	public Integer isStudent(String userId);
}
