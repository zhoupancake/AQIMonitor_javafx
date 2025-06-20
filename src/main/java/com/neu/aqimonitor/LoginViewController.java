package com.neu.aqimonitor;

import com.neu.aqimonitor.controller.logicController.UserController;
import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.Jump;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {
    private final UserController userController = new UserController();

    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
        accountField.setText("18083942294");
        passwordField.setText("admin0");
    }

    @FXML
    public void handleLogin() {
        Administrator admin = userController.adminLogin(accountField.getText(), passwordField.getText());
        if (admin != null) {
            Jump.jumpToPage(loginButton, PathUtil.ADMIN_MENU_VIEW_PATH);
        } else {
            AlertUtil.showErrorDialog("登录失败", "账号或密码错误");
        }
    }

}
