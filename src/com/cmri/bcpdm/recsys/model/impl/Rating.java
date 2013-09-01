package com.cmri.bcpdm.recsys.model.impl;

import java.util.Date;

import com.cmri.bcpdm.recsys.model.AbstractRating;

/**
 * Rating entity. @author MyEclipse Persistence Tools
 */
public class Rating extends AbstractRating implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Rating() {
	}

	/** full constructor */
	public Rating(RatingId id, Integer rating, Date ratingDate) {
		super(id, rating, ratingDate);
	}

}
