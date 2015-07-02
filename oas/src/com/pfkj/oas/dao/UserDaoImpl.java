package com.pfkj.oas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxAuthorityResource;
import com.pfkj.oas.model.qx.QxResource;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public class UserDaoImpl implements UserDao {


	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional("transactionManager")
	public void save(QxUser qxuser) {
		System.out.print("UserDao开始");
		//sessionFactory.getCurrentSession().save(qxuser);
		System.out.print("UserManager成功");
		
		
		QxAuthority authority = new QxAuthority();
		authority.setName("AUTH_ADMIN");
		authority.setDesc("管理员");
		authority.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority);
		
		QxAuthority authority1 = new QxAuthority();
		authority1.setName("AUTH_SWZG");
		authority1.setDesc("商务主管");
		authority1.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority1);
		
		QxAuthority authority2 = new QxAuthority();
		authority2.setName("AUTH_CWRY");
		authority2.setDesc("财务人员");
		authority2.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority2);

		QxAuthority authority3 = new QxAuthority();
		authority3.setName("AUTH_JBR");
		authority3.setDesc("经办人");
		authority3.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority3);
		
		QxAuthority authority4 = new QxAuthority();
		authority4.setName("AUTH_XMGL");
		authority4.setDesc("项目管理人员");
		authority4.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority4);

		QxAuthority authority5 = new QxAuthority();
		authority5.setName("AUTH_JCS");
		authority5.setDesc("监察室");
		authority5.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority5);
		
		QxAuthority authority6 = new QxAuthority();
		authority6.setName("AUTH_TJY");
		authority6.setDesc("统计员");
		authority6.setEnabled(true);
		sessionFactory.getCurrentSession().save(authority6);
		
		QxRole role = new QxRole();
		role.setDesc("管理员");
		role.setEnabled(true);
		role.setName("ROLE_ADMIN");
		sessionFactory.getCurrentSession().save(role);

		QxRole role1 = new QxRole();
		role1.setDesc("商务主管");
		role1.setEnabled(true);
		role1.setEnabled(true);
		role1.setName("ROLE_SWZG");
		sessionFactory.getCurrentSession().save(role1);

		QxRole role2 = new QxRole();
		role2.setDesc("财务人员");
		role2.setEnabled(true);
		role2.setEnabled(true);
		role2.setName("ROLE_CWRY");
		sessionFactory.getCurrentSession().save(role2);

		QxRole role3 = new QxRole();
		role3.setDesc("经办人");
		role3.setEnabled(true);
		role3.setEnabled(true);
		role3.setName("ROLE_JBR");
		sessionFactory.getCurrentSession().save(role3);

		QxRole role4 = new QxRole();
		role4.setDesc("项目经理");
		role4.setEnabled(true);
		role4.setEnabled(true);
		role4.setName("ROLE_XMGL");
		sessionFactory.getCurrentSession().save(role4);

		QxRole role5 = new QxRole();
		role5.setDesc("监察室");
		role5.setEnabled(true);
		role5.setEnabled(true);
		role5.setName("ROLE_JCS");
		sessionFactory.getCurrentSession().save(role5);

		QxRole role6 = new QxRole();
		role6.setDesc("统计员");
		role6.setEnabled(true);
		role6.setEnabled(true);
		role6.setName("ROLE_TJY");
		sessionFactory.getCurrentSession().save(role6);
		
		
		QxUser user = addUser("admin", "管理员", "管理员", "123");
		QxUser user6 = addUser("tjy", "统计员", "统计员", "123");
		QxUser user4 = addUser("xmgl", "项目管理人员", "项目管理人员", "123");
		QxUser user5 = addUser("jcs", "监察室", "监察室", "123");
		QxUser user3 = addUser("jbr", "经办人", "经办人", "123");
		QxUser user2 = addUser("cwry", "财务人员", "财务人员", "123");
		QxUser user1 = addUser("swzg", "商务主管", "商务主管", "123");
		
		QxResource resource = addRes("录入结算单数据", "录入结算单数据", "/ywgl/lrjsdsj/lrjsdsj.jsp");
		QxResource resource1 = addRes("录入结算合同数据", "录入结算合同数据", "/ywgl/lrjshtsj/lrjshtsj.jsp");
		QxResource resource2 = addRes("生成结算单", "生成结算单", "/ywgl/scjsd/scjsd.jsp");
		QxResource resource3 = addRes("查询结算单", "查询结算单", "/cxgl/cxjsd/cxjsd.jsp");
		QxResource resource4 = addRes("查询结算合同台账", "查询结算合同台账", "/cxgl/cxjshttz/cxjshttz.jsp");
		QxResource resource5 = addRes("确认复核结算单", "确认复核结算单", "/ywgl/qrfhjsd/qrfhjsd.jsp");
		
		QxResource resource6 = addRes("授权付款", "授权付款", "/ywgl/sqfk/sqfk.jsp");
		QxResource resource7 = addRes("预授权付款", "预授权付款", "/ywgl/ysqfk/ysqfk.jsp");
		QxResource resource8 = addRes("生成付款通知单", "生成付款通知单", "/ywgl/scfktzd/scfktzd.jsp");
		QxResource resource9 = addRes("确认付款通知单", "确认付款通知单", "/ywgl/qrfktzd/qrfktzd.jsp");
		QxResource resource10 = addRes("查询付款通知单", "查询付款通知单", "/cxgl/cxfktzd/cxfktzd.jsp");
		QxResource resource11 = addRes("录入资金日报", "录入资金日报", "/ywgl/lrzjrb/lrzjrb.jsp");
		QxResource resource12 = addRes("查询资金日报", "查询资金日报", "/cxgl/cxzjrb/cxzjrb.jsp");
		QxResource resource13 = addRes("查询回收款", "查询回收款", "/cxgl/cxhsk/cxhsk.jsp");
		QxResource resource14 = addRes("录入收入合同", "录入收入合同", "/ywgl/lrsrht/lrsrht.jsp");
		QxResource resource15 = addRes("录入收款通知单", "录入收款通知单", "/ywgl/lrsktzd/lrsktzd.jsp");
		QxResource resource16 = addRes("查询收款通知单", "查询收款通知单", "/cxgl/cxsktzd/cxsktzd.jsp");
		
		setAuthorityResource( authority, resource);
		setAuthorityResource( authority, resource1);
		setAuthorityResource( authority, resource2);
		setAuthorityResource( authority, resource3);
		setAuthorityResource( authority, resource4);
		setAuthorityResource( authority, resource5);
		setAuthorityResource( authority, resource6);
		setAuthorityResource( authority, resource7);
		setAuthorityResource( authority, resource8);
		setAuthorityResource( authority, resource9);
		setAuthorityResource( authority, resource10);
		setAuthorityResource( authority, resource11);
		setAuthorityResource( authority, resource12);
		setAuthorityResource( authority, resource13);
		setAuthorityResource( authority, resource14);
		setAuthorityResource( authority, resource15);
		setAuthorityResource( authority, resource16);
		
		setAuthorityResource( authority1, resource3);
		setAuthorityResource( authority1, resource13);
		setAuthorityResource( authority1, resource14);
		setAuthorityResource( authority1, resource15);
		
		setAuthorityResource( authority2, resource3);
		setAuthorityResource( authority2, resource9);
		setAuthorityResource( authority2, resource10);
		setAuthorityResource( authority2, resource11);
		setAuthorityResource( authority2, resource12);
		

		setAuthorityResource( authority3, resource2);
		setAuthorityResource( authority3, resource3);
		setAuthorityResource( authority3, resource8);
		
		setAuthorityResource( authority4, resource3);
		setAuthorityResource( authority4, resource4);
		setAuthorityResource( authority4, resource6);
		setAuthorityResource( authority4, resource7);
		setAuthorityResource( authority4, resource10);
		setAuthorityResource( authority4, resource12);
		setAuthorityResource( authority4, resource13);
		setAuthorityResource( authority4, resource16);
		

		setAuthorityResource( authority5, resource3);
		setAuthorityResource( authority5, resource4);
		setAuthorityResource( authority5, resource5);
		setAuthorityResource( authority5, resource12);
		setAuthorityResource( authority5, resource13);
		
		setAuthorityResource( authority6, resource);
		setAuthorityResource( authority6, resource1);
		setAuthorityResource( authority6, resource2);
		setAuthorityResource( authority6, resource3);
		
		setUserRole(user,role);
		setUserRole(user1,role1);
		setUserRole(user2,role2);
		setUserRole(user3,role3);
		setUserRole(user4,role4);
		setUserRole(user5,role5);
		setUserRole(user6,role6);
		
		setRoleAuthority(role,authority);
		setRoleAuthority(role1,authority1);
		setRoleAuthority(role2,authority2);
		setRoleAuthority(role3,authority3);
		setRoleAuthority(role4,authority4);
		setRoleAuthority(role5,authority5);
		setRoleAuthority(role6,authority6);
		
	}
	@Transactional("transactionManager")
	public QxUser addUser(String account, String desc, String name, String password){
		QxUser user = new QxUser();
		user.setAccount(account);
		user.setDesc(desc);
		user.setEnabled(true);
		user.setName(name);
		user.setPassword(password);
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Transactional("transactionManager")
	public QxResource addRes(String desc, String name, String url){
		QxResource resource = new QxResource();
		resource.setEnabled(true);
		resource.setName(name);
		resource.setDesc(desc);;
		resource.setResString(url);
		resource.setType("URL");
		sessionFactory.getCurrentSession().save(resource);
		return resource;
	}
	

	@Transactional("transactionManager")
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
	
	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public List<QxAuthority> getAuthorityByUser(QxUser user) {
		StringBuffer sql = new StringBuffer();
		sql.append("select {au.*} from glxt_qx_user_role ur,glxt_qx_role_authority ra,glxt_qx_authority au");
		sql.append(" where ur.user_id=");
		sql.append(user.getId());
		sql.append(" and ra.role_id=ur.role_id");
		sql.append(" and au.id=ra.authority_id");
		sql.append(" and au.isEnabled='1'");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
		query.addEntity("au", QxAuthority.class);
		List<QxAuthority> aulist = query.list();
		return aulist;
	}

	@SuppressWarnings("unchecked")
	@Transactional("transactionManager")
	@Override
	public QxUser getUserById(String id) {
		StringBuffer hql = new StringBuffer();
		hql.append("from QxUser where id="+id);
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
	
}
