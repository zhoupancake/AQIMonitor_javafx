package com.neu.aqimonitor.util;

import com.neu.aqimonitor.entity.character.Administrator;
import com.neu.aqimonitor.entity.character.GridDetector;
import com.neu.aqimonitor.entity.character.Supervisor;
import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.entity.data.City;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.entity.data.Task;

import java.io.IOException;
import java.util.Map;

public class DataUtil {
    public static Map<String, Administrator> administratorMap;
    public static Map<String, GridDetector> gridDetectorMap;
    public static Map<String, Supervisor> supervisorMap;
    public static Map<String, AirData> airDataMap;
    public static Map<String, Report> reportMap;
    public static Map<String, Task> taskMap;
    public static Map<String, City> cityMap;

    public static Administrator administrator;
        
    public static void init() throws IOException {
        administratorMap = IOUtil.loadAdmin();
        gridDetectorMap = IOUtil.loadGrid();
        supervisorMap = IOUtil.loadSuper();
        airDataMap = IOUtil.loadAirData();
        reportMap = IOUtil.loadReport();
        taskMap = IOUtil.loadTask();
        cityMap = IOUtil.loadCity();
    }
    
    public static void write() throws IOException {
        IOUtil.writeAdmin(administratorMap);
        IOUtil.writeGrid(gridDetectorMap);
        IOUtil.writeSuper(supervisorMap);
        IOUtil.writeAirData(airDataMap);
        IOUtil.writeCity(cityMap);
        IOUtil.writeTask(taskMap);
        IOUtil.writeReport(reportMap);
    }
}
