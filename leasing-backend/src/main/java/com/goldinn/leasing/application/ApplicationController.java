package com.goldinn.leasing.controller;

import com.goldinn.leasing.model.Application;
import com.goldinn.leasing.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<String> submitApplication(
        @RequestParam("file") MultipartFile file,
        @RequestParam("unitId") String unitId,
        @RequestParam("userId") String userId
    ) throws IOException {
        String pdfFileBase64 = Base64.getEncoder().encodeToString(file.getBytes());

        Application application = new Application();
        application.setUnitId(unitId);
        application.setPdfFile(pdfFileBase64);
        application.setUserId(userId);
        
        applicationService.createApplication(application);
        
        return ResponseEntity.ok("Application submitted successfully.");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Application> getApplicationByUserId(@PathVariable String userId) {
        Application application = applicationService.getApplicationByUserId(userId);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteApplicationByUserId(@PathVariable String userId) {
        applicationService.deleteApplicationByUserId(userId);
        return ResponseEntity.ok("Application withdrawn successfully.");
    }
}
