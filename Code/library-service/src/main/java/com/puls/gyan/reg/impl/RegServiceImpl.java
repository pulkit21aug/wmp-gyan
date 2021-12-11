/**
 * 
 */
package com.puls.gyan.reg.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.puls.gyan.common.RegStatusEnum;
import com.puls.gyan.dao.RegServiceDao;
import com.puls.gyan.dao.entity.RegEntity;
import com.puls.gyan.dao.entity.RegFormEntity;
import com.puls.gyan.exception.RegServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.RegInfo;
import com.puls.gyan.reg.RegService;

/**
 * @author Pulkit.Saxena
 *
 */
public class RegServiceImpl implements RegService {

	BaseLoggger logger = BaseLogFactory.getLogger(RegServiceImpl.class);

	private RegServiceDao regServiceDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.puls.gyan.reg.RegService#openReg(com.puls.gyan.model.RegInfo)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void openReg(RegInfo regInfo) throws RegServiceException {
		RegEntity regEnt = new RegEntity();
		regEnt.setTenantId(regInfo.getBatchName());
		regEnt.setTermCode(regInfo.getTermCode());
		Calendar cal = Calendar.getInstance();
		regEnt.setOpenDate(cal.getTime());
		regEnt.setStatus(RegStatusEnum.OPEN.name());

