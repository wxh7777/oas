package com.pfkj.oas.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jdom.JDOMException;

import com.pfkj.oas.service.FkService;


public class FkglAction extends BaseAction {
	private FkService service;

	public FkService getService() {
		return service;
	}
	public void setService(FkService service) {
		this.service = service;
	}
	
	
	//录入资金日报
	public String saveZjrb() throws JDOMException, IOException{
		return null;
	}
	

	//查询已授权结算单
	public String searchScfktzd() throws IOException{
		return null;
	}

	//生成付款通知单
	public String scfktzd() throws IOException{
		return null;
	}

	//
	public String searchJsdSq(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String htbh = request.getParameter("htbh");
		//result =  service.searchJsdlist(htbh);
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
		return htbh; 
	}

	//
	public void qrsq() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String jsdbh = request.getParameter("jsdbh");
        String sqje = request.getParameter("sqje");
		service.qrsq(jsdbh,Double.valueOf(sqje));
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		pw.print("success");
		pw.flush();
		pw.close(); 
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
}
