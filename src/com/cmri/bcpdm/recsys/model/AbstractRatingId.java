package com.cmri.bcpdm.recsys.model;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.model.impl.User;

/**
 * AbstractRatingId entity provides the base persistence definition of the
 * RatingId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRatingId implements java.io.Serializable {

	// Fields

	private User user;
	private Movie movie;

	// Constructors

	/** default constructor */
	public AbstractRatingId() {
	}

	/** full constructor */
	public AbstractRatingId(User user, Movie movie) {
		this.user = user;
		this.movie = movie;
	}

	// Property accessors

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractRatingId))
			return false;
		AbstractRatingId castOther = (AbstractRatingId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getMovie() == castOther.getMovie()) || (this
						.getMovie() != null && castOther.getMovie() != null && this
						.getMovie().equals(castOther.getMovie())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getMovie() == null ? 0 : this.getMovie().hashCode());
		return result;
	}

}