package com.pfkj.oas.util;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class KeyUtil implements IdentifierGenerator, Configurable {

	public String pk;
	public String pkLen;
	
	@Override
	public void configure(Type type, Properties properties, Dialect dialect)
			throws MappingException {
		this.pk = properties.getProperty("pk");
		this.pkLen = properties.getProperty("pkLen");
	}

	@Override
	public Serializable generate(SessionImplementor session, Object obj)
			throws HibernateException {
		int len = Integer.parseInt(pkLen) >= 20 ? 20 : Integer.parseInt(pkLen);
		String tString = StringUtil.generateRadom();
		StringBuilder sBuilder = new StringBuilder();
		if(tString.length() >= len) {
			tString = tString.substring(tString.length()-len);
		} else {
			while(tString.length() < len) {
				tString = "1" + tString;
			}
		}
		sBuilder.append(tString);
		return sBuilder.toString();
	}
	
}
