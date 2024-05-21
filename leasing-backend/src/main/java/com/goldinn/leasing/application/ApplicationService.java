package com.goldinn.leasing.service;

import com.goldinn.leasing.model.Application;
import com.goldinn.leasing.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application createApplication(Application application) {
        application.setApprovalStatus("pending");
        return applicationRepository.save(application);
    }
}
