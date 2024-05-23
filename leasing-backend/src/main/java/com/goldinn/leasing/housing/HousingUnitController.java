package com.goldinn.leasing.housing;

import com.goldinn.leasing.housing.HousingUnit;
import com.goldinn.leasing.housing.HousingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/housing-units")
public class HousingUnitController {

    @Autowired
    private HousingUnitService housingUnitService;

    @GetMapping
    public List<HousingUnit> getAllHousingUnits() {
        return housingUnitService.getAllHousingUnits();
    }

    @GetMapping("/{unitId}")
    public ResponseEntity<HousingUnit> getHousingUnitByUnitId(@PathVariable String unitId) {
        Optional<HousingUnit> housingUnit = housingUnitService.getHousingUnitById(unitId);
        return housingUnit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<HousingUnit> getHousingUnitByUserId(@PathVariable String userId) {
        Optional<HousingUnit> housingUnit = housingUnitService.getHousingUnitByUserId(userId);
        return housingUnit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/vacant")
    public List<HousingUnit> getVacantHousingUnits() {
        return housingUnitService.getVacantHousingUnits();
    }
}
