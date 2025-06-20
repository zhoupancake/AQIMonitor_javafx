package com.neu.aqimonitor;

import com.neu.aqimonitor.entity.character.Supervisor;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Random;

import static com.neu.aqimonitor.util.Back.pageJump;

public class UserRegisterController {
    @FXML
    private Button btn_backToLogin;

    @FXML
    private TextField txt_phoneNumber;
    @FXML
    private TextField txt_passWord;
    @FXML
    private TextField txt_realName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtGender;

    //点击“注册”后进行的步骤
    public void registerUser(){
        //创建对象
        String phoneNumber = txt_phoneNumber.getText();
        String passWord = txt_passWord.getText();
        String realName = txt_realName.getText();
        String age = txtAge.getText();
        String gender = txtGender.getText();
        Supervisor u = new Supervisor(phoneNumber,passWord,realName,age,gender, new Random().nextInt(367) + 1);
        //将用户信息写入文件,根据手机号！传入的
        DataUtil.supervisorMap.put(u.getPhoneNumber(), u);
        AlertUtil.showDialog("注册成功", "请登录");
    }

    //点击“返回”后进行的步骤
    public void backToLogin(){
        pageJump(btn_backToLogin,PathUtil.USER_LOGIN_VIEW_PATH);
    }
}
