package com.neu.aqimonitor.dto;

import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.util.DataUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProvincialGroupProperty {
    private StringProperty provinceId;
    private StringProperty provinceName;
    private StringProperty so2;
    private StringProperty co;
    private StringProperty pm25;
    private StringProperty aqi;

    public ProvincialGroupProperty(String provinceId, String provinceName, String so2, String co, String pm25, String aqi) {
        this.provinceId = new SimpleStringProperty(provinceId);
        this.provinceName = new SimpleStringProperty(provinceName);
        this.so2 = new SimpleStringProperty(so2);
        this.co = new SimpleStringProperty(co);
        this.pm25 = new SimpleStringProperty(pm25);
        this.aqi = new SimpleStringProperty(aqi);
    }

    // getter
    public String getProvinceId() {
        return provinceId.get();
    }
    public String getProvinceName() {
        return provinceName.get();
    }
    public String getSo2() {
        return so2.get();
    }
    public String getCo() {
        return co.get();
    }
    public String getPm25() {
        return pm25.get();
    }
    public String getAqi() {
        return aqi.get();
    }
    // setter
    public void setProvinceId(String provinceId) {
        this.provinceId.set(provinceId);
    }
    public void setProvinceName(String provinceName) {
        this.provinceName.set(provinceName);
    }
    public void setSo2(String so2) {
        this.so2.set(so2);
    }
    public void setCo(String co) {
        this.co.set(co);
    }
    public void setPm25(String pm25) {
        this.pm25.set(pm25);
    }
    public void setAqi(String aqi) {
        this.aqi.set(aqi);
    }
    // getter property
    public StringProperty provinceIdProperty() {
        return provinceId;
    }
    public StringProperty provinceNameProperty() {
        return provinceName;
    }
    public StringProperty so2Property() {
        return so2;
    }
    public StringProperty coProperty() {
        return co;
    }
    public StringProperty pm25Property() {
        return pm25;
    }
    public StringProperty aqiProperty() {
        return aqi;
    }
}
