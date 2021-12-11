/**
 * 
 */
package com.puls.gyan.sub.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.puls.gyan.dao.SubjectServiceDao;
import com.puls.gyan.dao.entity.SubjectEntity;
import com.puls.gyan.exception.SubServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.SubjectInfo;
import com.puls.gyan.sub.SubService;

/**
 * @author pulkit.saxena
 *
 */
public class SubServiceImpl implements SubService {

	private SubjectServiceDao subjectServiceDao;
	
	BaseLoggger logger = BaseLogFactory.getLogger(SubServiceImpl.class);
	
	/**
	 * 
	 */
	public SubServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.puls.gyan.sub.SubService#addSub(com.puls.gyan.dao.entity.SubjectEntity)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addSub(SubjectInfo subInfo) throws SubServiceException {
		SubjectEntity subEnt =new  SubjectEntity();
		
		subEnt.setSubjectCode(subInfo.getSubCode());
		subEnt.setSubjectName(subInfo.getSubName());
		subEnt.setTenantId(subInfo.getBatchName());
		subEnt.setTermCode(subInfo.getTermCode());
		Calendar cal = Calendar.getInstance();
		subEnt.setCreatedDate(cal.getTime());
		
		try {
			subjectServiceDao.addSub(subEnt);
			
		}catch(Exception ex) {
			logger.error("Error adding subject info", ex);
			throw new SubServiceException(ex.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.puls.gyan.sub.SubService#findAllSub(java.lang.String, java.lang.String)
	 */
	@Override
	public List<SubjectInfo> findAllSub(String tenantId, String termCode) throws SubServiceException {
		
		List<SubjectInfo> subList = new  ArrayList<SubjectInfo>();
		
		try {

			List<SubjectEntity> entList = subjectServiceDao.findAllSub(tenantId, termCode);
			for (SubjectEntity ent : entList) {
				SubjectInfo subInfo = new SubjectInfo();
				subInfo.setBatchName(ent.getTenantId());
				subInfo.setSubCode(ent.getSubjectCode());
				subInfo.setSubName(ent.getSubjectName());
				subInfo.setTermCode(ent.getTermCode());
				subInfo.setId(ent.getId());
				subList.add(subInfo);

			}
		} catch (Exception ex) {
			logger.error("Error finding subjects for term/or not defined", ex);
			throw new SubServiceException(ex.getMessage());
		}
		
		return subList;
	}

	public SubjectServiceDao getSubjectServiceDao() {
		return subjectServiceDao;
	}

	public void setSubjectServiceDao(SubjectServiceDao subjectServiceDao) {
		this.subjectServiceDao = subjectServiceDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void update(SubjectInfo subInfo) throws SubServiceException {
        SubjectEntity subEnt =subjectServiceDao.findSubById(subInfo.getId());
		subEnt.setSubjectName(subInfo.getSubName());

		if(subInfo.getDeactivate()!=null && subInfo.getDeactivate().equalsIgnoreCase("yes")) {
			Calendar cal = Calendar.getInstance();
			subEnt.setExpiredDate(cal.getTime());
		}
		
		try {
			subjectServiceDao.updateSub(subEnt);
			
		}catch(Exception ex) {
			logger.error("Error adding subject info", ex);
			throw new SubServiceException(ex.getMessage());
		}
		
	}

}
