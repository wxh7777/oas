package com.pfkj.oas.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.pfkj.oas.dao.CacheDao;
import com.pfkj.oas.model.dm.DmHtlbVo;
import com.pfkj.oas.model.dm.DmZjrbXmType;
import com.pfkj.oas.model.dm.DmZyVo;


public class CacheUtil {
private static Logger logger = Logger.getLogger(CacheUtil.class);
	
	private static CacheUtil instance = null;
	
	private Cache cache;

	private CacheDao dao;
	
	public CacheDao getDao() {
		return dao;
	}

	public void setDao(CacheDao dao) {
		this.dao = dao;
		System.out.println("setter dao");
	}

	public void setCache(Cache cache) {
		this.cache = cache;
		System.out.println("setter cache");
	}
	
	public static CacheUtil getInstance() {
		if(null == instance) {
			instance = new CacheUtil();
		}
		return instance;
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private void setSysConfig() {

		System.out.println("setSysConfig");
		String path = getClass().getResource("/").getPath();
		path = path.substring(0, path.indexOf("classes/")) + "oas.properties";
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			p.load(fis);
			Set s = p.keySet();
			Iterator iter = s.iterator();
			String key = "";
			String value = "";
			while(iter.hasNext()) {
				key = iter.next().toString();
				value = p.getProperty(key);
				setCache(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("oas.properties关闭异常!");
				}
				fis = null;
			}
		}
		setCache("ZYDM",this.getDmZy());
		setCache("HTLBDM",this.getDmHtlb());
		setCache("ZJRBXMTYPEDM",this.getDmZjrbXmType());
		
	}
	
	public String getCache(String key) {
		if(cache.get(key)==null){
			return key;
		}
		return (String)cache.get(key).getObjectValue();
	}
	
	public void setCache(String key, String value) {
		Element element = new Element(key, value);
		cache.put(element);
		logger.info("设置缓存： key--" + key + ";value--" + value + "...");
	}
	public void setCache(String key, Object value) {
		Element element = new Element(key, value);
		cache.put(element);
		logger.info("设置缓存： key--" + key + ";value--" + value.getClass().toString() + "...");
	}
	@SuppressWarnings("rawtypes")
	private String getDmZy(){ 
		List<DmZyVo> list = dao.getZyDmList();
		List<Map> listMap = new ArrayList<Map>();
		for (int i=0;i<list.size();i++) {
			DmZyVo zy = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
	        map.put("ZYDM", zy.getZydm());
	        map.put("ZYMC", zy.getZymc());
	        map.put("ZYJB", zy.getZyjb());
	        map.put("SJZYDM", zy.getZysjdm());
	        listMap.add(map);
	        setCache("ZYDM_"+zy.getZydm(),zy.getZymc());
		}
	    String result = JsonUtil.BuildJson(listMap);
		return result;
	}

	private String getDmHtlb(){ 
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("[");
		List<DmHtlbVo> list = dao.getHtlbDmList();
		for (int i=0;i<list.size();i++) {
			DmHtlbVo htlb = list.get(i);
			if(i!=0){
				sBuffer.append(",");
			}
			sBuffer.append("{text:'");
			sBuffer.append(htlb.getHtlbmc());
			sBuffer.append("',value:'");
			sBuffer.append(htlb.getHtlbdm());
			sBuffer.append("'}");
		}
		sBuffer.append("]");
		return sBuffer.toString();
	}
	@SuppressWarnings("rawtypes")
	private String getDmZjrbXmType(){ 
		List<DmZjrbXmType> list = dao.getDmZjrbXmTypeList();
		List<Map> listMap = new ArrayList<Map>();
		for (int i=0;i<list.size();i++) {
			DmZjrbXmType type = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
	        map.put("ZJRB_XM_TYPE_DM", type.getKxTypeDm());
	        map.put("ZJRB_XM_TYPE_MC", type.getKxTypeMc());
	        listMap.add(map);
	        setCache("ZJRB_XM_TYPE_"+type.getKxTypeDm(),type.getKxTypeMc());
		}
	    String result = JsonUtil.BuildJson(listMap);
		return result;
	}
}
