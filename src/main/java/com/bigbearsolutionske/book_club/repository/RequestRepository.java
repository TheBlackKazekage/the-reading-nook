package com.bigbearsolutionske.book_club.repository;

import com.bigbearsolutionske.book_club.model.Request;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository extends DefaultFirebaseRealtimeDatabaseRepository<Request, String> {
}
