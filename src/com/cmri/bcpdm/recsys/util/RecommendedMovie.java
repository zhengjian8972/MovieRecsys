package com.cmri.bcpdm.recsys.util;

import com.cmri.bcpdm.recsys.model.AbstractMovie;

public class RecommendedMovie extends AbstractMovie implements
		java.io.Serializable {

	double totalRecValue = 0;
	int count = 0;
	double recValue;

	public RecommendedMovie(SimilarMovie similarMovie) {
		super(similarMovie.getMovieId(), similarMovie.getMovieTitle());
	}

	public double getTotalRecValue() {
		return totalRecValue;
	}

	public void setTotalRecValue(double totalRecValue) {
		this.totalRecValue = totalRecValue;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increaseCount() {
		this.count += 1;
	}

	public void addRecValueCount(double recValue) {
		this.totalRecValue += recValue;
	}

	public double getRecValue() {
		if (recValue == 0)
			this.recValue = totalRecValue / count;
		return recValue;
	}
}
