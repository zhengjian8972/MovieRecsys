package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractItemSimilarity;

/**
 * ItemSimilarity entity. @author MyEclipse Persistence Tools
 */
public class ItemSimilarity extends AbstractItemSimilarity implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ItemSimilarity() {
	}

	/** full constructor */
	public ItemSimilarity(ItemSimilarityId id, Float similarity) {
		super(id, similarity);
	}

}
