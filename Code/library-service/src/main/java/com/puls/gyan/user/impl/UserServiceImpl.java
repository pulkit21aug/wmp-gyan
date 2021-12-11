/**
 * 
 */
package com.puls.gyan.user.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.puls.gyan.common.RoleEnum;
import com.puls.gyan.common.UserTypeEnum;
import com.puls.gyan.dao.UserServiceDao;
import com.puls.gyan.dao.entity.EmployeeEntity;
import com.puls.gyan.dao.entity.RolesEntity;
import com.puls.gyan.dao.entity.StudentEntity;
import com.puls.gyan.dao.entity.UserRoleEntity;
import com.puls.gyan.exception.UserServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.RoleInfo;
import com.puls.gyan.model.UserInfo;
import com.puls.gyan.user.UserService;

/**
 * @author pulkit.saxena
 *
 */
public class UserServiceImpl implements UserService {

	BaseLoggger logger = BaseLogFactory.getLogger(UserServiceImpl.class);

	private UserServiceDao userServiceDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addEmp(UserInfo userInfo) throws UserServiceException {

		if (userInfo.getUserType() == UserTypeEnum.EMPLOYEE.ordinal()) {
			// employee add detail flow
			EmployeeEntity empEnt = new EmployeeEntity();
			empEnt.setFirstName(userInfo.getFirstName());
			empEnt.setLastName(userInfo.getLastName());
			empEnt.setMiddleName(userInfo.getMiddleName());
			empEnt.setUserId(userInfo.getUserId().toLowerCase());
			Calendar cal = Calendar.getInstance();
			empEnt.setCreatedDate(cal.getTime());

			List<UserRoleEntity> roleList = new ArrayList<UserRoleEntity>();

			for (String role : userInfo.getRoles()) {
				UserRoleEntity roleEnt = new UserRoleEntity();
				RoleEnum rl = RoleEnum.valueOf(role);
				roleEnt.setRoleId(rl.getValue());
				roleEnt.setUser(empEnt);
				roleList.add(roleEnt);
				
			}

			empEnt.setUserRole(roleList); 
			try {
				userServiceDao.addEmp(empEnt);

			} catch (Exception ex) {
				logger.error("Error adding user info", ex);
				throw new UserServiceException(ex.getMessage());
			}

		} else {
			// Student add detail flow
			StudentEntity stuEnt = new StudentEntity();
			stuEnt.setFirstName(userInfo.getFirstName());
			stuEnt.setLastName(userInfo.getLastName());
			stuEnt.setMiddleName(userInfo.getMiddleName());
			stuEnt.setUserId(userInfo.getUserId().toLowerCase());
			stuEnt.setBatchId(userInfo.getBatchName());
			Calendar cal = Calendar.getInstance();
			stuEnt.setCreatedDate(cal.getTime());

			List<UserRoleEntity> roleList = new ArrayList<UserRoleEntity>();

			for (String role : userInfo.getRoles()) {
				UserRoleEntity roleEnt = new UserRoleEntity();
				RoleEnum rl = RoleEnum.valueOf(role);
				roleEnt.setRoleId(rl.getValue());
				roleEnt.setUser(stuEnt);
				roleList.add(roleEnt);
			}

			stuEnt.setUserRole(roleList); 
			try {
				userServiceDao.addStudent(stuEnt);

			} catch (Exception ex) {
				logger.error("Error adding user info", ex);
				throw new UserServiceException(ex.getMessage());
			}

		}

	}

	public UserServiceDao getUserServiceDao() {
		return userServiceDao;
	}

