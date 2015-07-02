package com.pfkj.oas.model.qx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "GLXT_QX_AUTHORITY_RESOURCE")
//管理系统权限相关-权限
public class QxAuthorityResource {
	@GeneratedValue(generator="tableIdGenerator")
    @GenericGenerator(name="tableIdGenerator", 
    	strategy="com.pfkj.oas.util.KeyUtil",
    	parameters={@Parameter(name="pkLen",value="20")})
	@Id
	@Column(name = "ID", unique = true, length=20, nullable=false)
	private String id;

	@Column(name = "ISENABLED", nullable=false)
	private boolean isEnabled;
	
	@Column(name = "AUTHORITY_ID", length=20, nullable=false)
	private String authority_id; 

	@Column(name = "RESOURCE_ID", length=20, nullable=false)
	private String resource_id;

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

	public String getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(String authority_id) {
		this.authority_id = authority_id;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

}
