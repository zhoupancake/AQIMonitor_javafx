package com.neu.aqimonitor.controller.logicController;

import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.entity.character.Supervisor;
import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.entity.data.City;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.entity.data.Task;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Report> getAllReports(){
        Map<String, Report> reportMap =  DataUtil.reportMap;
        return reportMap.values().stream().toList();
    }

    public static Map<String, Map<Integer,  Long>> groupByProvinceAndCountAqiLevel() {
        // 1. 按省份分组
        Map<String, List<AirData>> provinceGroup = DataUtil.airDataMap.values().stream()
                .filter(airData -> DataUtil.cityMap.containsKey(String.valueOf(airData.getCityId()))) // 过滤无效cityId
                .collect(Collectors.groupingBy(
                        airData -> {
                            City city = DataUtil.cityMap.get(String.valueOf(airData.getCityId()));
                            return city.getProvince(); // 按省份分组
                        }
                ));

        // 2. 统计每个省份的AQI等级分布
        Map<String, Map<Integer, Long>> result = new HashMap<>();
        provinceGroup.forEach((province, airDataList) -> {
            Map<Integer, Long> aqiLevelCount = airDataList.stream()
                    .collect(Collectors.groupingBy(
                            AirData::getAqiLevel,
                            Collectors.counting() // 统计每个AQI等级的数量
                    ));
            result.put(province, aqiLevelCount);
        });

        return result;
    }

    public static double getCoverageRate() {
        double occupied = DataUtil.supervisorMap.values().stream()
                .map(Supervisor::getCityId)      // 提取cityId
                .collect(Collectors.toSet())     // 自动去重
                .size();                         // 返回唯一数量
        return occupied / DataUtil.cityMap.size();
    }
}
