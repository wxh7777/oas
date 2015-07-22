package com.pfkj.oas.recover.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfkj.oas.recover.dao.ReceivableNoticeCardDao;
import com.pfkj.oas.recover.model.ReceivableNoticeCard;
import com.pfkj.oas.recover.service.ReceivableNoticeCardService;

public class ReceivableNoticeCardServiceImpl implements
		ReceivableNoticeCardService {
	
	@Autowired
	private ReceivableNoticeCardDao receivableNoticeCardDao;
	
	public ReceivableNoticeCardDao getReceivableNoticeCardDao() {
		return receivableNoticeCardDao;
	}

	public void setReceivableNoticeCardDao(
			ReceivableNoticeCardDao receivableNoticeCardDao) {
		this.receivableNoticeCardDao = receivableNoticeCardDao;
	}

	@Override
	public boolean insert(ReceivableNoticeCard receivableNoticeCard) {
		return receivableNoticeCardDao.insert(receivableNoticeCard);
	}

	@Override
	public List<Map> searchReceivalNoticeCardList() {
		return receivableNoticeCardDao.searchReceivalNoticeCardList();
	}

	@Override
	public ReceivableNoticeCard searchReceivalNoticeCardById(String id) {
		return receivableNoticeCardDao.searchReceivalNoticeCardById(id);
	}

	@Override
	public List<Map> searchReceivalNoticeCardTotalList(String xianMuIds) {
		return receivableNoticeCardDao.searchReceivalNoticeCardTotalList(xianMuIds);
	}
	
	@Override
	public List<Map> searchReceivalNoticeCardTotalList() {
		return receivableNoticeCardDao.searchReceivalNoticeCardTotalList();
	}

}
