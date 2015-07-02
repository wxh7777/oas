package com.pfkj.oas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.XiangMuVo;
import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public class BaseDaoImpl  implements BaseDao  {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> find(String hql) {

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
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
	@SuppressWarnings("unchecked")
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

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
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

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
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

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
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

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
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
	

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<QxResource> getResourceByAuth(QxAuthority auth) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {res.*} from glxt_qx_authority_resource ar,glxt_qx_resource res");
		sql.append(" where ar.authority_id='");
		sql.append(auth.getId());
		sql.append("' and ar.resource_id=res.id");
		sql.append(" and res.res_enabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("res", QxResource.class);
		List<QxResource> reslist = query.list();
		return reslist;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<QxUser> getUserByProject(XiangMuVo xm) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {user.*} from glxt_user_xm ux,glxt_qx_user user");
		sql.append(" where ux.xmid='");
		sql.append(xm.getId());
		sql.append("' and ux.user_id=user.id");
		sql.append(" and user.user_isenabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("user", QxUser.class);
		List<QxUser> userlist = query.list();
		return userlist;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
	@Override
	public List<QxAuthorityResource> getAuthResByAuth(QxAuthority auth) {
		String hql = "from QxAuthorityResource where authority_id='"+auth.getId()+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<QxAuthorityResource> arlist = query.list();
		return arlist; 
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
	    String sql = "delete from glxt_user_xm where xmid ='" + xm.getId()+"'";  
        SQLQuery query = session.createSQLQuery(sql);  
        query.executeUpdate();
        session.flush(); 
	}
	
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public QxRole getRoleByAuthId(String auth_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {role.*} from glxt_qx_role_authority ra,glxt_qx_role role");
		sql.append(" where ra.authority_id='");
		sql.append(auth_id);
		sql.append("' and ra.role_id=role.id");
		sql.append(" and role.role_enabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("role", QxRole.class);
		List<QxRole> rolist = query.list();
		if(rolist.size()>0){
			return rolist.get(0);
		}
		return null;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<QxRole> getRoleByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {role.*} from glxt_qx_user_role ur,glxt_qx_role role");
		sql.append(" where ur.user_id='");
		sql.append(user.getId());
		sql.append("' and role.id=ur.role_id");
		sql.append(" and role.role_enabled='1'");
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
	public QxAuthorityResource setAuthorityResource(QxAuthority au, QxResource re){
		QxAuthorityResource aResource = new QxAuthorityResource();
		aResource.setAuthority_id(au.getId());
		aResource.setResource_id(re.getId());
		aResource.setEnabled(true);
		sessionFactory.getCurrentSession().save(aResource);
		return aResource;
	}
	

	@Transactional("transactionManager")
	@Override
	public QxRoleAuthority setRoleAuthority(QxRole ro, QxAuthority au){
		QxRoleAuthority ra = new QxRoleAuthority();
		ra.setAuthority_id(au.getId());
		ra.setRole_id(ro.getId());
		ra.setEnabled(true);
		sessionFactory.getCurrentSession().save(ra);
		return ra;
	}
	

	@Transactional("transactionManager")
	@Override
	public QxUserRole setUserRole(QxUser user,QxRole role){
		QxUserRole ur = new QxUserRole();
		ur.setRole_id(role.getId());
		ur.setUser_id(user.getId());
		ur.setEnabled(true);
		sessionFactory.getCurrentSession().save(ur);
		return ur;
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
	public QxUser getUserByNameAndPwd(String name, String password) {
		String hql = "from QxUser u where u.name = :name and u.password =:password";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		if(query.list().size()>0){
			return (QxUser)query.list().get(0);
		}
		else{
			return null;
		}
	}

	@Transactional("transactionManager")
	@Override
	public String getPassword(String name) {
		QxUser user = getUserByName(name);
		if(user!=null){
			String pwd=user.getPassword();
			return pwd;
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
	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<XiangMuVo> getProjectByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {xm.*} from glxt_user_xm ux,glxt_xiangmu xm");
		sql.append(" where ux.user_id='");
		sql.append(user.getId());
		sql.append("' and ux.xmid=xm.xm_id");
		sql.append(" and xm.yxbz='Y'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("xm", XiangMuVo.class);
		List<XiangMuVo> xmlist = query.list();
		return xmlist;
	}

	@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	@Override
	public List<QxAuthority> getAuthorityByRole(QxRole role) {
		List<QxAuthority> list = new ArrayList<QxAuthority>();
		String id = role.getId();
		String sql = "select a.* from QxRoleAuthority ra,QxAuthority a where ra.role_id = :roleid and ra.authority_id=a.id and ra.enabled = '1'";

		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setString("roleid", id);
		List<Object> queryList = query.list();
		for(int i = 0;i<queryList.size();i++){
			QxAuthority authority = (QxAuthority)queryList.get(i);
			list.add(authority);
		}
		return list;
	}

	@Transactional("transactionManager")
	@Override
	public QxRole getRoleByName(String name) {
		String hql = "from QxRole u where u.name = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		if(query.list().size()>0){
			return (QxRole)query.list().get(0);
		}
		else{
			return null;
		}
	}

	@Transactional("transactionManager")
	@Override
	public QxResource getResourceByName(String name) {
		String hql = "from QxResource r where r.name = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		if(query.list().size()>0){
			return (QxResource)query.list().get(0);
		}
		else{
			return null;
		}
	}
}
