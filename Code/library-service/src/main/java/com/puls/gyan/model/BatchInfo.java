/**
 * Model class for Batch
 */
package com.puls.gyan.model;

import java.util.Date;

/**
 * @author Pulkit.Saxena
 *
 */
public class BatchInfo {

	private String batchName;

	private String batchDesc;
	
	private Date createdDate;
	
	private Date expiredDate;

	private String deactivate;
	
	
	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchDesc() {
		return batchDesc;
	}

	public void setBatchDesc(String batchDesc) {
		this.batchDesc = batchDesc;
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

	public String getDeactivate() {
		return deactivate;
	}

	public void setDeactivate(String deactivate) {
		this.deactivate = deactivate;
	}

}
