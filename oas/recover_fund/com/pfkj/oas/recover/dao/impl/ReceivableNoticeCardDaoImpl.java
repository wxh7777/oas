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

	@Transactional("transactionManager")
	@Override
	public List<Map> searchReceivalNoticeCardList() {
		List receivalNoticeCardList = new ArrayList();
		
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select rnc.ID,rnc.TOTAL_METERING,rnc.ADVANCE_MONEY,rnc.METERING_MONEY,rnc.HOLD_MONEY,rnc.WARRANTY_MONEY,rnc.FARMER_Money,rnc.OTHER_MONEY,rnc.MEMO");
		sqlBuffer.append(",xm.XM_DESC,xm.XM_MC from glxt_receivable_notice_card rnc,glxt_xiangmu xm");
		sqlBuffer.append(" where xm.ID = rnc.XIANGMU_ID");
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sqlBuffer.toString());

		List queryList = query.list();
		if(queryList != null && !queryList.isEmpty()){
			Iterator iter = queryList.iterator();
			while (iter.hasNext()) {
				Object obj[] = (Object[]) iter.next();
				Map itemMap = new HashMap();
				itemMap.put("ID", obj[0]);
				itemMap.put("TOTAL_METERING", obj[1]);
				itemMap.put("ADVANCE_MONEY", obj[2]);
				itemMap.put("METERING_MONEY", obj[3]);
				itemMap.put("HOLD_MONEY", obj[4]);
				itemMap.put("WARRANTY_MONEY", obj[5]);
				itemMap.put("FARMER_MONEY", obj[6]);
				itemMap.put("OTHER_MONEY", obj[7]);
				itemMap.put("MEMO", obj[8]);
				itemMap.put("XM_DESC", obj[9]);
				itemMap.put("XM_MC", obj[10]);
				receivalNoticeCardList.add(itemMap);
			}
		}
		return receivalNoticeCardList;
	}
	
	@Transactional("transactionManager")
	@Override
	public ReceivableNoticeCard searchReceivalNoticeCardById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from ReceivableNoticeCard where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<ReceivableNoticeCard> queryList = query.list();
		if(queryList.size()>0){
			ReceivableNoticeCard receivableNoticeCard = queryList.get(0);
			return receivableNoticeCard;
		}else{
			return null;
		}
	}
}
