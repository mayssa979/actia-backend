package com.example.air.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TokenRepository extends MongoRepository<Token, String> {

  List<Token> findAllValidTokenByUser(String userId);
}
