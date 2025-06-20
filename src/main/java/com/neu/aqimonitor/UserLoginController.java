package com.neu.aqimonitor;

import com.neu.aqimonitor.util.*;
import com.neu.aqimonitor.entity.character.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Map;

import static com.neu.aqimonitor.util.Back.pageJump;


public class UserLoginController {
    @FXML
    private Button btn_register;
    @FXML
    private Button btn_login;
    @FXML
    private TextField txt_phoneNumber;
    @FXML
    private PasswordField txt_passWord;

    @FXML
    private void initialize() {
        txt_phoneNumber.setText("13393012216");
        txt_passWord.setText("super0");
    }
    //点击“登录“按钮后的步骤
    public void login() throws IOException{
        String phoneNumber = txt_phoneNumber.getText();
        String passWord = SHA256Util.encrypt(txt_passWord.getText());
        //判断输入是否正确，key传入的是手机号！
        if(DataUtil.supervisorMap.containsKey("Super_" + phoneNumber)){
            User u = DataUtil.supervisorMap.get("Super_" + phoneNumber);
            if(passWord.equals(u.getPassword())){
               pageJump(btn_login,PathUtil.PUBLIC_SUPERVISOR_PATH);
            }else {
                AlertUtil.showErrorDialog("用户登录", "密码不正确");
            }
        } else {
            AlertUtil.showErrorDialog("用户登录", "登陆失败");
        }

    }


    //点击“注册”按钮后的步骤
    public void register(){
        pageJump(btn_register,PathUtil.USER_REGISTER_VIEW_PATH);
    }
}
