package com.pfkj.oas.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfkj.oas.action.vo.AuthorityFormVo;
import com.pfkj.oas.action.vo.ProjectFormVo;
import com.pfkj.oas.action.vo.UserFormVo;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.service.QxService;

public class QxAction extends BaseAction {
	QxService service;
	private AuthorityFormVo authAdd;
	private UserFormVo userAdd;
	private ProjectFormVo proAdd;
	
	public ProjectFormVo getProAdd() {
		return proAdd;
	}

	public void setProAdd(ProjectFormVo proAdd) {
		this.proAdd = proAdd;
	}

	public UserFormVo getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(UserFormVo userAdd) {
		this.userAdd = userAdd;
	}

	public AuthorityFormVo getAuthAdd() {
		return authAdd;
	}

	public void setAuthAdd(AuthorityFormVo authAdd) {
		this.authAdd = authAdd;
	}

	public QxService getService() {
		return service;
	}

	public void setService(QxService service) {
		this.service = service;
	}

	public void getList(){
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
        String str = request.getParameter("param");
        if("user".equals(str)){
    		result =  service.searchUser();
        }
        else if("role".equals(str)){
    		result =  service.searchRole();
        }
        else if("authority".equals(str)){
    		result =  service.searchAuthority();
        }
        else if("resource".equals(str)){
    		result =  service.searchResource();
        }
        else if("project".equals(str)){
    		result =  service.searchProject();
        }
        else if("search".equals(str)){
    		result =  service.searchSearch();
        }
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw;
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	public String saveAuthority() {
		service.saveAuthority(authAdd);
		return "success";
	}

	public String saveUser() {
		service.saveUser(userAdd);
		return "success";
	}
	

	public String saveProject() {
		service.saveProject(proAdd);
		return "success";
	}
	public void delData(){
		HttpServletRequest request = ServletActionContext.getRequest();
        String str = request.getParameter("param");
        String id = request.getParameter("id");
        if("user".equals(str)){
    		service.deleteUser(id);
        }
        else if("authority".equals(str)){
    		service.deleteAuthority(id);
        }
        else if("resource".equals(str)){
    		service.deleteResource(id);
        }
        else if("project".equals(str)){
    		service.deleteProject(id);
        }
	}
	
	public void getProjectlist(){
		String result = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		QxUser user= null;
		if(principal instanceof UserDetails){  
			String username = ((UserDetails)principal).getUsername();  
			user = service.searchUserByAccount(username);
		}
    	result =  service.getProjects(user);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw;
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void getGnlbList(){
		String result = "";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		if(principal instanceof UserDetails){  
			String username = ((UserDetails)principal).getUsername();  
			String str = request.getParameter("param");
	        if("gnlb".equals(str)){
	        	result =  service.getGnlbStr(username);
	        }
		}
		System.out.println("用户功能列表："+result);
		response.reset();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter pw;
			pw = response.getWriter();
			pw.print(result);
			pw.flush();
			pw.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
