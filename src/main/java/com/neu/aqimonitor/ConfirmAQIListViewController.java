package com.neu.aqimonitor;

import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConfirmAQIListViewController {
    @FXML
    private Button btn_back;

    @FXML
    public void initialize() {

    }

    @FXML
    private void handleBack() {
        Back.pageJump(btn_back, PathUtil.ADMIN_MENU_VIEW_PATH);
    }
}
