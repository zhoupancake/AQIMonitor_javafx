package com.neu.aqimonitor.controller;

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
        User u = new User(phoneNumber,passWord,realName,age,gender);
        //将用户信息写入文件,根据手机号！传入的
        Map<String, User> userMap = FileUtils.readMapObject("user.txt");
        userMap.put(u.getPhoneNumber(), u);
        FileUtils.writeObject("user.txt",userMap);
        System.out.println("注册成功");

    }

    //点击“返回”后进行的步骤
    public void backToLogin(){
        Stage stage = (Stage) btn_backToLogin.getScene().getWindow();
        //加载登录页面的fxml视图
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = getClass().getResource("../view/UserLoginView.fxml");
        fxmlLoader.setLocation(url);
        try {
            Parent root = fxmlLoader.load();
            Scene scene = btn_backToLogin.getScene();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
