/**
 * Model class for Batch
 */
package com.puls.gyan.model;

import java.util.List;

/**
 * @author Pulkit.Saxena
 *
 */
public class UserInfo {

	private String firstName;
	
	
	private String middleName;
	
	
	private String lastName;
	
	
	private String rollNum;
	
	private String batchName;
	
	private List<String> roles;
	
	private String userId;
	
	private String password;
	
	private int userType;
	private String deactivate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getDeactivate() {
		return deactivate;
	}

	public void setDeactivate(String deactivate) {
		this.deactivate = deactivate;
	}
}
