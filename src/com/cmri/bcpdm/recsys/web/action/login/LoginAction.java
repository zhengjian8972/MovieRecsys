package com.cmri.bcpdm.recsys.web.action.login;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONArray;

import com.cmri.bcpdm.recsys.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String userId = "";
	private String password = "";
	private String checkInfo = "";

	public String check() throws Exception {
		checkInfo = new UserService().loginSucc(userId, password);
		if (checkInfo.equals(SUCCESS)) {
			String userName = new UserService().getUserName(userId);
			ActionContext.getContext().getSession().put("USER_ID", userId);
			ActionContext.getContext().getSession().put("USER_NAME", userName);
		}
		return SUCCESS;
	}

	public String logout() {
		System.out.println("Logout user:"+userId);
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

}