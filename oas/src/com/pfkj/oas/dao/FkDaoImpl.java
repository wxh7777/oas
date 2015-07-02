package com.pfkj.oas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.JieSuanDanVo;
import com.pfkj.oas.model.ShouQuanDo;

public class FkDaoImpl  implements FkDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<JieSuanDanVo> searchSqJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where isenabled='1' and je>ysqje");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JieSuanDanVo> queryList = query.list();
		return queryList;
	}


	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public JieSuanDanVo getJsdByJsdbh(String jsdbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where isenabled='1' and jsdbh=:jsdbh");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("jsdbh", jsdbh);
		List<JieSuanDanVo> queryList = query.list();
		if(queryList.size()>0){
			JieSuanDanVo vo = queryList.get(0);
			return vo;
		}
		return null;
	}
	
	@Transactional("transactionManager")
	@Override
	public boolean saveJsd(JieSuanDanVo jsd) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(jsd);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<JieSuanDanVo> searchYSqJsd(String xmmc, String htbh,
			String skdw, String rq, String jbr, String gys, String kzr) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where isenabled='1' and ysqje>0");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JieSuanDanVo> queryList = query.list();
		return queryList;
	}


	@Transactional("transactionManager")
	@Override
	public void save(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}


	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public ShouQuanDo getSqById(String sqid) {
		StringBuffer hql = new StringBuffer();
		hql.append("from ShouQuanDo where isenabled='1' and id='"+sqid+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ShouQuanDo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}else{
			return null;
		}
	}

}
