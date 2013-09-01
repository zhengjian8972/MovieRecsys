package com.cmri.bcpdm.recsys.web.action.user;

import java.util.ArrayList;
import java.util.List;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.service.item.MovieService;
import com.cmri.bcpdm.recsys.service.recommender.RecommendService;
import com.cmri.bcpdm.recsys.service.user.UserService;
import com.cmri.bcpdm.recsys.util.RecommendedMovie;
import com.cmri.bcpdm.recsys.util.WatchedMovie;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	MovieService movieService = new MovieService();
	UserService userService = new UserService();
	RecommendService recommendService = new RecommendService();

	private List<RecommendedMovie> recommendMovies = new ArrayList();
	private List<Movie> top20Movie = new ArrayList();
	private List<WatchedMovie> watchedMovies = new ArrayList();
	private String userId;
	private String userName;
	private int watchedNum;

	public String profile() {
		userName = userService.getUserName(userId);
		top20Movie = movieService.findTop20Movie();
		watchedMovies = movieService.findWatchedMovie(userId);
		recommendMovies = recommendService
				.getItemBasedRecommends(watchedMovies);
		watchedNum = watchedMovies.size();
		//recommendMovies = 
		return SUCCESS;
	}

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	public List<Movie> getTop20Movie() {
		return top20Movie;
	}

	public void setTop20Movie(List<Movie> top20Movie) {
		this.top20Movie = top20Movie;
	}

	public List<WatchedMovie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(List<WatchedMovie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	public List<RecommendedMovie> getRecommendMovies() {
		return recommendMovies;
	}

	public void setRecommendMovies(List<RecommendedMovie> recommendMovies) {
		this.recommendMovies = recommendMovies;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getWatchedNum() {
		return watchedNum;
	}

	public void setWatchedNum(int watchedNum) {
		this.watchedNum = watchedNum;
	}

}
