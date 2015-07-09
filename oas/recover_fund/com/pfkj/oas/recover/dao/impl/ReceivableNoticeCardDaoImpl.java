package com.pfkj.oas.recover.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.recover.dao.ReceivableNoticeCardDao;
import com.pfkj.oas.recover.model.ReceivableNoticeCard;

public class ReceivableNoticeCardDaoImpl implements ReceivableNoticeCardDao {
	
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
	public boolean insert(ReceivableNoticeCard receivableNoticeCard) {
		try{
			sessionFactory.getCurrentSession().save(receivableNoticeCard);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
