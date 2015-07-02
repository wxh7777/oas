package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.UserXm;
import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public interface QxDao {

	List<XiangMuVo> getProjectList();

	List<QxResource> getResourceList();

	List<QxAuthority> getAuthorityList();

	List<QxRole> getRoleList();

	List<QxUser> getUserList();

	QxResource getResourceById(String id);

	QxAuthority getAuthorityById(String id);

	QxRole getRoleById(String id);

	QxUser getUserById(String id);

	XiangMuVo getProjectById(String id);

	void save(Object user);

	void delete(Object auth);

	QxRole getRoleByAuthId(String id);

	void deleteUserXmByUser(QxUser user);

	List<QxUser> getUserByProject(XiangMuVo xm);

	List<QxResource> getResourceByAuth(QxAuthority auth);

	List<QxAuthority> getAuthorityByUser(QxUser user);

	void deleteAuthResByAuth(QxAuthority auth);

	void deleteRoleAuthByAuth(QxAuthority auth);

	void deleteUserRoleByRole(QxRole role);

	void deleteRoleAuthorityByRole(QxRole role);

	void deleteUserRoleByAuth(QxUser user);

	List<QxRole> getRoleByUser(QxUser user);

	void deleteUserXmByXm(XiangMuVo xm);

	QxUser searchUserByAccount(String username);

	List<XiangMuVo> getProjectByUser(QxUser user);

	QxUser getUserByName(String username);

	List<QxResource> getResourceByUser(QxUser user);

	QxAuthorityResource getAuthResbyAR(String authid, String resid);
	QxRoleAuthority getRoleAuthbyRA(String roleid, String authid);
	QxUserRole getUserRolebyUR(String userid, String roleid);
	UserXm getUserXmByUX(String userid,String xmid);

}
