package com.pfkj.oas.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

public class IndexAction extends BaseAction {

	private String pageInfo;
	
	
	public String getPageInfo() {
		return pageInfo;
	}


	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String init(){
		Map<String, Object> map = ServletActionContext.getContext().getSession();
		if(!map.isEmpty()){
			this.pageInfo = "help.jsp";
			return "success";
		}
		else {
			return "fail";
		}
	}
}
