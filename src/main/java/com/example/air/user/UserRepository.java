package com.example.air.user;

import java.util.Optional;

import com.example.air.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
