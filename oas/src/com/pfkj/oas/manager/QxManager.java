package com.pfkj.oas.manager;

import java.util.List;

import com.pfkj.oas.dao.QxDao;
import com.pfkj.oas.model.UserXm;
import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public class QxManager {
	QxDao dao;

	public QxDao getDao() {
		return dao;
	}

	public void setDao(QxDao dao) {
		this.dao = dao;
	}

	public List<QxUser> searchUser() {
		return dao.getUserList();
	}

	public List<QxRole> searchRole() {
		return dao.getRoleList();
	}
	public List<QxAuthority> searchAuthority() {
		return dao.getAuthorityList();
	}

	public List<QxResource> searchResource() {
		return dao.getResourceList();
	}

	public List<XiangMuVo> searchProjects() {
		return dao.getProjectList();
	}

	public QxResource getResourceById(String id) {
		return dao.getResourceById(id);
	}
	public QxAuthority getAuthorityById(String id) {
		return dao.getAuthorityById(id);
	}
	public QxRole getRoleById(String id) {
		return dao.getRoleById(id);
	}
	public QxUser getUserById(String id) {
		return dao.getUserById(id);
	}
	public XiangMuVo getProjectById(String id) {
		return dao.getProjectById(id);
	}

	public void saveUser(QxUser user) {
		dao.save(user);
	}
	public void saveAuthority(QxAuthority auth) {
		dao.save(auth);
	}
	public void saveResource(QxResource res) {
		dao.save(res);
	}
	public void saveRole(QxRole role) {
		dao.save(role);
	}
	public void saveUserRole(QxUserRole ur) {
		dao.save(ur);
	}
	public void saveRoleAuth(QxRoleAuthority ra) {
		dao.save(ra);
	}
	public void saveAuthRes(QxAuthorityResource ar) {
		dao.save(ar);
	}

	public void saveUserXm(UserXm ux) {
		dao.save(ux);
	}
	public void saveProject(XiangMuVo xm) {
		dao.save(xm);
	}
	public void deleteAuthority(String id) {
		QxAuthority auth = dao.getAuthorityById(id);
		if(auth!=null){
			dao.delete(auth);
			this.deleteAuthResAboutAuth(auth);
		}
		QxRole role = dao.getRoleByAuthId(id);
		if(role!=null){
			dao.delete(role);
			this.deleteRoleAuthAboutAuth(auth);
			this.deleteUserRoleAboutRole(role);
		}
		//List<QxAuthorityResource> arList = dao.getAuthResListById(id);
		//for(QxAuthorityResource ar:arList){
		//	dao.delete(ar);
		//}
		//dao.deleteAuthorityResource(id);
		//dao.deleteAuthority(id);
	}
	public void deleteResource(QxResource res) {
		res.setEnabled(false);
		dao.save(res);
	}
	public void deleteRole(QxRole role) {
		role.setEnabled(false);
		dao.save(role);
	}
	public void deleteUser(String id) {
		QxUser user = dao.getUserById(id);
		if(user!=null){
			dao.delete(user);
			this.deleteUserRoleAboutUser(user);
			this.deleteXmUserAboutUser(user);
		}
	}
	private void deleteXmUserAboutUser(QxUser user) {
		dao.deleteUserXmByUser(user);
	}

	public void deleteUserRole(QxUserRole ur) {
		ur.setEnabled(false);
		dao.save(ur);
	}
	public void deleteRoleAuth(QxRoleAuthority ra) {
		ra.setEnabled(false);
		dao.save(ra);
	}
	public void deleteAuthRes(QxAuthorityResource ar) {
		ar.setEnabled(false);
		dao.save(ar);
	}
	public void deleteProject(XiangMuVo xm) {
		xm.setEnabled(false);
		dao.save(xm);
	}

	public List<QxUser> getUserByProject(XiangMuVo xm) {
		return dao.getUserByProject(xm);
	}

	public List<QxResource> getResourceByAuth(QxAuthority auth) {
		return dao.getResourceByAuth(auth);
	}

	public List<QxAuthority> getAuthorityByUser(QxUser user) {
		return dao.getAuthorityByUser(user);
	}

	public void deleteAuthResAboutAuth(QxAuthority auth) {
		/*List<QxAuthorityResource> list = dao.getAuthResByAuth(auth);
		for(QxAuthorityResource ar:list){
			dao.delete(ar);
		}*/
		dao.deleteAuthResByAuth(auth);
		
	}

	public void deleteRoleAuthAboutAuth(QxAuthority auth) {
		dao.deleteRoleAuthByAuth(auth);
	}

	public QxRole getRoleByAuthId(String auth_id) {
		// TODO Auto-generated method stub
		return dao.getRoleByAuthId(auth_id);
	}

	public void deleteUserRoleAboutRole(QxRole role) {
		dao.deleteUserRoleByRole(role);
	}

	public void deleteRoleAuthorityAboutRole(QxRole role) {
		dao.deleteRoleAuthorityByRole(role);
	}

	public void deleteUserRoleAboutUser(QxUser user) {
		dao.deleteUserRoleByAuth(user);
	}

	public void deleteUserXmAboutUser(QxUser user) {
		dao.deleteUserXmByUser(user);
	}

	public List<QxRole> getRoleByUser(QxUser user) {
		return dao.getRoleByUser(user);
	}

	public void deleteUserXmAboutXm(XiangMuVo xm) {
		dao.deleteUserXmByXm(xm);
	}

	public QxUser searchUserByAccount(String username) {
		return dao.searchUserByAccount(username);
	}

	public List<XiangMuVo> getProjects(QxUser user) {
		// TODO Auto-generated method stub
		return dao.getProjectByUser(user);
	}

	public QxUser getUserByName(String username) {
		return dao.getUserByName(username);
	}

	public List<QxResource> getResourceByUser(QxUser user) {
		return dao.getResourceByUser(user);
	}

	public QxAuthorityResource getAuthResbyAR(String id, String resid) {
		return dao.getAuthResbyAR(id, resid);
	}

	public QxRoleAuthority getRoleAuthbyRA(String roleid, String authid) {
		return dao.getRoleAuthbyRA(roleid, authid);
	}

	public QxUserRole getUserRolebyUR(String userid, String roleid) {
		return dao.getUserRolebyUR(userid, roleid);
	}

	public UserXm getUserXmByUX(String userid, String xmid) {
		return dao.getUserXmByUX(userid, xmid);
	}




}
