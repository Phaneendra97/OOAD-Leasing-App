package com.goldinn.leasing.billing;

import com.goldinn.leasing.billing.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateBill(@RequestBody BillRequest billRequest) {
        try {
            billingService.generateBill(
                billRequest.getUnitId(), 
                billRequest.getGas(), 
                billRequest.getElectricity(), 
                billRequest.getMaintenance(), 
                billRequest.getRent()
            );
            return ResponseEntity.ok("Bill generated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
