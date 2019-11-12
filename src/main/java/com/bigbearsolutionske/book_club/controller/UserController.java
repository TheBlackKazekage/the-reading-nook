package com.bigbearsolutionske.book_club.controller;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Credential;
import com.bigbearsolutionske.book_club.model.User;
import com.bigbearsolutionske.book_club.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody Credential credentials){
        try{
            ApiResponse response = userService.loginUser(credentials);
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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user){
        try{
            ApiResponse response = userService.createUser(user);
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
    public ResponseEntity<ApiResponse> viewAllUsers(){
        try{
            ApiResponse response = userService.viewAll();
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

    @RequestMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<ApiResponse> viewUser(@PathVariable("userId") String userId){
        try{
            ApiResponse response = userService.viewSpecificUser(userId);
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
    public ResponseEntity<ApiResponse> updateUser(@RequestBody User user){
        try{
            ApiResponse response = userService.updateUser(user);
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
