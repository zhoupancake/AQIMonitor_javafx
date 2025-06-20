package com.neu.aqimonitor;

//需求未知

import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.data.Data;
import com.neu.aqimonitor.entity.data.Information;
import com.neu.aqimonitor.util.PathUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Map;

import static com.neu.aqimonitor.util.Back.pageJump;

public class SubmitDataController {
    @FXML
    private TextField txt_SO2;
    @FXML
    private TextField txt_CO;
    @FXML
    private TextField txt_PM;
    @FXML
    private Button btn_backToTasks;

    public void SubmitDate(){
        String SO2 = txt_SO2.getText();
        String CO = txt_CO.getText();
        String PM = txt_PM.getText();
        Data d1 = new Data(SO2,CO,PM);
        Map<String, Data> dataMap = FileUtil.readMapObject(PathUtil.DATA_PATH);
        dataMap.put(d1.getSO2(), d1);
        FileUtil.writeObject(PathUtil.DATA_PATH,dataMap);
        AlertUtil.showDialog("提交数据","提交成功");
    }

    public void backToTasks() throws IOException {
        pageJump(btn_backToTasks, PathUtil.VIEW_THE_TASKS_PATH);
    }

    public void setData(Information selectedData) {
    }
}

