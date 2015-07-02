package com.pfkj.oas.model.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_DM_ZJRB_XM_TYPE")
public class DmZjrbXmType {

	@Id
	@Column(name = "XM_TYPE_DM", unique = true, nullable=false)
	private String kxTypeDm;
	
	@Column(name = "XM_TYPE_MC")
	private String kxTypeMc;

	public String getKxTypeDm() {
		return kxTypeDm;
	}

	public void setKxTypeDm(String kxTypeDm) {
		this.kxTypeDm = kxTypeDm;
	}

	public String getKxTypeMc() {
		return kxTypeMc;
	}

	public void setKxTypeMc(String kxTypeMc) {
		this.kxTypeMc = kxTypeMc;
	}
	
	
}
