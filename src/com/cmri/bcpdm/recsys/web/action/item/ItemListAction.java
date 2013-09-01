package com.cmri.bcpdm.recsys.web.action.item;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.service.item.MovieService;
import com.cmri.bcpdm.recsys.util.DetailMovie;
import com.cmri.bcpdm.recsys.util.SimilarMovie;
import com.cmri.bcpdm.recsys.util.WatchedEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	public static final int SIMILARITY_MOVIES_NUM = 20;

	MovieService movieService = new MovieService();

	private List<Movie> popularMovies = new ArrayList();
	private List<Movie> topMovies = new ArrayList();
	private List<DetailMovie> currentMovie = new ArrayList();
	private List<SimilarMovie> similarMovies = new ArrayList();
	private List<Movie> searchMovie = new ArrayList();

	private String movieId;
	private int userRating;
	private String searchText;
	private List<WatchedEntity> watchedUsers;

	/**
	 * @retrun popMovies and topMovies.
	 * 
	 * */
	public String index() {
		popularMovies = movieService.findPopMovie();
		topMovies = movieService.findTopMovie();
		return SUCCESS;
	}

	/**
	 * get details of the movie.
	 * */
	public String detail() {
		currentMovie = movieService.findMovie(movieId);
		watchedUsers = movieService.watchedUsers(movieId);
		similarMovies = movieService.findSimilarityMovies(movieId,
				SIMILARITY_MOVIES_NUM);
		String userId = (String) ActionContext.getContext().getSession()
				.get("USER_ID");
		userRating = 0;
		if (userId != null) {
			userRating = movieService.getUserRating(userId, movieId);
		}
		return SUCCESS;
	}

	public String search() {
		searchMovie = movieService.searchMovie(searchText);
		if (searchMovie.size() == 0) {

		}
		return SUCCESS;
	}

	public String rate() throws Exception {
		String userId = (String) ActionContext.getContext().getSession()
				.get("USER_ID");
		if (movieId != null && userId != null) {
			movieService.setUserRating(userId, movieId, userRating);
		}
		return SUCCESS;
	}

	/**
	 * get similar movies
	 * 
	 * */
	public void similarMovie() {
		similarMovies = null;
	}

	public List<Movie> getPopularMovies() {
		return popularMovies;
	}

	public void setPopularMovies(List<Movie> popularMovies) {
		this.popularMovies = popularMovies;
	}

	public List<Movie> getTopMovies() {
		return topMovies;
	}

	public void setTopMovies(List<Movie> topMovies) {
		this.topMovies = topMovies;
	}

	public List<DetailMovie> getCurrentMovie() {
		return currentMovie;
	}

	public void setCurrentMovie(List<DetailMovie> currentMovie) {
		this.currentMovie = currentMovie;
	}

	public List<SimilarMovie> getSimilarMovies() {
		return similarMovies;
	}

	public void setSimilarMovies(List<SimilarMovie> similarMovies) {
		this.similarMovies = similarMovies;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		try {
			this.searchText = new String(searchText.getBytes("iso8859-1"),
					"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Movie> getSearchMovie() {
		return searchMovie;
	}

	public void setSearchMovie(List<Movie> searchMovie) {
		this.searchMovie = searchMovie;
	}

	public List<WatchedEntity> getWatchedUsers() {
		return watchedUsers;
	}

	public void setWatchedUsers(List<WatchedEntity> watchedUsers) {
		this.watchedUsers = watchedUsers;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

}
