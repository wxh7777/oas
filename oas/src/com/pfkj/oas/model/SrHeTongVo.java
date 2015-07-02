package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "GLXT_SRHETONG")
//管理系统_收入合同
public class SrHeTongVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "HTBH")
	private String htbh;
	
	@Column(name = "HTMC")
	private String htmc;
	
	@Column(name = "YZDWMC")
	private String yzdwmc;
	
	@Column(name = "GCFL")
	private String gcfl;
	
	@Column(name = "HTJE")
	private String htje;
	
	@Column(name = "KGRQ",length=8)
	private String kgrq;
	
	@Column(name = "WGRQ",length=8)
	private String wgrq;
	
	@Column(name = "SJKGRQ",length=8)
	private String sjkgrq;
	
	@Column(name = "JGRQ",length=8)
	private String jgrq;
	
	@Column(name = "SJJSJE")
	private String sjjsje;

	@Column(name = "ZBDWMC")
	private String zbdwmc;

	@Column(name = "ZYMC")
	private String zymc;

	@Column(name = "GG")
	private String gg;

	@Column(name = "DW")
	private String dw;

	@Column(name = "MZ")
	private String mz;

	@Column(name = "PZ")
	private String pz;

	@Column(name = "SL")
	private String sl;

	@Column(name = "GYS")
	private String gys;
	
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

	public String getHtmc() {
		return htmc;
	}

	public void setHtmc(String htmc) {
		this.htmc = htmc;
	}

	public String getYzdwmc() {
		return yzdwmc;
	}

	public void setYzdwmc(String yzdwmc) {
		this.yzdwmc = yzdwmc;
	}

	public String getGcfl() {
		return gcfl;
	}

	public void setGcfl(String gcfl) {
		this.gcfl = gcfl;
	}

	public String getHtje() {
		return htje;
	}

	public void setHtje(String htje) {
		this.htje = htje;
	}

	public String getKgrq() {
		return kgrq;
	}

	public void setKgrq(String kgrq) {
		this.kgrq = kgrq;
	}

	public String getWgrq() {
		return wgrq;
	}

	public void setWgrq(String wgrq) {
		this.wgrq = wgrq;
	}

	public String getSjkgrq() {
		return sjkgrq;
	}

	public void setSjkgrq(String sjkgrq) {
		this.sjkgrq = sjkgrq;
	}

	public String getJgrq() {
		return jgrq;
	}

	public void setJgrq(String jgrq) {
		this.jgrq = jgrq;
	}

	public String getSjjsje() {
		return sjjsje;
	}

	public void setSjjsje(String sjjsje) {
		this.sjjsje = sjjsje;
	}

	public String getZbdwmc() {
		return zbdwmc;
	}

	public void setZbdwmc(String zbdwmc) {
		this.zbdwmc = zbdwmc;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getPz() {
		return pz;
	}

	public void setPz(String pz) {
		this.pz = pz;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
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


}
