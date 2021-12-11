/**
 * 
 */
package com.puls.gyan.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puls.gyan.common.RoleEnum;
import com.puls.gyan.common.UserTypeEnum;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.BatchInfo;
import com.puls.gyan.model.RoleInfo;
import com.puls.gyan.model.SubjectInfo;
import com.puls.gyan.model.UserInfo;
import com.puls.gyan.user.UserService;

/**
 * @author Pulkit.Saxena
 *
 */
@Controller
public class UserController {

	BaseLoggger logger = BaseLogFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmp(UserInfo userInfo, Model model) {
		String respMsg = "Success : Employee Details added ";
		try {
			userInfo.setUserType(UserTypeEnum.EMPLOYEE.ordinal());
		    String role = RoleEnum.ROLE_ADMIN.name();
		    List<String> roleList = new ArrayList<String>();
		    roleList.add(role);
		    userInfo.setRoles(roleList);
			userService.addEmp(userInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add emp details";
			logger.error("Exception while adding emp details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "addEmp";
	}
	

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(UserInfo userInfo, Model model) {
		String respMsg = "Success : Student Details added ";
		try {
			userInfo.setUserType(UserTypeEnum.STUDENT.ordinal());
		    String role = RoleEnum.ROLE_STUDENT.name();
		    List<String> roleList = new ArrayList<String>();
		    roleList.add(role);
		    userInfo.setRoles(roleList);
			userService.addEmp(userInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not add student details";
			logger.error("Exception while adding student details", ex);
		}
		model.addAttribute("msg", respMsg);

		return "addStudent";
	}
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String getAddEmp(UserInfo userInfo, Model model) {
		return "addEmp";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String getAddStudent(UserInfo userInfo, Model model) {
		return "addStudent";
	}
	
	@RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
	public @ResponseBody List<UserInfo> getAllEmp(String batchId,Model model) {

		List<UserInfo> userList = null;

		String respMsg = "No User Defined / Error to load user Details : Please contact system admin ";
		try {
			userList = userService.getAllUser(UserTypeEnum.EMPLOYEE,batchId);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not find user details";
			logger.error("Exception while fetching user details", ex);
		}

		if (userList != null && !(userList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return userList;
	}
	
	
	@RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
	public @ResponseBody List<UserInfo> getAllStudent(@RequestParam String tenantId,Model model) {

		List<UserInfo> userList = null;

		String respMsg = "No User Defined / Error to load user Details : Please contact system admin ";
		try {
			userList = userService.getAllUser(UserTypeEnum.STUDENT,tenantId);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not find user details";
			logger.error("Exception while fetching user details", ex);
		}

		if (userList != null && !(userList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return userList;
	}
	
	@RequestMapping(value = "/viewAllEmp", method = RequestMethod.GET)
	public String viewAllEmp(Model model) {
		return "viewAllEmp";
	}
	
	@RequestMapping(value = "/viewAllStudent", method = RequestMethod.GET)
	public String viewAllStudent(Model model) {
		return "viewAllStudent";
	}
	
	@RequestMapping(value = "/viewEmp", method = RequestMethod.GET)
	public String viewEmp(String userId,String firstName,String middleName, String lastName,Model model) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setFirstName(firstName);
		userInfo.setMiddleName(middleName);
		userInfo.setLastName(lastName);
		model.addAttribute("userInfo",userInfo);
		return "viewEmp";
	}
	
	@RequestMapping(value = "/viewStudent", method = RequestMethod.GET)
	public String viewStudent(String batchName, String userId,String firstName,String middleName, String lastName,Model model) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setFirstName(firstName);
		userInfo.setMiddleName(middleName);
		userInfo.setLastName(lastName);
		userInfo.setBatchName(batchName);
		model.addAttribute("userInfo",userInfo);
		return "viewStudent";
	}
	
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(UserInfo userInfo, Model model) {
		String respMsg = "Success : User Details updated ";
		userInfo.setUserType(UserTypeEnum.EMPLOYEE.ordinal());
		try {
			userService.update(userInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not Update user details";
			logger.error("Exception while Update user details", ex);
		}
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("msg", respMsg);

		return "viewEmp";
	}

	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(UserInfo userInfo, Model model) {
		String respMsg = "Success : User Details updated ";
		userInfo.setUserType(UserTypeEnum.STUDENT.ordinal());
		try {
			userService.update(userInfo);
		} catch (Exception ex) {
			respMsg = "Failure : Could  not Update user details";
			logger.error("Exception while Update user details", ex);
		}
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("msg", respMsg);

		return "viewEmp";
	}
	
	/*@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
	public @ResponseBody List<RoleInfo> getActiveBatch(Model model) {

		List<RoleInfo> roleList = null;

		String respMsg = "No Roles Defined / Error to load Roles Details : Please contact system admin ";
		try {
			roleList = userService.getAllRoles();
		} catch (Exception ex) {
			respMsg = "Failure : Could  not get role details";
			logger.error("Exception while getting roles details", ex);
		}

		if (roleList != null && !(roleList.size() > 0)) {
			model.addAttribute("msg", respMsg);
		}

		return roleList;
	}*/
}
