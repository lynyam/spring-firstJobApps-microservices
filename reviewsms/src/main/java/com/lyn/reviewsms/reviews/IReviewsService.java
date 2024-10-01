package com.lyn.reviewsms.reviews;

import java.util.List;

public interface IReviewsService {
    List<Review> findAllReviews(Long companyId);
    Review findReviewById(Long reviewId);
    boolean createReview(Long companyId, Review review);
    //boolean updateReview(Long companyId, Long reviewId, Review updateReview);

    boolean updateReview(Long reviewId, Review updateReview);

    //boolean deleteReviewById(Long companyId, Long reviewId);

    boolean deleteReviewById(Long reviewId);
}
