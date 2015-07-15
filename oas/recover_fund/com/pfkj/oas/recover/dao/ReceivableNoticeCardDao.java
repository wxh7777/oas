package com.pfkj.oas.recover.dao;

import java.util.List;
import java.util.Map;

import com.pfkj.oas.recover.model.ReceivableNoticeCard;

public interface ReceivableNoticeCardDao {

	boolean insert(ReceivableNoticeCard receivableNoticeCard);
	
	List<Map> searchReceivalNoticeCardList();

	ReceivableNoticeCard searchReceivalNoticeCardById(String id);

}
