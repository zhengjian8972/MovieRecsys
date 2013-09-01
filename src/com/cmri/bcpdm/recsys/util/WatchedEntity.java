package com.cmri.bcpdm.recsys.util;

import java.util.Date;

public class WatchedEntity {
	
	private String userId;
	private String userName;
	private Integer rating;
	private Date ratingDate;
	
	public WatchedEntity(Object userId, Object userName, Object ratingDate, Object rating) {
		super();
		this.userId = (String) userId;
		this.userName = (String) userName;
		this.ratingDate = (Date) ratingDate;
		this.rating = (Integer) rating;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getRatingDate() {
		return ratingDate;
	}
	public void setRatingDate(Date ratingDate) {
		this.ratingDate = ratingDate;
	}
	
}
