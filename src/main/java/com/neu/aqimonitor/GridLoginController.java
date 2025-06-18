package com.neu.aqimonitor;

import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.character.Grid;
import com.neu.aqimonitor.util.PathUtil;
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

public class GridLoginController {

    @FXML
    private TextField txtUserName,txtPassword;
    @FXML
    private Button btn_login;

    public void login() throws IOException {

        Map<String, Grid> userMap = FileUtil.readMapObject(PathUtil.GRID_LOAD_PATH);
        //向用户列表添加新的用户
        Grid g1 = new Grid("1","1");
        Grid g2 = new Grid("2","2");
        Grid g3 = new Grid("3","3");
        userMap.put(g1.getPassWord(), g1);
        userMap.put(g2.getPassWord(),g2);
        userMap.put(g3.getPassWord(),g3);

        FileUtil.writeObject(PathUtil.GRID_LOAD_PATH,userMap);
        //判断用户是不是存在
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userMap.containsKey(password)){
            Grid u = userMap.get(password);
            if (userName.equals(u.getUserName())){
                //登录成功之后跳转到管理员页面
                FXMLLoader fxmlLoader = new FXMLLoader();
                URL url = getClass().getResource(PathUtil.VIEW_THE_TASKS_PATH);
                fxmlLoader.setLocation(url);
                Parent root = fxmlLoader.load();
                Scene scene = btn_login.getScene();
                scene.setRoot(root);
                Stage stage = (Stage) scene.getWindow();
                stage.show();
            }else{
                AlertUtil.showDialog("用户登录","密码不正确");
            }
        }else{
            AlertUtil.showDialog("用户登录","用户不存在");
        }
    }
}
