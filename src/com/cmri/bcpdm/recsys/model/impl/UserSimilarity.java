package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractUserSimilarity;

/**
 * UserSimilarity entity. @author MyEclipse Persistence Tools
 */
public class UserSimilarity extends AbstractUserSimilarity implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserSimilarity() {
	}

	/** full constructor */
	public UserSimilarity(UserSimilarityId id, Float similarity) {
		super(id, similarity);
	}

}
