/**
 * 
 */
package com.puls.gyan.common;

/**
 * @author Pulkit.Saxena
 *
 */
public enum RoleEnum {
	ROLE_ADMIN(1), ROLE_STUDENT(2);

	private int value;

	private RoleEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
