package com.cmri.bcpdm.recsys.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractMovie entity provides the base persistence definition of the Movie
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovie implements java.io.Serializable {

	// Fields

	private String movieId;
	private String movieTitle;
	private Integer year;
	private String genres;
	private String countries;
	private String castId;
	private String castName;
	private String directorId;
	private String directorName;
	private String summary;
	private String avgRate;
	private String rateCnt;
	private Set ratinges = new HashSet(0);
	private Set movieRates = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractMovie() {
	}
	
	public AbstractMovie(String movieId, String movieTitle){
		this.movieId = movieId;
		this.movieTitle = movieTitle;
	}

	/** movieList constructor */
	public AbstractMovie(String movieId, String movieTitle, Float avgRate,
			int year, String countries, String director_name,
			String cast_name, int rate_cnt) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.avgRate = avgRate+"";
		this.countries = countries;
		this.year = year;
		this.directorName = director_name;
		this.castName = cast_name;
		this.rateCnt = rate_cnt+"";
	}
	
	/** movieDetail constructor */
	public AbstractMovie(String movieId, String movieTitle, Float avgRate,
			int year, String countries, String director_name,
			String cast_name, int rate_cnt,String summary,String genres) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.avgRate = avgRate+"";
		this.countries = countries;
		this.year = year;
		this.directorName = director_name;
		this.castName = cast_name;
		this.rateCnt = rate_cnt+"";
		this.summary =summary;
		this.genres = genres;
	}

	/** full constructor */
	public AbstractMovie(String movieId, String movieTitle, Integer year,
			String genres, String countries, String castId, String castName,
			String directorId, String directorName, String summary,
			Set ratinges, Set movieRates) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.year = year;
		this.genres = genres;
		this.countries = countries;
		this.castId = castId;
		this.castName = castName;
		this.directorId = directorId;
		this.directorName = directorName;
		this.summary = summary;
		this.ratinges = ratinges;
		this.movieRates = movieRates;
	}

	// Property accessors

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return this.movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenres() {
		return this.genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getCountries() {
		return this.countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getCastId() {
		return this.castId;
	}

	public void setCastId(String castId) {
		this.castId = castId;
	}

	public String getCastName() {
		return this.castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public String getDirectorId() {
		return this.directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return this.directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set getRatinges() {
		return this.ratinges;
	}

	public void setRatinges(Set ratinges) {
		this.ratinges = ratinges;
	}

	public Set getMovieRates() {
		return this.movieRates;
	}

	public void setMovieRates(Set movieRates) {
		this.movieRates = movieRates;
	}

	public String getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(String avgRate) {
		this.avgRate = avgRate;
	}

	public String getRateCnt() {
		return rateCnt;
	}

	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}

}