package com.neu.aqimonitor.entity;

import java.io.Serializable;
import java.util.Map;

public class Information implements Serializable {
    private String province;
    private String country;
    private String address;
    private String AQI;
    private String feedback;
    private String time;

    public Information(String province, String country, String address, String AQI, String feedback, String time) {
        this.province = province;
        this.country = country;
        this.address = address;
        this.AQI = AQI;
        this.feedback = feedback;
        this.time = time;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
