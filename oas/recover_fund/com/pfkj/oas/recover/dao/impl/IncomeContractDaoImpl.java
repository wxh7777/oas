package com.pfkj.oas.recover.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
		for(Object obj:queryMap.keySet()){
			sqlBuffer.append(" "+obj+"='"+queryMap.get(obj)+"'");
		}
		Query query = sessionFactory.getCurrentSession().createQuery(sqlBuffer.toString());
		List<IncomeContract> queryList = query.list();
		if(queryList!=null && !queryList.isEmpty()){
			return  queryList;
		}else{
			return null;
		}
	}
}
