package com.bigbearsolutionske.book_club.service;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Request;
import com.bigbearsolutionske.book_club.repository.RequestRepository;
import com.github.fabiomaffioletti.firebase.repository.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;

    public ApiResponse createRequest(Request request) throws Exception{
        Request bk = requestRepository.push(request);
        if(bk != null) {
            return new ApiResponse(true, bk, "Request successfully saved");
        }else {
            return new ApiResponse(false, "Error saving request");
        }
    }

    public ApiResponse updateRequest(Request request) throws Exception{
        Request bk = requestRepository.update(request);
        if(bk != null) {
            return new ApiResponse(true, bk, "Request successfully updated");
        }else {
            return new ApiResponse(false, "Error updating request");
        }
    }

    public ApiResponse viewAll() throws Exception{
        List<Request> bks = requestRepository.findAll();
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Request successfully loaded");
        }else {
            return new ApiResponse(false, "No requests in library");
        }
    }

    public ApiResponse viewRequestsForUser(String userId) throws Exception{
        List<Request> bks = requestRepository.find(Filter.FilterBuilder.builder().build(), userId);
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Request successfully loaded");
        }else {
            return new ApiResponse(false, "No requests in library");
        }
    }
}
