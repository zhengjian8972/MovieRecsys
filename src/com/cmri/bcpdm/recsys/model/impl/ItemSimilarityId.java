package com.cmri.bcpdm.recsys.model.impl;

import com.cmri.bcpdm.recsys.model.AbstractItemSimilarityId;

/**
 * ItemSimilarityId entity. @author MyEclipse Persistence Tools
 */
public class ItemSimilarityId extends AbstractItemSimilarityId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ItemSimilarityId() {
	}

	/** full constructor */
	public ItemSimilarityId(String itemA, String itemB) {
		super(itemA, itemB);
	}

}
