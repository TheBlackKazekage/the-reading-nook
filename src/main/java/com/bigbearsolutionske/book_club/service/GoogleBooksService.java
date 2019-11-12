package com.bigbearsolutionske.book_club.service;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Item;
import com.bigbearsolutionske.book_club.model.SearchResult;
import com.bigbearsolutionske.book_club.model.VolumeInfo;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleBooksService {
    private String url = "https://www.googleapis.com/books/v1/volumes?q=";

    public ApiResponse searchBookTitle(String bookTitle) throws Exception{
        String searchTerm = bookTitle.trim().replace(" ", "+");

        RestTemplate rT = new RestTemplate();
        String result = rT.getForObject(url + searchTerm, String.class);

        SearchResult searchResult = new Gson().fromJson(result, SearchResult.class);

        if(searchResult != null) {
            List<VolumeInfo> results = new ArrayList<>();
            for(Item item: searchResult.getItems()){
                if(item.getVolumeInfo() != null){
                    results.add(item.getVolumeInfo());
                }
            }
            return new ApiResponse(true, results, "Search results loaded successfully");
        }
        return new ApiResponse(false, "Book not found");
    }
}
