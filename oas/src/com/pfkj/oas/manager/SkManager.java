package com.pfkj.oas.manager;

import java.util.List;

import com.pfkj.oas.dao.SkDao;
import com.pfkj.oas.model.SktzdVo;
import com.pfkj.oas.model.SrHeTongVo;

public class SkManager {

	SkDao dao;
	public SkDao getDao() {
		return dao;
	}
	public void setDao(SkDao dao) {
		this.dao = dao;
	}
	public boolean saveSrht(SrHeTongVo htVo) {
		return dao.saveSrht(htVo);
	}
	public boolean saveSktzd(SktzdVo sktzd) {
		return dao.saveSktzd(sktzd);
	}
	public List<SktzdVo> searchSktzd(String htbh, String yzmc, String sj, String gclb) {
		return dao.searchSktzd(htbh, yzmc, sj, gclb);
	}

}
