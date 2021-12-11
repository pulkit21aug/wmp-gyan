/**
 * 
 */
package com.puls.gyan.config.impl;

import com.puls.gyan.config.ConfigService;
import com.puls.gyan.dao.ConfigServiceDao;
import com.puls.gyan.dao.entity.ConfigEntity;
import com.puls.gyan.exception.ConfigServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;

/**
 * @author Pulkit.Saxena
 *
 */
public class ConfigServiceImpl implements ConfigService {

	BaseLoggger logger = BaseLogFactory.getLogger(ConfigServiceImpl.class);

	private ConfigServiceDao configServiceDao;

	@Override
	public String  findByName(String name) throws ConfigServiceException {
		ConfigEntity ent = null;
		try {
			ent = configServiceDao.findByName(name);
		} catch (Exception ex) {
			logger.error("Error finding config info", ex);
			throw new ConfigServiceException(ex.getMessage());
		}

		return ent.getPropertyValue();
	}

	public ConfigServiceDao getConfigServiceDao() {
		return configServiceDao;
	}

	public void setConfigServiceDao(ConfigServiceDao configServiceDao) {
		this.configServiceDao = configServiceDao;
	}

}
