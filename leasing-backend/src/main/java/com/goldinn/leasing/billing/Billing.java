package com.goldinn.leasing.billing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "billings")
public class Billing {

    @Id
    private String id;
    private String unitId;
    private int gas;
    private int electricity;
    private int maintenance;
    private int rent;
    private LocalDate dueDate; // Add this field

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

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public LocalDate getDueDate() { // Add this getter
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) { // Add this setter
        this.dueDate = dueDate;
    }
}
