package com.pfkj.oas.qx.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.pfkj.oas.dao.UserDao;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.qx.UserService;
import com.pfkj.oas.security.MyInvocationSecurityMetadataSource;

public class UserServiceImpl<T extends QxUser,PK extends Serializable> implements UserService<T, PK> {
	
	private static final Logger logger = Logger.getLogger(MyInvocationSecurityMetadataSource.class);  
    
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Override
	public QxUser getById(String id) {
		return (QxUser) userDao.getUserById(id);
	}
	@Override
	public QxUser findByUserAccount(String userAccount) {
		logger.info("-------------");
		return userDao.getUserByName(userAccount);
	}
	
	
	
	@Override
	public List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		try{
			logger.info(username+"....au....");
			List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
			List<String> authorityNameList = loadUserAuthorities(username);
			
			for(String authName :authorityNameList )
			{
				 GrantedAuthorityImpl authority = new GrantedAuthorityImpl(authName);
				 auths.add(authority);
			}
			return auths;
			
		}catch(RuntimeException e)
		{
			throw e;
		}
	}

	@Override
	public List<String> loadUserAuthorities(final String username) {
		try{
			logger.info(username+"===au===");
			List<String> authorityName = new ArrayList<String>();
			QxUser user = findByUserAccount(username);
			List<QxAuthority> userAuths = userDao.getAuthorityByUser(user);
			for(QxAuthority auth:userAuths)
			{
				String authName = auth.getName();
				authorityName.add(authName);
			}
			return authorityName;
		}catch(RuntimeException e){
			throw e;
		}

	}
	
	public void save(QxUser qxuser) {
		userDao.save(qxuser);
	}
	
}
