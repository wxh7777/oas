package com.pfkj.oas.model.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_DM_HTLB")
public class DmHtlbVo {

	@Id
	@Column(name = "HTLB_DM", unique = true, nullable=false)
	private String htlbdm;
	
	@Column(name = "HTLB_MC")
	private String htlbmc;
	
	@Column(name = "ISENABLED")
	private boolean isEnabled;

	public String getHtlbdm() {
		return htlbdm;
	}

	public void setHtlbdm(String htlbdm) {
		this.htlbdm = htlbdm;
	}

	public String getHtlbmc() {
		return htlbmc;
	}

	public void setHtlbmc(String htlbmc) {
		this.htlbmc = htlbmc;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
	
	
}
