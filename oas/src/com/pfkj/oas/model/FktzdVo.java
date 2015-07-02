package com.pfkj.oas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_FKTZD")
//管理系统_付款通知单
public class FktzdVo {
	
	
	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;
	
	@Column(name = "SQDO_ID")
	private String sqdo_id; 
	
	//生成时间
	@Column(name = "SCSJ")
	private Date SCSJ;
	
	//打印次数
	@Column(name = "DYCS")
	private int dycs;
	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getSqdo_id() {
		return sqdo_id;
	}

	public void setSqdo_id(String sqdo_id) {
		this.sqdo_id = sqdo_id;
	}

	public Date getSCSJ() {
		return SCSJ;
	}

	public void setSCSJ(Date sCSJ) {
		SCSJ = sCSJ;
	}

	public int getDycs() {
		return dycs;
	}

	public void setDycs(int dycs) {
		this.dycs = dycs;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
