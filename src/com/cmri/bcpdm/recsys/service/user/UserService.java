package com.cmri.bcpdm.recsys.service.user;

import com.cmri.bcpdm.recsys.model.impl.User;
import com.cmri.bcpdm.recsys.persistence.UserDAO;
import com.cmri.bcpdm.recsys.util.MD5Tool;

public class UserService {

	// 判断是否登录成功
	public String loginSucc(String id, String pwd) {
		UserDAO ud = new UserDAO();
		User user = ud.findById(id);
		ud = null;
		if (user == null)
			return com.opensymphony.xwork2.Action.NONE;
		if (user.getPwd().equals(MD5Tool.mainMD5(pwd).toLowerCase()))
			return com.opensymphony.xwork2.Action.SUCCESS;
		return com.opensymphony.xwork2.Action.ERROR;
	}

	// 根据用户ID获取用户名
	public String getUserName(String id) {
		UserDAO ud = new UserDAO();
		User user = ud.findById(id);
		ud = null;
		return user.getUserName();
	}

	// 添加用户
	public String addUser(String id, String name, String pwd) {
		UserDAO ud = new UserDAO();
		User user = ud.findById(id);
		if (user != null) {
			return com.opensymphony.xwork2.Action.ERROR;
		}
		user = new User();
		user.setUserId(id);
		user.setUserName(name);
		user.setPwd(MD5Tool.mainMD5(pwd).toLowerCase());
		ud.save(user);
		return com.opensymphony.xwork2.Action.SUCCESS;
	}

}
