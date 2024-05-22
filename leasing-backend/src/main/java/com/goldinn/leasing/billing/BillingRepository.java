package com.goldinn.leasing.billing;

import com.goldinn.leasing.billing.Billing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingRepository extends MongoRepository<Billing, String> {
    // Additional query methods can be defined here if needed
}
