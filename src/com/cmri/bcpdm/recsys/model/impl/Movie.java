package com.cmri.bcpdm.recsys.model.impl;

import java.util.Set;

import com.cmri.bcpdm.recsys.model.AbstractMovie;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */
public class Movie extends AbstractMovie implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** minimal constructor */
	
	public Movie(Object movieId, Object movieTitle){
		super((String)movieId, (String)movieTitle);
	}
	public Movie(Object movieId, Object movieTitle, Object avgRate,
			Object year, Object countries, Object director_name,
			Object cast_name, Object rate_cnt) {
		super((String)movieId, (String)movieTitle, (Float)avgRate, (Integer)year, (String)countries, (String)director_name,
				(String)cast_name, (Integer)rate_cnt);
	}
	
	public Movie(Object movieId, Object movieTitle, Object avgRate,
			Object year, Object countries, Object director_name,
			Object cast_name, Object rate_cnt, Object summery,Object genres) {
		super((String)movieId, (String)movieTitle, (Float)avgRate, (Integer)year, (String)countries, (String)director_name,
				(String)cast_name, (Integer)rate_cnt,(String)summery,(String)genres);
	}

	/** full constructor */
	public Movie(String movieId, String movieTitle, Integer year,
			String genres, String countries, String castId, String castName,
			String directorId, String directorName, String summary,
			Set ratingses, Set movieRates) {
		super(movieId, movieTitle, year, genres, countries, castId, castName,
				directorId, directorName, summary, ratingses, movieRates);
	}

	@Override
	public String toString(){
		return "movieId===" + super.getMovieId() + "     movieTitle========" + super.getMovieTitle()  ;
	}
}
