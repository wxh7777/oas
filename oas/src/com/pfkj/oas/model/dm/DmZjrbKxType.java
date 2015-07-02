package com.pfkj.oas.model.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_DM_ZJRB_KX_TYPE")
public class DmZjrbKxType {

	@Id
	@Column(name = "KX_TYPE_DM", unique = true, nullable=false)
	private String kxTypeDm;
	
	@Column(name = "KX_TYPE_MC")
	private String kxTypemc;

	public String getKxTypeDm() {
		return kxTypeDm;
	}

	public void setKxTypeDm(String kxTypeDm) {
		this.kxTypeDm = kxTypeDm;
	}

	public String getKxTypemc() {
		return kxTypemc;
	}

	public void setKxTypemc(String kxTypemc) {
		this.kxTypemc = kxTypemc;
	}
	
	
}
