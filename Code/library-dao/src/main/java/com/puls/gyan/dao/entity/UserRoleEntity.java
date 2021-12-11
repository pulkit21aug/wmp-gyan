/**
 * Tenant Entity ( Batch such as WMP18 )
 */
package com.puls.gyan.dao.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Pulkit.Saxena
 *
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7625872194614389022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLEID")
	private int roleId;
	
	@ManyToOne
	@JoinColumn(name = "USERID", referencedColumnName="USERID",nullable = false)
	private UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
