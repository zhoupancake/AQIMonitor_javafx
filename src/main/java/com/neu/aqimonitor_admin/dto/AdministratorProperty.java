package com.neu.aqimonitor_admin.dto;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdministratorProperty extends Administrator {
    // 属性
    private final StringProperty id;

    // 构造函数
    public AdministratorProperty(Administrator administrator) {
        super(administrator.getPhoneNumber(), administrator.getPassword(), administrator.getRealName(), administrator.getAge(), administrator.getGender());
        this.id = new SimpleStringProperty(administrator.getId());
    }

    // getter
    public String getId() {
        return id.get();
    }

    // setter
    public void setId(String id) {
        this.id.set(id);
    }

    // getter property
    public StringProperty idProperty() {
        return id;
    }


}
