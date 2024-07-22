package com.example.air.token;

import com.example.air.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tokens")
public class Token {

  @Id
  private String id; // MongoDB uses String type for IDs

  @org.springframework.data.mongodb.core.index.Indexed(unique = true)
  private String token;

  private String tokenType = TokenType.BEARER.name(); // Store token type as a string

  private boolean revoked;

  private boolean expired;

  @DBRef(lazy = true)
  private User user; // Reference to User entity
}
