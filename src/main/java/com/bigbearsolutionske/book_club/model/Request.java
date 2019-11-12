package com.bigbearsolutionske.book_club.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import com.google.firebase.database.annotations.NotNull;

import java.util.Date;

@FirebaseDocument("/requests")
public class Request {

    @FirebaseId
    private String requestId;
    @NotNull
    private String userId;
    @NotNull
    private Date dateRequest;
    @NotNull
    private boolean delivered;
    @NotNull
    private boolean requestClosed;
    @NotNull
    private String bookId;

    public Request() {
    }

    public Request(String requestId, String userId, Date dateRequest, boolean delivered, boolean requestClosed, String bookId) {
        this.requestId = requestId;
        this.userId = userId;
        this.dateRequest = dateRequest;
        this.delivered = delivered;
        this.requestClosed = requestClosed;
        this.bookId = bookId;
    }

    public Request(String userId, Date dateRequest, boolean delivered, boolean requestClosed, String bookId) {
        this.userId = userId;
        this.dateRequest = dateRequest;
        this.delivered = delivered;
        this.requestClosed = requestClosed;
        this.bookId = bookId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isRequestClosed() {
        return requestClosed;
    }

    public void setRequestClosed(boolean requestClosed) {
        this.requestClosed = requestClosed;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
