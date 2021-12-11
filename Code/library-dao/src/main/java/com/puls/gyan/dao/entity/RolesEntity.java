/**
 * Tenant Entity ( Batch such as WMP18 )
 */
package com.puls.gyan.dao.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Pulkit.Saxena
 *
 */
@Entity
@Table(name = "ROLES")
@NamedQueries({ @NamedQuery(name = "RolesEntity.getAllRoles", query = "SELECT c FROM RolesEntity c")

})
public class RolesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2021329462934922803L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "ROLENAME")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
