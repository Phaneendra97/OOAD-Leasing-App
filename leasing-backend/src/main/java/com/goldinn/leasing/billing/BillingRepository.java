package com.goldinn.leasing;

import com.goldinn.leasing.Billing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingRepository extends MongoRepository<Billing, String> {
    // Additional query methods can be defined here if needed
}
