package com.neu.aqimonitor.entity.data;

import java.io.Serial;
import java.io.Serializable;

public class FeedbackData implements Serializable {

    @Serial
    private static final long serialVersionUID = -1411228467683373780L;
    private String code;
    private String name;
    private String province;
    private String city;
    private String address;
    private String AQI;
    private String feedback;
    private String time;
    private String griderName="无";



    private boolean isChecked=false;
    public FeedbackData(String name, String province, String city, String address, String AQI, String feedback,String time) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.address = address;
        this.AQI = AQI;
        this.feedback = feedback;
        this.time=time;
    }

    public FeedbackData(String code, String name, String province, String city, String address, String AQI, String feedback, String time) {
        this.code = code;
        this.name = name;
        this.province = province;
        this.city = city;
        this.address = address;
        this.AQI = AQI;
        this.feedback = feedback;
        this.time = time;
    }
    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }
    public String getGriderName() {
        return griderName;
    }

    public void setGriderName(String griderName) {
        this.griderName = griderName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
