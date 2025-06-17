package com.neu.aqimonitor.controller;

import com.neu.aqimonitor.util.AlertUtils;
import com.neu.aqimonitor.util.FileUtils;
import com.neu.aqimonitor.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;


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
        Map<String, User> userMap = FileUtils.readMapObject("user.txt");
        String phoneNumber = txt_phoneNumber.getText();
        String passWord = txt_passWord.getText();
        System.out.println(userMap);
        //判断输入是否正确，key传入的是手机号！
        if(userMap.containsKey(phoneNumber)){
            User u = userMap.get(phoneNumber);
            if(passWord.equals(u.getPassword())){
                FXMLLoader fxmlLoader = new FXMLLoader();
                URL url = getClass().getResource("../view/PublicSupervisor.fxml");
                fxmlLoader.setLocation(url);
                Parent root = fxmlLoader.load();
                Scene scene = btn_login.getScene();
                scene.setRoot(root);
                Stage stage = (Stage) scene.getWindow();
                stage.show();
            }else {
                AlertUtils.showErrorDialog("用户登录", "密码不正确");
            }
        } else {
            AlertUtils.showErrorDialog("用户登录", "登陆失败");
        }

    }


    //点击“注册”按钮后的步骤
    public void register(){
        Stage stage = (Stage) btn_register.getScene().getWindow();
        //加载注册页面的fxml视图
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = getClass().getResource("../view/UserRegisterView.fxml");
        fxmlLoader.setLocation(url);
        try {
            Parent root = fxmlLoader.load();
            Scene scene = btn_register.getScene();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
