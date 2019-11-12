package com.bigbearsolutionske.book_club.repository;

import com.bigbearsolutionske.book_club.model.Book;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository extends DefaultFirebaseRealtimeDatabaseRepository<Book, String> {
}
