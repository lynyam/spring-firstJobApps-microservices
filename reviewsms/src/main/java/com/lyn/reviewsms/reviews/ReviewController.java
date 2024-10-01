package com.lyn.reviewsms.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
    private IReviewsService reviewsService;

    public ReviewController(IReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAllReviews(@RequestParam Long companyId) {
        return (new ResponseEntity<>(reviewsService.findAllReviews(companyId), HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId, @RequestBody Review review) {
        if (reviewsService.createReview(companyId, review))
            return (new ResponseEntity<>("Review Successful created", HttpStatus.CREATED));
        return (new ResponseEntity<>("Review Not save", HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long reviewId) {
        Review searchedReview = reviewsService.findReviewById(reviewId);
        if (searchedReview !=  null)
            return (new ResponseEntity<>(searchedReview, HttpStatus.OK));
        return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review updateReview) {
        if (reviewsService.updateReview(reviewId, updateReview))
            return (new ResponseEntity<>("Review Successful Updated", HttpStatus.OK));
        return (new ResponseEntity<>("Review not updated Successful", HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId){
        if (reviewsService.deleteReviewById(reviewId))
            return (new ResponseEntity<>("Review Succesfull Deleted", HttpStatus.OK));
        return (new ResponseEntity<>("Review Not deleted", HttpStatus.NOT_FOUND));
    }
}
