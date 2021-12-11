package com.puls.gyan.dao;

import com.puls.gyan.dao.entity.ConfigEntity;


/**
 * Manage configuration
 * 
 * @author Pulkit.Saxena
 *
 */
public interface ConfigServiceDao {

public ConfigEntity findByName(String name)	;

}
