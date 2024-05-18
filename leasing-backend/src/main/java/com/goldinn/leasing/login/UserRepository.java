package com.goldinn.leasing.login;

import com.goldinn.leasing.login.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}