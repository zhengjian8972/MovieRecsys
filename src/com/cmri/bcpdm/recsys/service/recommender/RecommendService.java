package com.cmri.bcpdm.recsys.service.recommender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.cmri.bcpdm.recsys.service.item.MovieService;
import com.cmri.bcpdm.recsys.util.RecommendedMovie;
import com.cmri.bcpdm.recsys.util.SimilarMovie;
import com.cmri.bcpdm.recsys.util.WatchedMovie;

public class RecommendService {
	MovieService movieService = new MovieService();
	public static final int SIMILARITY_MOVIES_NUM = 10;
	public RecMovieComparator recMovieComparator = new RecMovieComparator();
	private int userRate;
	private RecommendedMovie temp;

	public List<RecommendedMovie> getItemBasedRecommends(
			List<WatchedMovie> watchedMovies) {

		List<RecommendedMovie> recommendList = new ArrayList();
		HashMap<String, RecommendedMovie> recList = new HashMap<String, RecommendedMovie>();

		for (WatchedMovie movie : watchedMovies) {
			userRate = Integer.parseInt(movie.getUserRate());
			List<SimilarMovie> similarMovies = movieService
					.findSimilarityMovies(movie.getMovieId(),
							SIMILARITY_MOVIES_NUM);
			for (SimilarMovie similarMovie : similarMovies) {
				if (recList.containsKey(similarMovie.getMovieId())) {
					temp = recList.get(similarMovie.getMovieId());
				} else {
					temp = new RecommendedMovie(similarMovie);
				}
				temp.increaseCount();
				temp.addRecValueCount(userRate
						* Double.parseDouble(similarMovie.getSimilarity()));
				recList.put(temp.getMovieId(), temp);
			}
		}

		// 去除看过的
		for (WatchedMovie movie : watchedMovies) {
			recList.remove(movie.getMovieId());
		}
		Object array[] = recList.values().toArray();
		if (array == null) {
			return recommendList;
		}
		Arrays.sort(array, recMovieComparator);

		for (int i = 0; i < array.length && i < 18; i++) {
			recommendList.add((RecommendedMovie) array[i]);
		}
		return recommendList;
	}

	public static class RecMovieComparator implements Comparator<Object> {
		@Override
		public int compare(Object m1, Object m2) {
			RecommendedMovie rm1 = (RecommendedMovie) m1;
			RecommendedMovie rm2 = (RecommendedMovie) m2;
			if (rm1.getRecValue() > rm2.getRecValue())
				return 1;
			else if (rm1.getRecValue() == rm2.getRecValue())
				return 0;
			else
				return -1;
		}
	}
}
