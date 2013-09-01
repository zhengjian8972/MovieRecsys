package com.cmri.bcpdm.recsys.service.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cmri.bcpdm.recsys.model.impl.Movie;
import com.cmri.bcpdm.recsys.persistence.MovieDAO;
import com.cmri.bcpdm.recsys.persistence.RatingDAO;
import com.cmri.bcpdm.recsys.util.DetailMovie;
import com.cmri.bcpdm.recsys.util.SimilarMovie;
import com.cmri.bcpdm.recsys.util.WatchedEntity;
import com.cmri.bcpdm.recsys.util.WatchedMovie;

public class MovieService {
	MovieDAO md = new MovieDAO();
	RatingDAO ratingDao = new RatingDAO();

	public List<Movie> findPopMovie() {
		List queryList = md.findPopMovie();
		List<Movie> popMovies = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			Movie movie = new Movie(obj[0], obj[1], obj[2], obj[3], obj[4],
					obj[5], obj[6], obj[7]);
			popMovies.add(movie);
		}
		return popMovies;
	}

	public List<Movie> findTopMovie() {
		List queryList = md.findTopMovie();
		List<Movie> topMovies = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			Movie movie = new Movie(obj[0], obj[1], obj[2], obj[3], obj[4],
					obj[5], obj[6], obj[7]);
			topMovies.add(movie);
		}
		return topMovies;
	}


	public List<DetailMovie> findMovie(String movieId) {

		List queryList = md.findMovieDetail(movieId);

		List<DetailMovie> datailMovie = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			DetailMovie movie = new DetailMovie(obj[0], obj[1], obj[2], obj[3],
					obj[4], obj[5], obj[6], obj[7], obj[8], obj[9]);
			datailMovie.add(movie);
		}
		return datailMovie;
	}

	public List<Movie> searchMovie(String searchText) {
		List<Movie> searchList = md.searchMovies(searchText);
		List<Movie> searchMovies = new ArrayList();
		for (Iterator iter = searchList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			Movie movie = new Movie(obj[0], obj[1], obj[2], obj[3], obj[4],
					obj[5], obj[6], obj[7]);
			searchMovies.add(movie);
		}
		return searchMovies;
	}

	public List<Movie> findTop20Movie() {
		List queryList = md.findTop20Movie();
		List<Movie> topMovies = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			Movie movie = new Movie(obj[0], obj[1], obj[2], obj[3], obj[4],
					obj[5], obj[6], obj[7]);
			topMovies.add(movie);
		}
		return topMovies;
	}

	public List<WatchedMovie> findWatchedMovie(String userId) {
		List queryList = md.findWatchedMovie(userId);
		List<WatchedMovie> topMovies = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			WatchedMovie movie = new WatchedMovie(obj[0], obj[1], obj[2],
					obj[3], obj[4], obj[5], obj[6], obj[7], obj[8]);
			topMovies.add(movie);
		}
		return topMovies;
	}

	public List<WatchedEntity> watchedUsers(String movieId) {
		// TODO Auto-generated method stub
		List<WatchedEntity> list = md.searchWatchedUsers(movieId);
		List<WatchedEntity> watchedUserList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			WatchedEntity entity = new WatchedEntity(obj[0], obj[1], obj[2],
					obj[3]);
			watchedUserList.add(entity);
		}
		return watchedUserList;

	}

	public List<SimilarMovie> findSimilarityMovies(String movieId, int recNum) {
		List queryList = md.findSimilatiryMovies(movieId, recNum);
		List<SimilarMovie> similatiryMovies = new ArrayList();
		for (Iterator iter = queryList.iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			SimilarMovie movie = new SimilarMovie(obj[0], obj[1], obj[2]);
			similatiryMovies.add(movie);
		}
		return similatiryMovies;
	}

	public int getUserRating(String userId, String movieId) {
		List queryList = ratingDao.getUserRating(userId, movieId);
		if (queryList.size() == 0) {
			return 0;
		}
		int rating = (Integer) queryList.get(0);
		return rating;
	}

	public int setUserRating(String userId, String movieId, int rating) {
		String result = ratingDao.setUserRating(userId, movieId, rating);
		if (!result.equals("success"))
			System.out.println("error when saving ratings");
		return rating;
	}
}
