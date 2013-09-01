package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractUserSimilarityId;

/**
 * UserSimilarityId entity. @author MyEclipse Persistence Tools
 */
public class UserSimilarityId extends AbstractUserSimilarityId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserSimilarityId() {
	}

	/** full constructor */
	public UserSimilarityId(String userA, String userB) {
		super(userA, userB);
	}

}
