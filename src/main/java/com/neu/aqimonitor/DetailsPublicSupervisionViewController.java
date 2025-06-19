package com.neu.aqimonitor;

import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DetailsPublicSupervisionViewController {
    @FXML
    private Button btn_back;

    @FXML
    public void initialize() {

    }

    @FXML
    public void handleBack() {
        Back.pageJump(btn_back, PathUtil.PUBLIC_SUPERVISION_PATH);
    }
}
