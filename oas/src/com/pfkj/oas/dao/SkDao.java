package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.SktzdVo;
import com.pfkj.oas.model.SrHeTongVo;

public interface SkDao {

	List<SktzdVo> searchSktzd(String htbh, String yzmc, String sj, String gclb);

	boolean saveSktzd(SktzdVo sktzd);

	boolean saveSrht(SrHeTongVo htVo);

}
