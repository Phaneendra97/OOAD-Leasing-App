package com.goldinn.leasing.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing generateBill(String unitId, int gas, int electricity, int maintenance, int rent) {
        Optional<Billing> existingBilling = billingRepository.findByUnitId(unitId);
        Billing billing;
        if (existingBilling.isPresent()) {
            billing = existingBilling.get();
            billing.setGas(gas);
            billing.setElectricity(electricity);
            billing.setMaintenance(maintenance);
            billing.setRent(rent);
        } else {
            billing = new Billing();
            billing.setUnitId(unitId);
            billing.setGas(gas);
            billing.setElectricity(electricity);
            billing.setMaintenance(maintenance);
            billing.setRent(rent);
        }
        return billingRepository.save(billing);
    }

    public void generateAndSaveBill(String unitId, double rentCost) {
        Random random = new Random();
        int gas = 30 + random.nextInt(21); // Random between 30 and 50
        int electricity = 50 + random.nextInt(51); // Random between 50 and 100
        int maintenance = 30 + random.nextInt(31); // Random between 30 and 60
        int rent = (int) rentCost;

        generateBill(unitId, gas, electricity, maintenance, rent);
    }
}
