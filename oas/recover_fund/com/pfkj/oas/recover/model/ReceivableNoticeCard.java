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
	
	//合同金额
	@Column(name = "CONTRACT_MONEY")
	private double contractMoney;

	//累计计量
	@Column(name = "TOTAL_METERING")
	private double totalMetering;

	//累计收款
	@Column(name = "TOTAL_RECEIVABLES")
	private double totalReceivables;
	
	//应收计量款
	@Column(name = "MUST_METERING_MONEY")
	private double mustMeteringMoney;
	
	//累计开票
	@Column(name = "TOTAL_BILLING")
	private double totalBilling;
	
	//应收其他款
	@Column(name = "MUST_OTHER_MONEY")
	private double mustOtherMoney;
	
	//应收款合计
	@Column(name = "MUST_TOTAL_MONEY")
	private double mustTotalMoney;
	
	//本次收计量款合计
	@Column(name = "TOTAL_METERING_MONEY")
	private double totalMeteringMoney;
	
	//应收工程款合计
	@Column(name = "MUST_TOTAL_PROJECT_MONEY")
	private double mustTotalProjectMoney;
	
	//开工预付款
	@Column(name = "ADVANCE_MONEY")
	private double advanceMoney;
	
	//计量款
	@Column(name = "METERING_MONEY")
	private double meteringMoney;
	
	//右边计量款
	@Column(name = "PROJECT_METERING_MONEY")
	private double projectMeteringMoney;
	
	//保留金
	@Column(name = "HOLD_MONEY")
	private double holdMoney;
	
	//右边保留金
	@Column(name = "PROJECT_HOLD_MONEY")
	private double projectHoldMoney;
	
	//质保金
	@Column(name = "WARRANTY_MONEY")
	private double warrantyMoney;
	
	//右边质保金
	@Column(name = "PROJECT_WARRANTY_MONEY")
	private double projectWarrantyMoney;
	
	//农民工工资保证金
	@Column(name = "FARMER_MONEY")
	private double farmerMoney;
	
	//右边农民工工资保证金
	@Column(name = "PROJECT_FARMER_MONEY")
	private double projectFarmerMoney;
	
	//其他扣款
	@Column(name = "OTHER_MONEY")
	private double otherMoney;
		
	//右边其他扣款
	@Column(name = "PROJECT_OTHER_MONEY")
	private double projectOtherMoney;
	
	//已收开工预付款
	@Column(name = "PROJECt_ADVANCE_MONEY")
	private double projectAdvanceMoney;
	
	//备注
	@Column(name = "MEMO")
	private String memo;
	
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

	public double getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(double contractMoney) {
		this.contractMoney = contractMoney;
	}

	public double getTotalMetering() {
		return totalMetering;
	}

	public void setTotalMetering(double totalMetering) {
		this.totalMetering = totalMetering;
	}
	
	public double getTotalReceivables() {
		return totalReceivables;
	}

	public void setTotalReceivables(double totalReceivables) {
		this.totalReceivables = totalReceivables;
	}

	public double getMustMeteringMoney() {
		return mustMeteringMoney;
	}

	public void setMustMeteringMoney(double mustMeteringMoney) {
		this.mustMeteringMoney = mustMeteringMoney;
	}

	public double getTotalBilling() {
		return totalBilling;
	}

	public void setTotalBilling(double totalBilling) {
		this.totalBilling = totalBilling;
	}

	public double getMustOtherMoney() {
		return mustOtherMoney;
	}

	public void setMustOtherMoney(double mustOtherMoney) {
		this.mustOtherMoney = mustOtherMoney;
	}

	public double getMustTotalMoney() {
		return mustTotalMoney;
	}

	public void setMustTotalMoney(double mustTotalMoney) {
		this.mustTotalMoney = mustTotalMoney;
	}

	public double getTotalMeteringMoney() {
		return totalMeteringMoney;
	}

	public void setTotalMeteringMoney(double totalMeteringMoney) {
		this.totalMeteringMoney = totalMeteringMoney;
	}

	public double getMustTotalProjectMoney() {
		return mustTotalProjectMoney;
	}

	public void setMustTotalProjectMoney(double mustTotalProjectMoney) {
		this.mustTotalProjectMoney = mustTotalProjectMoney;
	}

	public double getAdvanceMoney() {
		return advanceMoney;
	}

	public void setAdvanceMoney(double advanceMoney) {
		this.advanceMoney = advanceMoney;
	}

	public double getMeteringMoney() {
		return meteringMoney;
	}

	public void setMeteringMoney(double meteringMoney) {
		this.meteringMoney = meteringMoney;
	}

	public double getProjectMeteringMoney() {
		return projectMeteringMoney;
	}

	public void setProjectMeteringMoney(double projectMeteringMoney) {
		this.projectMeteringMoney = projectMeteringMoney;
	}

	public double getHoldMoney() {
		return holdMoney;
	}

	public void setHoldMoney(double holdMoney) {
		this.holdMoney = holdMoney;
	}

	public double getProjectHoldMoney() {
		return projectHoldMoney;
	}

	public void setProjectHoldMoney(double projectHoldMoney) {
		this.projectHoldMoney = projectHoldMoney;
	}

	public double getWarrantyMoney() {
		return warrantyMoney;
	}

	public void setWarrantyMoney(double warrantyMoney) {
		this.warrantyMoney = warrantyMoney;
	}

	public double getProjectWarrantyMoney() {
		return projectWarrantyMoney;
	}

	public void setProjectWarrantyMoney(double projectWarrantyMoney) {
		this.projectWarrantyMoney = projectWarrantyMoney;
	}

	public double getFarmerMoney() {
		return farmerMoney;
	}

	public void setFarmerMoney(double farmerMoney) {
		this.farmerMoney = farmerMoney;
	}

	public double getProjectFarmerMoney() {
		return projectFarmerMoney;
	}

	public void setProjectFarmerMoney(double projectFarmerMoney) {
		this.projectFarmerMoney = projectFarmerMoney;
	}

	public double getOtherMoney() {
		return otherMoney;
	}

	public void setOtherMoney(double otherMoney) {
		this.otherMoney = otherMoney;
	}

	public double getProjectOtherMoney() {
		return projectOtherMoney;
	}

	public void setProjectOtherMoney(double projectOtherMoney) {
		this.projectOtherMoney = projectOtherMoney;
	}

	public double getProjectAdvanceMoney() {
		return projectAdvanceMoney;
	}

	public void setProjectAdvanceMoney(double projectAdvanceMoney) {
		this.projectAdvanceMoney = projectAdvanceMoney;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
				+ ", contractMoney=" + contractMoney + ", totalMetering="
				+ totalMetering + ", totalReceivables=" + totalReceivables
				+ ", mustMeteringMoney=" + mustMeteringMoney
				+ ", totalBilling=" + totalBilling + ", mustOtherMoney="
				+ mustOtherMoney + ", mustTotalMoney=" + mustTotalMoney
				+ ", totalMeteringMoney=" + totalMeteringMoney
				+ ", mustTotalProjectMoney=" + mustTotalProjectMoney
				+ ", advanceMoney=" + advanceMoney + ", meteringMoney="
				+ meteringMoney + ", projectMeteringMoney="
				+ projectMeteringMoney + ", holdMoney=" + holdMoney
				+ ", projectHoldMoney=" + projectHoldMoney + ", warrantyMoney="
				+ warrantyMoney + ", projectWarrantyMoney="
				+ projectWarrantyMoney + ", farmerMoney=" + farmerMoney
				+ ", projectFarmerMoney=" + projectFarmerMoney
				+ ", otherMoney=" + otherMoney + ", projectOtherMoney="
				+ projectOtherMoney + ", projectAdvanceMoney="
				+ projectAdvanceMoney + ", memo=" + memo + ", status=" + status
				+ ", userId=" + userId + ", createTime=" + createTime + "]";
	}
	
}
