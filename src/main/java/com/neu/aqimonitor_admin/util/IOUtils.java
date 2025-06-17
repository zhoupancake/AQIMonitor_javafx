package com.neu.aqimonitor_admin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.entity.character.GridDetector;
import com.neu.aqimonitor_admin.entity.data.AirData;
import com.neu.aqimonitor_admin.entity.data.City;
import com.neu.aqimonitor_admin.entity.data.Report;
import com.neu.aqimonitor_admin.entity.data.Task;

public class IOUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()) // 支持LocalDateTime
            .disable(SerializationFeature.INDENT_OUTPUT); // 美化输出

    private static final String ADMIN_PATH = "com/neu/aqimonitor/data/admin.json";
    private static final String GRID_PATH = "com/neu/aqimonitor/data/grid.json";
    private static final String AIR_DATA_PATH = "com/neu/aqimonitor/data/airData.json";
    private static final String CITY_PATH = "com/neu/aqimonitor/data/city.json";
    private static final String TASK_PATH = "com/neu/aqimonitor/data/task.json";
    private static final String REPORT_PATH = "com/neu/aqimonitor/data/report.json";

    public static Map<String, Administrator> loadAdmin(){
        URL adminUrl = IOUtils.class.getResource(ADMIN_PATH);
        assert adminUrl != null;
        return safeReadMapFromJson(
                new File(adminUrl.toString()),
                Administrator.class,
                Administrator::getId
        );
    }

    public static Map<String, GridDetector> loadGrid(){
        URL gridUrl = IOUtils.class.getResource(GRID_PATH);
        assert gridUrl != null;
        return safeReadMapFromJson(
                new File(gridUrl.toString()),
                GridDetector.class,
                GridDetector::getId
        );
    }

    public static Map<String, AirData> loadAirData(){
        URL airDataUrl = IOUtils.class.getResource(AIR_DATA_PATH);
        assert airDataUrl != null;
        return safeReadMapFromJson(
                new File(airDataUrl.toString()),
                AirData.class,
                AirData::getId
        );
    }

    public static Map<String, City> loadCity(){
        URL cityUrl = IOUtils.class.getResource(CITY_PATH);
        assert cityUrl != null;
        return safeReadMapFromJson(
                new File(cityUrl.toString()),
                City.class,
                City::getId
        );
    }

    public static Map<String, Task> loadTask(){
        URL taskUrl = IOUtils.class.getResource(TASK_PATH);
        assert taskUrl != null;
        return safeReadMapFromJson(
                new File(taskUrl.toString()),
                Task.class,
                Task::getId
        );
    }

    public static Map<String, Report> loadReport(){
        URL reportUrl = IOUtils.class.getResource(REPORT_PATH);
        assert reportUrl != null;
        return safeReadMapFromJson(
                new File(reportUrl.toString()),
                Report.class,
                Report::getId
        );
    }

    public static void writeAdmin() throws IOException {
        URL adminUrl = IOUtils.class.getResource(ADMIN_PATH);
        assert adminUrl != null;
        writeMapToJson(new File(adminUrl.toString()), loadAdmin());
    }

    public static void writeGrid(Map<String, GridDetector> grids) throws IOException {
        URL gridUrl = IOUtils.class.getResource(GRID_PATH);
        assert gridUrl != null;
        writeMapToJson(new File(gridUrl.toString()), grids);
    }

    public static void writeAirData(Map<String, AirData> airDatas) throws IOException {
        URL airDataUrl = IOUtils.class.getResource(AIR_DATA_PATH);
        assert airDataUrl != null;
        writeMapToJson(new File(airDataUrl.toString()), airDatas);
    }

    public static void writeCity(Map<String,  City>  cities) throws IOException {
        URL cityUrl = IOUtils.class.getResource(CITY_PATH);
        assert cityUrl != null;
        writeMapToJson(new File(cityUrl.toString()), cities);
    }

    public static void writeTask(Map<String,  Task> tasks) throws IOException {
        URL taskUrl = IOUtils.class.getResource(TASK_PATH);
        assert taskUrl != null;
        writeMapToJson(new File(taskUrl.toString()), tasks);
    }

    public static void writeReport(Map<String, Report>  reports) throws IOException {
        URL reportUrl = IOUtils.class.getResource(REPORT_PATH);
        assert reportUrl != null;
        writeMapToJson(new File(reportUrl.toString()), reports);
    }

    public static <T> void writeMapToJson(File file, Map<String, T> dataMap) throws IOException {
        List<T> dataList = new ArrayList<>(dataMap.values());
        objectMapper.writeValue(file, dataList);
    }

    public static <T> Map<String, T> readMapFromJson(
            File file,
            Class<T> valueType,
            Function<T, String> idGetter) throws IOException {

        if (!file.exists() || file.length() == 0) {
            return new LinkedHashMap<>();
        }

        List<T> dataList = objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, valueType)
        );

        return dataList.stream()
                .collect(Collectors.toMap(
                        idGetter,
                        data -> data,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));
    }

    public static <T> Map<String, T> safeReadMapFromJson(
            File file,
            Class<T> valueType,
            Function<T, String> idGetter) {

        try {
            return readMapFromJson(file, valueType, idGetter);
        } catch (IOException e) {
            return new LinkedHashMap<>();
        }
    }
}
