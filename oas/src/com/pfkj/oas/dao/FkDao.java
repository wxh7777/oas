package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.JieSuanDanVo;
import com.pfkj.oas.model.ShouQuanDo;

public interface FkDao {

	List<JieSuanDanVo> searchYSqJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr);

	boolean saveJsd(JieSuanDanVo jsd);

	JieSuanDanVo getJsdByJsdbh(String jsdbh);

	List<JieSuanDanVo> searchSqJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr);

	void save(Object obj);

	ShouQuanDo getSqById(String sqid);

}
