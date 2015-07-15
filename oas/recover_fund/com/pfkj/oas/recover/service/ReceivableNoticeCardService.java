package com.pfkj.oas.recover.service;

import java.util.List;
import java.util.Map;

import com.pfkj.oas.recover.model.ReceivableNoticeCard;

public interface ReceivableNoticeCardService {
	
	public boolean insert(ReceivableNoticeCard receivableNoticeCard);

	public List<Map> searchReceivalNoticeCardList();

	public ReceivableNoticeCard searchReceivalNoticeCardById(String id);
	
}
