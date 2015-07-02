package com.pfkj.oas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_FKDO")
//管理系统_付款记录
public class FuKuanDo {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;
	
	@Column(name = "FKTZD_ID")
	private String fktzd_id; 
	
	//付款金额
	@Column(name = "FKJE")
	private double fkje;
	
	//付款日期
	@Column(name = "FKRQ")
	private Date fkrq;
	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFktzdVo() {
		return fktzd_id;
	}

	public void setFktzdVo(String fktzd_id) {
		this.fktzd_id = fktzd_id;
	}

	public double getFkje() {
		return fkje;
	}

	public void setFkje(double fkje) {
		this.fkje = fkje;
	}

	public Date getFkrq() {
		return fkrq;
	}

	public void setFkrq(Date fkrq) {
		this.fkrq = fkrq;
	}

	public String getFktzd_id() {
		return fktzd_id;
	}

	public void setFktzd_id(String fktzd_id) {
		this.fktzd_id = fktzd_id;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}
