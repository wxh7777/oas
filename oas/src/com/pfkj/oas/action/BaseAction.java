package com.pfkj.oas.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class BaseAction implements Action {

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
        
		return SUCCESS;
	}

	// 测试方法
	public String test() {
		System.out.println("action success");
		return SUCCESS;
	}
}
