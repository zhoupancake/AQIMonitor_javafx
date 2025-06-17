package com.neu.aqimonitor_admin.util;

import javafx.scene.control.Alert;

public class AlertUtils {

    //输入正确时
    public static void showDialog(String title,String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    //输入错误时
    public static void showErrorDialog(String title,String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