	public void setUserServiceDao(UserServiceDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<RoleInfo> getAllRoles() throws UserServiceException {
		List<RoleInfo> roleList = new ArrayList<RoleInfo>();
		List<RolesEntity> entList = userServiceDao.getAllRoles();
		for (RolesEntity ent : entList) {
			RoleInfo roleInfo = new RoleInfo();
			roleInfo.setRoleId(ent.getId());
			roleInfo.setRoleName(ent.getRoleName());
			roleList.add(roleInfo);

		}

		return roleList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<UserInfo> getAllUser(UserTypeEnum userEnum, String batchId) throws UserServiceException {
		List<UserInfo> emps = new ArrayList<UserInfo>();
		try {
			if (userEnum == UserTypeEnum.EMPLOYEE) {
				List<EmployeeEntity> empEntList = userServiceDao.getAllEmp();
				for (EmployeeEntity ent : empEntList) {
					UserInfo user = new UserInfo();
					user.setFirstName(ent.getFirstName());
					user.setMiddleName(ent.getMiddleName());
					user.setLastName(ent.getLastName());
					user.setUserId(ent.getUserId());
					emps.add(user);

				}
			} else {
				List<StudentEntity> empEntList = userServiceDao.getAllStundent(batchId);
				for (StudentEntity ent : empEntList) {
					UserInfo user = new UserInfo();
					user.setFirstName(ent.getFirstName());
					user.setMiddleName(ent.getMiddleName());
					user.setLastName(ent.getLastName());
					user.setUserId(ent.getUserId());
					user.setBatchName(batchId);
					emps.add(user);
				}
			}

		} catch (Exception ex) {
			logger.error("Error finding user info", ex);
			throw new UserServiceException(ex.getMessage());
		}
		return emps;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void update(UserInfo userInfo) throws UserServiceException {
		if (userInfo.getUserType() == UserTypeEnum.EMPLOYEE.ordinal()) {
			EmployeeEntity empEnt = userServiceDao.findByUserId(userInfo.getUserId());
			empEnt.setFirstName(userInfo.getFirstName());
			empEnt.setMiddleName(userInfo.getMiddleName());
			empEnt.setLastName(userInfo.getLastName());

			if (userInfo.getDeactivate() != null && userInfo.getDeactivate().equalsIgnoreCase("yes")) {
				Calendar cal = Calendar.getInstance();
				empEnt.setExpiredDate(cal.getTime());
			}

			try {
				userServiceDao.updateEmp(empEnt);

			} catch (Exception ex) {
				logger.error("Error updating user info", ex);
				throw new UserServiceException(ex.getMessage());
			}
		} else {

			StudentEntity empEnt = userServiceDao.findStudentByUserId(userInfo.getUserId());
			empEnt.setFirstName(userInfo.getFirstName());
			empEnt.setMiddleName(userInfo.getMiddleName());
			empEnt.setLastName(userInfo.getLastName());

			if (userInfo.getDeactivate() != null && userInfo.getDeactivate().equalsIgnoreCase("yes")) {
				Calendar cal = Calendar.getInstance();
				empEnt.setExpiredDate(cal.getTime());
			}

			try {
				userServiceDao.updateStudent(empEnt);

			} catch (Exception ex) {
				logger.error("Error updating user info", ex);
				throw new UserServiceException(ex.getMessage());
			}

		}

	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public UserInfo getUserDetail(String userId) throws UserServiceException {
		UserInfo userInfo = new UserInfo();
		HashMap<Integer, String> roleMap = new HashMap<Integer, String>();
		List<String> roles = new ArrayList<String>();

		Integer userType = userServiceDao.isStudent(userId);
		
		List<RolesEntity> roleEntList = userServiceDao.getAllRoles();
		
		for (RolesEntity roleEnt : roleEntList) {
			roleMap.put((Integer)roleEnt.getId(), roleEnt.getRoleName());
		}

		if (userType == UserTypeEnum.EMPLOYEE.ordinal()) {
			EmployeeEntity empEnt = userServiceDao.findByUserId(userId);
			userInfo.setUserId(empEnt.getUserId());
			
			List<UserRoleEntity> roleEntity = empEnt.getUserRole();
			
			for (UserRoleEntity roleEnt : roleEntity) {
				roles.add(roleMap.get(roleEnt.getRoleId()));
			}
			
			userInfo.setRoles(roles);

		} else {
           

			StudentEntity empEnt = userServiceDao.findStudentByUserId(userId);
			userInfo.setUserId(empEnt.getUserId());
			
			List<UserRoleEntity> roleEntity = empEnt.getUserRole();
			
			for (UserRoleEntity roleEnt : roleEntity) {
				roles.add(roleMap.get(roleEnt.getRoleId()));
			}
			
			userInfo.setRoles(roles);

		
		}
		return userInfo;
	}

}
