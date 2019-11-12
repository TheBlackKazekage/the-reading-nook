package com.bigbearsolutionske.book_club.service;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Credential;
import com.bigbearsolutionske.book_club.model.User;
import com.bigbearsolutionske.book_club.repository.UserRepository;
import com.github.fabiomaffioletti.firebase.repository.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ApiResponse createUser(User user) throws Exception{
        User bk = userRepository.push(user);
        if(bk.getUserId() != null) {
            return new ApiResponse(true, bk, "User successfully saved");
        }else {
            return new ApiResponse(false, "Error saving user");
        }
    }

    public ApiResponse loginUser(Credential credentials) throws Exception{
        List<User> users = userRepository.find(Filter.FilterBuilder.builder().build(), credentials.getEmail());
        if(users.get(0).getPassword().equals(credentials.getPassword())) {
            return new ApiResponse(true, users.get(0), "User successfully logged in");
        }
        return new ApiResponse(false, "Invalid credentials");
    }

    public ApiResponse updateUser(User user) throws Exception{
        User bk = userRepository.update(user);
        if(bk.getUserId() != null) {
            return new ApiResponse(true, bk, "User successfully updated");
        }else {
            return new ApiResponse(false, "Error updating user");
        }
    }

    public ApiResponse viewAll() throws Exception{
        List<User> bks = userRepository.findAll();
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "User successfully loaded");
        }else {
            return new ApiResponse(false, "No users in library");
        }
    }

    public ApiResponse viewSpecificUser(String userId) throws Exception{
        List<User> bks = userRepository.find(Filter.FilterBuilder.builder().build(), userId);
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "User successfully loaded");
        }else {
            return new ApiResponse(false, "No users in library");
        }
    }
}

//AIzaSyDAujRwJaE4gsGBUbFb3y539EiilyHKmY0
