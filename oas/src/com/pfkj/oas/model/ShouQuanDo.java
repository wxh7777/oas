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
@Table(name = "GLXT_SQDO")
//管理系统_授权记录
public class ShouQuanDo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;
	
	//结算单编号
	@Column(name = "JSDBH")
	private String jsdbh; 

	//授权理由
	@Column(name = "SQLY")
	private String sqly; 
	
	//授权时间
	@Column(name = "SQSJ")
	private Date SQSJ;
	
	//授权金额
	@Column(name = "SQJE")
	private double sqje;
	
	//预授权标志
	@Column(name = "YSQBZ")
	private char ysqbz;
	
	//处理状态：01新建授权，02审核通过，03审核失败,04生成付款通知单，05付款通知单交接完成，06付款通知单财务拒绝
	@Column(name = "CLZT",length=2)
	private String clzt;
	
	//付款通知单打印次数
	@Column(name = "FKTZDDYCS")
	private int fktzddycs;
	
	//是否有效
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsdbh() {
		return jsdbh;
	}

	public void setJsdbh(String jsdbh) {
		this.jsdbh = jsdbh;
	}

	public Date getSQSJ() {
		return SQSJ;
	}

	public void setSQSJ(Date sQSJ) {
		SQSJ = sQSJ;
	}

	public double getSqje() {
		return sqje;
	}

	public void setSqje(double sqje) {
		this.sqje = sqje;
	}

	public char getYsqbz() {
		return ysqbz;
	}

	public void setYsqbz(char ysqbz) {
		this.ysqbz = ysqbz;
	}


	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getSqly() {
		return sqly;
	}

	public void setSqly(String sqly) {
		this.sqly = sqly;
	}

	public String getClzt() {
		return clzt;
	}

	public void setClzt(String clzt) {
		this.clzt = clzt;
	}

	public int getFktzddycs() {
		return fktzddycs;
	}

	public void setFktzddycs(int fktzddycs) {
		this.fktzddycs = fktzddycs;
	}


	
}
