package com.cmri.bcpdm.recsys.model;

import com.cmri.bcpdm.recsys.model.impl.UserSimilarityId;

/**
 * AbstractUserSimilarity entity provides the base persistence definition of the
 * UserSimilarity entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserSimilarity implements java.io.Serializable {

	// Fields

	private UserSimilarityId id;
	private Float similarity;

	// Constructors

	/** default constructor */
	public AbstractUserSimilarity() {
	}

	/** full constructor */
	public AbstractUserSimilarity(UserSimilarityId id, Float similarity) {
		this.id = id;
		this.similarity = similarity;
	}

	// Property accessors

	public UserSimilarityId getId() {
		return this.id;
	}

	public void setId(UserSimilarityId id) {
		this.id = id;
	}

	public Float getSimilarity() {
		return this.similarity;
	}

	public void setSimilarity(Float similarity) {
		this.similarity = similarity;
	}

}