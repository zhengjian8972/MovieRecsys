package com.cmri.bcpdm.recsys.model;

/**
 * AbstractItemSimilarityId entity provides the base persistence definition of
 * the ItemSimilarityId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractItemSimilarityId implements java.io.Serializable {

	// Fields

	private String itemA;
	private String itemB;

	// Constructors

	/** default constructor */
	public AbstractItemSimilarityId() {
	}

	/** full constructor */
	public AbstractItemSimilarityId(String itemA, String itemB) {
		this.itemA = itemA;
		this.itemB = itemB;
	}

	// Property accessors

	public String getItemA() {
		return this.itemA;
	}

	public void setItemA(String itemA) {
		this.itemA = itemA;
	}

	public String getItemB() {
		return this.itemB;
	}

	public void setItemB(String itemB) {
		this.itemB = itemB;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractItemSimilarityId))
			return false;
		AbstractItemSimilarityId castOther = (AbstractItemSimilarityId) other;

		return ((this.getItemA() == castOther.getItemA()) || (this.getItemA() != null
				&& castOther.getItemA() != null && this.getItemA().equals(
				castOther.getItemA())))
				&& ((this.getItemB() == castOther.getItemB()) || (this
						.getItemB() != null && castOther.getItemB() != null && this
						.getItemB().equals(castOther.getItemB())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getItemA() == null ? 0 : this.getItemA().hashCode());
		result = 37 * result
				+ (getItemB() == null ? 0 : this.getItemB().hashCode());
		return result;
	}

}