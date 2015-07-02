package com.pfkj.oas.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.HeTongMxVo;
import com.pfkj.oas.model.HeTongVo;
import com.pfkj.oas.model.HthbDo;
import com.pfkj.oas.model.JieSuanDanVo;
import com.pfkj.oas.model.JsdMxVo;
import com.pfkj.oas.model.ShouQuanDo;
import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.ZjrbMxVo;
import com.pfkj.oas.model.ZjrbVo;
import com.pfkj.oas.model.dm.DmZjrbXm;
import com.pfkj.oas.model.dm.DmZyVo;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.util.DateUtil;

public class JsdDaoImpl implements JsdDao  {
	

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional("transactionManager")
	public boolean save(JsdMxVo jsdmx){
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(jsdmx);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional("transactionManager")
	public boolean saveJsdmx(JsdMxVo jsdmx) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(jsdmx);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Transactional("transactionManager")
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
	public boolean saveHt(HeTongVo htVo) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(htVo);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	public List<HeTongVo> searchHtlist() {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongVo where isenabled='1' and htbh is not null");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HeTongVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	public List<HeTongVo> searchJshttz(String lb, String rq, String jsdh,
			String htbh, String jbr, String gys, String kzr) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongVo where isEnabled='1' ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HeTongVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	public List<JieSuanDanVo> searchJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where isEnabled='1' ");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JieSuanDanVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	public JieSuanDanVo getJsdByJsdbh(String jsdbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where isEnabled='1' and jsdbh=:jsdbh");
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
	@SuppressWarnings("unchecked")
	public List<DmZyVo> searchZylist() {
		StringBuffer hql = new StringBuffer();
		hql.append("from DmZyVo where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<DmZyVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	public void save(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	

	@Transactional("transactionManager")
	@Override
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	public HthbDo getHthbDoByHthbbh(String hthbbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HthbDo where hbbh='"+hthbbh+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HthbDo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}
		return null;
	}

	
	
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<XiangMuVo> getProjectByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {xm.*} from glxt_user_xm ux,glxt_xiangmu xm");
		sql.append(" where ux.user_id='");
		sql.append(user.getId());
		sql.append("' and ux.xm_id=xm.id");
		sql.append(" and xm.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("xm", XiangMuVo.class);
		List<XiangMuVo> xmlist = query.list();
		return xmlist;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<HthbDo> getHthbDoByXm(XiangMuVo xm) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HthbDo where xmid='"+ xm.getId()+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HthbDo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public int getHTNum(String xmid, String htlbdm) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongVo where xm_id='"+ xmid+"' and htlx='"+htlbdm+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HthbDo> queryList = query.list();
		return queryList.size();
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<HeTongVo> searchHtlist(String xmdm) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongVo where xm_id='"+ xmdm+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HeTongVo> queryList = query.list();
		return queryList;
	}
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public int getJsdNum(String htbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where htbh='"+ htbh+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JieSuanDanVo> queryList = query.list();
		return queryList.size();
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<HeTongMxVo> searchHtmxlist(String htbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongMxVo where htbh='"+ htbh+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HeTongMxVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public XiangMuVo getProjectById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from XiangMuVo where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<XiangMuVo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}
		return null;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<JieSuanDanVo> getJsdList(String htbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JieSuanDanVo where htbh='"+ htbh+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JieSuanDanVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<JsdMxVo> getJsdmxList(String jsdbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from JsdMxVo where jsdbh='"+ jsdbh+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<JsdMxVo> queryList = query.list();
		return queryList;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public HeTongVo getHetongByHtbh(String htbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from HeTongVo where htbh='"+htbh+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<HeTongVo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}
		return null;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<ShouQuanDo> getSqListByJsdbh(String jsdbh) {
		StringBuffer hql = new StringBuffer();
		hql.append("from ShouQuanDo where jsdbh='"+ jsdbh+"' and isenabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ShouQuanDo> queryList = query.list();
		return queryList;
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

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<DmZjrbXm> getZjrbXmList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from DmZjrbXm order by zjrbXmDm");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<DmZjrbXm> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public ZjrbVo getZjrbLast() {
		Date today = new Date();
		StringBuffer hql = new StringBuffer();
		hql.append("from ZjrbVo where isenabled='1' and tbrq<STR_TO_DATE('"+DateUtil.dateToString(today)+"','%Y%m%d') order by tbrq");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ZjrbVo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public ZjrbVo getZjrb(String dateToString) {
		StringBuffer hql = new StringBuffer();
		hql.append("from ZjrbVo where isenabled='1' and tbrq=STR_TO_DATE('"+dateToString+"','%Y%m%d')");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ZjrbVo> queryList = query.list();
		if(queryList.size()>0){
			return queryList.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<ZjrbMxVo> getZjrbXmList(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from ZjrbMxVo where isenabled='1' and zjrb_id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ZjrbMxVo> queryList = query.list();
		return queryList;
	}
}
