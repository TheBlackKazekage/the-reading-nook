package com.bigbearsolutionske.book_club.service;

import com.bigbearsolutionske.book_club.model.ApiResponse;
import com.bigbearsolutionske.book_club.model.Book;
import com.bigbearsolutionske.book_club.repository.BookRepository;
import com.github.fabiomaffioletti.firebase.repository.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public ApiResponse createBook(Book book) throws Exception{
        Book bk = bookRepository.push(book);
        if(bk.getBookId() != null) {
            return new ApiResponse(true, bk, "Book successfully saved");
        }else {
            return new ApiResponse(false, "Error saving book");
        }
    }

    public ApiResponse updateBook(Book book) throws Exception{
        Book bk = bookRepository.update(book);
        if(bk != null) {
            return new ApiResponse(true, bk, "Book successfully updated");
        }else {
            return new ApiResponse(false, "Error updating book");
        }
    }

    public ApiResponse viewAll() throws Exception{
        List<Book> bks = bookRepository.findAll();
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Book successfully loaded");
        }else {
            return new ApiResponse(false, "No books in library");
        }
    }

    public ApiResponse viewBooksForUser(String userId) throws Exception{
        List<Book> bks = bookRepository.find(Filter.FilterBuilder.builder().build(), userId);
        if(bks.size() > 0) {
            return new ApiResponse(true, bks, "Book successfully loaded");
        }else {
            return new ApiResponse(false, "No books in library");
        }
    }
}
