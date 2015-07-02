package com.pfkj.oas.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {

	private static final Logger logger = Logger.getLogger(AccessDecisionManager.class);  
    
	
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		
		

		if (configAttributes == null) {  
            return;  
        }  
		logger.debug("正在访问的url是："+object.toString());  
		System.out.println("正在访问的url是："+object.toString());
        // object is a URL.  
        Iterator<ConfigAttribute> ite = configAttributes.iterator();  
        
        
      
        while (ite.hasNext()) {  
            ConfigAttribute ca = ite.next();
            logger.debug("needRole is："+ca.getAttribute());    
            //System.out.println(ca);
            String needRole = ((SecurityConfig) ca).getAttribute(); 
            //String needRole = ((SecurityConfig) ca).getAttribute(); 
            //System.out.println(""+);
            
            for (GrantedAuthority ga : authentication.getAuthorities()) {
            	logger.debug("/t授权信息是："+ga.getAuthority());  
            	 if(needRole.trim().equals(ga.getAuthority().trim()))
                {
            		System.out.println("判断到，needRole 是"+needRole+",用户的角色是:"+ga.getAuthority()+"，授权数据相匹配");  
            		System.out.println("decide(Authentication, Object, Collection<ConfigAttribute>) - end"); //$NON-NLS-1$  
                	//System.out.println("good");
                	return;
                }else
                {
                	//System.out.println("bad");
                }
            }
            
            
        }  
        //  
        System.out.println("没有权限");
        //throw new InsufficientAuthenticationException("no right!");
        throw new AccessDeniedException("没有权限!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
