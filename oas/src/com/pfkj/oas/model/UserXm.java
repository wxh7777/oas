package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "GLXT_USER_XM")
//管理系统_用户_项目_关系表
public class UserXm {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;
	
	@Column(name = "USER_ID", length=20, nullable=false)
	private String user_id;
	
	@Column(name = "XM_ID", length=20, nullable=false)
	private String xm_id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getXm_id() {
		return xm_id;
	}

	public void setXm_id(String xm_id) {
		this.xm_id = xm_id;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
}
