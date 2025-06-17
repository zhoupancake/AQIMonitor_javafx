package com.neu.aqimonitor_admin.entity.character;

public class GridDetector extends User{
    private String id;

    private int cityId;

    public GridDetector(String phoneNumber, String password, String realName, String age, String gender, int cityId){
        super(phoneNumber, password, realName, age, gender);
        this.id = "Grid_" + phoneNumber;
        this.cityId = cityId;
    }

    public GridDetector(String id, String phoneNumber, String password, String realName, String age, String gender, int cityId){
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
