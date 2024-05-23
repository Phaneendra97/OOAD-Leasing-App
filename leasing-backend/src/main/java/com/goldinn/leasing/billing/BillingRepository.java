package com.goldinn.leasing.billing;

import com.goldinn.leasing.billing.Billing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BillingRepository extends MongoRepository<Billing, String> {
       boolean existsByUnitId(String unitId);
       Optional<Billing> findByUnitId(String unitId);

}
