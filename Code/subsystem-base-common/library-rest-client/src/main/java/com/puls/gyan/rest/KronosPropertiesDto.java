/**
 *  Model class to be send as Json 
 */
package com.puls.gyan.rest;

/**
 * @author Pulkit.Saxena
 *
 */

public class KronosPropertiesDto {

	private String propertyName;

	private String propertyValue;

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
