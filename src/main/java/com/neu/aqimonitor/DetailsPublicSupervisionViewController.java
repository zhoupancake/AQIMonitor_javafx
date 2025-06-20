package com.neu.aqimonitor;

import com.neu.aqimonitor.dto.SupervisionDetail;
import com.neu.aqimonitor.util.Back;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class DetailsPublicSupervisionViewController {
    private SupervisionDetail supervisionDetail;

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
    public void initialize() {

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
}
