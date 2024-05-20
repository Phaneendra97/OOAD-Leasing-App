package com.goldinn.leasing.repository;

import com.goldinn.leasing.model.HousingUnit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HousingUnitRepository extends MongoRepository<HousingUnit, String> {
    Optional<HousingUnit> findByUserId(String userId);
    List<HousingUnit> findByUserIdIsNull();
}
