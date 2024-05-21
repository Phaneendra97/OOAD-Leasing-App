package com.goldinn.leasing.repository;

import com.goldinn.leasing.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    Application findByUserId(String userId);
}
