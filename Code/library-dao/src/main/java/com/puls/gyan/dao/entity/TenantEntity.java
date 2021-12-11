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
@Table(name = "TENANT")
@NamedQueries({
		@NamedQuery(name = "TenantEntity.findAllActive", query = "SELECT c FROM TenantEntity c where c.expiredDate is null"),
		@NamedQuery(name = "TenantEntity.viewAll", query = "SELECT c FROM TenantEntity c "),
		@NamedQuery(name = "TenantEntity.findByBatchId", query = "SELECT c FROM TenantEntity c where c.tenantId=:tenantId")

})
public class TenantEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5450286447985308710L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TENANT_ID")
	private String tenantId;

	@Column(name = "TENANTDESC")
	private String tenantDesc;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "EXPIRED_DATE")
	private Date expiredDate;

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

	public String getTenantDesc() {
		return tenantDesc;
	}

	public void setTenantDesc(String tenantDesc) {
		this.tenantDesc = tenantDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}
