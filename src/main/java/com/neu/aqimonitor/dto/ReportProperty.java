package com.neu.aqimonitor.dto;

import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.util.DataUtil;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.format.DateTimeFormatter;

public class ReportProperty extends Report {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty province;
    private final StringProperty city;
    private final StringProperty forecastAqiLevel;
    private final StringProperty date;
    private final StringProperty time;

    public ReportProperty(Report report) {
        super(report.getSubmitterId(),
                report.getStatus(),
                report.getDescription(),
                report.getCityId(),
                report.getLocation(),
                report.getForecastAqiLevel());
        this.id = new SimpleStringProperty(report.getId());
        this.name = new SimpleStringProperty(DataUtil.gridDetectorMap.get(report.getSubmitterId()).getRealName());
        this.province = new SimpleStringProperty(DataUtil.cityMap.get(report.getCityId()).getProvince());
        this.city = new SimpleStringProperty(DataUtil.cityMap.get(report.getCityId()).getName());
        this.forecastAqiLevel = new SimpleStringProperty(Integer.toString(report.getForecastAqiLevel()));
        this.date = new SimpleStringProperty(report.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.time = new SimpleStringProperty(report.getCreatedTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    // getter
    public String getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public String getProvince() {
        return province.get();
    }
    public String getCity() {
        return city.get();
    }
    public String getForecastAqiLevelString() {
        return forecastAqiLevel.get();
    }
    public String getDate() {
        return date.get();
    }
    public String getTime() {
        return time.get();
    }

    // setter
    public void setId(String id) {
        this.id.set(id);
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public void setProvince(String province) {
        this.province.set(province);
    }
    public void setCity(String city) {
        this.city.set(city);
    }
    public void setForecastAqiLevel(int forecastAqiLevel) {
        this.forecastAqiLevel.set(Integer.toString(forecastAqiLevel));
    }
    public void setDate(String date) {
        this.date.set(date);
    }
    public void setTime(String time) {
        this.time.set(time);
    }

    // getter Property
    public StringProperty getIdProperty() {
        return id;
    }
    public StringProperty getNameProperty() {
        return name;
    }
    public StringProperty getProvinceProperty() {
        return province;
    }
    public StringProperty getCityProperty() {
        return city;
    }
    public StringProperty getForecastAqiLevelProperty() {
        return forecastAqiLevel;
    }
    public StringProperty getDateProperty() {
        return date;
    }
    public StringProperty getTimeProperty() {
        return time;
    }
}
