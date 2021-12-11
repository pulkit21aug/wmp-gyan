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
@Table(name = "REG_FORM")
@NamedQueries({
		@NamedQuery(name = "RegFormEntity.findById", query = "SELECT c FROM RegFormEntity c where c.id=:id"),
		@NamedQuery(name = "RegFormEntity.findByUserId", query = "SELECT c FROM RegFormEntity c where c.userId=:userId"),
		@NamedQuery(name = "RegFormEntity.findByBanktransactionId", query = "SELECT c FROM RegFormEntity c where c.bankTransactionId=:bankTransactionId"),

})
public class RegFormEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5684309050083396383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERID")
	private String userId;

	@Column(name = "REGISTRATION_ID")
	private Long regId;

	@Column(name = "REGISTRATION_DATE")
	private Date regDate;

	@Column(name = "BANKNAME")
	private  String bankName;
	
	@Column(name ="BANK_TRANSACTION_ID")
	private String bankTransactionId;
	
	@Column(name ="TRANSACTIONDATE")
	private  Date transactionDate;
	
	@Column(name = "STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
