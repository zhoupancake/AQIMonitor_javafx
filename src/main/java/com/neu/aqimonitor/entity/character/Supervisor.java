package com.neu.aqimonitor.entity.character;

public class Supervisor extends User{
    private String id;

    private int cityId;

    public Supervisor(){}

    public Supervisor(String phoneNumber, String password, String realName, String age, String gender, int cityId){
        super(phoneNumber, password, realName, age, gender);
        this.id = "Super_" + phoneNumber;
        this.cityId = cityId;
    }

    public Supervisor(String id, String phoneNumber, String password, String realName, String age, String gender, int cityId){
        super(phoneNumber, password, realName, age, gender);
        this.id = id;
        this.cityId = cityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
