package com.goldinn.leasing.application;

import com.goldinn.leasing.login.User;

public class ApplicationWithUserDetails {
    private String id;
    private String unitId;
    private String pdfFile;
    private String approvalStatus;
    private String userId;
    private String firstName;
    private String lastName;

    public ApplicationWithUserDetails(Application application, User user) {
        this.id = application.getId();
        this.unitId = application.getUnitId();
        this.pdfFile = application.getPdfFile();
        this.approvalStatus = application.getApprovalStatus();
        this.userId = application.getUserId();
        if (user != null) {
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
