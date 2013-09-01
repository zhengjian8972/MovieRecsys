package com.cmri.bcpdm.recsys.model;

import com.cmri.bcpdm.recsys.model.impl.Movie;

/**
 * AbstractMovieRate entity provides the base persistence definition of the
 * MovieRate entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovieRate implements java.io.Serializable {

	// Fields

	private String movieId;
	private Movie movie;
	private Integer rateCnt;
	private Float avgRate;

	// Constructors

	/** default constructor */
	public AbstractMovieRate() {
	}

	/** full constructor */
	public AbstractMovieRate(String movieId, Movie movie, Integer rateCnt,
			Float avgRate) {
		this.movieId = movieId;
		this.movie = movie;
		this.rateCnt = rateCnt;
		this.avgRate = avgRate;
	}

	// Property accessors

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getRateCnt() {
		return this.rateCnt;
	}

	public void setRateCnt(Integer rateCnt) {
		this.rateCnt = rateCnt;
	}

	public Float getAvgRate() {
		return this.avgRate;
	}

	public void setAvgRate(Float avgRate) {
		this.avgRate = avgRate;
	}

}