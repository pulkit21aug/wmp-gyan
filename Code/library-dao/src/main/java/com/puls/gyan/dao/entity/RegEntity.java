/**
 * Tenant Entity ( Batch such as WMP18 )
 */
package com.puls.gyan.dao.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "REGISTRATION")
@NamedQueries({
		@NamedQuery(name = "RegEntity.findAllActive", query = "SELECT c FROM RegEntity c where c.closeDate is null"),
		@NamedQuery(name = "RegEntity.findById", query = "SELECT c FROM RegEntity c where c.id=:id"),
		@NamedQuery(name = "RegEntity.findByBatch", query = "SELECT c FROM RegEntity c where c.tenantId=:tenantId"),
		@NamedQuery(name = "RegEntity.findByBatchTerm", query = "SELECT c FROM RegEntity c where c.tenantId=:tenantId and c.termCode=:termCode and c.closeDate is null")

})
public class RegEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1232637430280048993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TENANT_ID")
	private String tenantId;

	@Column(name = "OPEN_DATE")
	private Date openDate;

	@Column(name = "CLOSE_DATE")
	private Date closeDate;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "TERMCODE")
	private String termCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

}
