package com.cmri.bcpdm.recsys.model;

import java.util.Date;

import com.cmri.bcpdm.recsys.model.impl.RatingId;

/**
 * AbstractRating entity provides the base persistence definition of the
 * Rating entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRating implements java.io.Serializable {

	// Fields

	private RatingId id;
	private Integer rating;
	private Date ratingDate;

	// Constructors

	/** default constructor */
	public AbstractRating() {
	}

	/** full constructor */
	public AbstractRating(RatingId id, Integer rating, Date ratingDate) {
		this.id = id;
		this.rating = rating;
		this.ratingDate = ratingDate;
	}

	// Property accessors

	public RatingId getId() {
		return this.id;
	}

	public void setId(RatingId id) {
		this.id = id;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getRatingDate() {
		return this.ratingDate;
	}

	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}

}