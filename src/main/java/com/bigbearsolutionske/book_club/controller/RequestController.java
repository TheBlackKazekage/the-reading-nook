package com.bigbearsolutionske.book_club.controller;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Request;
import com.bigbearsolutionske.book_club.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    RequestService requestService;

    Logger logger = LoggerFactory.getLogger(RequestController.class);

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createRequest(@RequestBody Request request){
        try{
            ApiResponse response = requestService.createRequest(request);
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
    public ResponseEntity<ApiResponse> viewAllRequests(){
        try{
            ApiResponse response = requestService.viewAll();
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
    public ResponseEntity<ApiResponse> viewRequestByUser(@PathVariable("userId") String userId){
        try{
            ApiResponse response = requestService.viewRequestsForUser(userId);
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
    public ResponseEntity<ApiResponse> updateRequest(@RequestBody Request request){
        try{
            ApiResponse response = requestService.updateRequest(request);
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
