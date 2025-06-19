package com.neu.aqimonitor;

import com.neu.aqimonitor.util.Jump;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminMenuViewController {
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;

    @FXML
    private void initialize() {

    }

    @FXML
    public void jumpToPublicSupervision() {
        Jump.jumpToPage(b1, PathUtil.PUBLIC_SUPERVISION_PATH);
    }

    @FXML
    public void jumpToConfirmAQIList() {
        Jump.jumpToPage(b2, PathUtil.CONFIRM_AQI_LIST_VIEW_PATH);
    }

    @FXML
    public void jumpToProvincialGroupView() {
        Jump.jumpToPage(b3, PathUtil.PROVINCIAL_GROUP_VIEW_PATH);
    }
}
