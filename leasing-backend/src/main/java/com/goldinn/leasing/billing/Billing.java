package com.goldinn.leasing.billing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "billings")
public class Billing {
    @Id
    private String id;
    private String unitId;
    private LocalDate dueDate;
    private double gas;
    private double electricity;
    private double maintenance;
    private double rent; // Add rent field

    // Getters and Setters

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
}
