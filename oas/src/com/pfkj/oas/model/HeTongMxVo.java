package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_HETONG_MX")
//管理系统_合同明细
public class HeTongMxVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	//合同编号
	@Column(name = "HTBH")
	private String htbh;
	
	//资源代码【B3】（与A4相同）、
	@Column(name = "ZYDM")
	private String zydm;
	
	//资源名称【B3】（与A4相同）、
	@Column(name = "ZYMC")
	private String zymc;
	
	//规格【B4】（与A11相同）
	@Column(name = "guige")
	private String guige;
	
	//单位【B5】（与A5相同）
	@Column(name = "DW")
	private String danwei;
	
	//单价【B6】
	@Column(name = "DJ")
	private double danjia;
	

	//数量【B6】
	@Column(name = "SL")
	private int shuliang;
	

	//总价【B6】
	@Column(name = "ZJ")
	private double zongjia;
	
	//补充次数（生成合同时为0，每修改一次，补充次数+1）
	@Column(name = "BCCS")
	private int bccs;
	
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

	public String getZydm() {
		return zydm;
	}

	public void setZydm(String zydm) {
		this.zydm = zydm;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getDanwei() {
		return danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public double getDanjia() {
		return danjia;
	}

	public void setDanjia(double danjia) {
		this.danjia = danjia;
	}

	public int getBccs() {
		return bccs;
	}

	public void setBccs(int bccs) {
		this.bccs = bccs;
	}


	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	public int getShuliang() {
		return shuliang;
	}

	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}

	public double getZongjia() {
		return zongjia;
	}

	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}
	

	
}
