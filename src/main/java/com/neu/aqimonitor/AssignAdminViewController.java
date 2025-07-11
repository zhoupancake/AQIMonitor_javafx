package com.neu.aqimonitor;

import com.neu.aqimonitor.controller.logicController.AdminController;
import com.neu.aqimonitor.controller.logicController.UserController;
import com.neu.aqimonitor.dto.SupervisionDetail;
import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.PathUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.HashMap;
import java.util.Map;

public class AssignAdminViewController {
    @FXML
    private Button btn_back;
    @FXML
    private Label label_id;
    @FXML
    private Label label_info;
    @FXML
    private Label label_phone;
    @FXML
    private Label label_address;
    @FXML
    private Label label_des;
    @FXML
    private Label label_level;
    @FXML
    private Label label_datetime;
    @FXML
    private ComboBox grid_deBox;
    @FXML
    private Button btn_assign;

    private SupervisionDetail supervisionDetail;
    private ObservableList<String> grid_deList = FXCollections.observableArrayList();
    public Map<String, GridDetector> gridDetectorMapByName = new HashMap<>();

    @FXML
    public void initialize() {
        for(GridDetector detector:DataUtil.gridDetectorMap.values()) {
            grid_deList.add(detector.getRealName());
            gridDetectorMapByName.put(detector.getRealName(), detector);
        }
        grid_deBox.setItems(grid_deList);
    }

    @FXML
    public void handleBack() {
        Back.pageJump(btn_back, PathUtil.PUBLIC_SUPERVISION_PATH);
    }

    public void setSupervisionDetail(SupervisionDetail supervisionDetail) {
        this.supervisionDetail = supervisionDetail;
        label_id.setText(supervisionDetail.getId());
        label_info.setText(supervisionDetail.getName());
        label_phone.setText(supervisionDetail.getPhoneNumber());
        label_address.setText(supervisionDetail.getAddress());
        label_des.setText(supervisionDetail.getDes());
        label_level.setText(supervisionDetail.getLevel());
        label_datetime.setText(supervisionDetail.getDatetime());
    }

    @FXML
    public void handleAssign() {
        if (grid_deBox.getValue() == null || grid_deBox.getValue() == "") {
            AlertUtil.showErrorDialog("错误", "请选择网格员");
        } else {
            AdminController adminController = new AdminController(DataUtil.administrator);
            String grid_deName = (String) grid_deBox.getValue();
            adminController.appoint(gridDetectorMapByName.get(grid_deName).getId(), supervisionDetail.getId());
        }
    }
}
