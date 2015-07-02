package com.pfkj.oas.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.pfkj.oas.manager.SkManager;
import com.pfkj.oas.model.HeTongVo;
import com.pfkj.oas.model.SktzdVo;
import com.pfkj.oas.model.SrHeTongVo;

public class SkService {
	SkManager manager;
	
	public SkManager getManager() {
		return manager;
	}

	public void setManager(SkManager manager) {
		this.manager = manager;
	}

	public boolean saveHt(HeTongVo htVo) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean saveSrht(SrHeTongVo htVo) {
		return manager.saveSrht(htVo);
	}

	public boolean saveSktzd(SktzdVo sktzd) {
		return manager.saveSktzd(sktzd);
	}

	
	public String searchSktzd(String str) throws JDOMException, IOException{
		
		StringBuffer result = new StringBuffer();
        /** *创建一个新的字符串*** */  
        StringReader xmlReader = new StringReader(str);  
        /** **创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入 */  
        InputSource xmlSource = new InputSource(xmlReader);  
        /** *创建一个SAXBuilder* */  
        SAXBuilder builder = new SAXBuilder();  
        /** *通过输入源SAX构造一个Document** */  
        org.jdom.Document doc = builder.build(xmlSource);  
        /** *获得根节点** */  
        org.jdom.Element elt = doc.getRootElement();  
        /** *获得节点** */  
        String htbh = elt.getChild("HTBH").getText();  
        String yzmc = elt.getChild("YZMC").getText();  
        String sj = elt.getChild("SJ").getText().replace("-", "");  
        String gclb = elt.getChild("GCLB").getText();  
        List<SktzdVo> list = manager.searchSktzd(htbh,yzmc,sj,gclb);
       
        for (int i = 0;i<list.size();i++) {
        	SktzdVo sktzdVo = (SktzdVo)list.get(i);
        	result.append("<tr><td>");
        	result.append(i+1);
        	result.append("</td><td>");
        	result.append(sktzdVo.getJlqs());
        	result.append("</td><td>");
        	result.append(sktzdVo.getJlrq());
        	result.append("</td><td>");
        	result.append(sktzdVo.getJlk());
        	result.append("</td><td>");
        	result.append(sktzdVo.getZbj());
        	result.append("</td><td>");
        	result.append(sktzdVo.getNmggzbzj());
        	result.append("</td><td>");
        	result.append(sktzdVo.getQtkk());
        	result.append("</td></tr>");
		}
        return result.toString(); 
	}
}
