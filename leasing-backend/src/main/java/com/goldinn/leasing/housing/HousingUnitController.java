package com.goldinn.leasing.controller;

import com.goldinn.leasing.model.HousingUnit;
import com.goldinn.leasing.service.HousingUnitService;
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

    @GetMapping("/{id}")
    public ResponseEntity<HousingUnit> getHousingUnitById(@PathVariable String id) {
        Optional<HousingUnit> housingUnit = housingUnitService.getHousingUnitById(id);
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
