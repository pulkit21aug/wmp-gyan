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
@Table(name = "SUBJECT")
@NamedQueries({
		@NamedQuery(name = "SubjectEntity.findAllSubjectByTermBatch", query = "SELECT c FROM SubjectEntity c where c.tenantId=:tenantId and c.termCode=:termCode"),
		@NamedQuery(name = "SubjectEntity.findSubById", query = "SELECT c FROM SubjectEntity c where c.id=:id ")

})
public class SubjectEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784946813324254239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TENANT_ID")
	private String tenantId;

	@Column(name = "TERMCODE")
	private String termCode;

	@Column(name = "SUBJECTCODE")
	private String subjectCode;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

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

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}
