package com.pfkj.oas.recover.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 收入合同
 * @author xiao yi
 *
 */
@Entity
@Table(name = "GLXT_INCOME_CONTRACT")
public class IncomeContract {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	//合同编号
	@Column(name = "NUMBER", unique = true, nullable=false)
	private String number;
	
	//合同类型
	@Column(name = "TYPE")
	private String type;
	
	//合同路径
	@Column(name = "PATH")
	private String path;
	
	//操作人
	@Column(name = "USER_ID")
	private String userId;
	
	//上传时间
	@Column(name = "UPLOAD_TIME")
	private Date uploadTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "IncomeContract [id=" + id + ", userId=" + userId + ", number="
				+ number + ", type=" + type + ", path=" + path
				+ ", uploadTime=" + uploadTime + "]";
	}

}
