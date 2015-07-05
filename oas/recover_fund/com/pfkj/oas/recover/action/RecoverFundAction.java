package com.pfkj.oas.recover.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.json.JsonObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.pfkj.oas.action.BaseAction;
import com.pfkj.oas.recover.model.IncomeContract;
import com.pfkj.oas.recover.model.ReceivableNoticeCard;
import com.pfkj.oas.recover.service.IncomeContractService;
import com.pfkj.oas.recover.service.ReceivableNoticeCardService;
import com.pfkj.oas.util.DateUtil;
import com.pfkj.oas.util.JsonUtil;

/**
 * 回收资金Action
 * @author xiao yi
 *
 */
public class RecoverFundAction extends BaseAction {
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
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
		ReceivableNoticeCard receivableNoticeCard = new ReceivableNoticeCard();
		
		String xiangmuId = request.getParameter("xiangmuId");
		receivableNoticeCard.setXiangmuId(xiangmuId);
		
		String ownerName = request.getParameter("ownerName");
		receivableNoticeCard.setOwnerName(ownerName);
		
		try {
			String time = request.getParameter("time");
			if(time != null && !"".equals(time)){
				receivableNoticeCard.setTime(DateUtil.stringToDate(time));
			}
			
			String meteringTime = request.getParameter("meteringTime");
			if(meteringTime != null && !"".equals(meteringTime)){
				receivableNoticeCard.setMeteringTime(DateUtil.stringToDate(meteringTime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String projectType = request.getParameter("projectType");
		receivableNoticeCard.setProjectType(projectType);
		
		String meteringNum = request.getParameter("meteringNum");
		if(meteringNum !=null && !"".equals(meteringNum)){
			receivableNoticeCard.setMeteringNum(Integer.parseInt(meteringNum));
		}
		
		String meteringCash = request.getParameter("meteringCash");
		if(meteringCash !=null && !"".equals(meteringCash)){
			receivableNoticeCard.setMeteringCash(Double.parseDouble(meteringCash));
		}
		
		String warrantyCash = request.getParameter("warrantyCash");
		if(warrantyCash !=null && !"".equals(warrantyCash)){
			receivableNoticeCard.setWarrantyCash(Double.parseDouble(warrantyCash));
		}
		
		String farmerCash = request.getParameter("farmerCash");
		if(farmerCash !=null && !"".equals(farmerCash)){
			receivableNoticeCard.setFarmerCash(Double.parseDouble(farmerCash));
		}
		
		String otherCash = request.getParameter("otherCash");
		if(otherCash !=null && !"".equals(otherCash)){
			receivableNoticeCard.setOtherCash(Double.parseDouble(otherCash));
		}
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
		List<IncomeContract> incomeContractList = new ArrayList<IncomeContract>();
		Map queryMap = new HashMap();
		queryMap.put("XIANGMU_ID","11111139763039816337");
		incomeContractList = incomeContractService.searchList(queryMap);
		JsonUtil.output(response, JSONArray.fromObject(incomeContractList).toString());
	}
}
