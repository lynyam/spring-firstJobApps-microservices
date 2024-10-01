package com.lyn.reviewsms.reviews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService implements IReviewsService{
    private final IReviewRepository reviewRepository;

    public ReviewsService(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> findAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review findReviewById(Long reviewId) {
        return (reviewRepository.findById(reviewId).orElse(null));
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return (true);
        }
        return (false);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updateReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setText(updateReview.getText());
            review.setAuthor(updateReview.getAuthor());
            reviewRepository.save(review);
            return (true);
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.deleteById(reviewId);
            return (true);
        }
        return false;
    }
}
