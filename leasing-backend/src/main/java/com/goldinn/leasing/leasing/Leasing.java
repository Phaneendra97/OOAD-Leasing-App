package com.goldinn.leasing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "leasings")
public class Leasing {
    @Id
    private String id;
    private String userId;
    private String unitId;
    private Instant leaseStart;
    private Instant leaseEnd;
    private String billingId;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }
}
