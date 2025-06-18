package com.neu.aqimonitor;

import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.PathUtil;
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

            Scene scene = new Scene(loginView);
            stage.setScene(scene);
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
            loader.setLocation(MainApp.class.getResource(PathUtil.ADMIN_MENU_VIEW_PATH));
            AnchorPane adminMenuView = (AnchorPane) loader.load();

            Scene scene = new Scene(adminMenuView);
            stage.setScene(scene);
            stage.setTitle("管理员菜单");

            AdminMenuViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPublicSupervisionView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(PathUtil.PUBLIC_SUPERVISION_PATH));
            AnchorPane publicSupervisionView = (AnchorPane) loader.load();

            Scene scene = new Scene(publicSupervisionView);
            stage.setScene(scene);
            stage.setTitle("公众监督数据管理");

            PublicSupervisionViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showConfirmAQIListView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(PathUtil.CONFIRM_AQI_LIST_VIEW_PATH));
            AnchorPane confirmAQIListView = (AnchorPane) loader.load();

            Scene scene = new Scene(confirmAQIListView);
            stage.setScene(scene);
            stage.setTitle("确认AQI数据详情");

            ConfirmAQIListViewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}