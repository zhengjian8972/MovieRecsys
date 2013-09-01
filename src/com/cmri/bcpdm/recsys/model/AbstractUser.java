package com.cmri.bcpdm.recsys.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String pwd;
	private Set ratinges = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String userId, String userName, String pwd) {
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
	}

	/** full constructor */
	public AbstractUser(String userId, String userName, String pwd,
			Set ratinges) {
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.ratinges = ratinges;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set getRatinges() {
		return this.ratinges;
	}

	public void setRatinges(Set ratinges) {
		this.ratinges = ratinges;
	}

}