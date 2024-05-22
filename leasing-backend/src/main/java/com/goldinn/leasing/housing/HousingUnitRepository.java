package com.goldinn.leasing.housing;

import com.goldinn.leasing.housing.HousingUnit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HousingUnitRepository extends MongoRepository<HousingUnit, String> {
    Optional<HousingUnit> findByUserId(String userId);
    Optional<HousingUnit> findByUnitId(String unitId);
    List<HousingUnit> findByUserIdIsNull();
}
