package com.neu.aqimonitor_admin;

import com.neu.aqimonitor_admin.MainApp;
import com.neu.aqimonitor_admin.controller.logicController.UserController;
import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {
    private UserController userController = new UserController();

    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        accountField.setText("1817774560");
        passwordField.setText("123456");
    }

    @FXML
    public void handleLogin() {
        Administrator admin = userController.adminLogin(accountField.getText(), passwordField.getText());

        if (admin != null) {
            mainApp.showAdminMenuView();
        } else {
            AlertUtil.showErrorDialog("登录失败", "账号或密码错误");
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
