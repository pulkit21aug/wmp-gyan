package com.puls.gyan.user;

import java.util.List;

import com.puls.gyan.common.UserTypeEnum;
import com.puls.gyan.exception.UserServiceException;
import com.puls.gyan.model.RoleInfo;
import com.puls.gyan.model.UserInfo;

/**
 * Subject Service is used to manage subject in the system for a batch ; is the
 * Batch such as WMP18, WMP17
 * 
 * @author Pulkit.Saxena
 *
 */
/**
 * @author pulkit.saxena
 *
 */
public interface UserService {

	/**
	 * Adds user details in the system - emp 
	 * @param userInfo
	 * @throws UserServiceException
	 */
	public void addEmp(UserInfo userInfo) throws UserServiceException;
	
	/**
	 *  get all the roles defined in the system
	 * @return
	 * @throws UserServiceException
	 */
	public List<RoleInfo> getAllRoles() throws UserServiceException;
	
	
	/**
	 * gets all employees
	 * @param userEnum 
	 * @return 
	 * @throws UserServiceException
	 */
	public List<UserInfo> getAllUser(UserTypeEnum userEnum,String batchId) throws UserServiceException;

	/**
	 * update emp details
	 * @param userInfo
	 * @throws UserServiceException
	 */
	public void update(UserInfo userInfo) throws UserServiceException;
	
	public UserInfo  getUserDetail(String userId) throws UserServiceException;

	
}
