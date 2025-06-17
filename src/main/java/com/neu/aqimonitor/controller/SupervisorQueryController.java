package com.neu.aqimonitor.controller;

import com.neu.aqimonitor.util.FileUtils;
import com.neu.aqimonitor.entity.Information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SupervisorQueryController {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Information,String> colProvince,colCountry,colAddress,colAQI,colTime;

    @FXML
    private Button btn_back;

    private ObservableList tableList = FXCollections.observableArrayList();
    private Map infoMap = new HashMap();
    //初始化方法
    @FXML
    public void initialize(){
        tableView.setItems(tableList);

        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAQI.setCellValueFactory(new PropertyValueFactory<>("AQI"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        //从文件中读取所有对象数据
        infoMap = FileUtils.readMapObject("Information.txt");
        tableList.addAll(infoMap.values());

        //设置表格为可编辑表格
        tableView.setEditable(true);
        //设置允许编辑的单元格类型
        colAQI.setCellFactory(TextFieldTableCell.forTableColumn());
        //处理点击单元格之后的事件
        colAQI.setOnEditCommit(event->{
            Information info = event.getRowValue();
            String newAQI = event.getNewValue();
            //更新数据到文件里
            info.setAQI(newAQI);
            infoMap.put(info.getAddress(),info);
            FileUtils.writeObject("user.txt",infoMap);
        });

    }


    public void backToSubmit(){
        Stage stage = (Stage) btn_back.getScene().getWindow();
        //加载登录页面的fxml视图
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = getClass().getResource("../view/PublicSupervisor.fxml");
        fxmlLoader.setLocation(url);
        try {
            Parent root = fxmlLoader.load();
            Scene scene = btn_back.getScene();
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
