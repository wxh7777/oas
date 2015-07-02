package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "GLXT_XIANGMU")
//管理系统_项目明细
public class XiangMuVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "XM_MC")
	private String xmmc;

	@Column(name = "XM_DESC")
	private String desc;
	
	//有效标志
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	public XiangMuVo() {
		super();
		this.isEnabled = true;
	}
	



	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}




	public boolean isEnabled() {
		return isEnabled;
	}




	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
	
}
