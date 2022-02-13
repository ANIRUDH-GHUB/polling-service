package com.au.polling.repository;

import com.au.polling.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    @Query
    public User findByUsername(String username);
}
