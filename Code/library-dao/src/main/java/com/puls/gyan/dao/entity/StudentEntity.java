/**
 * 
 */
package com.puls.gyan.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Pulkit.Saxena
 *
 */
@Entity
@DiscriminatorValue(value = "1")
@NamedQueries({ @NamedQuery(name = "StudentEntity.getAllStudent", query = "SELECT c FROM StudentEntity c where c.batchId=:batchId"),
	@NamedQuery(name = "StudentEntity.findStudentByUserId", query = "SELECT c FROM StudentEntity c where c.userId=:userId")

})
public class StudentEntity extends UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133754311172724703L;
	@Column(name = "TENANT_ID")
	private String batchId;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

}
