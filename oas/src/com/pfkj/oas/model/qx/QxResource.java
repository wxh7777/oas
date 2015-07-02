package com.pfkj.oas.model.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_QX_RESOURCE")
//管理系统权限相关-权限
public class QxResource {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;
	
	@Column(name = "RES_NAME", unique = true, nullable=false)
	private String name;
	
	@Column(name = "RES_DESC")
	private String desc;
	
	@Column(name = "RES_TYPE")
	private String type;
	
	@Column(name = "RES_STRING")
	private String resString;
	
	@Column(name = "RES_PRIORITY")
	private String priority;
	
	@Column(name = "ISENABLED")
	private boolean isEnabled;	

	
	public QxResource() {
		super();
		this.isEnabled = true;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getResString() {
		return resString;
	}


	public void setResString(String resString) {
		this.resString = resString;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


			
}
