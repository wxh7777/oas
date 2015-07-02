package com.pfkj.oas.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;

public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	private static final Logger logger = Logger.getLogger(MyInvocationSecurityMetadataSource.class);  
    
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();  
	  
    private static Map<String, Collection<ConfigAttribute>> resourceMap=null;  
  
    public MyInvocationSecurityMetadataSource() {  
        loadResourceDefine();  
    } 

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl(); 
		int firstQuestionMarkIndex = url.indexOf("?");  
		
        if (firstQuestionMarkIndex != -1) {  
            url = url.substring(0, firstQuestionMarkIndex);  
            
        } 
        Iterator<String> ite = resourceMap.keySet().iterator();  
        while (ite.hasNext()) {  
            String resURL = ite.next();  
            if (urlMatcher.pathMatchesUrl(url, resURL)) {  
                return resourceMap.get(resURL);  
            }  
        } 
		//return null;
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>(); 
		
		List<QxAuthority> authLists = new ArrayList<QxAuthority>();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-hibernate.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		
		//AuthorityLists = authorityService.getAll();
		authLists = session.createQuery("from QxAuthority").list();
		for(QxAuthority auth :authLists)
		{
			ConfigAttribute ca = new SecurityConfig(auth.getName());
			List<QxAuthorityResource> arList = new ArrayList<QxAuthorityResource>();
			arList = session.createQuery("from QxAuthorityResource where authority_id='"+auth.getId()+"'").list();
			for(QxAuthorityResource ar:arList){
				List<QxResource> resList = session.createQuery("from QxResource where id='"+ar.getResource_id()+"'").list();
				for(QxResource res:resList){
					String url = res.getResString();
					if (resourceMap.containsKey(url)) {
						 Collection<ConfigAttribute> value = resourceMap.get(url);
						 value.add(ca);
						 resourceMap.put(url, value);
					}else{
						Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
		                atts.add(ca);  
		                resourceMap.put(url, atts); 
					}
					logger.info("角色：["+auth.getName()+"]可以访问页面："+url);
				}
			}		
		}
	}
}
