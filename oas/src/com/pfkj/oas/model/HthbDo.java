package com.pfkj.oas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLXT_HTHB")
//管理系统_合同核备记录
public class HthbDo {

	
	@Id
	@Column(name = "HBBH", unique = true, length=20, nullable=false)
	private String hbbh;
	
	//项目ID
	@Column(name = "XM_ID", length=20, nullable=false)
	private String xmid;
	
	//上传待核备文件
	@Column(name = "HTHB_HT_FILES")
	private String files;
	
	//上传待核备文件日期
	@Column(name = "HTHB_HT_FILES_DATE")
	private Date htFilesDate;
	
	//上传审核文件1
	@Column(name = "HTHB_SH_FilE_A")
	private String shFileA;
	
	//上传审核文件1日期
	@Column(name = "HTHB_SH_FilE_A_DATE")
	private Date shFileADate;

	//审核人1
	@Column(name = "HTHB_SHR_A")
	private String shrA;

	//上传审核文件2
	@Column(name = "HTHB_SH_FilE_B")
	private String shFileB;
	
	//上传审核文件2日期
	@Column(name = "HTHB_SH_FilE_B_DATE")
	private Date shFileBDate;

	//审核人2
	@Column(name = "HTHB_SHR_B")
	private String shrB;
	
	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;
	

	public String getHbbh() {
		return hbbh;
	}

	public void setHbbh(String hbbh) {
		this.hbbh = hbbh;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Date getHtFilesDate() {
		return htFilesDate;
	}

	public void setHtFilesDate(Date htFilesDate) {
		this.htFilesDate = htFilesDate;
	}

	public String getShFileA() {
		return shFileA;
	}

	public void setShFileA(String shFileA) {
		this.shFileA = shFileA;
	}

	public Date getShFileADate() {
		return shFileADate;
	}

	public void setShFileADate(Date shFileADate) {
		this.shFileADate = shFileADate;
	}

	public String getShFileB() {
		return shFileB;
	}

	public void setShFileB(String shFileB) {
		this.shFileB = shFileB;
	}

	public Date getShFileBDate() {
		return shFileBDate;
	}

	public void setShFileBDate(Date shFileBDate) {
		this.shFileBDate = shFileBDate;
	}

	

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getShrA() {
		return shrA;
	}

	public void setShrA(String shrA) {
		this.shrA = shrA;
	}

	public String getShrB() {
		return shrB;
	}

	public void setShrB(String shrB) {
		this.shrB = shrB;
	}

	public String getXmid() {
		return xmid;
	}

	public void setXmid(String xmid) {
		this.xmid = xmid;
	}
	
	
}
