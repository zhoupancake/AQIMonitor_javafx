package com.neu.aqimonitor;

import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.character.User;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TextField txt_passWord;

    //点击“登录“按钮后的步骤
    public void login() throws IOException{
        Map<String, User> userMap = FileUtil.readMapObject(PathUtil.USER_PATH);
        String phoneNumber = txt_phoneNumber.getText();
        String passWord = txt_passWord.getText();
        //判断输入是否正确，key传入的是手机号！
        if(userMap.containsKey(phoneNumber)){
            User u = userMap.get(phoneNumber);
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
        pageJump(btn_register,"../view/UserRegisterView.fxml");
    }
}
