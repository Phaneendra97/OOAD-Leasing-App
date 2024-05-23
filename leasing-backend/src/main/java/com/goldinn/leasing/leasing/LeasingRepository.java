package com.goldinn.leasing.leasing;

import com.goldinn.leasing.leasing.Leasing;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LeasingRepository extends MongoRepository<Leasing, String> {
      Optional<Leasing> findByUserId(String userId);
      
}
