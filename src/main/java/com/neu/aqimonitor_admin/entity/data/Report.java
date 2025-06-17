package com.neu.aqimonitor_admin.entity.data;

import com.neu.aqimonitor_admin.util.UUIDUtil;

import java.time.LocalDateTime;

public class Report {
    private  String id;
    private  String submitterId;
    private int status;
    private  LocalDateTime createdTime;
    private  String description;
    private  int cityId;
    private  String location;
    private  int forecastAqiLevel;
    
    public Report() {}

    public Report(String submitterId, Integer status, String description, Integer cityId, String location, Integer forecastAqiLevel){
        this.submitterId = submitterId;
        this.status = status;
        this.description = description;
        this.cityId = cityId;
        this.location = location;
        this.forecastAqiLevel = forecastAqiLevel;
        this.id = UUIDUtil.generate32();
        this.createdTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCityId() {
        return cityId;
    }

    public String getLocation() {
        return location;
    }

    public int getForecastAqiLevel() {
        return forecastAqiLevel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setForecastAqiLevel(int forecastAqiLevel) {
        this.forecastAqiLevel = forecastAqiLevel;
    }
}
