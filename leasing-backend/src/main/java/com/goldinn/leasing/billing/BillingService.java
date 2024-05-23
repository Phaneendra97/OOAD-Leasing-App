package com.goldinn.leasing.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public void generateBill(String unitId, int gas, int electricity, int maintenance, int rent) {
        Billing billing = new Billing();
        billing.setUnitId(unitId);
        billing.setGas(gas);
        billing.setElectricity(electricity);
        billing.setMaintenance(maintenance);
        billing.setRent(rent);
        billingRepository.save(billing);
    }
}
