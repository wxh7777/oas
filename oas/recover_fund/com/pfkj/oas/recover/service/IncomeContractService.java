package com.pfkj.oas.recover.service;

import java.util.List;
import java.util.Map;

import com.pfkj.oas.recover.model.IncomeContract;

/**
 * 收入合同管理接口
 * @author xiao yi
 *
 */
public interface IncomeContractService {
	//添加
	public boolean insert(IncomeContract incomeContract);
	//删除
	public boolean delete(String id);
	//修改
	public boolean update(IncomeContract incomeContract);
	//查询主键
	public IncomeContract searchByID(String id);
	//查询一条
	public IncomeContract searchOne(Map queryMap);
	//查询多条
	public List<IncomeContract> searchList(Map queryMap);
	//更加当前登录用户的ID获取他管理的收入合同
	public List<Map> searchListByUserId(String userId);
	

}
