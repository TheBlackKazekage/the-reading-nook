package com.bigbearsolutionske.book_club.repository;

import com.bigbearsolutionske.book_club.model.User;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends DefaultFirebaseRealtimeDatabaseRepository<User, String> {
}
