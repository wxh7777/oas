package com.pfkj.oas.recover.service.impl;

import java.util.List;
import java.util.Map;

import com.pfkj.oas.recover.dao.IncomeContractDao;
import com.pfkj.oas.recover.model.IncomeContract;
import com.pfkj.oas.recover.service.IncomeContractService;

public class IncomeContractServiceImpl implements IncomeContractService {
	
	public IncomeContractDao incomeContractDao;

	public IncomeContractDao getIncomeContractDao() {
		return incomeContractDao;
	}

	public void setIncomeContractDao(IncomeContractDao incomeContractDao) {
		this.incomeContractDao = incomeContractDao;
	}

	@Override
	public boolean insert(IncomeContract incomeContract) {
		return incomeContractDao.insert(incomeContract);
	}

	@Override
	public boolean delete(String id) {
		return incomeContractDao.delete(id);
	}

	@Override
	public boolean update(IncomeContract incomeContract) {
		return incomeContractDao.update(incomeContract);
	}

	@Override
	public IncomeContract searchByID(String id) {
		return incomeContractDao.searchByID(id);
	}

	@Override
	public IncomeContract searchOne(Map queryMap) {
		return incomeContractDao.searchOne(queryMap);
	}

	@Override
	public List<IncomeContract> searchList(Map queryMap) {
		return incomeContractDao.searchList(queryMap);
	}

	@Override
	public List<Map> searchListByUserId(String userName) {
		// TODO Auto-generated method stub
		return incomeContractDao.searchListByUserId(userName);
	}

}
