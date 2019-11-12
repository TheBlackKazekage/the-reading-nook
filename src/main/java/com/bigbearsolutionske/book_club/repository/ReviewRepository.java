package com.bigbearsolutionske.book_club.repository;

import com.bigbearsolutionske.book_club.model.Review;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository extends DefaultFirebaseRealtimeDatabaseRepository<Review, String> {
}
