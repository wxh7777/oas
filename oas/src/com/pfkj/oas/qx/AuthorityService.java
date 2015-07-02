package com.pfkj.oas.qx;

import java.util.List;

import com.pfkj.oas.model.qx.QxAuthority;

public interface AuthorityService<T extends QxAuthority> {
	
	
	List<QxAuthority> getAll();
}
