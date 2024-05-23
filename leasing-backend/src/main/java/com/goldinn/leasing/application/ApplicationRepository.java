package com.goldinn.leasing.application;

import com.goldinn.leasing.application.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    Application findByUserId(String userId);
}
