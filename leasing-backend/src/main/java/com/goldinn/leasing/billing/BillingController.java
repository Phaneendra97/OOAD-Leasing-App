package com.goldinn.leasing.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateBill(@RequestBody BillRequest billRequest) {
        billingService.generateAndSaveBill(billRequest.getUnitId(), billRequest.getRent());
        return ResponseEntity.ok("Bill generated successfully.");
    }
}
