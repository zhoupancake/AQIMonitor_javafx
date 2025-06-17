package com.neu.aqimonitor_admin.controller.logicController;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.util.AlertUtil;
import com.neu.aqimonitor_admin.util.DataUtil;
import com.neu.aqimonitor_admin.util.SHA256Util;

import java.util.Map;

public class UserController {
    public Administrator login(String phoneNumber, String password){
        password = SHA256Util.encrypt(password);
        Administrator administrator = DataUtil.administratorMap.get("Admin_" + phoneNumber);
        if(administrator ==  null) {
            AlertUtil.showErrorDialog("用户登录", "用户不存在");
            return null;
        }
        if(administrator.getPassword().equals(password))
            return administrator;
        AlertUtil.showErrorDialog("用户登录", "密码不正确");
        return null;
    }
}
