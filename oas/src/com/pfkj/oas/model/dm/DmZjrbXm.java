package com.pfkj.oas.model.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_DM_ZJRB_XM")
public class DmZjrbXm {

	@Id
	@Column(name = "ZJRB_XM_DM", unique = true, nullable=false)
	private String zjrbXmDm;
	
	@Column(name = "ZJRB_XM_MC")
	private String zjrbXmMc;
	
	@Column(name = "ZJRB_XM_TYPE_DM")
	private String zjrbXmTypeDm;

	public String getZjrbXmDm() {
		return zjrbXmDm;
	}

	public void setZjrbXmDm(String zjrbXmDm) {
		this.zjrbXmDm = zjrbXmDm;
	}

	public String getZjrbXmMc() {
		return zjrbXmMc;
	}

	public void setZjrbXmMc(String zjrbXmMc) {
		this.zjrbXmMc = zjrbXmMc;
	}

	public String getZjrbXmTypeDm() {
		return zjrbXmTypeDm;
	}

	public void setZjrbXmTypeDm(String zjrbXmTypeDm) {
		this.zjrbXmTypeDm = zjrbXmTypeDm;
	}
	
	
}
