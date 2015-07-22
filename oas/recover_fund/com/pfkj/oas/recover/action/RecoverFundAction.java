package com.pfkj.oas.recover.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfkj.oas.action.BaseAction;
import com.pfkj.oas.recover.model.ReceivableNoticeCard;
import com.pfkj.oas.recover.service.IncomeContractService;
import com.pfkj.oas.recover.service.ReceivableNoticeCardService;
import com.pfkj.oas.util.JsonUtil;

/**
 * 回收资金Action
 * @author xiao yi
 *
 */
public class RecoverFundAction extends BaseAction {
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	//收款通知单 应该实现从页面自动注入model
	private ReceivableNoticeCard receivableNoticeCard;
	
	public ReceivableNoticeCard getReceivableNoticeCard() {
		return receivableNoticeCard;
	}

	public void setReceivableNoticeCard(ReceivableNoticeCard receivableNoticeCard) {
		this.receivableNoticeCard = receivableNoticeCard;
	}

	//收入合同管理
	private IncomeContractService incomeContractService;

	public IncomeContractService getIncomeContractService() {
		return incomeContractService;
	}

	public void setIncomeContractService(IncomeContractService incomeContractService) {
		this.incomeContractService = incomeContractService;
	}
	
	//通知单管理
	private ReceivableNoticeCardService receivableNoticeCardService;

	public ReceivableNoticeCardService getReceivableNoticeCardService() {
		return receivableNoticeCardService;
	}

	public void setReceivableNoticeCardService(
			ReceivableNoticeCardService receivableNoticeCardService) {
		this.receivableNoticeCardService = receivableNoticeCardService;
	}
	
	/**
	 * 执行收款通知单提交
	 */
	public String doReceivableNoticeCardSubmit(){
		int ret = -1;
		//获取用户名
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUsername();
		receivableNoticeCard.setUserId(userId);
		
		receivableNoticeCard.setCreateTime(new Date());
		receivableNoticeCard.setStatus(1);
		
		boolean res = receivableNoticeCardService.insert(receivableNoticeCard);
		if(res){
			ret = 1;
		}
		JsonUtil.output(response, ""+ret);
		
		return null;
	}
	
	/**
	 * 获取当前用户权限的项目所对应的集合
	 * @return
	 */
	public void getIncomeContractList(){
		List<Map> incomeContractList = new ArrayList<Map>();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		incomeContractList = incomeContractService.searchListByUserId(userName);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(incomeContractList).toString());
		JsonUtil.output(response, jsonObject.toString());
	}
	
	/**
	 * 获取收款通知单列表（暂时没说需要权限)
	 */
	public void getReceivalNoticeCardList(){
		List<Map> receivableNoticeCardList = new ArrayList<Map>();
		receivableNoticeCardList = receivableNoticeCardService.searchReceivalNoticeCardList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(receivableNoticeCardList).toString());
		JsonUtil.output(response, jsonObject.toString());
	}
	
	/**
	 * 根据Id获取收款通知单
	 * @param id
	 */
	public String getReceivalbeNoticeCardById(){
		String id = request.getParameter("id");
		String xiangMuName = "";
		try {
			xiangMuName = new String(request.getParameter("xiangMuName").getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ReceivableNoticeCard receivableNoticeCard = new ReceivableNoticeCard();
		receivableNoticeCard = receivableNoticeCardService.searchReceivalNoticeCardById(id);
		request.setAttribute("receivableNoticeCard", receivableNoticeCard);
		request.setAttribute("xiangMuName", xiangMuName);
		return "viewReceivalbeNoticeCard";
	}
	
	/**
	 * 获取项目汇总列表
	 * @return
	 */
	public void getReceivalNoticeCardTotalList(){
		List<Map> receivableNoticeCardTotalList = new ArrayList<Map>();
		receivableNoticeCardTotalList = receivableNoticeCardService.searchReceivalNoticeCardTotalList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", JSONArray.fromObject(receivableNoticeCardTotalList).toString());
		JsonUtil.output(response, jsonObject.toString());
		
	}
}
