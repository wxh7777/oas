package com.pfkj.oas.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.JDOMException;
import org.mortbay.log.Log;

import com.pfkj.oas.file.HtmxResult.HtmxBase;
import com.pfkj.oas.file.JcmxResult.JcmxBase;
import com.pfkj.oas.file.JcmxResult.JcmxDetail;
import com.pfkj.oas.manager.JsdManager;
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
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.util.CacheUtil;
import com.pfkj.oas.util.ConstantUtil;
import com.pfkj.oas.util.DateUtil;
import com.pfkj.oas.util.JsonUtil;
import com.pfkj.oas.util.StringUtil;

public class JsdService {
	JsdManager manager;
	public JsdManager getManager() {
		return manager;
	}
	public void setManager(JsdManager manager) {
		this.manager = manager;
	}
	public boolean saveJsdMx(JsdMxVo jsdmx){
		return manager.saveJsdMx(jsdmx);
	}
	public boolean exportJsd(String xmlStr,String filename) {
		boolean result = false;
		result = manager.exportJsd(xmlStr,filename);
		return result;
	}
	public boolean saveJsd(JieSuanDanVo jsdVo) {
		return manager.saveJsd(jsdVo);
	}
	public boolean saveHt(HeTongVo htVo) {
		return manager.saveHt(htVo);
	}
	public String searchHtlist() {
		return manager.searchHtlist();
	}
	public String searchZylist() {
		return CacheUtil.getInstance().getCache("ZYDM");
	}
	public String qrfhJsd(String str) throws JDOMException, IOException {

        return null; 
	}
	public void fhJsd(String jsdbh) {
		manager.fhJsd(jsdbh);
	}
	public void jjJsd(String jsdbh) {
		manager.jjJsd(jsdbh);
	}
	public void saveHthbDo(HthbDo hthb) {
		manager.saveHthbDo(hthb);
	}
	public HthbDo getHthbDoByHthbbh(String hthbbh) {
		return manager.getHthbDoByHthbbh(hthbbh);
	}
	@SuppressWarnings("rawtypes")
	public String searchHthblist(QxUser user) {
		List<HthbDo> list = manager.searchHthblist(user);
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			HthbDo hthb = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("HTHBBH", hthb.getHbbh());
			String files = "";
			String[] fs = hthb.getFiles().split(";");
			for(int j=0;j<fs.length;j++){
				String htFileName = fs[j].replace("\\"+hthb.getHbbh()+"\\", "");
				files = files + "<a name='file' class='btn-link' href=\"javascript:;\">"+htFileName+"</a></br>";
			}
	        map.put("HTWJLB", files);
	        Date dateFile = hthb.getHtFilesDate();
	        String scsj = "";//上传时间
	        if(dateFile!=null){
	        	scsj = StringUtil.dateToStringMx(dateFile);
	        }
	        map.put("SCWJSJ", scsj);
	        String shA = "<a name='file' class='btn-link' href='javascript:;'>"+ hthb.getShFileA()+"</a>";
	        map.put("GCBSHYJWD", shA);
	        String shsj = "";
	        Date date = hthb.getShFileADate();
	        if(date!=null){
	        	shsj = StringUtil.dateToStringMx(date);
	        }
	        map.put("GCBSHSJ", shsj);
	        map.put("GCBSHR", hthb.getShrA());
	        String shB = "<a name='file' class='btn-link' href='javascript:;'>"+ hthb.getShFileB()+"</a>";
	        map.put("SWBSHYJWD", shB);
	        Date date2 = hthb.getShFileBDate();
	        if(date2!=null){
	        	shsj = StringUtil.dateToStringMx(date2);
	        }
	        map.put("SWBSHSJ", shsj);
	        map.put("SWBSHR", hthb.getShrB());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	public String excuteHtbh(String xmid, String htlbdm) {
		int num = manager.getHTNum(xmid,htlbdm);
		return String.format("%05d", num+1);
	}
	@SuppressWarnings("rawtypes")
	public String getHtList(String xmdm) {
		List<HeTongVo> list = manager.searchHtlist(xmdm);
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			HeTongVo ht = list.get(i);
			List<HeTongMxVo> mxvos = manager.searchHtmxlist(ht.getHtbh());
			List<Map> listMapMx = new ArrayList<Map>();
			for(int j=0;j<mxvos.size();j++){
				HeTongMxVo mx = mxvos.get(j);
				Map<String, String> mapmx = new HashMap<String, String>();
				mapmx.put("JSXMGGSJ", mx.getZydm()+"/"+String.valueOf(mx.getDanjia())+"/"+String.valueOf(mx.getShuliang()));
				mapmx.put("JSXMGG", mx.getZymc()+"/"+mx.getGuige());
				listMapMx.add(mapmx);
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("HTBH", ht.getHtbh());
	        map.put("HTMC", ht.getHtmc());
	        map.put("HTLX", ht.getHtlx());
	        map.put("HTLXMC", CacheUtil.getInstance().getCache("ZYDM_"+ht.getHtlx()));
	        map.put("HTMX", JsonUtil.BuildJson(listMapMx));
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	public String excuteJsdbh(String htbh) {
		int num = manager.getJsdNum(htbh);
		return String.format("%05d", num+1);
	}
	@SuppressWarnings("rawtypes")
	public String getHtmxFileResult(Set<HtmxBase> allHtMx) {
		List<Map> listMap = new ArrayList<Map>();
		for(HtmxBase htmx:allHtMx){
			Map<String, String> map = new HashMap<String, String>();
			/*String xh = htmx.xh;
			if((htmx.xh).indexOf(".")>0){
				xh = (htmx.xh).substring(0,(htmx.xh).indexOf("."));
			}*/
			map.put("xh", htmx.xh);
			map.put("htmxZymc", htmx.htmxZymc);
	        map.put("htmxGg", htmx.htmxGg);
	        map.put("htmxDw", htmx.htmxDw);
	        map.put("htmxDj", htmx.htmxDj);
	        map.put("htmxSl", htmx.htmxSl);
	        map.put("htmxZj", htmx.htmxZj);
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	@SuppressWarnings("unchecked")
	public String saveHtsj(String tableData, Map<String, String> map) {
		 String result = "";
		 try {
			HeTongVo htVo = new HeTongVo();
			htVo.setGys(map.get("gys"));
			htVo.setHtbh(map.get("htbh"));
			htVo.setHtlx(map.get("htlx"));
			htVo.setHtmc(map.get("htmc"));
			htVo.setJbr(map.get("jbr"));
			htVo.setJsdwmc(map.get("jsdwmc"));
			htVo.setKzr(map.get("kzr"));
			htVo.setRq(DateUtil.stringToDate(map.get("rq"), "yyyy-MM-dd"));
			htVo.setTbr(map.get("tbr"));
			htVo.setTbrq(new Date());
			htVo.setXmid(map.get("xmdm"));
			htVo.setXmmc(map.get("xmmc"));
			htVo.setEnabled(true);
	 		Map<String, Object> mapData = JsonUtil.parseJSON2Map(tableData);
	 		List<Map<String, Object>> mapTable = (List<Map<String, Object>>)mapData.get("data");
	 		double htzj = 0;
			for(int i = 0;i<mapTable.size();i++){
				HeTongMxVo htmxVo = new HeTongMxVo();
				Map<String, Object> mapStr = mapTable.get(i);
				htmxVo.setHtbh(map.get("htbh"));
				htmxVo.setDanjia(Double.parseDouble(mapStr.get("htmxDj").toString()));
				htmxVo.setGuige(mapStr.get("htmxGg").toString());
				htmxVo.setZydm("");
				htmxVo.setZymc(mapStr.get("htmxZymc").toString());
				htmxVo.setDanwei(mapStr.get("htmxDw").toString());
				String sl = mapStr.get("htmxSl").toString();
				htmxVo.setShuliang(Integer.parseInt(sl));
				double zj = Double.parseDouble(mapStr.get("htmxZj").toString());
				htmxVo.setZongjia(zj);
				htmxVo.setEnabled(true);
				manager.saveHtmx(htmxVo);
				htzj = htzj + zj;
	        }
			htVo.setHtzj(htzj);
			manager.saveHt(htVo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	@SuppressWarnings("rawtypes")
	public String searchHtmxlist(QxUser user) {
		List<XiangMuVo> xmList = manager.getXiangMuList(user);
		List<Map> listMap = new ArrayList<Map>();
		int xh = 1;
		for(int k = 0;k<xmList.size();k++){
			XiangMuVo xm = xmList.get(k);
			List<HeTongVo> list = manager.searchHtlist(xm.getId());
			for(int i=0;i<list.size();i++){
				HeTongVo ht = list.get(i);
				List<HeTongMxVo> mxList = manager.searchHtmxlist(ht.getHtbh());
				for(int j=0;j<mxList.size();j++){
					HeTongMxVo mx = mxList.get(j);
					Map<String, String> map = new HashMap<String, String>();
	                map.put("XH", String.valueOf(xh));
	                map.put("XMMC", ht.getXmmc());
	                map.put("LB", CacheUtil.getInstance().getCache("ZYDM_"+ht.getHtlx()));
	                map.put("HTBH", ht.getHtbh());
	                map.put("HTMC", ht.getHtmc());
	                map.put("ZYMC", mx.getZymc());
	                map.put("GG", mx.getGuige());
	                map.put("DW", mx.getDanwei());
	                map.put("DJ", String.valueOf(mx.getDanjia()));
	                map.put("JBR", ht.getJbr());
	                map.put("GYS", ht.getGys());
	                map.put("KZR", ht.getKzr());
	                map.put("QDRQ", DateUtil.dateTo10String(ht.getRq()));
			        listMap.add(map);
			        xh++;
				}
			}
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	@SuppressWarnings("rawtypes")
	public String getJcmxFileResult(JcmxBase jcmxBase) {
		Map<String,String> mapRes = new HashMap<String, String>();
		mapRes.put("jcmxJsdw", jcmxBase.jcmxJsdw);
		mapRes.put("jcmxJsxm", jcmxBase.jcmxJsxm);
		mapRes.put("jcmxGg", jcmxBase.jcmxGg);
		mapRes.put("jcmxGhrq", jcmxBase.jcmxGhrq);
		mapRes.put("jcmxZs", jcmxBase.jcmxZs);
		
		List<Map> listMap = new ArrayList<Map>();
		for(JcmxDetail jcdetal:jcmxBase.jcmxDetail){
			Map<String, String> map = new HashMap<String, String>();
			/*String xh = jcdetal.jcmxXh;
			if(xh.indexOf(".")>0){
				xh = xh.substring(0,xh.indexOf("."));
			}*/
			map.put("jcmxXh", jcdetal.jcmxXh);
			/*String ph = jcdetal.jcmxPh;
			if(ph.indexOf(".")>0){
				ph = ph.substring(0,ph.indexOf("."));
			}*/
			map.put("jcmxPh", jcdetal.jcmxPh);
			/*String sl = jcdetal.jcmxSl;
			if(sl.indexOf(".")>0){
				sl = sl.substring(0,sl.indexOf("."));
			}*/
	        map.put("jcmxSl", jcdetal.jcmxSl);
	        listMap.add(map);
		}
		mapRes.put("jcmxDetail", JsonUtil.BuildJson(listMap));
        String result = JsonUtil.BuildJson(mapRes);
        return result;
	}
	@SuppressWarnings("unchecked")
	public String saveJsd(String tableData, Map<String, String> map) {
		String result = "";
		 try {
			JieSuanDanVo jsdVo = new JieSuanDanVo();
			//map.put("jsxmgg", request.getParameter("jsxmgg"));
			jsdVo.setHtbh(map.get("htbh"));
			jsdVo.setJsdbh(map.get("jsdbh"));
			jsdVo.setLeibie(map.get("lb"));
			jsdVo.setRq(DateUtil.stringToDate(map.get("rq"), "yyyy-MM-dd"));
			jsdVo.setTBR(map.get("tbr"));
			jsdVo.setTbsj(new Date());
			jsdVo.setXmmc(map.get("xmmc"));
			jsdVo.setEnabled(true);
			jsdVo.setZje(Double.parseDouble(map.get("jsdzj")));
			jsdVo.setYsqbz('N');
	 		List<Map<String, Object>> mapData = JsonUtil.parseJSON2List(tableData);
	 		String detail = mapData.get(0).get("jcmxDetail").toString();
	 		Map<String, Object> mapDetail = JsonUtil.parseJSON2Map(detail);
	 		List<Map<String, Object>> mapTable = (List<Map<String, Object>>)mapDetail.get("data");
			for(int i = 0;i<mapTable.size();i++){
				JsdMxVo jsdmxVo = new JsdMxVo();
				Map<String, Object> mapStr = (Map<String, Object>) mapTable.get(i);
				jsdmxVo.setJsdbh(map.get("jsdbh"));
				String[] jsxmgg = map.get("jsxmgg").split("/");
				jsdmxVo.setZydm(jsxmgg[0]);
				jsdmxVo.setDjh(mapStr.get("jcmxPh").toString());
				jsdmxVo.setEnabled(true);
				jsdmxVo.setGg(jsxmgg[1]);
				String sl = mapStr.get("jcmxSl").toString();
				jsdmxVo.setSl(Integer.parseInt(sl));
				manager.saveJsdmx(jsdmxVo);
	        }
			manager.saveJsd(jsdVo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	@SuppressWarnings("rawtypes")
	public String searchJsdlist(String htbh) {
		List<Map> listMap = new ArrayList<Map>();
		List<JieSuanDanVo> jsdList = manager.getJsdList(htbh);
		for(int i=0;i<jsdList.size();i++){
			JieSuanDanVo jsd = jsdList.get(i);
			Map<String, String> map = new HashMap<String, String>();
            map.put("XH", String.valueOf(i+1));
            map.put("XMMC", jsd.getXmmc());
            map.put("LB", CacheUtil.getInstance().getCache("ZYDM_"+jsd.getLeibie()));
            map.put("JSDBH", jsd.getJsdbh());
            map.put("HTBH", jsd.getHtbh());
            map.put("JE", String.valueOf(jsd.getZje()));
            String jjsj = "";
            if(jsd.getJjsj()!=null){
            	jjsj = DateUtil.dateTo10String(jsd.getJjsj());
            }
            map.put("JJSJ", jjsj);
            String shsj = "";
            if(jsd.getShsj()!=null){
            	shsj = DateUtil.dateTo10String(jsd.getShsj());
            }
            map.put("SHSJ", shsj);
            List<ShouQuanDo> sqList = manager.getSqListByJsdbh(jsd.getJsdbh());
            double ysqje = 0;
            double ysqwshje = 0;
            for(ShouQuanDo sq : sqList){
            	if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_XJSQ)){
            		ysqwshje += sq.getSqje();
            	}
            	ysqje += sq.getSqje();
            }
            map.put("YSQCS", String.valueOf(sqList.size()));
            map.put("YSQJE", String.valueOf(ysqje));
            map.put("WSQJE", String.valueOf(jsd.getZje() - ysqje));
            map.put("YSQYSHJE", String.valueOf(ysqje-ysqwshje));
            map.put("YSQWSHJE", String.valueOf(ysqwshje));
            map.put("JSRQ", DateUtil.dateTo10String(jsd.getTbsj()));
		    listMap.add(map);
		
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	public String searchPrintJsd(String jsdbh) {
        
        Map<String,String> mapRes = new HashMap<String, String>();
        JieSuanDanVo jsd = manager.getJsd(jsdbh);
        mapRes.put("HTBH", jsd.getHtbh());
		mapRes.put("RQFW", DateUtil.dateTo10String(jsd.getRq()));
		mapRes.put("JSDW", "");
		mapRes.put("JSRQ", DateUtil.dateTo10String(jsd.getTbsj()));
		String je = String.valueOf(jsd.getZje());
		mapRes.put("JSJE", je);
		mapRes.put("JSJEDX", StringUtil.getCnString(je));//结算金额大写
		mapRes.put("DYCS", String.valueOf(jsd.getDycs()));
		
		mapRes.put("JSXM", CacheUtil.getInstance().getCache("ZYDM_"+jsd.getLeibie()));
		mapRes.put("GG", "");
		mapRes.put("SL", "");
		mapRes.put("DW", "");
		mapRes.put("DJ", "");
		mapRes.put("LK", String.valueOf(jsd.getZje()));
		mapRes.put("SFHS", "sfhs");
        String result = JsonUtil.BuildJson(mapRes);
        return result;
	}
	public void qrsq(String jsdbh, double sqje) {
		manager.qrsq(jsdbh,sqje);
	}


	public String sqsh(String sqid, boolean istg) {
		try{
			manager.sqsh(sqid,istg);
			return "成功";
		}
		catch(Exception e){
			return "失败";
		}
	}
	@SuppressWarnings("rawtypes")
	public String searchSqDsh(String htbh) {
		List<Map> listMap = new ArrayList<Map>();
		List<JieSuanDanVo> jsdList = manager.getJsdList(htbh);
		for(int i=0;i<jsdList.size();i++){
			JieSuanDanVo jsd = jsdList.get(i);
			List<ShouQuanDo> sqList = manager.getSqListByJsdbh(jsd.getJsdbh());
            for(int j=0;j<sqList.size();j++){
            	ShouQuanDo sq = sqList.get(j);
            	Map<String, String> map = new HashMap<String, String>();
                map.put("XH", String.valueOf(i*sqList.size()+j+1));
                map.put("ID", sq.getId());
                map.put("JSDBH", jsd.getJsdbh());
                map.put("JE", String.valueOf(jsd.getZje()));
                map.put("BCSQJE", String.valueOf(sq.getSqje()));
                map.put("YSQCS", String.valueOf(sqList.size()));
                map.put("SQLY", sq.getSqly()==null?"":sq.getSqly());
                String sqjg = "";
                if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_XJSQ)){
                	sqjg = "未审核";
                }else if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_SHTG)){
                	sqjg = "审核通过";
                }else if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_SHSB)){
                	sqjg = "审核不通过";
                }
                
                map.put("SQJG", sqjg);
                map.put("YSQBZ", sq.getYsqbz()=='Y'?"预授权":"非预授权");
    		    listMap.add(map);
            }
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	public String ysq(String htbh, String yusqje, String ysqly) {
		String jsdbh = htbh+"-预授权-"+excuteJsdbh(htbh);
		try{
			manager.ysq(htbh,jsdbh,Double.parseDouble(yusqje),ysqly);
			return "成功";
		}
		catch(Exception e){
			return "失败";
		}
	}
	public String scfktzd(String sqid) {
		try{
			manager.scfktzd(sqid);
			return "成功";
		}
		catch(Exception e){
			return "失败";
		}
	}
	@SuppressWarnings("rawtypes")
	public String searchScfktzd(String htbh) {
		List<Map> listMap = new ArrayList<Map>();
		List<JieSuanDanVo> jsdList = manager.getJsdList(htbh);
		for(int i=0;i<jsdList.size();i++){
			JieSuanDanVo jsd = jsdList.get(i);
			List<ShouQuanDo> sqList = manager.getSqListByJsdbh(jsd.getJsdbh());
            for(int j=0;j<sqList.size();j++){
            	ShouQuanDo sq = sqList.get(j);
            	
            	Map<String, String> map = new HashMap<String, String>();
                map.put("XH", String.valueOf(i*sqList.size()+j+1));
                map.put("ID", sq.getId());
                map.put("JSDBH", jsd.getJsdbh());
                map.put("JE", String.valueOf(jsd.getZje()));
                map.put("SQJE", String.valueOf(sq.getSqje()));
                map.put("YSQCS", String.valueOf(sqList.size()));
                String clzt = "";
                if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_XJSQ)){
                	clzt = "未审核";
                }else if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_SHTG)){
                	clzt = "审核通过";
                }else if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_SHSB)){
                	clzt = "审核不通过";
                }else if(sq.getClzt().equals(ConstantUtil.SHOUQUAN_CLZT_SCFKTZD)){
                	clzt = "已生成付款通知单";
                }
                map.put("CLZTDM", sq.getClzt());
                map.put("CLZT", clzt);
    		    listMap.add(map);
            }
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	@SuppressWarnings("rawtypes")
	public String searchFktzd(String htbh) {
		List<Map> listMap = new ArrayList<Map>();
		List<JieSuanDanVo> jsdList = manager.getJsdList(htbh);
		for(int i=0;i<jsdList.size();i++){
			JieSuanDanVo jsd = jsdList.get(i);
			List<ShouQuanDo> sqList = manager.getSqListByJsdbh(jsd.getJsdbh());
            for(int j=0;j<sqList.size();j++){
            	ShouQuanDo sq = sqList.get(j);
            	Map<String, String> map = new HashMap<String, String>();
                map.put("XH", String.valueOf(i*sqList.size()+j+1));
                map.put("ID", sq.getId());
                map.put("XMMC", jsd.getXmmc());
                map.put("HTBH", htbh);
                map.put("JSDBH", jsd.getJsdbh());
                map.put("JE", String.valueOf(jsd.getZje()));
                map.put("SQJE", String.valueOf(sq.getSqje()));
                map.put("YSQCS", String.valueOf(sqList.size()));
                map.put("YFKJE", "yfkje");
    		    listMap.add(map);
            }
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	public String initZjrbTable() {
		Map<String, String> mapResult = new HashMap<String, String>();
		mapResult.put("TABLE",initZjrbTableString() );
		mapResult.put("ZJRBJE",initZjrbJe() );
		String result = JsonUtil.BuildJson(mapResult);
	    return result;
	}

	@SuppressWarnings("rawtypes")
	public String initZjrbTableString() {
		Map<String, List> mapResult = new HashMap<String, List>();
		
		List<Map> hkgcsrlist = new ArrayList<Map>();
		List<Map> hkqtlist = new ArrayList<Map>();
		List<Map> fkzjfylist = new ArrayList<Map>();
		List<Map> fkjjfylist = new ArrayList<Map>();
		List<Map> fkqtlist = new ArrayList<Map>();
		List<DmZjrbXm> zirbdmList = manager.getZjrbXmList();
		for(int j=0;j<zirbdmList.size();j++){
			DmZjrbXm zjrbxm = zirbdmList.get(j);
        	Map<String, String> map = new HashMap<String, String>();
            map.put("ZJRBXMDM", zjrbxm.getZjrbXmDm());
            map.put("ZJRBXMMC", zjrbxm.getZjrbXmMc());
            map.put("ZJRBXMTYPE", zjrbxm.getZjrbXmTypeDm());
            map.put("ZJRBXMTYPENAME", CacheUtil.getInstance().getCache("ZJRB_XM_TYPE_"+zjrbxm.getZjrbXmTypeDm()));
		    if("1".equals(zjrbxm.getZjrbXmTypeDm())){
		    	hkgcsrlist.add(map);
		    }else if("2".equals(zjrbxm.getZjrbXmTypeDm())){
		    	hkqtlist.add(map);
		    }else if("3".equals(zjrbxm.getZjrbXmTypeDm())){
		    	fkzjfylist.add(map);
		    }else if("4".equals(zjrbxm.getZjrbXmTypeDm())){
		    	fkjjfylist.add(map);
		    }else if("5".equals(zjrbxm.getZjrbXmTypeDm())){
		    	fkqtlist.add(map);
		    } 
        }
		mapResult.put("HKGCSR", hkgcsrlist);
		mapResult.put("HKQT", hkqtlist);
		mapResult.put("FKZJFY", fkzjfylist);
		mapResult.put("FKJJFY", fkjjfylist);
		mapResult.put("FKQT", fkqtlist);
		String result = JsonUtil.BuildJson(mapResult);
	    return result;
	}
	public String initZjrbJe() {
		Map<String, String> mapResult = new HashMap<String, String>();
		ZjrbVo zjrb = manager.getZjrbLast();
		if(zjrb==null){
			mapResult.put("QCJE1", String.valueOf(0));
			mapResult.put("QCJE2", String.valueOf(0));
			mapResult.put("QCJE3", String.valueOf(0));
			mapResult.put("QCJE4", String.valueOf(0));
			mapResult.put("QCJE", String.valueOf(0));
		}
		else{
			mapResult.put("QCJE1", String.valueOf(zjrb.getQmyeA()));
			mapResult.put("QCJE2", String.valueOf(zjrb.getQmyeB()));
			mapResult.put("QCJE3", String.valueOf(zjrb.getQmyeC()));
			mapResult.put("QCJE4", String.valueOf(zjrb.getQmyeD()));
			mapResult.put("QCJE", String.valueOf(zjrb.getQmyeE()));
		}
		String result = JsonUtil.BuildJson(mapResult);
	    return result;
	}
	public String saveZjrb(Map<String, String> map) {
		ZjrbVo zjrb = manager.getZjrb(new Date());
		if(zjrb==null){
			zjrb = new ZjrbVo();
		}
		else{
			manager.deleteZjrbMx(zjrb.getId());
		}
		String data = map.get("data").replaceAll("\\r" , "").replaceAll("\\t", "").replaceAll("\\n", "");
		zjrb.setContent(data);
		Log.info(data);
		zjrb.setEnabled(true);
		
		zjrb.setQmyeA(Double.parseDouble(map.get("qmye1")));
		zjrb.setQmyeB(Double.parseDouble(map.get("qmye2")));
		zjrb.setQmyeC(Double.parseDouble(map.get("qmye3")));
		zjrb.setQmyeD(Double.parseDouble(map.get("qmye4")));
		zjrb.setQmyeE(Double.parseDouble(map.get("qmye")));
		//zjrb.setZbr(zbr);
		//zjrb.setTbdw(tbdw);
		//zjrb.setCwzg(cwzg);
		try {
			zjrb.setTbrq(DateUtil.stringToDate(DateUtil.dateToString(new Date())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		manager.saveZjrb(zjrb);
		String array = map.get("array");
		List<Map<String, Object>> list = JsonUtil.parseJSON2List("["+array+"]");
		for(int n = 0;n<list.size();n++){
			Map<String, Object> mapMx = list.get(n);
			ZjrbMxVo vo = new ZjrbMxVo();
			vo.setEnabled(true);
			vo.setJe(Double.parseDouble(mapMx.get("je").toString()));
			vo.setKxtype(mapMx.get("kxtype").toString());
			vo.setLeibie(mapMx.get("type").toString());
			vo.setZjrb_id(zjrb.getId());
			vo.setZjrbxmdm(mapMx.get("zjrbxmdm").toString());
			manager.save(vo);
		}
		return "success";
	}
	public String searchZjrb(String rq) {
		Date date = new Date();
		try {
			date = DateUtil.stringToDate(rq);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ZjrbVo zjrb = manager.getZjrb(date);
		if(zjrb==null){
			return "没有数据";
		}
		return zjrb.getContent();
	}
	public String searchZjrb(String rqq, String rqz) {
		return "zjrbhj";
	}
}
