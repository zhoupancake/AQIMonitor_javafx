package com.neu.aqimonitor.controller.logicController;

import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.SHA256Util;

public class UserController {
    public Administrator adminLogin(String phoneNumber, String password){
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
