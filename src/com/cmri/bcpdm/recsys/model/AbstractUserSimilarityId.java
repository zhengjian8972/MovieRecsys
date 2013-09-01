package com.cmri.bcpdm.recsys.model;

/**
 * AbstractUserSimilarityId entity provides the base persistence definition of
 * the UserSimilarityId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserSimilarityId implements java.io.Serializable {

	// Fields

	private String userA;
	private String userB;

	// Constructors

	/** default constructor */
	public AbstractUserSimilarityId() {
	}

	/** full constructor */
	public AbstractUserSimilarityId(String userA, String userB) {
		this.userA = userA;
		this.userB = userB;
	}

	// Property accessors

	public String getUserA() {
		return this.userA;
	}

	public void setUserA(String userA) {
		this.userA = userA;
	}

	public String getUserB() {
		return this.userB;
	}

	public void setUserB(String userB) {
		this.userB = userB;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractUserSimilarityId))
			return false;
		AbstractUserSimilarityId castOther = (AbstractUserSimilarityId) other;

		return ((this.getUserA() == castOther.getUserA()) || (this.getUserA() != null
				&& castOther.getUserA() != null && this.getUserA().equals(
				castOther.getUserA())))
				&& ((this.getUserB() == castOther.getUserB()) || (this
						.getUserB() != null && castOther.getUserB() != null && this
						.getUserB().equals(castOther.getUserB())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserA() == null ? 0 : this.getUserA().hashCode());
		result = 37 * result
				+ (getUserB() == null ? 0 : this.getUserB().hashCode());
		return result;
	}

}