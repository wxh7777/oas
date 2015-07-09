package com.pfkj.oas.recover.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * 收款通知单详细
 * @author xiao yi
 *
 */
@Entity
@Table(name = "GLXT_RECEIVABLE_NOTICE_CARD")
public class ReceivableNoticeCard {

	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	//项目名称(ID)
	@Column(name = "XIANGMU_ID")
	private String xiangmuId;
	
	//业主名称
	@Column(name = "OWNER_NAME")
	private String ownerName;
	
	//时间
	@Column(name = "TIME")
	private Date time;
	
	//工程类别
	@Column(name = "PROJECT_TYPE")
	private String projectType;

	//计量期数
	@Column(name = "METERING_NUM")
	private int meteringNum;
	
	//计量日期
	@Column(name = "METERING_TIME")
	private Date meteringTime;
	
	//计量款
	@Column(name = "METERING_CASH")
	private double meteringCash;
	
	//质保金
	@Column(name = "WARRANTY_CASH")
	private double warrantyCash;
	
	//农民工工资保证金
	@Column(name = "FARMER_CASH")
	private double farmerCash;
	
	//其他扣款
	@Column(name = "OTHER_CASH")
	private double otherCash;
	
	//状态
	@Column(name = "STATUS")
	private int status;
	
	//操作人
	@Column(name = "USER_ID")
	private String userId;
	
	//创建时间
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXiangmuId() {
		return xiangmuId;
	}

	public void setXiangmuId(String xiangmuId) {
		this.xiangmuId = xiangmuId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public int getMeteringNum() {
		return meteringNum;
	}

	public void setMeteringNum(int meteringNum) {
		this.meteringNum = meteringNum;
	}

	public Date getMeteringTime() {
		return meteringTime;
	}

	public void setMeteringTime(Date meteringTime) {
		this.meteringTime = meteringTime;
	}

	public double getMeteringCash() {
		return meteringCash;
	}

	public void setMeteringCash(double meteringCash) {
		this.meteringCash = meteringCash;
	}

	public double getWarrantyCash() {
		return warrantyCash;
	}

	public void setWarrantyCash(double warrantyCash) {
		this.warrantyCash = warrantyCash;
	}

	public double getFarmerCash() {
		return farmerCash;
	}

	public void setFarmerCash(double farmerCash) {
		this.farmerCash = farmerCash;
	}

	public double getOtherCash() {
		return otherCash;
	}

	public void setOtherCash(double otherCash) {
		this.otherCash = otherCash;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ReceivableNoticeCard [id=" + id + ", xiangmuId=" + xiangmuId
				+ ", ownerName=" + ownerName + ", time=" + time
				+ ", projectType=" + projectType + ", meteringNum="
				+ meteringNum + ", meteringTime=" + meteringTime
				+ ", meteringCash=" + meteringCash + ", warrantyCash="
				+ warrantyCash + ", farmerCash=" + farmerCash + ", otherCash="
				+ otherCash + ", status=" + status + ", userId=" + userId
				+ ", createTime=" + createTime + "]";
	}
	
}
