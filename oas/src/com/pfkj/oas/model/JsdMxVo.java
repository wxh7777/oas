package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_JSDMX")
//管理系统_材料明细
public class JsdMxVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "JSDBH", nullable=false)
	private String jsdbh; 
	
	//资源名称（结算项目）
	@Column(name = "JSD_MX_ZYDM")
	private String zydm;
	
	//规格
	@Column(name = "JSD_MX_GG")
	private String gg;
	
	//单据号
	@Column(name = "JSD_MX_DJH")
	private String djh;
	
	//数量
	@Column(name = "JSD_MX_SL")
	private int sl;
	
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

	public String getZydm() {
		return zydm;
	}

	public void setZydm(String zydm) {
		this.zydm = zydm;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
