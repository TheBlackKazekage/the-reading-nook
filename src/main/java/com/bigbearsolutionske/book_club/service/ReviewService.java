package com.bigbearsolutionske.book_club.service;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Review;
import com.bigbearsolutionske.book_club.repository.ReviewRepository;
import com.github.fabiomaffioletti.firebase.repository.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public ApiResponse createReview(Review review) throws Exception{
        Review bk = reviewRepository.push(review);
        if(bk.getReviewId() != null) {
            return new ApiResponse(true, bk, "Review successfully saved");
        }else {
            return new ApiResponse(false, "Error saving review");
        }
    }

    public ApiResponse updateReview(Review review) throws Exception{
        Review bk = reviewRepository.update(review);
        if(bk.getReviewId() != null) {
            return new ApiResponse(true, bk, "Review successfully updated");
        }else {
            return new ApiResponse(false, "Error updating review");
        }
    }

    public ApiResponse viewAll() throws Exception{
        List<Review> bks = reviewRepository.findAll();
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Review successfully loaded");
        }else {
            return new ApiResponse(false, "No reviews in library");
        }
    }

    public ApiResponse viewReviewsForBook(String bookId) throws Exception{
        List<Review> bks = reviewRepository.find(Filter.FilterBuilder.builder().build(), bookId);
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Review successfully loaded");
        }else {
            return new ApiResponse(false, "No reviews in library");
        }
    }
}
