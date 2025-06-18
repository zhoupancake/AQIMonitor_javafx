package com.neu.aqimonitor.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Back {
    public static void pageJump(Button btn_x,String name){

        Stage stage = (Stage) btn_x.getScene().getWindow();
        //加载登录页面的fxml视图
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = Back.class.getResource(name);
        fxmlLoader.setLocation(url);
        try {
            Parent root = fxmlLoader.load();
            Scene scene = btn_x.getScene();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}