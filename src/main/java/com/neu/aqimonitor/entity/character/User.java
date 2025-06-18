package com.neu.aqimonitor.entity.character;

public class User {
    private String phoneNumber;
    private String password;
    private String realName;
    private String age;
    private String gender;

    public User(){}

    public User(String phoneNumber, String password, String realName, String age, String gender) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
