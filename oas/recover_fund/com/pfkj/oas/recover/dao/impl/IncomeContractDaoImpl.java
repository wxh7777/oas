package com.pfkj.oas.recover.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.manager.QxManager;
import com.pfkj.oas.recover.dao.IncomeContractDao;
import com.pfkj.oas.recover.model.IncomeContract;

public class IncomeContractDaoImpl implements IncomeContractDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private QxManager qxManager;

	public QxManager getQxManager() {
		return qxManager;
	}

	public void setQxManager(QxManager qxManager) {
		this.qxManager = qxManager;
	}

	@Transactional("transactionManager")
	@Override
	public boolean insert(IncomeContract incomeContract) {
		try {
			sessionFactory.getCurrentSession().save(incomeContract);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional("transactionManager")
	@Override
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete("ID", id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional("transactionManager")
	@Override
	public boolean update(IncomeContract incomeContract) {
		try {
			sessionFactory.getCurrentSession().update(incomeContract);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional("transactionManager")
	@Override
	public IncomeContract searchByID(String id) {
		return (IncomeContract) sessionFactory.getCurrentSession().byId(id);
	}
	
	@Transactional("transactionManager")
	@Override
	public IncomeContract searchOne(Map queryMap) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from IncomeContract where");
		for(Object obj:queryMap.keySet()){
			sqlBuffer.append(" "+obj+"='"+queryMap.get(obj)+"'");
		}
		Query query = sessionFactory.getCurrentSession().createQuery(sqlBuffer.toString());
		List<IncomeContract> queryList = query.list();
		if(queryList!=null && !queryList.isEmpty()){
			return  queryList.get(0);
		}else{
			return null;
		}
	}
	
	@Transactional("transactionManager")
	@Override
	public List<IncomeContract> searchList(Map queryMap) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("from IncomeContract where");
		boolean flag = false;
		for(Object obj:queryMap.keySet()){
			if(flag){
				sqlBuffer.append(" AND");
			}
			sqlBuffer.append(" "+obj+"='"+queryMap.get(obj)+"'");
			flag = true;
		}
		Query query = sessionFactory.getCurrentSession().createQuery(sqlBuffer.toString());
		List<IncomeContract> queryList = query.list();
		if(queryList!=null && !queryList.isEmpty()){
			return  queryList;
		}else{
			return null;
		}
	}
	
	@Transactional("transactionManager")
	@Override
	public List<Map> searchListByUserId(String userName) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select ic.ID,ic.TYPE,ic.NUMBER,ic.PATH,xm.XM_DESC,xm.XM_MC");
		sqlBuffer.append(" from glxt_income_contract ic,glxt_xiangmu xm,glxt_user_xm uxm,glxt_qx_user u"); 
		sqlBuffer.append(" where u.ID= uxm.USER_ID and ic.XIANGMU_ID =uxm.XM_ID and uxm.XM_ID = xm.ID and u.USER_ACCOUNT = '"+userName+"'");
		sqlBuffer.append(" order by ic.UPLOAD_TIME desc");
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlBuffer.toString());
		List<Map> queryList = query.list();
		if(queryList!=null && !queryList.isEmpty()){
			List<Map> resList = new ArrayList<Map>();
			Iterator iter = queryList.iterator();
			while (iter.hasNext()) {
				Object obj[] = (Object[]) iter.next();
				Map itemMap = new HashMap();
				itemMap.put("ID", obj[0]);
				itemMap.put("TYPE", obj[1]);
				itemMap.put("NUMBER", obj[2]);
				itemMap.put("PATH", obj[3]);
				itemMap.put("XM_DESC", obj[4]);
				itemMap.put("XM_MC", obj[5]);
				resList.add(itemMap);
			}
			return resList;
		}else{
			return new ArrayList<Map>();
		}
	}
}
