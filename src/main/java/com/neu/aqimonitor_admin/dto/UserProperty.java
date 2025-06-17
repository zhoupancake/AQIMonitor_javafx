package com.neu.aqimonitor_admin.dto;

import com.neu.aqimonitor_admin.entity.character.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserProperty extends User {
    // 属性
    private final StringProperty phoneNumber;
    private final StringProperty password;
    private final StringProperty realName;
    private final StringProperty age;
    private final StringProperty gender;

    // 构造方法
    public UserProperty(User user) {
        super(user.getPhoneNumber(), user.getPassword(), user.getRealName(), user.getAge(), user.getGender());
        this.phoneNumber = new SimpleStringProperty(user.getPhoneNumber());
        this.password = new SimpleStringProperty(user.getPassword());
        this.realName = new SimpleStringProperty(user.getRealName());
        this.age = new SimpleStringProperty(user.getAge());
        this.gender = new SimpleStringProperty(user.getGender());
    }

    // getter
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getRealName() {
        return realName.get();
    }
    public String getAge() {
        return age.get();
    }
    public String getGender() {
        return gender.get();
    }

    // setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
    public void setPassword(String password) {
        this.password.set(password);
    }
    public void setRealName(String realName) {
        this.realName.set(realName);
    }
    public void setAge(String age) {
        this.age.set(age);
    }
    public void setGender(String gender) {
        this.gender.set(gender);
    }

    // getter property
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    public StringProperty passwordProperty() {
        return password;
    }
    public StringProperty realNameProperty() {
        return realName;
    }
    public StringProperty ageProperty() {
        return age;
    }
    public StringProperty genderProperty() {
        return gender;
    }

}
