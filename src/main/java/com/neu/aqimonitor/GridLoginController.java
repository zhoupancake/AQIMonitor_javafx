package com.neu.aqimonitor;

import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.util.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class GridLoginController {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btn_login;

    @FXML
    private void initialize() {
        txtUserName.setText("19874399452");
        txtPassword.setText("grid0");
    }

    public void login() throws IOException {
        //判断用户是不是存在
        String userName = txtUserName.getText();
        String password = SHA256Util.encrypt(txtPassword.getText());

        if (DataUtil.gridDetectorMap.containsKey("Grid_" + userName)){
            GridDetector grid = DataUtil.gridDetectorMap.get("Grid_" + userName);
            if (!password.equals(grid.getPassword())){
                AlertUtil.showDialog("用户登录","密码不正确");
                return;
            }
            //登录成功之后跳转到管理员页面
            FXMLLoader fxmlLoader = new FXMLLoader();
            URL url = getClass().getResource(PathUtil.VIEW_THE_TASKS_PATH);
            fxmlLoader.setLocation(url);
            Parent root = fxmlLoader.load();
            Scene scene = btn_login.getScene();
            scene.setRoot(root);
            Stage stage = (Stage) scene.getWindow();
            stage.show();
        }
        else
            AlertUtil.showDialog("用户登录","用户不存在");
    }
}
