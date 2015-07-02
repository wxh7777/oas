package com.pfkj.oas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.SktzdVo;
import com.pfkj.oas.model.SrHeTongVo;

public class SkDaoImpl implements SkDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional("transactionManager")
	@Override
	public boolean saveSrht(SrHeTongVo htVo) {
		try{
			sessionFactory.getCurrentSession().save(htVo);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional("transactionManager")
	@Override
	public boolean saveSktzd(SktzdVo sktzd) {
		try{
			sessionFactory.getCurrentSession().save(sktzd);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public  List<SktzdVo> searchSktzd(String htbh, String yzmc, String sj, String gclb) {
		StringBuffer hql = new StringBuffer();
		hql.append("from SktzdVo where isenabled='1' ");
		if(htbh!=null&&!"".equals(htbh)){
			hql.append(" and  htbh=:htbh");
		}
		if(yzmc!=null&&!"".equals(yzmc)){
			hql.append(" and yzmc=:yzmc");
		}
		if(sj!=null&&!"".equals(sj)){
			hql.append(" and sj=:sj");
		}
		if(gclb!=null&&!"".equals(gclb)){
			hql.append(" and gclb=:gclb");
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		if(htbh!=null&&!"".equals(htbh)){
			query.setString("htbh", htbh);
		}
		if(yzmc!=null&&!"".equals(yzmc)){
			query.setString("yzmc", yzmc);
		}
		if(sj!=null&&!"".equals(sj)){
			query.setString("sj", sj);
		}
		if(gclb!=null&&!"".equals(gclb)){
			query.setString("gclb", gclb);
		}
		List<SktzdVo> queryList = query.list();
		return queryList;
	}

}
