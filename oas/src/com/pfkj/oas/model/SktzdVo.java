package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_SKTZD")
//管理系统_收款通知单
public class SktzdVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "HTBH")
	private String htbh;

	@Column(name = "YZMC")
	private String yzmc;

	@Column(name = "SJ",length=8)
	private String sj;

	@Column(name = "GCLB")
	private String gclb;

	@Column(name = "JLQS")
	private String jlqs;

	@Column(name = "JLRQ",length=8)
	private String  jlrq;

	@Column(name = "JLK")
	private String jlk;

	@Column(name = "ZBJ")
	private String zbj;

	@Column(name = "NMGGZBZJ")
	private String nmggzbzj;

	@Column(name = "QTKK")
	private String qtkk;

	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

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

	public String getYzmc() {
		return yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public String getSj() {
		return sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}

	public String getGclb() {
		return gclb;
	}

	public void setGclb(String gclb) {
		this.gclb = gclb;
	}

	public String getJlqs() {
		return jlqs;
	}

	public void setJlqs(String jlqs) {
		this.jlqs = jlqs;
	}

	public String getJlrq() {
		return jlrq;
	}

	public void setJlrq(String jlrq) {
		this.jlrq = jlrq;
	}

	public String getJlk() {
		return jlk;
	}

	public void setJlk(String jlk) {
		this.jlk = jlk;
	}

	public String getZbj() {
		return zbj;
	}

	public void setZbj(String zbj) {
		this.zbj = zbj;
	}

	public String getNmggzbzj() {
		return nmggzbzj;
	}

	public void setNmggzbzj(String nmggzbzj) {
		this.nmggzbzj = nmggzbzj;
	}

	public String getQtkk() {
		return qtkk;
	}

	public void setQtkk(String qtkk) {
		this.qtkk = qtkk;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
