package com.bigbearsolutionske.book_club.controller;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Review;
import com.bigbearsolutionske.book_club.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createReview(@RequestBody Review review){
        try{
            ApiResponse response = reviewService.createReview(review);
            if(response.isSuccess()){
                return ResponseEntity.status(200).body(response);
            }else{
                return ResponseEntity.status(409).body(response);
            }
        }catch(Exception e) {
            logger.error(e.getMessage(), e.getStackTrace());
            return ResponseEntity.status(409).body(new ApiResponse(false, e.getMessage(), new ArrayList<>(Arrays.asList(e.getStackTrace()))));
        }
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<ApiResponse> viewAllReviews(){
        try{
            ApiResponse response = reviewService.viewAll();
            if(response.isSuccess()){
                return ResponseEntity.status(200).body(response);
            }else {
                return ResponseEntity.status(409).body(response);
            }
        }catch(Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(409).body(new ApiResponse(false, e.getMessage(), new ArrayList<>(Arrays.asList(e.getStackTrace()))));
        }
    }

    @RequestMapping("/{bookId}")
    @ResponseBody
    public ResponseEntity<ApiResponse> viewReviewByUser(@PathVariable("bookId") String bookId){
        try{
            ApiResponse response = reviewService.viewReviewsForBook(bookId);
            if(response.isSuccess()){
                return ResponseEntity.status(200).body(response);
            }else {
                return ResponseEntity.status(409).body(response);
            }
        }catch(Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(409).body(new ApiResponse(false, e.getMessage(), new ArrayList<>(Arrays.asList(e.getStackTrace()))));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> updateReview(@RequestBody Review review){
        try{
            ApiResponse response = reviewService.updateReview(review);
            if(response.isSuccess()){
                return ResponseEntity.status(200).body(response);
            }else{
                return ResponseEntity.status(409).body(response);
            }
        }catch(Exception e) {
            logger.error(e.getMessage(), e.getStackTrace());
            return ResponseEntity.status(409).body(new ApiResponse(false, e.getMessage(), new ArrayList<>(Arrays.asList(e.getStackTrace()))));
        }
    }


}
