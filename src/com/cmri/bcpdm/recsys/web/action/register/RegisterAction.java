package com.cmri.bcpdm.recsys.web.action.register;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONArray;

import com.cmri.bcpdm.recsys.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private String userId = "";
	private String userName = "";
	private String pwd = "";
	private String checkInfo = "";

	public String register() throws Exception {
		System.out.println("Registe user:" + userId);
		checkInfo = new UserService().addUser(userId, userName, pwd);
		if (checkInfo.equals(SUCCESS)) {
			String userName = new UserService().getUserName(userId);
			ActionContext.getContext().getSession().put("USER_ID", userId);
			ActionContext.getContext().getSession().put("USER_NAME", userName);
		}
		System.out.println(checkInfo);
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

}