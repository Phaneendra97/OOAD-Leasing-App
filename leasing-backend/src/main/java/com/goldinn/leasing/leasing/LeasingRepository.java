package com.goldinn.leasing.leasing;

import com.goldinn.leasing.leasing.Leasing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeasingRepository extends MongoRepository<Leasing, String> {
    // Additional query methods can be defined here if needed
}
