package com.pfkj.oas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.UserXm;
import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public class QxDaoImpl  implements QxDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxUser> getUserList() {		
		StringBuffer hql = new StringBuffer();
		hql.append("from QxUser where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxUser> queryList = query.list();
		return queryList;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxRole> getRoleList() {		
		StringBuffer hql = new StringBuffer();
		hql.append("from QxRole where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxRole> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxAuthority> getAuthorityList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxAuthority where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxAuthority> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxResource> getResourceList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxResource where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxResource> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<XiangMuVo> getProjectList() {
		StringBuffer hql = new StringBuffer();
		hql.append("from XiangMuVo where isEnabled='1'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<XiangMuVo> queryList = query.list();
		return queryList;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxResource getResourceById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxResource where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxResource> queryList = query.list();
		if(queryList.size()>0){
			QxResource res = (QxResource)queryList.get(0);
			return res;
		}
		else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxAuthority getAuthorityById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxAuthority where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxAuthority> queryList = query.list();
		if(queryList.size()>0){
			QxAuthority auth = (QxAuthority)queryList.get(0);
			return auth;
		}
		else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxRole getRoleById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxRole where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxRole> queryList = query.list();
		if(queryList.size()>0){
			QxRole role = (QxRole)queryList.get(0);
			return role;
		}
		else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxUser getUserById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxUser where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<QxUser> queryList = query.list();
		if(queryList.size()>0){
			QxUser user = (QxUser)queryList.get(0);
			return user;
		}
		else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public XiangMuVo getProjectById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from XiangMuVo where id='"+id+"'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		List<XiangMuVo> queryList = query.list();
		if(queryList.size()>0){
			XiangMuVo xm = (XiangMuVo)queryList.get(0);
			return xm;
		}
		else{
			return null;
		}
	}
	

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxResource> getResourceByAuth(QxAuthority auth) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {res.*} from glxt_qx_authority_resource ar,glxt_qx_resource res");
		sql.append(" where ar.authority_id='");
		sql.append(auth.getId());
		sql.append("' and ar.resource_id=res.id");
		sql.append(" and res.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("res", QxResource.class);
		List<QxResource> reslist = query.list();
		return reslist;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxUser> getUserByProject(XiangMuVo xm) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {user.*} from glxt_user_xm ux,glxt_qx_user user");
		sql.append(" where ux.xm_id='");
		sql.append(xm.getId());
		sql.append("' and ux.user_id=user.id");
		sql.append(" and user.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("user", QxUser.class);
		List<QxUser> userlist = query.list();
		return userlist;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxAuthority> getAuthorityByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {au.*} from glxt_qx_user_role ur,glxt_qx_role_authority ra,glxt_qx_authority au");
		sql.append(" where ur.user_id='");
		sql.append(user.getId());
		sql.append("' and ra.role_id=ur.role_id");
		sql.append(" and au.id=ra.authority_id");
		sql.append(" and au.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("au", QxAuthority.class);
		List<QxAuthority> aulist = query.list();
		return aulist;
	}
	@Transactional("transactionManager")
	@Override
	public void deleteAuthResByAuth(QxAuthority auth) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_qx_authority_resource where authority_id ='" + auth.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteRoleAuthByAuth(QxAuthority auth) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_qx_role_authority where authority_id ='" + auth.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteUserRoleByRole(QxRole role) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_qx_user_role where role_id ='" + role.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteRoleAuthorityByRole(QxRole role) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_qx_role_authority where role_id ='" + role.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteUserRoleByAuth(QxUser user) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_qx_user_role where user_id ='" + user.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteUserXmByUser(QxUser user) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_user_xm where user_id ='" + user.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}

	@Transactional("transactionManager")
	@Override
	public void deleteUserXmByXm(XiangMuVo xm) {
		Session session = sessionFactory.getCurrentSession();
	    String sql = "delete from glxt_user_xm where xm_id ='" + xm.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxRole getRoleByAuthId(String auth_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {role.*} from glxt_qx_role_authority ra,glxt_qx_role role");
		sql.append(" where ra.authority_id='");
		sql.append(auth_id);
		sql.append("' and ra.role_id=role.id");
		sql.append(" and role.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("role", QxRole.class);
		List<QxRole> rolist = query.list();
		if(rolist.size()>0){
			return rolist.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxRole> getRoleByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {role.*} from glxt_qx_user_role ur,glxt_qx_role role");
		sql.append(" where ur.user_id='");
		sql.append(user.getId());
		sql.append("' and role.id=ur.role_id");
		sql.append(" and role.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("role", QxRole.class);
		List<QxRole> rolelist = query.list();
		return rolelist;
	}

	@Transactional("transactionManager")
	@Override
	public QxUser searchUserByAccount(String account) {
		String hql = "from QxUser u where u.account = :account and u.isEnabled='1'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("account", account);
		if(query.list().size()>0){
			return (QxUser)query.list().get(0);
		}
		else{
			return null;
		}
	}


	
	@Transactional("transactionManager")
	@Override
	public QxUser getUserByName(String account) {
		String hql = "from QxUser u where u.account = :account and u.isEnabled='1'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("account", account);
		if(query.list().size()>0){
			return (QxUser)query.list().get(0);
		}
		else{
			return null;
		}
	}




	@Transactional("transactionManager")
	@Override
	public List<QxResource> getResourceByUser(QxUser user) {
		List<QxAuthority> authList= this.getAuthorityByUser(user);
		List<QxResource> resList = new ArrayList<QxResource>();
		for(QxAuthority auth:authList){
			List<QxResource> res = this.getResourceByAuth(auth);
			resList.addAll(res);
		}
		return resList;
	}
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<XiangMuVo> getProjectByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {xm.*} from glxt_user_xm ux,glxt_xiangmu xm");
		sql.append(" where ux.user_id='");
		sql.append(user.getId());
		sql.append("' and ux.xm_id=xm.id");
		sql.append(" and xm.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("xm", XiangMuVo.class);
		List<XiangMuVo> xmlist = query.list();
		return xmlist;
	}

	@Transactional("transactionManager")
	@Override
	public void save(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	@Transactional("transactionManager")
	@Override
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Transactional("transactionManager")
	@Override
	public QxAuthorityResource getAuthResbyAR(String authid, String resid) {
		String hql = "from QxAuthorityResource where authority_id = :authid and resource_id=:resid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("authid", authid);
		query.setParameter("resid", resid);
		if(query.list().size()>0){
			return (QxAuthorityResource)query.list().get(0);
		}
		else{
			return null;
		}
	}

	@Transactional("transactionManager")
	@Override
	public QxRoleAuthority getRoleAuthbyRA(String roleid, String authid) {
		String hql = "from QxRoleAuthority where role_id = :roleid and authority_id=:authid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("roleid", roleid);
		query.setParameter("authid", authid);
		if(query.list().size()>0){
			return (QxRoleAuthority)query.list().get(0);
		}
		else{
			return null;
		}
	}

	@Transactional("transactionManager")
	@Override
	public QxUserRole getUserRolebyUR(String userid, String roleid) {
		String hql = "from QxUserRole where user_id = :userid and role_id=:roleid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userid", userid);
		query.setParameter("roleid", roleid);
		if(query.list().size()>0){
			return (QxUserRole)query.list().get(0);
		}
		else{
			return null;
		}
	}

	@Transactional("transactionManager")
	@Override
	public UserXm getUserXmByUX(String userid, String xmid) {
		String hql = "from UserXm where user_id = :userid and xm_id=:xmid";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("userid", userid);
		query.setParameter("xmid", xmid);
		if(query.list().size()>0){
			return (UserXm)query.list().get(0);
		}
		else{
			return null;
		}
	}
	

}
