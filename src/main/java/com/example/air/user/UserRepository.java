package com.example.air.user;

import java.util.Optional;

import com.example.air.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
