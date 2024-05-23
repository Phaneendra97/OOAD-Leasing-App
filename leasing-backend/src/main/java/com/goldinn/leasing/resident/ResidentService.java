package com.goldinn.leasing.resident;

import com.goldinn.leasing.billing.Billing;
import com.goldinn.leasing.billing.BillingRepository;
import com.goldinn.leasing.resident.ResidentDTO;
import com.goldinn.leasing.leasing.Leasing;
import com.goldinn.leasing.leasing.LeasingRepository;
import com.goldinn.leasing.login.User;
import com.goldinn.leasing.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ResidentDTO> getAllResidents() {
        return userRepository.findAllByIsResidentTrue()
            .stream()
            .map(user -> new ResidentDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getId() // Assuming getId() returns the unitId
            ))
            .collect(Collectors.toList());
    }
}
