package com.neu.aqimonitor.entity.data;

public class City {
    private  String id;
    private  String name;
    private  String province;

    public City(){}

    public City(String id, String name, String province){
        this.id = id;
        this.name = name;
        this.province = province;
    }

    public String getId() {
        return String.valueOf(this.id);
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
