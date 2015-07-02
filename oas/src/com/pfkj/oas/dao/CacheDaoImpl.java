package com.pfkj.oas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.dm.DmHtlbVo;
import com.pfkj.oas.model.dm.DmZjrbXmType;
import com.pfkj.oas.model.dm.DmZyVo;

public class CacheDaoImpl implements CacheDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<DmHtlbVo> getHtlbDmList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from DmHtlbVo where isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<DmHtlbVo> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<DmZyVo> getZyDmList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from DmZyVo where isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<DmZyVo> queryList = query.list();
		return queryList;
	}
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<XiangMuVo> getXmDmList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from XiangMuVo where isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<XiangMuVo> queryList = query.list();
		return queryList;
	}
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<DmZjrbXmType> getDmZjrbXmTypeList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from DmZjrbXmType");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<DmZjrbXmType> queryList = query.list();
		return queryList;
	}

}
