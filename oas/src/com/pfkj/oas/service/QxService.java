package com.pfkj.oas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pfkj.oas.action.vo.AuthorityFormVo;
import com.pfkj.oas.action.vo.ProjectFormVo;
import com.pfkj.oas.action.vo.RoleFormVo;
import com.pfkj.oas.action.vo.UserFormVo;
import com.pfkj.oas.manager.QxManager;
import com.pfkj.oas.model.UserXm;
import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;
import com.pfkj.oas.util.CacheUtil;
import com.pfkj.oas.util.JsonUtil;

public class QxService {
	QxManager manager;
	
	public QxManager getManager() {
		return manager;
	}

	public void setManager(QxManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("rawtypes")
	public String searchUser() {
		List<QxUser> list = manager.searchUser();
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			QxUser user = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
	        map.put("ID", user.getId().toString());
	        map.put("NAME", user.getName());
	        map.put("DLZH", user.getAccount());
	        map.put("DESC", user.getDesc());
	        List<QxRole> roleList = manager.getRoleByUser(user);
	        String qxlb = "";
	        String qxlbid = "";
			for(QxRole role : roleList){
				qxlb = qxlb+role.getDesc()+";";
				qxlbid = qxlbid+role.getId()+";";
			}
	        map.put("QXLB", qxlb);
	        map.put("QXLBID", qxlbid);
	        map.put("BZ", user.getDesc());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}


	@SuppressWarnings("rawtypes")
	public String searchRole() {
		List<QxRole> list = manager.searchRole();
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			QxRole role = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
	        map.put("ID", role.getId().toString());
	        map.put("NAME", role.getName());
	        map.put("DESC", role.getDesc());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	@SuppressWarnings("rawtypes")
	public String searchAuthority() {
		List<QxAuthority> list = manager.searchAuthority();
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			QxAuthority auth = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
	        map.put("ID", auth.getId());
	        map.put("NAME", auth.getName());
	        map.put("DESC", auth.getDesc());
	        List<QxResource> resList = manager.getResourceByAuth(auth);
	        String gnlb = "";
	        String gnlbid = "";
			for(QxResource res : resList){
				gnlb = gnlb+res.getName()+";";
				gnlbid = gnlbid+res.getId().toString()+",";
			}
	        map.put("GNLB", gnlb);
	        map.put("GNLBID", gnlbid);
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}

	@SuppressWarnings("rawtypes")
	public String searchResource() {
		List<QxResource> list = manager.searchResource();
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			QxResource res = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("ID", res.getId());
	        map.put("NAME", res.getName());
	        map.put("URL", res.getResString());
	        map.put("TYPE", res.getType());
	        map.put("DESC", res.getDesc());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}

	@SuppressWarnings("rawtypes")
	public String searchProject() {
		List<XiangMuVo> list = manager.searchProjects();
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			XiangMuVo xm = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("ID", xm.getId());
	        map.put("NAME", xm.getXmmc());
	        map.put("XMSM", xm.getDesc());
	        List<QxUser> userList = manager.getUserByProject(xm);
	        StringBuffer ryqxlb = new StringBuffer();
			String rylbid = "";
	        for(QxUser user : userList){
				ryqxlb.append(user.getName());
				ryqxlb.append(";");
				rylbid = rylbid + user.getId().toString() +";";
			}
	        map.put("RYLB", ryqxlb.toString());
	        map.put("RYLBID", rylbid.toString());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}

	public String searchSearch() {
		return null;
	}
	
	public void saveAuthority(AuthorityFormVo authForm) {
		QxAuthority auth = new QxAuthority();
		if(authForm.getId()!=null && !("").equals(authForm.getId())){
			auth = manager.getAuthorityById(authForm.getId());
			manager.deleteAuthResAboutAuth(auth);
			//manager.deleteRoleAuthAboutAuth(auth);
		}
		auth.setDesc(authForm.getDesc());
		auth.setName(authForm.getName());
		auth.setEnabled(true);
		manager.saveAuthority(auth);
		
		
		String gnlb = authForm.getSelgnlb();
		String[] gnlbs = gnlb.split(",");
		for(int i=0; i<gnlbs.length; i++){
			String resid = gnlbs[i].replaceAll(" ","");
			if(!"".equals(resid)){
				
				QxAuthorityResource ar = manager.getAuthResbyAR(auth.getId(),resid);
				if(ar == null){
					ar = new QxAuthorityResource();
				}
				ar.setAuthority_id(auth.getId());
				ar.setResource_id(resid);
				ar.setEnabled(true);
				manager.saveAuthRes(ar);
			}
		}
		RoleFormVo roleForm = new RoleFormVo();
		roleForm.setAuth_id(auth.getId().toString());
		roleForm.setDesc(authForm.getDesc());
		roleForm.setName(authForm.getName());
		this.saveRole(roleForm);
	}

	private void saveRole(RoleFormVo roleForm) {
		QxRole role = new QxRole();
		if(roleForm.getAuth_id()!=null && !("").equals(roleForm.getAuth_id())){
			role = manager.getRoleByAuthId(roleForm.getAuth_id());
			if(role!=null){
				role.setName(roleForm.getName());
				role.setDesc(roleForm.getDesc());
				role.setEnabled(true);
				manager.saveRole(role);
			}else{
				role = new QxRole();
				role.setName(roleForm.getName());
				role.setDesc(roleForm.getDesc());
				role.setEnabled(true);
				manager.saveRole(role);
				//manager.deleteRoleAuthorityAboutRole(role);
				QxRoleAuthority ra = manager.getRoleAuthbyRA(role.getId(), roleForm.getAuth_id());
				if(ra == null){
					ra = new QxRoleAuthority();
				}
				ra.setEnabled(true);
				ra.setRole_id(role.getId());
				ra.setAuthority_id(roleForm.getAuth_id());
				manager.saveRoleAuth(ra);
			}
		}
	}

	public void deleteUser(String id) {
		manager.deleteUser(id);
	}

	public void deleteAuthority(String id) {
		manager.deleteAuthority(id);
	}

	public void deleteResource(String id) {
		QxResource res = manager.getResourceById(id);
		manager.deleteResource(res);
	}

	public void deleteProject(String id) {
		XiangMuVo xm = manager.getProjectById(id);
		manager.deleteProject(xm);
	}

	public void saveUser(UserFormVo userFrom) {
		QxUser user = new QxUser();
		if(userFrom.getId()!=null && !("").equals(userFrom.getId())){
			user = manager.getUserById(userFrom.getId());
			manager.deleteUserRoleAboutUser(user);
			//manager.deleteUserXmAboutUser(user);
		}
		user.setName(userFrom.getUsername());
		user.setAccount(userFrom.getAccount());
		user.setDesc(userFrom.getDesc());
		user.setPassword(userFrom.getPassword());
		user.setEnabled(true);
		manager.saveUser(user);
		String qxlb = userFrom.getSelqxlb();
		String[] qxlbs = qxlb.split(",");
		for(int i=0; i<qxlbs.length; i++){
			String qxid = qxlbs[i].replaceAll(" ","");
			if(!"".equals(qxid)){
				QxUserRole ur = manager.getUserRolebyUR(user.getId(), qxid);
				if(ur==null){
					ur = new QxUserRole();
				}
				ur.setUser_id(user.getId());
				ur.setRole_id(qxid);
				ur.setEnabled(true);
				manager.saveUserRole(ur);
			}
		}
	}

	public void saveProject(ProjectFormVo proAdd) {
		XiangMuVo xm = new XiangMuVo();
		if(proAdd.getId()!=null && !("").equals(proAdd.getId())){
			xm = manager.getProjectById(proAdd.getId());
			manager.deleteUserXmAboutXm(xm);
			//manager.deleteUserXmAboutUser(user);
		}
		xm.setXmmc(proAdd.getName());
		xm.setDesc(proAdd.getXmsm());
		xm.setEnabled(true);
		manager.saveProject(xm);
		String rylb = proAdd.getSelrylb();
		String[] users = rylb.split(",");
		for(int i=0; i<users.length; i++){
			String userid = users[i].replaceAll(" ","");
			if(!"".equals(userid)){
				UserXm ux = manager.getUserXmByUX(userid, xm.getId());
				if(ux==null){
					ux = new UserXm();
				}
				ux.setUser_id(userid);
				ux.setXm_id(xm.getId());
				ux.setEnabled(true);
				manager.saveUserXm(ux);
			}
		}
	}

	public QxUser searchUserByAccount(String username) {
		return manager.searchUserByAccount(username);
	}

	@SuppressWarnings("rawtypes")
	public String getProjects(QxUser user) {
		List<XiangMuVo> list = manager.getProjects(user);
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			XiangMuVo xm = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("ID", xm.getId());
	        map.put("NAME", xm.getXmmc());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	
	public String getGnlbStr(String username) {
		QxUser user = manager.getUserByName(username);
		List<QxResource> resList = manager.getResourceByUser(user);
		String resListStr = this.generateResJson(resList);
		return resListStr;
	}

	@SuppressWarnings("rawtypes")
	private String generateResJson(List<QxResource> list){
		List<Map> listMap = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			QxResource res = list.get(i);
			Map<String, String> map = new HashMap<String, String>();
			map.put("ID", res.getId());
	        map.put("NAME", res.getName());
	        map.put("URL", res.getResString());
	        map.put("TYPE", res.getType());
	        map.put("DESC", res.getDesc());
	        listMap.add(map);
		}
        String result = JsonUtil.BuildJson(listMap);
        return result;
	}
	

	public String getCache(String key) {
		return CacheUtil.getInstance().getCache(key);
	}
}
