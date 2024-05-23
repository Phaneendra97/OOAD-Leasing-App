package com.goldinn.leasing.resident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldinn.leasing.leasing.Leasing;
import com.goldinn.leasing.leasing.LeasingRepository;
import com.goldinn.leasing.billing.Billing;
import com.goldinn.leasing.billing.BillingRepository;
import com.goldinn.leasing.login.User;
import com.goldinn.leasing.login.UserRepository;

@Service
public class ResidentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LeasingRepository leasingRepository;

    @Autowired
    private BillingRepository billingRepository;

    public ResidentProfile getResidentProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Leasing leasing = leasingRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("Leasing not found"));
        Billing billing = billingRepository.findById(leasing.getBillingId()).orElseThrow(() -> new IllegalArgumentException("Billing not found"));

        return new ResidentProfile(user, leasing, billing);
    }
}
