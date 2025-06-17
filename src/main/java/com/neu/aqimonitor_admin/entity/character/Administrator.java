package com.neu.aqimonitor_admin.entity.character;

public class Administrator extends User{
    private String id;

    public Administrator(String phoneNumber, String password, String realName, String age, String gender){
        super(phoneNumber, password, realName, age, gender);
        this.id = "Admin_" + phoneNumber;
    }

    public Administrator(String id, String phoneNumber, String password, String realName, String age, String gender){
        super(phoneNumber, password, realName, age, gender);
        this.id = id;
    }

    public String getId(){
        return id;
    }

    private void setId(String id){
        this.id = id;
    }
}
