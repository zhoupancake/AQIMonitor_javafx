package com.neu.aqimonitor_admin.entity.data;

import com.neu.aqimonitor_admin.util.AQIUtil;
import com.neu.aqimonitor_admin.util.UUIDUtil;

import java.time.LocalDateTime;

public class AirData {
    private final String id;
    private final int cityId;
    private final String location;
    private final LocalDateTime date;

    //data attributes
    private final double pm25;
    private final double pm10;
    private final double so2;
    private final double no2;
    private final double co;
    private final double o3;
    private final int aqiLevel;
    private final int aqi;

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
