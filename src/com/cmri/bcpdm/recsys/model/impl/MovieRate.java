package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractMovieRate;

/**
 * MovieRate entity. @author MyEclipse Persistence Tools
 */
public class MovieRate extends AbstractMovieRate implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MovieRate() {
	}

	/** full constructor */
	public MovieRate(String movieId, Movie movie, Integer rateCnt,
			Float avgRate) {
		super(movieId, movie, rateCnt, avgRate);
	}

}
