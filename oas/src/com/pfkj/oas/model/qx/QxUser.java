package com.pfkj.oas.model.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Entity
@Table(name = "GLXT_QX_USER")
//管理系统权限相关-用户
public class QxUser {
	

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "USER_ACT_USER_ID",length=64)
	private String actUserId;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_PWD", nullable=false)
	private String password;
	
	@Column(name = "USER_ACCOUNT", nullable=false)
	private String account;
	
	@Column(name = "USER_DESC")
	private String desc;
	
	@Column(name = "ISENABLED")
	private boolean isEnabled;
	

	public QxUser() {
		super();
		this.isEnabled = true;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getActUserId() {
		return actUserId;
	}

	public void setActUserId(String actUserId) {
		this.actUserId = actUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
		String result = md5.encodePassword(password, null);
		this.password = result;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}
