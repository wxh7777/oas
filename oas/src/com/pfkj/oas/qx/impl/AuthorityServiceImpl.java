package com.pfkj.oas.qx.impl;

import java.util.List;

import com.pfkj.oas.dao.AuthorityDao;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.qx.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService<QxAuthority> {

	private AuthorityDao authorityDao;
	@Override
	public List<QxAuthority> getAll() {
		// TODO Auto-generated method stub
		return authorityDao.getAuthorityList();
	}
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

}
