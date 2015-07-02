package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.dm.DmHtlbVo;
import com.pfkj.oas.model.dm.DmZjrbXmType;
import com.pfkj.oas.model.dm.DmZyVo;

public interface CacheDao {
	public List<DmHtlbVo> getHtlbDmList();
	public List<DmZyVo> getZyDmList();
	public List<XiangMuVo> getXmDmList();
	public List<DmZjrbXmType> getDmZjrbXmTypeList();
}
