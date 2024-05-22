package com.goldinn.leasing.application;

import com.goldinn.leasing.application.Application;
import com.goldinn.leasing.application.ApplicationWithUserDetails;
import com.goldinn.leasing.login.UserRepository;
import com.goldinn.leasing.login.User;
import com.goldinn.leasing.application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

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
        application.setApprovalStatus(status);
        applicationRepository.save(application);
    }

    public Application getApplicationById(String id) {
        return applicationRepository.findById(id).orElse(null);
    }
}
