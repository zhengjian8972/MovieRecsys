package com.cmri.bcpdm.recsys.model.impl;

import java.util.Set;

import com.cmri.bcpdm.recsys.model.AbstractUser;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, String userName, String pwd) {
		super(userId, userName, pwd);
	}

	/** full constructor */
	public User(String userId, String userName, String pwd, Set ratinges) {
		super(userId, userName, pwd, ratinges);
	}

}
