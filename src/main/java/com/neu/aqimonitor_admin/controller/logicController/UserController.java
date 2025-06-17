package com.neu.aqimonitor_admin.controller.logicController;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.util.AlertUtils;
import com.neu.aqimonitor_admin.util.SHA256Utils;

import java.util.Map;

public class UserController {
    private final Map<String, Administrator> administrators;

    public UserController(Map<String, Administrator>  administrators){
        this.administrators = administrators;
    }

    public Administrator login(String phoneNumber, String password){
        password = SHA256Utils.encrypt(password);
        Administrator administrator = administrators.get("Admin_" + phoneNumber);
        if(administrator ==  null) {
            AlertUtils.showErrorDialog("用户登录", "用户不存在");
            return null;
        }
        if(administrator.getPassword().equals(password))
            return administrator;
        AlertUtils.showErrorDialog("用户登录", "密码不正确");
        return null;
    }
}
