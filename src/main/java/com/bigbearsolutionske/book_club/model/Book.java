package com.bigbearsolutionske.book_club.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import com.google.firebase.database.annotations.NotNull;

import java.util.List;

@FirebaseDocument("/books")
public class Book {

    @FirebaseId
    private String bookId;
    @NotNull
    private String userId;
    @NotNull
    private String title;
    @NotNull
    private String summary;
    @NotNull
    private boolean like;
    @NotNull
    private boolean recommend;
    @NotNull
    private boolean available;
    @NotNull
    private String imageUrl;
    @NotNull
    private List<Request> requests;

    public Book() {
    }

    public Book(String userId, String title, String summary, boolean like, boolean recommend, boolean available, String imageUrl) {
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.like = like;
        this.recommend = recommend;
        this.available = available;
        this.imageUrl = imageUrl;
    }

    public Book(String bookId, String userId, String title, String summary, boolean like, boolean recommend, boolean available, String imageUrl, List<Request> requests) {
        this.bookId = bookId;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.like = like;
        this.recommend = recommend;
        this.available = available;
        this.imageUrl = imageUrl;
        this.requests = requests;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
