package com.pfkj.oas.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.pfkj.oas.dao.JsdDao;
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
import com.pfkj.oas.util.ConstantUtil;
import com.pfkj.oas.util.DateUtil;


public class JsdManager {
	public JsdDao dao;
	
	public JsdDao getDao() {
		return dao;
	}

	public void setDao(JsdDao dao) {
		this.dao = dao;
	}
	
	public boolean saveJsdMx(JsdMxVo jsdmx){
		return dao.saveJsdmx(jsdmx);
	}
	
	public boolean exportJsd(String xmlInput,String filename) {
		try{
			WritableWorkbook workbook = Workbook.createWorkbook(new File(filename));
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);


			for(int i=0;i<sheet.getRows();i++){
				for(int j=0;j<sheet.getColumns();j++){
					//Label label = new Label(i, j, "A label record"); 
					//sheet.addCell(label); 

					Number number = new Number(i, j, i+j); 
					sheet.addCell(number);
				}
			}
			workbook.write(); 
			workbook.close();
			return true;
		}
		catch(WriteException e){
			return false;
			
		}
		catch(IOException e){
			return false;
			
		}
		
	}

	public boolean saveJsd(JieSuanDanVo jsdVo) {
		return dao.saveJsd(jsdVo);
	}

	public boolean saveHt(HeTongVo htVo) {
		return dao.saveHt(htVo);
	}

	public String searchHtlist() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("[");
		List<HeTongVo> list = dao.searchHtlist();
		for (int i=0;i<list.size();i++) {
			HeTongVo ht = list.get(i);
			if(i!=0){
				sBuffer.append(",");
			}
			sBuffer.append("{text:'");
			sBuffer.append(ht.getHtmc());
			sBuffer.append("',value:'");
			sBuffer.append(ht.getHtbh());
			sBuffer.append("'}");
		}
		sBuffer.append("]");
		return sBuffer.toString();
	}

	public List<HeTongVo> searchJshttz(String lb, String htbh, String jsdh,
			String rq, String jbr, String gys, String kzr) {
		return dao.searchJshttz(lb,htbh,jsdh,rq,jbr,gys,kzr);
	}

	public List<JieSuanDanVo> searchJsd(String xmmc, String htbh, String skdw,
			String rq, String jbr, String gys, String kzr) {
		return dao.searchJsd(xmmc,htbh,skdw,rq,jbr,gys,kzr);
	}

	public void fhJsd(String jsdbh) {
		JieSuanDanVo vo = dao.getJsdByJsdbh(jsdbh);
		vo.setShsj(new Date());
		dao.save(vo);
	}

	public void jjJsd(String jsdbh) {
		JieSuanDanVo vo = dao.getJsdByJsdbh(jsdbh);
		vo.setJjsj(new Date());
		dao.save(vo);
	}
	

	public List<DmZyVo> searchZylist() {
		return dao.searchZylist();
	}

	public void saveHthbDo(HthbDo hthb) {
		dao.save(hthb);
	}

	public HthbDo getHthbDoByHthbbh(String hthbbh) {
		return dao.getHthbDoByHthbbh(hthbbh);
	}

	public List<HthbDo> searchHthblist(QxUser user) {
		List<HthbDo> list = new ArrayList<HthbDo>();
		List<XiangMuVo> xmList = dao.getProjectByUser(user);
		for(XiangMuVo xm : xmList){
			List<HthbDo> listHb = dao.getHthbDoByXm(xm);
			list.addAll(listHb);
		}
		return list;
	}

	public int getHTNum(String xmid, String htlbdm) {
		return dao.getHTNum(xmid,htlbdm);
	}

	public List<HeTongVo> searchHtlist(String xmdm) {
		return dao.searchHtlist(xmdm);
	}

	public int getJsdNum(String htbh) {
		return dao.getJsdNum(htbh);
	}

	public void saveHtmx(HeTongMxVo htmxVo) {
		dao.save(htmxVo);
	}

	public List<XiangMuVo> getXiangMuList(QxUser user) {
		return dao.getProjectByUser(user);
	}

	public List<HeTongMxVo> searchHtmxlist(String htbh) {
		return dao.searchHtmxlist(htbh);
	}

	public void saveJsdmx(JsdMxVo jsdmxVo) {
		dao.saveJsdmx(jsdmxVo);
	}

	public XiangMuVo getXiangmuById(String id) {
		return dao.getProjectById(id);
	}

	public List<JieSuanDanVo> getJsdList(String htbh) {
		return dao.getJsdList(htbh);
	}

	public List<JsdMxVo> searchJsdmxlist(String jsdbh) {
		return dao.getJsdmxList(jsdbh);
	}
	
	public JieSuanDanVo getJsd(String jsdbh){
		return dao.getJsdByJsdbh(jsdbh);
	}

	public HeTongVo getHetongByHtbh(String htbh) {
		return dao.getHetongByHtbh(htbh);
	}

	public List<ShouQuanDo> getSqListByJsdbh(String jsdbh) {
		return dao.getSqListByJsdbh(jsdbh);
	}
	
	public void qrsq(String jsdbh, double sqje) {
		ShouQuanDo sq = new ShouQuanDo();
		sq.setJsdbh(jsdbh);
		sq.setSqje(sqje);
		sq.setSQSJ(new Date());
		sq.setSqly("由结算单付款");
		sq.setYsqbz('N');
		sq.setClzt(ConstantUtil.SHOUQUAN_CLZT_XJSQ);
		sq.setFktzddycs(0);
		sq.setEnabled(true);
		dao.save(sq);
	}

	
	public void sqsh(String sqid, boolean istg) {
		ShouQuanDo sq = dao.getSqById(sqid);
		if(istg){
			sq.setClzt(ConstantUtil.SHOUQUAN_CLZT_SHTG);
		}
		else{
			sq.setClzt(ConstantUtil.SHOUQUAN_CLZT_SHSB);
		}
		dao.save(sq);
	}

	public void ysq(String htbh, String jsdbh, double yusqje, String ysqly) {
		JieSuanDanVo jsd = new JieSuanDanVo();
		jsd.setJsdbh(jsdbh);
		jsd.setLeibie("预授权");
		jsd.setHtbh(htbh);
		jsd.setZje(yusqje);
		jsd.setRq(new Date());
		jsd.setYsqbz('Y');
		jsd.setEnabled(true);
		dao.save(jsd);
		
		ShouQuanDo sq = new ShouQuanDo();
		sq.setJsdbh(jsdbh);
		sq.setSqje(yusqje);
		sq.setSqly(ysqly);
		sq.setFktzddycs(0);
		sq.setClzt(ConstantUtil.SHOUQUAN_CLZT_XJSQ);
		sq.setSQSJ(new Date());
		sq.setYsqbz('Y');
		sq.setEnabled(true);
		dao.save(sq);
	}

	public void scfktzd(String sqid) {
		ShouQuanDo sq = dao.getSqById(sqid);
		sq.setClzt(ConstantUtil.SHOUQUAN_CLZT_SCFKTZD);
		dao.save(sq);
	}

	public List<DmZjrbXm> getZjrbXmList() {
		return dao.getZjrbXmList();
	}

	public ZjrbVo getZjrbLast() {
		return dao.getZjrbLast();
	}

	public ZjrbVo getZjrb(Date date) {
		return dao.getZjrb(DateUtil.dateToString(date));
	}

	public void saveZjrb(ZjrbVo zjrb) {
		dao.save(zjrb);
	}

	public void save(Object vo) {
		dao.save(vo);
	}

	public void deleteZjrbMx(String id) {
		List<ZjrbMxVo> list =  dao.getZjrbXmList(id);
		for(int i = 0;i<list.size();i++){
			ZjrbMxVo xm = list.get(i);
			dao.delete(xm);
		}
	}
}
