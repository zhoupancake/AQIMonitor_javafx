package com.neu.aqimonitor_admin.entity.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neu.aqimonitor_admin.util.UUIDUtil;

import java.time.LocalDateTime;

public class Report {
    private final String id;
    private final String submitterId;
    private int status;
    private final LocalDateTime createdTime;
    private final String description;
    private final int cityId;
    private final String location;
    private final int forecastAqiLevel;

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
}
