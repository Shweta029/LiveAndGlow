package com.live_glow.model;

public class Review {
	
	
	private int reviewId;
	private int reviewName;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, int reviewName) {
		super();
		this.reviewId = reviewId;
		this.reviewName = reviewName;
	}
	public int getreviewId() {
		return reviewId;
	}
	public void setreviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getreviewName() {
		return reviewName;
	}
	public void setreviewName(int reviewName) {
		this.reviewName = reviewName;
	

	}
	
}
