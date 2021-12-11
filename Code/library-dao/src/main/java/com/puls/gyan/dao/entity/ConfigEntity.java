/**
 * CONFIG Entity - to store external config
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
@Table(name = "CONFIG")
@NamedQueries({ @NamedQuery(name = "ConfigEntity.findByName", query = "SELECT c FROM ConfigEntity c where c.propertyName=:propertyName")

})
public class ConfigEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5450286447985308710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PROPERTY_NAME")
	private String propertyName;

	@Column(name = "PROPERTY_VALUE")
	private String propertyValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

}
