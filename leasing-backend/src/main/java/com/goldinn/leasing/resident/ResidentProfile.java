package com.goldinn.leasing.resident;

import com.goldinn.leasing.billing.Billing;
import com.goldinn.leasing.leasing.Leasing;
import com.goldinn.leasing.login.User;

import java.time.Instant;

public class ResidentProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String unitId;
    private Instant leaseStart;
    private Instant leaseEnd;
    private Billing billing;

    public ResidentProfile(User user, Leasing leasing, Billing billing) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.unitId = leasing.getUnitId();
        this.leaseStart = leasing.getLeaseStart();
        this.leaseEnd = leasing.getLeaseEnd();
        this.billing = billing;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Instant getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(Instant leaseStart) {
        this.leaseStart = leaseStart;
    }

    public Instant getLeaseEnd() {
        return leaseEnd;
    }

    public void setLeaseEnd(Instant leaseEnd) {
        this.leaseEnd = leaseEnd;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }
}
