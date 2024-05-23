package com.goldinn.leasing.housing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "housing_units")
public class HousingUnit {

    @Id
    private String id;
    private String unitId;
    private String dimensions;
    private String userId;
    private List<String> images;
    private String map;
    private String type;
    private String furnished;
    private int baths;
    private int beds;
    private double cost;

    // Constructors
    public HousingUnit() {}

    public HousingUnit(String id, String unitId, String dimensions, String userId, List<String> images, String map, String type, String furnished, int baths, int beds, double cost) {
        this.id = id;
        this.unitId = unitId;
        this.dimensions = dimensions;
        this.userId = userId;
        this.images = images;
        this.map = map;
        this.type = type;
        this.furnished = furnished;
        this.baths = baths;
        this.beds = beds;
        this.cost = cost;
    }

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

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFurnished() {
        return furnished;
    }

    public void setFurnished(String furnished) {
        this.furnished = furnished;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
