package com.neu.aqimonitor.entity.data;

import com.neu.aqimonitor.util.AQIUtil;
import com.neu.aqimonitor.util.UUIDUtil;

import java.time.LocalDateTime;

public class AirData {
    private String id;
    private  int cityId;
    private  String location;
    private  LocalDateTime date;

    //data attributes
    private  double pm25;
    private  double pm10;
    private  double so2;
    private  double no2;
    private  double co;
    private  double o3;
    private  int aqiLevel;
    private  int aqi;

    public AirData(){}

    public AirData(int cityId, String location, double pm25, double pm10, double so2, double no2, double co, double o3) {
        this.cityId = cityId;
        this.location = location;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.so2 = so2;
        this.no2 = no2;
        this.co = co;
        this.o3 = o3;
        this.id = UUIDUtil.generate32();
        this.aqi = AQIUtil.getAQI(pm25, so2, co);
        this.aqiLevel = AQIUtil.getAQILevel(pm25, so2, co);
        this.date = LocalDateTime.now();
    }
    
    public void setId(String  id){
        this.id = id;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public void setAqiLevel(int aqiLevel) {
        this.aqiLevel = aqiLevel;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getId() {
        return id;
    }

    public int getCityId() {
        return cityId;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getPm25() {
        return pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public double getSo2() {
        return so2;
    }

    public double getNo2() {
        return no2;
    }

    public double getCo() {
        return co;
    }

    public double getO3() {
        return o3;
    }

    public int getAqiLevel() {
        return aqiLevel;
    }

    public int getAqi() {
        return aqi;
    }
}
