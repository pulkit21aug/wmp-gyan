/**
 * Model class for Batch
 */
package com.puls.gyan.model;

import java.util.Date;

/**
 * @author Pulkit.Saxena
 *
 */
public class TermInfo {

	private Long  id;
	
	private String termCode;

	private String batchName;
	
	private Date createdDate;
	
	private Date expiredDate;

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
