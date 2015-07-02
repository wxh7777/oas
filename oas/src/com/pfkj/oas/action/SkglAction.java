package com.pfkj.oas.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.pfkj.oas.model.SktzdVo;
import com.pfkj.oas.model.SrHeTongVo;
import com.pfkj.oas.service.SkService;


public class SkglAction extends BaseAction {
	private String pageInfo;
	private SkService service;
	
	public String getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}


	public SkService getService() {
		return service;
	}
	public void setService(SkService service) {
		this.service = service;
	}
	
	//查询回收款
	public String searchHsk(){
		return "fail";
	}
	
	//查询收款通知单
	public String searchSktzd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("xmlStr");
        try {
			pageInfo =  service.searchSktzd(str);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(pageInfo==null||"".equals(pageInfo)){
			return "fail";
		}
		else{
			response.reset();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter(); 
			pw.print(pageInfo);
			pw.flush();
			pw.close(); 
			return null;
		}
	}
	//录入收入合同
	public String saveSrht() throws JDOMException, IOException{
		boolean result = true;
		HttpServletRequest request = ServletActionContext.getRequest();
        String str = request.getParameter("xmlStr");
        
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
        String htmc = elt.getChild("HTMC").getText();  
        String htje = elt.getChild("HTJE").getText();  
        String yzdwmc = elt.getChild("YZDWMC").getText();  
        String gcfl = elt.getChild("GCFL").getText();  
        String kgrq = elt.getChild("KGRQ").getText().replace("-", "");  
        String wgrq = elt.getChild("WGRQ").getText().replace("-", "");   
        String sjkgrq = elt.getChild("SJKGRQ").getText().replace("-", "");  
        String jgrq = elt.getChild("JGRQ").getText().replace("-", "");   
        String sjjsje = elt.getChild("SJJSJE").getText(); 
        String zbdwmc = elt.getChild("ZBDWMC").getText(); 
         
       
        org.jdom.Element table = elt.getChild("TABLE");  
        /** *获得body节点下面的所有子节点*** */  
        @SuppressWarnings("unchecked")
		List<org.jdom.Element> row = table.getContent();  
        for(int i = 0;i<row.size();i++){
        	org.jdom.Element rowcell =  row.get(i);
        	String zymc = rowcell.getChildText("ZYMC");
        	String gg = rowcell.getChildText("GG");
        	String dw = rowcell.getChildText("DW");
        	String mz = rowcell.getChildText("MZ");
        	String pz = rowcell.getChildText("PZ");
        	String sl = rowcell.getChildText("SL");
        	String gys = rowcell.getChildText("GYS");
        	 SrHeTongVo htVo = new SrHeTongVo();
        	 htVo.setHtmc(htmc);
        	 htVo.setHtbh(htbh);
        	 htVo.setHtje(htje);
        	 htVo.setJgrq(jgrq);
        	 htVo.setKgrq(kgrq);
        	 htVo.setSjjsje(sjjsje);
        	 htVo.setSjkgrq(sjkgrq);
        	 htVo.setDw(dw);
        	 htVo.setGcfl(gcfl);
        	 htVo.setGg(gg);
        	 htVo.setGys(gys);
        	 htVo.setMz(mz);
        	 htVo.setPz(pz);
        	 htVo.setSl(sl);
        	 htVo.setWgrq(wgrq);
        	 htVo.setYzdwmc(yzdwmc);
        	 htVo.setZbdwmc(zbdwmc);
             htVo.setZymc(zymc);
             htVo.setEnabled(true);
        	boolean saveSuc = service.saveSrht(htVo);
        	if(!saveSuc){
        		result = false;
        	}
        }
		pageInfo="save";
		if(result){
			return "success";
		}
		else{
			return "fail";
		}
	}
	//录入收款通知单
	public String saveSktzd() throws JDOMException, IOException{
		boolean result = true;
		HttpServletRequest request = ServletActionContext.getRequest();
        String str = request.getParameter("xmlStr");
        
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
        String jlqs = elt.getChild("JLQS").getText();  
        String jlrq = elt.getChild("JLRQ").getText().replace("-", "");  
        String jlk = elt.getChild("JLK").getText();   
        String zbj = elt.getChild("ZBJ").getText();  
        String nmggzbzj = elt.getChild("NMGGZBZJ").getText();   
        String qtkk = elt.getChild("QTKK").getText(); 

    	 SktzdVo sktzd = new SktzdVo();
    	 sktzd.setGclb(gclb);
    	 sktzd.setHtbh(htbh);
    	 sktzd.setJlk(jlk);
    	 sktzd.setJlqs(jlqs);
    	 sktzd.setJlrq(jlrq);
    	 sktzd.setNmggzbzj(nmggzbzj);
    	 sktzd.setQtkk(qtkk);
    	 sktzd.setSj(sj);
    	 sktzd.setYzmc(yzmc);
    	 sktzd.setZbj(zbj);
    	 sktzd.setEnabled(true);
         result = service.saveSktzd(sktzd);
        
		pageInfo="save";
		if(result){
			return "success";
		}
		else{
			return "fail";
		}
	}

}
