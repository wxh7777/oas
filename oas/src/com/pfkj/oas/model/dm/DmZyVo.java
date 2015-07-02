package com.pfkj.oas.model.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_DM_ZY")
public class DmZyVo {

	@Id
	@Column(name = "ZY_DM", unique = true, nullable=false)
	private String zydm;
	
	@Column(name = "ZY_MC")
	private String zymc;
	
	@Column(name = "ZY_JB")
	private String zyjb;
	
	@Column(name = "ZY_SJ_DM")
	private String zysjdm;
	
	@Column(name = "ISENABLED")
	private boolean isEnabled;


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

	public String getZyjb() {
		return zyjb;
	}

	public void setZyjb(String zyjb) {
		this.zyjb = zyjb;
	}

	public String getZysjdm() {
		return zysjdm;
	}

	public void setZysjdm(String zysjdm) {
		this.zysjdm = zysjdm;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
	
	
}
