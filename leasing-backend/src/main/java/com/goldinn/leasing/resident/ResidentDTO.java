package com.goldinn.leasing.resident;

public class ResidentDTO {
    private String firstName;
    private String lastName;
    private String unitId;

    // Constructors
    public ResidentDTO() {
    }

    public ResidentDTO(String firstName, String lastName, String unitId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.unitId = unitId;
    }

    // Getters and Setters
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

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}
