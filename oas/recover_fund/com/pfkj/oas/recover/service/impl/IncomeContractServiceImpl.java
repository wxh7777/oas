package com.pfkj.oas.recover.service.impl;

import java.util.List;
import java.util.Map;

import com.pfkj.oas.recover.dao.IncomeContractDao;
import com.pfkj.oas.recover.model.IncomeContract;
import com.pfkj.oas.recover.service.IncomeContractService;

public class IncomeContractServiceImpl implements IncomeContractService {
	
	public IncomeContractDao dao;
	
	public IncomeContractDao getDao() {
		return dao;
	}

	public void setDao(IncomeContractDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean insert(IncomeContract incomeContract) {
		return dao.insert(incomeContract);
	}

	@Override
	public boolean delete(String id) {
		return dao.delete(id);
	}

	@Override
	public boolean update(IncomeContract incomeContract) {
		return dao.update(incomeContract);
	}

	@Override
	public IncomeContract searchByID(String id) {
		return dao.searchByID(id);
	}

	@Override
	public IncomeContract searchOne(Map queryMap) {
		return dao.searchOne(queryMap);
	}

	@Override
	public List<IncomeContract> searchList(Map queryMap) {
		return dao.searchList(queryMap);
	}

}
