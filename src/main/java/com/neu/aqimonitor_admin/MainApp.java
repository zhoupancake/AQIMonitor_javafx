package com.neu.aqimonitor_admin;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.util.DataUtil;
import com.neu.aqimonitor_admin.util.PathUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class MainApp extends Application {

    private Stage stage;
    private BorderPane blank;

    private Map<String, Administrator> administrators;

    public Stage getStage() {
        return stage;
    }

    //=================初始启动方法================//
    @Override
    public void init() throws Exception {
        // 读取数据
        DataUtil.init();

    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        iniBlank();
        showLoginView();
    }

    @Override
    public void stop() throws Exception {
        // 保存数据
    }

    public static void main(String[] args) {
        launch();
    }

    //=================容器初始化================//
    public void iniBlank() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(PathUtil.BLANK_PATH));
            blank = (BorderPane) loader.load();

            Scene scene = new Scene(blank);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(PathUtil.LOGIN_VIEW_PATH));
            AnchorPane loginView = (AnchorPane) loader.load();

            blank.setCenter(loginView);
            stage.setTitle("用户登录");

            LoginViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdminMenuView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(PathUtil.Admin_Menu_VIEW_PATH));
            AnchorPane adminMenuView = (AnchorPane) loader.load();

            blank.setCenter(adminMenuView);
            stage.setTitle("管理员菜单");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}