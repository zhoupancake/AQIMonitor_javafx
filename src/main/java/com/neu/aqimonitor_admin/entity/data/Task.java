package com.neu.aqimonitor_admin.entity.data;

import com.neu.aqimonitor_admin.util.UUIDUtil;

import java.time.LocalDateTime;

public class Task {
    private final String id;
    private final String appointerId;
    private final String appointeeId;
    private final LocalDateTime createdTime;
    private int status;
    private final String relatedReportId;

    public Task(String appointerId, String appointeeId, String relatedReportId) {
        this.appointerId = appointerId;
        this.appointeeId = appointeeId;
        this.relatedReportId = relatedReportId;
        this.id = UUIDUtil.generate32();
        this.createdTime = LocalDateTime.now();
        this.status = 0;
    }

    public Task(String id, String appointerId, String appointeeId, LocalDateTime createdTime, int status, String relatedReportId) {
        this.id = id;
        this.appointerId = appointerId;
        this.appointeeId = appointeeId;
        this.createdTime = createdTime;
        this.status = status;
        this.relatedReportId = relatedReportId;
    }

    public String getId() {
        return id;
    }

    public String getAppointerId() {
        return appointerId;
    }

    public String getAppointeeId() {
        return appointeeId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRelatedReportId() {
        return relatedReportId;
    }
}
