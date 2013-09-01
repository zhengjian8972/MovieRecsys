package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractRatingId;

/**
 * RatingId entity. @author MyEclipse Persistence Tools
 */
public class RatingId extends AbstractRatingId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public RatingId() {
	}

	/** full constructor */
	public RatingId(User user, Movie movie) {
		super(user, movie);
	}

}
