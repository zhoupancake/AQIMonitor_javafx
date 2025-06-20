package com.neu.aqimonitor;

//需求未知
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.data.Data;
import com.neu.aqimonitor.entity.data.Information;
import com.neu.aqimonitor.util.PathUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.neu.aqimonitor.util.Back.pageJump;

public class viewTheTaskController {

    @FXML
    private Button btn_login;
    @FXML
    private Button btn_check;
    @FXML
    private Button btn_backToHall;
    @FXML
    private Button btn_viewData;
    @FXML
    private TableView<Information> tableView;
    private final ObservableList<Information> tableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Information,String> colProvince,colCountry,colAddress,colAQI,colTime;
    private Map infoMap = new HashMap();
    @FXML
    public void initialize() {
        tableView.setItems(tableList);
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAQI.setCellValueFactory(new PropertyValueFactory<>("AQI"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        //从文件中读取所有对象数据
        infoMap = FileUtil.readMapObject(PathUtil.INFORMATION_PATH);
        tableList.addAll(infoMap.values());
    }
        public void check () throws IOException {
            // 1. 获取选中行（非空判断）
            Information selectedData = tableView.getSelectionModel().getSelectedItem();
            if (selectedData == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("请选择一行数据！");
                alert.showAndWait();
                return; // 未选中则不跳转
            }
            // 2. 加载目标页面（如 SubmitData.fxml）并传递数据
            FXMLLoader loader = new FXMLLoader(getClass().getResource(PathUtil.SUBMIT_DATA_PATH));
            Parent root = loader.load();
            // 3. 获取目标页面的控制器，传递数据
            SubmitDataController targetController = loader.getController();
            targetController.setData(selectedData); // 需在目标控制器定义 setData 方法

            // 4. 切换场景
            Scene scene = btn_check.getScene();
            scene.setRoot(root);

        }

        public void backToHall () throws IOException {
            pageJump(btn_backToHall, PathUtil.ADMIN_VIEW_PATH);
        }

        public void viewSubmittedData () {
            try {
                Map<String, Data> dataMap = FileUtil.readMapObject(PathUtil.DATA_PATH);
                if (dataMap.isEmpty()) {
                    AlertUtil.showDialog("查看数据", "暂无提交的数据");
                    return;
                }
                TableView<Data> tableView = new TableView<>();
                tableView.setPrefHeight(400);
                tableView.setPrefWidth(600);
                // 创建SO2列
                TableColumn<Data, String> so2Column = new TableColumn<>("SO2");
                so2Column.setCellValueFactory(new PropertyValueFactory<>("SO2"));
                // 创建CO列
                TableColumn<Data, String> coColumn = new TableColumn<>("CO");
                coColumn.setCellValueFactory(new PropertyValueFactory<>("CO"));
                // 创建PM列
                TableColumn<Data, String> pmColumn = new TableColumn<>("PM");
                pmColumn.setCellValueFactory(new PropertyValueFactory<>("PM"));
                // 添加列到表格
                tableView.getColumns().addAll(so2Column, coColumn, pmColumn);

                // 添加数据到表格
                tableView.getItems().addAll(dataMap.values());

                // 创建对话框
                Dialog<Void> dialog = new Dialog<>();
                dialog.setTitle("已提交数据");
                dialog.getDialogPane().setContent(tableView);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

                // 显示对话框
                dialog.showAndWait();

            } catch (Exception e) {
                e.printStackTrace(); // 开发阶段打印堆栈信息
                AlertUtil.showDialog("错误", "查看数据失败: " + e.getMessage());
            }
        }


}
