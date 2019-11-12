package com.bigbearsolutionske.book_club.controller;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Book;
import com.bigbearsolutionske.book_club.service.BookService;
import com.bigbearsolutionske.book_club.service.GoogleBooksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    GoogleBooksService googleBooksService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createBook(@RequestBody Book book){
        try{
            ApiResponse response = bookService.createBook(book);
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

    @PostMapping("/search")
    public ResponseEntity<ApiResponse> searchBookTitle(@RequestBody String bookTitle){
        try{
            ApiResponse response = googleBooksService.searchBookTitle(bookTitle);
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
    public ResponseEntity<ApiResponse> viewAllBooks(){
        try{
            ApiResponse response = bookService.viewAll();
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
    public ResponseEntity<ApiResponse> viewBookByUser(@PathVariable("userId") String userId){
        try{
            ApiResponse response = bookService.viewBooksForUser(userId);
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
    public ResponseEntity<ApiResponse> updateBook(@RequestBody Book book){
        try{
            ApiResponse response = bookService.updateBook(book);
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
