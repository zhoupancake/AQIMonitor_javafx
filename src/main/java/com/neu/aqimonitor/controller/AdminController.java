package com.neu.aqimonitor.controller;
import com.neu.aqimonitor.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;

public class AdminController {
    @FXML
    private ImageView imageView;

    @FXML
    private BorderPane borderPane;

    @FXML
    private StackPane stackPane;

    //主页面
    @FXML
    public void initialize(){
        Image image = new Image("image/Welcome.png" );
        imageView.setImage(image);

        imageView.fitWidthProperty().bind(borderPane.widthProperty());
        imageView.fitHeightProperty().bind(borderPane.heightProperty());
        imageView.setSmooth(true);
        imageView.setPreserveRatio(false);
    }

    //公共方法实现页面转换
    public void loadView(String fxmlFilePath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = getClass().getResource(fxmlFilePath);
        fxmlLoader.setLocation(url);
        Parent root = fxmlLoader.load();
        stackPane.getChildren().setAll(root);
    }

    //转换到AQI查询页面
    public void loadPublicSupervisor() throws IOException {
        loadView("../view/UserLoginView.fxml" );

    }

}
