package com.cmri.bcpdm.recsys.util;

import com.cmri.bcpdm.recsys.model.AbstractMovie;

public class WatchedMovie extends AbstractMovie implements
		java.io.Serializable {
	private String userRate;

	// watched Movie
	public WatchedMovie(Object movieId, Object movieTitle, Object avgRate,
			Object year, Object countries, Object director_name,
			Object cast_name, Object rate_cnt, Object user_rating) {
		super((String) movieId, (String) movieTitle, (Float) avgRate,
				(Integer) year, (String) countries, (String) director_name,
				(String) cast_name, (Integer) rate_cnt);
		this.userRate = (Integer) user_rating + "";
	}

	public String getUserRate() {
		return userRate;
	}

	public void setUserRate(String userRate) {
		this.userRate = userRate;
	}
}
