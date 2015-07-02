package com.pfkj.oas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.qx.QxAuthority;

public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxAuthority> getAuthorityList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxAuthority where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxAuthority> queryList = query.list();
		return queryList;
	}


}
