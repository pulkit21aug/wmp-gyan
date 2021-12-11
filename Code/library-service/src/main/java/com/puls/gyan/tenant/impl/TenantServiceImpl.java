/**
 * 
 */
package com.puls.gyan.tenant.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.puls.gyan.dao.TenantServiceDao;
import com.puls.gyan.dao.entity.TenantEntity;
import com.puls.gyan.dao.entity.TermEntity;
import com.puls.gyan.exception.TenantServiceException;
import com.puls.gyan.log.BaseLogFactory;
import com.puls.gyan.log.BaseLoggger;
import com.puls.gyan.model.BatchInfo;
import com.puls.gyan.model.TermInfo;
import com.puls.gyan.tenant.TenantService;

/**
 * @author Pulkit.Saxena
 *
 */
public class TenantServiceImpl implements TenantService {

	private TenantServiceDao tenantServiceDao;

	BaseLoggger logger = BaseLogFactory.getLogger(TenantServiceImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addTenant(String tenantId, String tenantDesc) throws TenantServiceException {
		TenantEntity tntEntity = new TenantEntity();
		tntEntity.setTenantId(tenantId);
		tntEntity.setTenantDesc(tenantDesc);
		Calendar cal = Calendar.getInstance();
		tntEntity.setCreatedDate(cal.getTime());

		if(StringUtils.isEmpty(tenantId)) {
			logger.error("Batch Id empty");
			throw new TenantServiceException("Add correct Batch Id");
		}
		
		try {
			tenantServiceDao.addTenant(tntEntity);
		} catch (Exception ex) {
			logger.error("Error adding batch info", ex);
			throw new TenantServiceException(ex.getMessage());
		}

	}

	public TenantServiceDao getTenantServiceDao() {
		return tenantServiceDao;
	}

	public void setTenantServiceDao(TenantServiceDao tenantServiceDao) {
		this.tenantServiceDao = tenantServiceDao;
	}

	@Override
	public List<BatchInfo> findAllBatches() throws TenantServiceException {
		List<BatchInfo> listBatches = new ArrayList<BatchInfo>();

		try {

			List<TenantEntity> tenantList = tenantServiceDao.findAllBatches();
			for (TenantEntity ent : tenantList) {
				BatchInfo batchInfo = new BatchInfo();
				batchInfo.setBatchName(ent.getTenantId());
				batchInfo.setBatchDesc(ent.getTenantDesc());
				listBatches.add(batchInfo);

			}
		} catch (Exception ex) {
			logger.error("Error finding batches/batch not defined", ex);
			throw new TenantServiceException(ex.getMessage());
		}

		return listBatches;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void addTerm(String tenantId, String termCode) throws TenantServiceException {
		TermEntity trmEntity = new TermEntity();
		trmEntity.setTenantId(tenantId);
		trmEntity.setTermCode(termCode);
		Calendar cal = Calendar.getInstance();
		trmEntity.setCreatedDate(cal.getTime());

		try {
			tenantServiceDao.addTerm(trmEntity);
		} catch (Exception ex) {
			logger.error("Error adding term info", ex);
		}
		
	}

	@Override
	public List<TermInfo> findAllTermsForBatch(String tenantId) throws TenantServiceException {
		List<TermInfo> listTerm = new ArrayList<TermInfo>();

		try {

			List<TermEntity> termList = tenantServiceDao.findAllTermsForBatch(tenantId);
			for (TermEntity ent : termList) {
				TermInfo termInfo = new TermInfo();
				termInfo.setId(ent.getId());
				termInfo.setBatchName(ent.getTenantId());
				termInfo.setTermCode(ent.getTermCode());
				listTerm.add(termInfo);

			}
		} catch (Exception ex) {
			logger.error("Error finding terms for batch", ex);
			throw new TenantServiceException(ex.getMessage());
		}

		return listTerm;
	}

	@Override
	public List<BatchInfo> viewAllBatches() throws TenantServiceException {
		List<BatchInfo> listBatches = new ArrayList<BatchInfo>();

		try {

			List<TenantEntity> tenantList = tenantServiceDao.viewAllBatches();
			for (TenantEntity ent : tenantList) {
				BatchInfo batchInfo = new BatchInfo();
				batchInfo.setBatchName(ent.getTenantId());
				batchInfo.setBatchDesc(ent.getTenantDesc());
				batchInfo.setCreatedDate(ent.getCreatedDate());
				listBatches.add(batchInfo);

			}
		} catch (Exception ex) {
			logger.error("Error finding batches/batch not defined", ex);
			throw new TenantServiceException(ex.getMessage());
		}

		return listBatches;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void updateTenant(BatchInfo batchInfo) throws TenantServiceException {
		TenantEntity tntEntity = tenantServiceDao.findByBatchId(batchInfo.getBatchName());
		
		tntEntity.setTenantId(batchInfo.getBatchName());
		tntEntity.setTenantDesc(batchInfo.getBatchDesc());
		
		if(batchInfo.getDeactivate().equalsIgnoreCase("yes")) {
			Calendar cal = Calendar.getInstance();
			tntEntity.setExpiredDate(cal.getTime());
		}

		try {
			tenantServiceDao.updateTenant(tntEntity);
		} catch (Exception ex) {
			logger.error("Error updating batch info", ex);
			throw new TenantServiceException(ex.getMessage());
		}

		
	}

}
