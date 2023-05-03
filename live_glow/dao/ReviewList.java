package com.live_glow.dao;

import java.sql.SQLException;
import java.util.List;

public interface ReviewList<T> {
	
	
	List<T> getAllReviews() throws SQLException;
	T getReviewById(int ReviewId);
	T getReviewByName(String ReviewName);
	
	Boolean updateReview(int id, T t);

}
