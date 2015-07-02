package com.pfkj.oas.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jdom.JDOMException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.qx.UserService;
import com.pfkj.oas.service.JsdService;

public class JsdglAction extends BaseAction {
	
	private String pageInfo;
	private String pageData;
	private JsdService service;
	@SuppressWarnings("rawtypes")
	private UserService userService;
	public JsdService getService() {
		return service;
	}
	public void setService(JsdService service) {
		this.service = service;
	}
	public String getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}
	public String getPageData() {
		return pageData;
	}
	public void setPageData(String pageData) {
		this.pageData = pageData;
	}
	
	@SuppressWarnings("rawtypes")
	public UserService getUserService() {
		return userService;
	}
	@SuppressWarnings("rawtypes")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//确认复核结算单
	public String qrfhJsd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("xmlStr");
		try {
			pageInfo =  service.qrfhJsd(str);
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
	
	//查询合同名称列表
	public String searchHtlist() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
        pageInfo =  service.searchHtlist();
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

	//交接结算单
	public String jjJsd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String jsdbh = request.getParameter("jsdbh");
		service.jjJsd(jsdbh);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		pw.print("success");
		pw.flush();
		pw.close(); 
		return null;
	}
	//复核结算单
	public String fhJsd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String jsdbh = request.getParameter("jsdbh");
		service.fhJsd(jsdbh);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		pw.print("success");
		pw.flush();
		pw.close(); 
		return null;
	}


	public String excuteHtbh() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String xmid = request.getParameter("xmid");
		String htlbdm = request.getParameter("htlbdm");
		String num = service.excuteHtbh(xmid,htlbdm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		pw.print(num);
		pw.flush();
		pw.close(); 
		return null;
	}
	
	public String searchZylist() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
        pageInfo =  service.searchZylist();
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
	

	//查询合同名称列表
	public void getHthbList() throws IOException{
		String result = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		QxUser user= null;
		if(principal instanceof UserDetails){  
			String username = ((UserDetails)principal).getUsername();  
			user = userService.findByUserAccount(username);
		}
		result =  service.searchHthblist(user);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		pw.print(result);
		pw.flush();
		pw.close(); 
	}
	
	public void getHtList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String xmdm = request.getParameter("xmdm");
		String result = service.getHtList(xmdm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void excuteJsdbh(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String htbh = request.getParameter("htbh");
		String num = service.excuteJsdbh(htbh);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(num);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	//保存结算合同数据
	public void saveHtsj(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Map<String,String> map = new HashMap<String,String>();
		String tableData = request.getParameter("table");
		try {
			map.put("xmmc", java.net.URLDecoder.decode(request.getParameter("xmmc"),"UTF-8"));
		} catch (UnsupportedEncodingException e2) {
			map.put("xmmc", request.getParameter("xmmc"));
			e2.printStackTrace();
		}
		map.put("xmdm", request.getParameter("xmdm"));
		map.put("hthbbh", request.getParameter("hthbbh"));
		map.put("htlx", request.getParameter("htlx"));
		map.put("htbh", request.getParameter("htbh"));
		map.put("rq", request.getParameter("rq"));
		map.put("htmc", request.getParameter("htmc"));
		map.put("jsdwmc", request.getParameter("jsdwmc"));
		map.put("gys", request.getParameter("gys"));
		map.put("kzr", request.getParameter("kzr"));
		map.put("jbr", request.getParameter("jbr"));
		map.put("tbr", request.getParameter("tbr"));
		try {
			tableData = new String(tableData.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			result = service.saveHtsj(tableData, map);
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void searchHtsj(){
		String result = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		String username="";
		if(principal instanceof UserDetails){  
			username = ((UserDetails)principal).getUsername();  
		}
		QxUser user= userService.findByUserAccount(username);
		result =  service.searchHtmxlist(user);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void saveJsd(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Map<String,String> map = new HashMap<String,String>();
		String tableData = request.getParameter("table");
		map.put("xmdm", request.getParameter("xmdm"));
		try {
			map.put("xmmc", java.net.URLDecoder.decode(request.getParameter("xmmc"),"UTF-8"));
		} catch (UnsupportedEncodingException e2) {
			map.put("xmmc", request.getParameter("xmmc"));
			e2.printStackTrace();
		}
		map.put("htbh", request.getParameter("htbh"));
		map.put("jsdbh", request.getParameter("jsdbh"));
		map.put("lb", request.getParameter("lb"));
		map.put("jsxmgg", request.getParameter("jsxmgg"));
		map.put("rq", request.getParameter("rq"));
		map.put("tbr", request.getParameter("tbr"));
		map.put("jsdzj", request.getParameter("jsdzj"));
		try {
			tableData = new String(tableData.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			result = service.saveJsd(tableData, map);
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void searchJsd(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String htbh = request.getParameter("htbh");
		result =  service.searchJsdlist(htbh);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getPrintJsd(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String jsdbh ="";
		try {
			jsdbh = java.net.URLDecoder.decode(request.getParameter("jsdbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			jsdbh = request.getParameter("jsdbh");
		}
		result =  service.searchPrintJsd(jsdbh);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void searchJsdSq(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String htbh ="";
		try {
			htbh = java.net.URLDecoder.decode(request.getParameter("htbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			htbh = request.getParameter("htbh");
		}
		result =  service.searchJsdlist(htbh);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void qrsq(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String jsdbh ="";
		try {
			jsdbh = java.net.URLDecoder.decode(request.getParameter("jsdbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			jsdbh = request.getParameter("jsdbh");
		}
		String sqje = request.getParameter("sqje");
		service.qrsq(jsdbh,Double.valueOf(sqje));
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;try {
			pw = response.getWriter();
			pw.print("成功");
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void sqsh(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String sqid = request.getParameter("sqid");
		boolean istg = request.getParameter("istg").equals("true");
		String result = service.sqsh(sqid,istg);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void searchSqDsh(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String htbh ="";
		try {
			htbh = java.net.URLDecoder.decode(request.getParameter("htbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			htbh = request.getParameter("htbh");
		}
		String result = service.searchSqDsh(htbh);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void ysq(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String htbh ="";
		String ysqly ="";
		try {
			htbh = java.net.URLDecoder.decode(request.getParameter("htbh"),"UTF-8");
			ysqly = java.net.URLDecoder.decode(request.getParameter("ysqly"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			htbh = request.getParameter("htbh");
			ysqly = request.getParameter("ysqly");
		}
		String yusqje = request.getParameter("yusqje");
		String result = service.ysq(htbh,yusqje,ysqly);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void scfktzd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String sqid = request.getParameter("sqid");
		String result = service.scfktzd(sqid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void searchScfktzd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String htbh ="";
		try {
			htbh = java.net.URLDecoder.decode(request.getParameter("htbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			htbh = request.getParameter("htbh");
		}
		String result = service.searchScfktzd(htbh);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void searchFktzd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String htbh ="";
		try {
			htbh = java.net.URLDecoder.decode(request.getParameter("htbh"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			htbh = request.getParameter("htbh");
		}
		String result = service.searchFktzd(htbh);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void initZjrbTable(){
		String result = service.initZjrbTable();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void saveZjrb(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String,String> map = new HashMap<String,String>();
		String data ="";
		try {
			data = java.net.URLDecoder.decode(request.getParameter("data"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
			data = request.getParameter("data");
		}
		map.put("data", data);
		map.put("qmye1", request.getParameter("qmye1"));
		map.put("qmye2", request.getParameter("qmye2"));
		map.put("qmye3", request.getParameter("qmye3"));
		map.put("qmye4", request.getParameter("qmye4"));
		map.put("qmye", request.getParameter("qmye"));
		map.put("array", request.getParameter("array"));
		String result = service.saveZjrb(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void searchZjrb(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = "";
		String type = request.getParameter("type");
		if("0".equals(type)){
			String rqq = request.getParameter("rqq");
			String rqz = request.getParameter("rqz");
			result = service.searchZjrb(rqq,rqz);
		}
		else{
			String rq = request.getParameter("rq").replaceAll("-", "");
			result = service.searchZjrb(rq);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
