package com.pfkj.oas.model.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_QX_ROLE")
//管理系统权限相关-角色
public class QxRole {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;
	
	@Column(name = "ROLE_ACT_GROUP_ID",length=64)
	private String actGroupId;
	
	@Column(name = "ROLE_NAME", unique = true, nullable=false)
	private String name;
	
	@Column(name = "ROLE_DESC")
	private String desc;
	
	@Column(name = "ISENABLED")
	private boolean isEnabled;
	
	public QxRole() {
		super();
		this.isEnabled = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActGroupId() {
		return actGroupId;
	}

	public void setActGroupId(String actGroupId) {
		this.actGroupId = actGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
