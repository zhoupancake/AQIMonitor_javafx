package com.neu.aqimonitor;

import com.neu.aqimonitor.dto.ReportProperty;
import com.neu.aqimonitor.dto.SupervisionDetail;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.Jump;
import com.neu.aqimonitor.util.PathUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PublicSupervisionViewController {
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_detail;
    @FXML
    private Button btn_assign;
    @FXML
    private TableView<ReportProperty> reportTable;
    @FXML
    private TableColumn<ReportProperty, String> idColumn;
    @FXML
    private TableColumn<ReportProperty, String> nameColumn;
    @FXML
    private TableColumn<ReportProperty, String> provinceColumn;
    @FXML
    private TableColumn<ReportProperty, String> cityColumn;
    @FXML
    private TableColumn<ReportProperty, String> forecastAqiLevelColumn;
    @FXML
    private TableColumn<ReportProperty, String> dateColumn;
    @FXML
    private TableColumn<ReportProperty, String> timeColumn;

    private ObservableList<ReportProperty> reports = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        for (Report report : DataUtil.reportMap.values()) {
            reports.add(new ReportProperty(report));
        }

        reportTable.setItems(reports);

        idColumn.setCellValueFactory(a -> a.getValue().getIdProperty());
        nameColumn.setCellValueFactory(a -> a.getValue().getNameProperty());
        provinceColumn.setCellValueFactory(a -> a.getValue().getProvinceProperty());
        cityColumn.setCellValueFactory(a -> a.getValue().getCityProperty());
        forecastAqiLevelColumn.setCellValueFactory(a -> a.getValue().getForecastAqiLevelProperty());
        dateColumn.setCellValueFactory(a -> a.getValue().getDateProperty());
        timeColumn.setCellValueFactory(a -> a.getValue().getTimeProperty());
    }

    @FXML
    private void handleBack() {
        Back.pageJump(btn_back, PathUtil.ADMIN_MENU_VIEW_PATH);
    }

    @FXML
    private void handleDetail() throws IOException {
        Stage stage = (Stage) btn_detail.getScene().getWindow();
//        Jump.jumpToPage(btn_detail, PathUtil.DETAILS_PUBLIC_SUPERVISION_VIEW_PATH);
        FXMLLoader loader = new FXMLLoader();
        URL url = PublicSupervisionViewController.class.getResource(PathUtil.DETAILS_PUBLIC_SUPERVISION_VIEW_PATH);
        loader.setLocation(url);
        Parent root = loader.load();
        Scene scene = btn_detail.getScene();
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();

        DetailsPublicSupervisionViewController controller = loader.getController();
        ReportProperty reportProperty = reportTable.getSelectionModel().selectedItemProperty().getValue();
        controller.setSupervisionDetail(new SupervisionDetail(reportProperty.getId(),
                reportProperty.getName(),
                DataUtil.supervisorMap.get(reportProperty.getSubmitterId()).getPhoneNumber(),
                reportProperty.getCity(),
                reportProperty.getDescription(),
                reportProperty.getForecastAqiLevelString(),
                reportProperty.getCreatedTime().toString()));

    }

    @FXML
    private void handleAssign() {
        Jump.jumpToPage(btn_assign, PathUtil.ASSIGN_ADMIN_VIEW_PATH);
    }
}
