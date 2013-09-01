package com.cmri.bcpdm.recsys.util;

import com.cmri.bcpdm.recsys.model.AbstractMovie;

public class SimilarMovie extends AbstractMovie implements
		java.io.Serializable {

	private String similarity;

	// similar movie
	public SimilarMovie(Object movieId, Object movieTitle, Object similarity) {
		super((String) movieId, (String) movieTitle);
		this.similarity = (Object) similarity + "";
	}

	public String getSimilarity() {
		return similarity;
	}

	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
}
