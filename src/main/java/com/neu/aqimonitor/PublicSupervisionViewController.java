package com.neu.aqimonitor;

import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.Jump;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class PublicSupervisionViewController {
    @FXML
    private Button btn_back;

    @FXML
    private Button btn_detail;

    @FXML
    private Button btn_assign;


    @FXML
    private void initialize() {

    }

    @FXML
    private void handleBack() {
        Back.pageJump(btn_back, PathUtil.ADMIN_MENU_VIEW_PATH);
    }

    @FXML
    private void handleDetail() {
        Jump.jumpToPage(btn_detail, PathUtil.DETAILS_PUBLIC_SUPERVISION_VIEW_PATH);
    }

    @FXML
    private void handleAssign() {
        Jump.jumpToPage(btn_assign, PathUtil.ASSIGN_ADMIN_VIEW_PATH);
    }
}
