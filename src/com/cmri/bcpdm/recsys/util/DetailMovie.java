package com.cmri.bcpdm.recsys.util;

import com.cmri.bcpdm.recsys.model.AbstractMovie;

public class DetailMovie extends AbstractMovie implements java.io.Serializable {

	public DetailMovie(Object movieId, Object movieTitle, Object avgRate,
			Object year, Object countries, Object director_name,
			Object cast_name, Object rate_cnt, Object summery, Object genres) {
		super((String) movieId, (String) movieTitle, (Float) avgRate,
				(Integer) year, (String) countries, (String) director_name,
				(String) cast_name, (Integer) rate_cnt, (String) summery,
				(String) genres);
	}

}
