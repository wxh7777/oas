package com.pfkj.oas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
@Entity
@Table(name = "GLXT_ZJRB")
//管理系统_资金日报
public class ZjrbVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	@Column(name = "TBRQ")
	private Date tbrq;

	@Type(type="text")  
	@Column(name = "CONTENT")
	private String content;//表格字符串

	@Column(name = "TBDW")
	private String tbdw;//填报单位

	@Column(name = "ZBR")
	private String zbr;//制表人

	@Column(name = "CWZG")
	private String cwzg;//财务主管

	@Column(name = "QMYE_A")
	private double qmyeA;//期末余额

	@Column(name = "QMYE_B")
	private double qmyeB;//期末余额(银行存款)

	@Column(name = "QMYE_C")
	private double qmyeC;//期末余额（现金）

	@Column(name = "QMYE_D")
	private double qmyeD;//期末余额（银行卡）

	@Column(name = "QMYE_E")
	private double qmyeE;//期末余额（承兑）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getTbrq() {
		return tbrq;
	}

	public void setTbrq(Date tbrq) {
		this.tbrq = tbrq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTbdw() {
		return tbdw;
	}

	public void setTbdw(String tbdw) {
		this.tbdw = tbdw;
	}

	public String getZbr() {
		return zbr;
	}

	public void setZbr(String zbr) {
		this.zbr = zbr;
	}

	public String getCwzg() {
		return cwzg;
	}

	public void setCwzg(String cwzg) {
		this.cwzg = cwzg;
	}

	public double getQmyeA() {
		return qmyeA;
	}

	public void setQmyeA(double qmyeA) {
		this.qmyeA = qmyeA;
	}

	public double getQmyeB() {
		return qmyeB;
	}

	public void setQmyeB(double qmyeB) {
		this.qmyeB = qmyeB;
	}

	public double getQmyeC() {
		return qmyeC;
	}

	public void setQmyeC(double qmyeC) {
		this.qmyeC = qmyeC;
	}

	public double getQmyeD() {
		return qmyeD;
	}

	public void setQmyeD(double qmyeD) {
		this.qmyeD = qmyeD;
	}

	public double getQmyeE() {
		return qmyeE;
	}

	public void setQmyeE(double qmyeE) {
		this.qmyeE = qmyeE;
	}

	
}
