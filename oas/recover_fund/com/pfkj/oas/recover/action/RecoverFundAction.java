package com.pfkj.oas.recover.action;

import com.pfkj.oas.action.BaseAction;
import com.pfkj.oas.recover.service.IncomeContractService;

/**
 * 回收资金Action
 * @author xiao yi
 *
 */
public class RecoverFundAction extends BaseAction {
	//收入合同管理
	private IncomeContractService incomeContractService;

	public IncomeContractService getIncomeContractService() {
		return incomeContractService;
	}

	public void setIncomeContractService(IncomeContractService incomeContractService) {
		this.incomeContractService = incomeContractService;
	}
	
}
