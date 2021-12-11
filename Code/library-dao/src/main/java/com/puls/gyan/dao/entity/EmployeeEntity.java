/**
 * 
 */
package com.puls.gyan.dao.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Pulkit.Saxena
 *
 */
@Entity
@DiscriminatorValue(value = "0")
@NamedQueries({ @NamedQuery(name = "EmployeeEntity.getAllEmp", query = "SELECT c FROM EmployeeEntity c"),
	@NamedQuery(name = "EmployeeEntity.findByUserId", query = "SELECT c FROM EmployeeEntity c where c.userId=:userId")

})
public class EmployeeEntity extends UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7463611430671306570L;

	

}
