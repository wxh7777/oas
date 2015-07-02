package com.pfkj.oas.qx.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.qx.MyUserDetailsService;
import com.pfkj.oas.qx.UserService;

public class MyUserDetailsServiceImpl implements MyUserDetailsService {
	
	@SuppressWarnings("rawtypes")
	private UserService userService;

	@SuppressWarnings("rawtypes")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException{
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>(); 
		QxUser user = new QxUser();
		try{
			auths  = userService.loadUserAuthoritiesByName(username);
			user = userService.findByUserAccount(username);
		}catch(Exception e){
			return null;
		}
		//System.out.println("user.getUserId() "+user.getId()+" user.getUserName()"+user.getName()+" user.getUserPassword()"+user.getPassword());  
		System.out.println(user.getName()+";"+user.getAccount()+";"+user.getPassword()+";"+auths);
		return new User(  
                user.getAccount(),   
                user.getPassword(),   
                true,
                true,   
                true,   
                true,  
                auths);
		//return null;
	}

}
