package com.neu.aqimonitor_admin.controller.logicController;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.entity.character.GridDetector;
import com.neu.aqimonitor_admin.entity.data.Report;
import com.neu.aqimonitor_admin.entity.data.Task;
import com.neu.aqimonitor_admin.util.AlertUtil;
import com.neu.aqimonitor_admin.util.DataUtil;

import java.util.Map;

public class AdminController {
    private final Administrator administrator;

    public AdminController(Administrator administrator) {
        this.administrator = administrator;
    }
    public void appoint(String appointeeId, String relatedReportId){
        GridDetector gridDetector = DataUtil.gridDetectorMap.get(appointeeId);
        Report report = DataUtil.reportMap.get(relatedReportId);
        if(gridDetector == null)
            AlertUtil.showErrorDialog("错误", "不存在该网格员");
        if(report == null)
            AlertUtil.showErrorDialog("错误", "不存在该公众监督员报告");
        Task task = new Task(administrator.getId(), appointeeId, relatedReportId);
        DataUtil.taskMap.put(task.getId(), task);
        AlertUtil.showDialog("提示", "添加成功");
    }





}
