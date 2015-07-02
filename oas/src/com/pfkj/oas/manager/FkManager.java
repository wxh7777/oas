package com.pfkj.oas.manager;

import java.util.Date;
import java.util.List;

import com.pfkj.oas.dao.FkDao;
import com.pfkj.oas.model.JieSuanDanVo;
import com.pfkj.oas.model.ShouQuanDo;

public class FkManager {

	FkDao dao;
	
	public FkDao getDao() {
		return dao;
	}

	public void setDao(FkDao dao) {
		this.dao = dao;
	}

	public List<JieSuanDanVo> searchSqJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr) {
		return dao.searchSqJsd(xmmc,htbh,skdw,rq,jbr,gys,kzr);
	}

	public void qrsq(String jsdbh, double sqje) {
		ShouQuanDo sq = new ShouQuanDo();
		sq.setJsdbh(jsdbh);
		sq.setSqje(sqje);
		//sq.setSqshjg('N');
		sq.setSQSJ(new Date());
		sq.setYsqbz('N');
		sq.setEnabled(true);
		dao.save(sq);
	}

	public List<JieSuanDanVo> searchScfktzd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr) {
		return dao.searchYSqJsd(xmmc,htbh,skdw,rq,jbr,gys,kzr);
	}

	public void sqsh(String sqid, boolean istg) {
		ShouQuanDo sq = dao.getSqById(sqid);
		if(istg){
			//sq.setSqshjg('Y');
		}
		else{
			//sq.setSqshjg('N');
		}
		dao.save(sq);
	}

}
