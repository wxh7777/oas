package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;


public interface BaseDao {
	List<Object> find(String sql);
	
	XiangMuVo getProjectById(String id);
	QxUser getUserById(String id);
	QxRole getRoleById(String id);
	QxAuthority getAuthorityById(String id);
	QxResource getResourceById(String id);
	QxRole getRoleByAuthId(String auth_id);
	
	List<QxResource> getResourceByAuth(QxAuthority auth);
	List<QxUser> getUserByProject(XiangMuVo xm);
	List<QxAuthority> getAuthorityByUser(QxUser user);
	List<QxAuthorityResource> getAuthResByAuth(QxAuthority auth);
	List<QxRole> getRoleByUser(QxUser user);
	List<QxResource> getResourceByUser(QxUser user);
	List<XiangMuVo> getProjectByUser(QxUser user);
	List<QxAuthority> getAuthorityByRole(QxRole role);
	
	void deleteUserXmByUser(QxUser user);
	void deleteAuthResByAuth(QxAuthority auth);
	void deleteRoleAuthByAuth(QxAuthority auth);
	void deleteUserRoleByRole(QxRole role);
	void deleteRoleAuthorityByRole(QxRole role);
	void deleteUserRoleByAuth(QxUser user);
	void deleteUserXmByXm(XiangMuVo xm);
	
	QxUserRole setUserRole(QxUser user, QxRole role);
	QxRoleAuthority setRoleAuthority(QxRole ro, QxAuthority au);
	QxAuthorityResource setAuthorityResource(QxAuthority au, QxResource re);
	
	String getPassword(String name);
	QxUser searchUserByAccount(String account);
	QxUser getUserByNameAndPwd(String name, String password);
	QxUser getUserByName(String account);
	QxRole getRoleByName(String name);
	QxResource getResourceByName(String name);
	void save(Object obj);
	void delete(Object obj);
}
