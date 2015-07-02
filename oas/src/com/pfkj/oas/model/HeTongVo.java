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
@Table(name = "GLXT_HETONG")
//管理系统_合同
public class HeTongVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	//合同编号
	@Column(name = "HTBH", unique = true, nullable=false)
	private String htbh;

	//合同名称【B7】
	@Column(name = "HTMC")
	private String htmc;
	
	//合同类型（对应dm_zy）
	@Column(name = "HTLX")
	private String htlx;
	
	//项目名称
	@Column(name = "XM_ID")
	private String xmid;
	
	//项目名称
	@Column(name = "XMMC")
	private String xmmc;
	
	//结算单位名称
	@Column(name = "JSDWMC")
	private String jsdwmc;
	
	//日期【B8】
	@Column(name = "RQ")
	private Date rq;

	//供应商
	@Column(name = "GYS")
	private String gys;
	
	//填报人【B9登陆人姓名】
	@Column(name = "TBR")
	private String tbr;
	
	//控制人【B10】
	@Column(name = "KZR")
	private String kzr;
	
	//经办人【B11】
	@Column(name = "JBR")
	private String jbr;
	
	//填报日期
	@Column(name = "TBRQ")
	private Date tbrq;
	
	//补充日期
	@Column(name = "BCRQ")
	private Date bcrq;
	
	
	//合同总价
	@Column(name = "HTZJ")
	private double htzj;
	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;
	

	public String getHtlx() {
		return htlx;
	}

	public void setHtlx(String htlx) {
		this.htlx = htlx;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getGys() {
		return gys;
	}

	public void setGys(String gys) {
		this.gys = gys;
	}

	

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public String getJsdwmc() {
		return jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		this.jsdwmc = jsdwmc;
	}


	public String getHtmc() {
		return htmc;
	}

	public void setHtmc(String htmc) {
		this.htmc = htmc;
	}

	public Date getRq() {
		return rq;
	}

	public void setRq(Date rq) {
		this.rq = rq;
	}

	public String getTbr() {
		return tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	public String getKzr() {
		return kzr;
	}

	public void setKzr(String kzr) {
		this.kzr = kzr;
	}

	public String getJbr() {
		return jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public Date getTbrq() {
		return tbrq;
	}

	public void setTbrq(Date tbrq) {
		this.tbrq = tbrq;
	}

	public Date getBcrq() {
		return bcrq;
	}

	public void setBcrq(Date bcrq) {
		this.bcrq = bcrq;
	}

	public double getHtzj() {
		return htzj;
	}

	public void setHtzj(double htzj) {
		this.htzj = htzj;
	}


}
