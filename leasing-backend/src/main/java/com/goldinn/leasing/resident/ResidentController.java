package com.goldinn.leasing.resident;

import com.goldinn.leasing.resident.ResidentDTO;
import com.goldinn.leasing.resident.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @GetMapping("/all")
    public ResponseEntity<List<ResidentDTO>> getAllResidents() {
        return ResponseEntity.ok(residentService.getAllResidents());
    }
}
