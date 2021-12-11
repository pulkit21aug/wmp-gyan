package com.puls.gyan.config;




import com.puls.gyan.exception.ConfigServiceException;

public interface ConfigService {

	
	public String findByName(String name) throws ConfigServiceException;
	
}
