package com.neu.aqimonitor.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SupervisionDetail {
    private StringProperty id;
    private StringProperty name;
    private StringProperty phoneNumber;
    private StringProperty address;
    private StringProperty des;
    private StringProperty level;
    private StringProperty datetime;

    public SupervisionDetail(String id, String name, String phoneNumber, String address, String des, String level, String datetime) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.des = new SimpleStringProperty(des);
        this.level = new SimpleStringProperty(level);
        this.datetime = new SimpleStringProperty(datetime);
    }

    // getter
    public String getId() {
        return id.get();
    }
    public String getName() {
        return name.get();
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public String getAddress() {
        return address.get();
    }
    public String getDes() {
        return des.get();
    }
    public String getLevel() {
        return level.get();
    }
    public String getDatetime() {
        return datetime.get();
    }

    // setter
    public void setId(String id) {
        this.id.set(id);
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
    public void setAddress(String address) {
        this.address.set(address);
    }
    public void setDes(String des) {
        this.des.set(des);
    }
    public void setLevel(String level) {
        this.level.set(level);
    }
    public void setDatetime(String datetime) {
        this.datetime.set(datetime);
    }

    // getter property
    public StringProperty idProperty() {
        return id;
    }
    public StringProperty nameProperty() {
        return name;
    }
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    public StringProperty addressProperty() {
        return address;
    }
    public StringProperty desProperty() {
        return des;
    }
    public StringProperty levelProperty() {
        return level;
    }
    public StringProperty datetimeProperty() {
        return datetime;
    }
}
