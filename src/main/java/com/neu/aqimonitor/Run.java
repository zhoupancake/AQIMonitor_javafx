package com.neu.aqimonitor;

import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.PathUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Run extends Application {

    public static void main(String[] args){launch(args);}

    @Override
    public void init() throws Exception {
        // 读取数据
        DataUtil.init();

    }

    @Override
    public void start(Stage stage) throws Exception {

        //从一个fxml文件中加载视图
        FXMLLoader fxmlLoader = new FXMLLoader();
        //为fxmlLoader设置要加载的fxml文件路径
        URL url = getClass().getResource(PathUtil.ADMIN_VIEW_PATH);
        //设置加载路径
        fxmlLoader.setLocation(url);
        //加载视图（NODE根节点）
        Parent root = fxmlLoader.load();
        //创建一个Scene（场景）
        Scene scene = new Scene(root);
        //将Scene设置给stage
        stage.setScene(scene);
        stage.show();
    }
}
