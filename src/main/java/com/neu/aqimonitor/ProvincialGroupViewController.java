package com.neu.aqimonitor;

import com.neu.aqimonitor.controller.logicController.AdminController;
import com.neu.aqimonitor.dto.ProvincialGroupProperty;
import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.PathUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;
import java.util.Map;

public class ProvincialGroupViewController {
    @FXML
    private Button btn_back;
    @FXML
    private TableView<ProvincialGroupProperty> provincialGroupView;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> cityIdColumn;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> cityNameColumn;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> so2Column;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> coColumn;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> pm25Column;
    @FXML
    private TableColumn<ProvincialGroupProperty, String> aqiColumn;

    private ObservableList<ProvincialGroupProperty> provincialGroupPropertyList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        Map<String, List<AirData>> AirDataByProvince = AdminController.getAirDataByProvince();
        for (String provinceName : AirDataByProvince.keySet()) {
            List<AirData> list = AirDataByProvince.get(provinceName);
            double so2 = 0;
            double co = 0;
            double pm25 = 0;
            double aqi = 0;
            for (AirData airData : list) {
                so2 += airData.getSo2();
                co += airData.getCo();
                pm25 += airData.getPm25();
                aqi += airData.getAqi();
            }
            provincialGroupPropertyList.add(new ProvincialGroupProperty("",
                    provinceName,
                    Double.toString(so2),
                    Double.toString(co),
                    Double.toString(pm25),
                    Double.toString(aqi)));
        }

        this.provincialGroupView.setItems(provincialGroupPropertyList);

        cityIdColumn.setCellValueFactory(cellData -> cellData.getValue().provinceIdProperty());
        cityNameColumn.setCellValueFactory(cellData -> cellData.getValue().provinceNameProperty());
        so2Column.setCellValueFactory(cellData -> cellData.getValue().so2Property());
        coColumn.setCellValueFactory(cellData -> cellData.getValue().coProperty());
        pm25Column.setCellValueFactory(cellData -> cellData.getValue().pm25Property());
        aqiColumn.setCellValueFactory(cellData -> cellData.getValue().aqiProperty());
    }

    @FXML
    public void handleBack() {
        Back.pageJump(btn_back, PathUtil.ADMIN_MENU_VIEW_PATH);
    }
}
