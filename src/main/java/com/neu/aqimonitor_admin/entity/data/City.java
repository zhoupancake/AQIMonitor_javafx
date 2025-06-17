package com.neu.aqimonitor_admin.entity.data;

public class City {
    private final int id;
    private final String name;
    private final String province;

    public City(String id, String name, String province){
        this.id = Integer.parseInt(id);
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
}
