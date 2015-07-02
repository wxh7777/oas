package com.pfkj.oas.dao;

import java.util.List;

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

public interface JsdDao {

	boolean save(JsdMxVo jsdmx);

	HthbDo getHthbDoByHthbbh(String hthbbh);

	List<DmZyVo> searchZylist();

	JieSuanDanVo getJsdByJsdbh(String jsdbh);

	List<JieSuanDanVo> searchJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr);

	List<HeTongVo> searchJshttz(String lb, String rq, String jsdh, String htbh,
			String jbr, String gys, String kzr);

	List<HeTongVo> searchHtlist();

	boolean saveHt(HeTongVo htVo);

	boolean saveJsd(JieSuanDanVo jsd);

	boolean saveJsdmx(JsdMxVo jsdmx);

	void save(Object hthb);

	List<XiangMuVo> getProjectByUser(QxUser user);

	List<HthbDo> getHthbDoByXm(XiangMuVo xm);

	int getHTNum(String xmid, String htlbdm);

	List<HeTongVo> searchHtlist(String xmdm);

	int getJsdNum(String htbh);

	List<HeTongMxVo> searchHtmxlist(String htbh);

	XiangMuVo getProjectById(String id);

	List<JieSuanDanVo> getJsdList(String htbh);

	List<JsdMxVo> getJsdmxList(String jsdbh);

	HeTongVo getHetongByHtbh(String htbh);

	List<ShouQuanDo> getSqListByJsdbh(String jsdbh);
	
	ShouQuanDo getSqById(String sqid);

	List<DmZjrbXm> getZjrbXmList();

	ZjrbVo getZjrbLast();

	ZjrbVo getZjrb(String dateToString);

	void delete(Object xm);

	List<ZjrbMxVo> getZjrbXmList(String id);
}
