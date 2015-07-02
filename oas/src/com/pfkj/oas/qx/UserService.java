package com.pfkj.oas.qx;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.pfkj.oas.model.qx.QxUser;



public interface UserService<T extends QxUser,PK extends Serializable> {
    
	public QxUser getById(String id);
	
	public QxUser findByUserAccount(String userAccount);
	
	public List<String> loadUserAuthorities(final String username) ;
	
	public List<GrantedAuthority> loadUserAuthoritiesByName(String username);
	
	public void save(QxUser qxuser);
	

}
