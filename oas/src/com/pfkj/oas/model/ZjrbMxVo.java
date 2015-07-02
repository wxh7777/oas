package com.pfkj.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_ZJRB_MX")
public class ZjrbMxVo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	@Column(name = "ZJRB_ID" ,length=20, nullable=false)
	private String zjrb_id;

	@Column(name = "LB",length=1)
	private String leibie;//

	@Column(name = "ZJRB_XMDM")
	private String zjrbxmdm;//

	@Column(name = "ZJRB_KX_TYPE_DM")
	private String kxtype;//

	@Column(name = "JE")
	private double je;//

	@Column(name = "FKTZD_ID", length=20)
	private String fktzd_id;//

	@Column(name = "SKTZD_ID", length=20)
	private String sktzd_id;//

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getZjrb_id() {
		return zjrb_id;
	}

	public void setZjrb_id(String zjrb_id) {
		this.zjrb_id = zjrb_id;
	}

	public String getLeibie() {
		return leibie;
	}

	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}

	public String getZjrbxmdm() {
		return zjrbxmdm;
	}

	public void setZjrbxmdm(String zjrbxmdm) {
		this.zjrbxmdm = zjrbxmdm;
	}

	public String getKxtype() {
		return kxtype;
	}

	public void setKxtype(String kxtype) {
		this.kxtype = kxtype;
	}


	public double getJe() {
		return je;
	}

	public void setJe(double je) {
		this.je = je;
	}

	public String getFktzd_id() {
		return fktzd_id;
	}

	public void setFktzd_id(String fktzd_id) {
		this.fktzd_id = fktzd_id;
	}

	public String getSktzd_id() {
		return sktzd_id;
	}

	public void setSktzd_id(String sktzd_id) {
		this.sktzd_id = sktzd_id;
	}


}