		try {
			regServiceDao.addReg(regEnt);

		} catch (Exception ex) {
			logger.error("Error adding registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.puls.gyan.reg.RegService#updateReg(com.puls.gyan.model.RegInfo)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void updateReg(RegInfo regInfo) throws RegServiceException {

		RegEntity regEnt = regServiceDao.findById(regInfo.getId());

		if (regInfo.getDeactivate() != null && regInfo.getDeactivate().equalsIgnoreCase("yes")) {
			Calendar cal = Calendar.getInstance();
			regEnt.setCloseDate(cal.getTime());
			regEnt.setStatus(RegStatusEnum.CLOSED.name());

			try {
				regServiceDao.updateReg(regEnt);
			} catch (Exception ex) {
				logger.error("Error closing registration info", ex);
				throw new RegServiceException(ex.getMessage());
			}
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<RegInfo> findByBatch(String batchName) throws RegServiceException {
		List<RegInfo> regList = new ArrayList<RegInfo>();
		try {
			List<RegEntity> regEntList = regServiceDao.findByBatch(batchName);
			for (RegEntity regEnt : regEntList) {
				RegInfo regInfo = new RegInfo();
				regInfo.setBatchName(regEnt.getTenantId());
				regInfo.setId(regEnt.getId());
				regInfo.setStatus(regEnt.getStatus());
				regInfo.setTermCode(regEnt.getTermCode());
				regList.add(regInfo);
			}

		} catch (Exception ex) {
			logger.error("Error closing registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regList;

	}

	public RegServiceDao getRegServiceDao() {
		return regServiceDao;
	}

	public void setRegServiceDao(RegServiceDao regServiceDao) {
		this.regServiceDao = regServiceDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegInfo findByBatchTerm(String tenantId, String termCode) throws RegServiceException {
		RegInfo regInfo = new RegInfo();
		try {
			RegEntity regEnt = regServiceDao.findByBatchTerm(tenantId, termCode);
			regInfo.setBatchName(regEnt.getTenantId());
			regInfo.setId(regEnt.getId());
			regInfo.setTermCode(regEnt.getTermCode());
			regInfo.setStatus(regEnt.getStatus());

		} catch (Exception ex) {
			logger.error("Error closing registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regInfo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void smtRegForm(RegInfo regInfo) throws RegServiceException {

		RegFormEntity regEnt = new RegFormEntity();
		regEnt.setRegId(regInfo.getId());
		Calendar cal = Calendar.getInstance();
		regEnt.setRegDate(cal.getTime());
		regEnt.setBankName(regInfo.getBankName());
		regEnt.setBankTransactionId(regInfo.getBankTransactionId());
		regEnt.setTransactionDate(regInfo.getTransactionDate());
		regEnt.setStatus(RegStatusEnum.SUBMITTED.name());
		regEnt.setUserId(regInfo.getUserId());

		try {
			regServiceDao.addStudentRegForm(regEnt);

		} catch (Exception ex) {
			logger.error("Error adding registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<RegInfo> getRegFormTransaction(String bankTransactionId) throws RegServiceException {
		List<RegInfo> regList = new ArrayList<RegInfo>();
		try {
			List<RegFormEntity> regEntList = regServiceDao.getRegFormTransaction(bankTransactionId);
			for (RegFormEntity regEnt : regEntList) {
				RegInfo regInfo = new RegInfo();
				regInfo.setId(regEnt.getId());
				regInfo.setUserId(regEnt.getUserId());
				regInfo.setBankName(regEnt.getBankName());
				regInfo.setBankTransactionId(regEnt.getBankTransactionId());
				regInfo.setTransactionDate(regEnt.getTransactionDate());
				regInfo.setRegDate(regEnt.getRegDate());
				regInfo.setRegId(regEnt.getRegId());
				regInfo.setStatus(regEnt.getStatus());

				regList.add(regInfo);
			}

		} catch (Exception ex) {
			logger.error("Error closing registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regList;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegInfo approveReg(RegInfo regInfo) throws RegServiceException {

		// regid is of regFormEntity
		RegFormEntity regEnt = regServiceDao.findRegForm(regInfo.getId());
		regEnt.setStatus(RegStatusEnum.APPROVED.name());

		try {
			regEnt = regServiceDao.updateRegForm(regEnt);
			regInfo.setId(regEnt.getId());
			regInfo.setBankName(regEnt.getBankName());
			regInfo.setTransactionDate(regEnt.getTransactionDate());
			regInfo.setBankTransactionId(regEnt.getBankTransactionId());
			regInfo.setRegId(regEnt.getRegId());
			regInfo.setRegDate(regEnt.getRegDate());
			regInfo.setUserId(regEnt.getUserId());
			regInfo.setStatus(regEnt.getStatus());

		} catch (Exception ex) {
			logger.error("Error approving registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regInfo;

	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public RegInfo getRegFormById(Long id) throws RegServiceException {
		RegInfo regInfo = new RegInfo();
		try {
			RegFormEntity regEnt = regServiceDao.findRegForm(id);

			regInfo.setId(regEnt.getId());
			regInfo.setUserId(regEnt.getUserId());
			regInfo.setBankName(regEnt.getBankName());
			regInfo.setBankTransactionId(regEnt.getBankTransactionId());
			regInfo.setTransactionDate(regEnt.getTransactionDate());
			regInfo.setRegDate(regEnt.getRegDate());
			regInfo.setRegId(regEnt.getRegId());
			regInfo.setStatus(regEnt.getStatus());

		} catch (Exception ex) {
			logger.error("Error closing registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regInfo;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<RegInfo> getRegFormUser(String userId) throws RegServiceException {
		List<RegInfo> regList = new ArrayList<RegInfo>();
		try {
			List<RegFormEntity> regEntList = regServiceDao.findByUserId(userId);
			for (RegFormEntity regEnt : regEntList) {
				RegInfo regInfo = new RegInfo();
				regInfo.setId(regEnt.getId());
				regInfo.setUserId(regEnt.getUserId());
				regInfo.setBankName(regEnt.getBankName());
				regInfo.setBankTransactionId(regEnt.getBankTransactionId());
				regInfo.setTransactionDate(regEnt.getTransactionDate());
				regInfo.setRegDate(regEnt.getRegDate());
				regInfo.setRegId(regEnt.getRegId());
				regInfo.setStatus(regEnt.getStatus());

				regList.add(regInfo);
			}

		} catch (Exception ex) {
			logger.error("Error closing registration info", ex);
			throw new RegServiceException(ex.getMessage());
		}

		return regList;

	}

}
