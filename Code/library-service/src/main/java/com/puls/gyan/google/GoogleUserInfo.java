/**
 * 
 */
package com.puls.gyan.google;

import java.io.Serializable;

/**
 * @author Pulkit.Saxena
 *
 */
public class GoogleUserInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6246268741488244527L;

	private String id;
	
	private String email;
	
	private Boolean verified_email;
	
	private String name;
	
	private String given_name;
	
	private String family_name;
	
	private String picture;
	
	private String locale;
	
	private String hd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getVerified_email() {
		return verified_email;
	}

	public void setVerified_email(Boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}
	
	

}
