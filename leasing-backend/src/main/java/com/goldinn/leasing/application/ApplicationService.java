package com.goldinn.leasing.application;

import com.goldinn.leasing.application.Application;
import com.goldinn.leasing.billing.Billing;
import com.goldinn.leasing.billing.BillingRepository;
import com.goldinn.leasing.leasing.Leasing;
import com.goldinn.leasing.leasing.LeasingRepository;
import com.goldinn.leasing.housing.HousingUnit;
import com.goldinn.leasing.housing.HousingUnitRepository;
import com.goldinn.leasing.login.UserRepository;
import com.goldinn.leasing.login.User;
import com.goldinn.leasing.application.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private LeasingRepository leasingRepository;

    @Autowired
    private HousingUnitRepository housingUnitRepository;

    public Application createApplication(Application application) {
        application.setApprovalStatus("pending");
        return applicationRepository.save(application);
    }

    public Application getApplicationByUserId(String userId) {
        return applicationRepository.findByUserId(userId);
    }

    public void deleteApplicationByUserId(String userId) {
        Application application = applicationRepository.findByUserId(userId);
        if (application != null) {
            applicationRepository.delete(application);
        }
    }

    public List<ApplicationWithUserDetails> getAllApplications() {
        return applicationRepository.findAll().stream().map(application -> {
            User user = userRepository.findById(application.getUserId()).orElse(null);
            return new ApplicationWithUserDetails(application, user);
        }).collect(Collectors.toList());
    }

    public void updateApplicationStatus(String id, String status) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid application ID"));
        if ("approved".equals(status)) {
            createBillingAndLeasing(application);
            applicationRepository.delete(application);
        } else {
            application.setApprovalStatus(status);
            applicationRepository.save(application);
        }
    }

    private void createBillingAndLeasing(Application application) {
        Instant now = Instant.now();

        // Create billing entry
        Billing billing = new Billing();
        billing.setUnitId(application.getUnitId());
        billing.setDueDate(LocalDate.now().plus(30, ChronoUnit.DAYS));
        billing.setGas(0);
        billing.setElectricity(0);
        billing.setMaintenance(0);
        billing.setRent(1000); // Set the rent value as needed
        billing = billingRepository.save(billing);

        // Create leasing entry
        Leasing leasing = new Leasing();
        leasing.setUserId(application.getUserId());
        leasing.setUnitId(application.getUnitId());
        leasing.setLeaseStart(now);
        leasing.setLeaseEnd(LocalDateTime.now().plus(12, ChronoUnit.MONTHS).toInstant(ZoneOffset.UTC));
        leasing.setBillingId(billing.getId());
        leasingRepository.save(leasing);

        // Update housing unit
        Optional<HousingUnit> housingUnitOptional = housingUnitRepository.findByUnitId(application.getUnitId());
        if (housingUnitOptional.isPresent()) {
            HousingUnit housingUnit = housingUnitOptional.get();
            housingUnit.setUserId(application.getUserId());
            housingUnitRepository.save(housingUnit);
        }
    }

    public void deleteApplicationById(String id) {
        applicationRepository.deleteById(id);
    }
}