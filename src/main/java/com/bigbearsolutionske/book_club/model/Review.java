package com.bigbearsolutionske.book_club.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import com.google.firebase.database.annotations.NotNull;

@FirebaseDocument("/reviews")
public class Review {
    @FirebaseId
    private String reviewId;
    @NotNull
    private String userId;
    @NotNull
    private String bookId;
    @NotNull
    private String review;

    public Review() {
    }

    public Review(String userId, String bookId, String review) {
        this.userId = userId;
        this.bookId = bookId;
        this.review = review;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
