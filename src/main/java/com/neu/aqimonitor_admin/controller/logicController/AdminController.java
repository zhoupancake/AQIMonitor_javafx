package com.neu.aqimonitor_admin.controller.logicController;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.entity.character.GridDetector;
import com.neu.aqimonitor_admin.entity.data.AirData;
import com.neu.aqimonitor_admin.entity.data.Report;
import com.neu.aqimonitor_admin.entity.data.Task;
import com.neu.aqimonitor_admin.util.AlertUtils;

import java.util.Map;

public class AdminController {
    private final Administrator administrator;
    private final Map<String, Report> reports;
    private final Map<String, GridDetector> gridDetectors;
    private Map<String, Task> tasks;
    public AdminController(Administrator administrator, Map<String, GridDetector> gridDetectors,
                           Map<String, Task> tasks, Map<String, Report>  reports){
        this.administrator = administrator;
        this.gridDetectors = gridDetectors;
        this.tasks = tasks;
        this.reports = reports;
    }

    public void appoint(String appointeeId, String relatedReportId){
        GridDetector gridDetector = this.gridDetectors.get(appointeeId);
        Report report = this.reports.get(relatedReportId);
        if(gridDetector == null)
            AlertUtils.showErrorDialog("错误", "不存在该网格员");
        if(report == null)
            AlertUtils.showErrorDialog("错误", "不存在该公众监督员报告");
        Task task = new Task(administrator.getId(), appointeeId, relatedReportId);
        this.tasks.put(task.getId(), task);
        AlertUtils.showDialog("提示", "添加成功");
    }



}
