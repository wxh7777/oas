package com.pfkj.oas.dao;

import java.util.List;

import com.pfkj.oas.model.qx.QxAuthority;
import com.pfkj.oas.model.qx.QxRole;
import com.pfkj.oas.model.qx.QxRoleAuthority;
import com.pfkj.oas.model.qx.QxUser;
import com.pfkj.oas.model.qx.QxUserRole;

public interface UserDao {

	QxUser getUserByNameAndPwd(String name, String password);

	void save(QxUser qxuser);

	QxUserRole setUserRole(QxUser user, QxRole role);

	QxUser getUserById(String id);

	QxUser getUserByName(String userAccount);

	List<QxAuthority> getAuthorityByUser(QxUser user);

	QxRoleAuthority setRoleAuthority(QxRole ro, QxAuthority au);

}
