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
	
	//操作人
	@Column(name = "USER_ID")
	private String userId;

	//合同编号
	@Column(name = "NUMBER", unique = true, nullable=false)
	private String number;
	
	//上传时间
	@Column(name = "CREATE_TIME")
	private Date createTime;
	
}
