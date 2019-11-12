package com.bigbearsolutionske.book_club.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import com.google.firebase.database.annotations.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

@FirebaseDocument("/users")
public class User {

    @FirebaseId
    private String userId;
    @NotNull
    @UniqueElements
    private String username;
    @NotNull
    @UniqueElements
    private String email;
    @NotNull
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
