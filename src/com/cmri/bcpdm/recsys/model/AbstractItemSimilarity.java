package com.cmri.bcpdm.recsys.model;

import com.cmri.bcpdm.recsys.model.impl.ItemSimilarityId;

/**
 * AbstractItemSimilarity entity provides the base persistence definition of the
 * ItemSimilarity entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractItemSimilarity implements java.io.Serializable {

	// Fields

	private ItemSimilarityId id;
	private Float similarity;

	// Constructors

	/** default constructor */
	public AbstractItemSimilarity() {
	}

	/** full constructor */
	public AbstractItemSimilarity(ItemSimilarityId id, Float similarity) {
		this.id = id;
		this.similarity = similarity;
	}

	// Property accessors

	public ItemSimilarityId getId() {
		return this.id;
	}

	public void setId(ItemSimilarityId id) {
		this.id = id;
	}

	public Float getSimilarity() {
		return this.similarity;
	}

	public void setSimilarity(Float similarity) {
		this.similarity = similarity;
	}

}