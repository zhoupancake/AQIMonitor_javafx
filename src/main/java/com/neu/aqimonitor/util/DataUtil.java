package com.neu.aqimonitor.util;

import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.entity.data.City;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.entity.data.Task;

import java.io.IOException;
import java.util.Map;

public class DataUtil {
    public static Map<String, Administrator> administratorMap;
    public static Map<String, GridDetector> gridDetectorMap;
    public static Map<String, AirData> airDataMap;
    public static Map<String, Report> reportMap;
    public static Map<String, Task> taskMap;
    public static Map<String, City> cityMap;
        
    public static void init() throws IOException {
        administratorMap = IOUtil.loadAdmin();
        gridDetectorMap = IOUtil.loadGrid();
        airDataMap = IOUtil.loadAirData();
        reportMap = IOUtil.loadReport();
        taskMap = IOUtil.loadTask();
        cityMap = IOUtil.loadCity();
    }
    
    public static void write() throws IOException {
        IOUtil.writeAdmin();
        IOUtil.writeGrid(gridDetectorMap);
        IOUtil.writeAirData(airDataMap);
        IOUtil.writeCity(cityMap);
        IOUtil.writeTask(taskMap);
        IOUtil.writeReport(reportMap);
    }
}
