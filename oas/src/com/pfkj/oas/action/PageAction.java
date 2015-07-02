package com.pfkj.oas.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class PageAction extends BaseAction {
	private String pageInfo;
	private File myFile;  
	
	
	public File getMyFile() {
		return myFile;
	}


	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}


	public String getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}


	public String success(){
		pageInfo="success";
		return "success";
	}
	
	public String fail(){
		pageInfo="error";
		return "fail";
	}
	
	@SuppressWarnings("unused")
	public void isLogin() throws IOException{
		

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Enumeration<String> userName = request.getSession().getAttributeNames();
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		Object principal =  SecurityContextHolder.getContext()  
				  .getAuthentication().getPrincipal();  
		if(principal instanceof UserDetails){  
		  String username = ((UserDetails)principal).getUsername();  
		  Iterator<GrantedAuthority> it = ((UserDetails)principal).getAuthorities().iterator();  
		  String authority = "";  
		  while(it.hasNext()){  
		    authority = ((GrantedAuthority)it.next()).getAuthority();  
		    //System.out.println("Authority:"+authority);  
		  }
		  pw.print("islogin");
		}
		else{
			pw.print("nologin");
		}
		
		pw.flush();
		pw.close(); 
	}
	
	

	public void uploadFile() throws IOException{
		
	}
}
