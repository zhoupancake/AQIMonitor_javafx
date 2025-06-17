package com.neu.aqimonitor_admin.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.neu.aqimonitor_admin.entity.character.Administrator;
import com.neu.aqimonitor_admin.entity.character.GridDetector;
import com.neu.aqimonitor_admin.entity.data.AirData;
import com.neu.aqimonitor_admin.entity.data.City;
import com.neu.aqimonitor_admin.entity.data.Report;
import com.neu.aqimonitor_admin.entity.data.Task;

public class IOUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()) // 支持LocalDateTime
            .disable(SerializationFeature.INDENT_OUTPUT); // 美化输出
    
    public static Map<String, Administrator> loadAdmin() throws IOException {
        String adminUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.ADMIN_PATH)).toString().replace("file:/", "");
        System.out.println(adminUrl);
        return readJsonFileToMap(adminUrl, String.class, Administrator.class);
    }

    public static Map<String, GridDetector> loadGrid() throws IOException {
        String gridUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.GRID_PATH)).toString().replace("file:/", "");
        return readJsonFileToMap(gridUrl, String.class, GridDetector.class);
    }

    public static Map<String, AirData> loadAirData() throws IOException {
        String airDataUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.AIR_DATA_PATH)).toString().replace("file:/", "");
        return readJsonFileToMap(airDataUrl, String.class, AirData.class);
    }

    public static Map<String, City> loadCity() throws IOException {
        String cityUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.CITY_PATH)).toString().replace("file:/", "");
        return readJsonFileToMap(cityUrl, String.class, City.class);
    }

    public static Map<String, Task> loadTask() throws IOException {
        String taskUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.TASK_PATH)).toString().replace("file:/", "");
        return readJsonFileToMap(taskUrl, String.class, Task.class);
    }

    public static Map<String, Report> loadReport() throws IOException {
        String reportUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.REPORT_PATH)).toString().replace("file:/", "");
        return readJsonFileToMap(reportUrl, String.class, Report.class);
    }

    public static void writeAdmin() throws IOException {
        String adminUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.ADMIN_PATH)).toString().replace("file:/", "");
        writeMapToJson(adminUrl, loadAdmin());
    }

    public static void writeGrid(Map<String, GridDetector> grids) throws IOException {
        String gridUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.GRID_PATH)).toString().replace("file:/", "");
        writeMapToJson(gridUrl, grids);
    }

    public static void writeAirData(Map<String, AirData> airDatas) throws IOException {
        String airDataUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.AIR_DATA_PATH)).toString().replace("file:/", "");
        writeMapToJson(airDataUrl, airDatas);
    }

    public static void writeCity(Map<String,  City>  cities) throws IOException {
        String cityUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.CITY_PATH)).toString().replace("file:/", "");
        writeMapToJson(cityUrl, cities);
    }

    public static void writeTask(Map<String,  Task> tasks) throws IOException {
        String taskUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.TASK_PATH)).toString().replace("file:/", "");
        writeMapToJson(taskUrl, tasks);
    }

    public static void writeReport(Map<String, Report>  reports) throws IOException {
        String reportUrl = Objects.requireNonNull(IOUtil.class.getResource(PathUtil.REPORT_PATH)).toString().replace("file:/", "");
        writeMapToJson(reportUrl, reports);
    }

    public static <K, V> void writeMapToJson(String filePath, Map<K, V> map) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), map);
    }

    public static <K, V> Map<K, V> readJsonFileToMap(String filePath, Class<K> keyType, Class<V> valueType) throws IOException {
        try {
            File file = new File(filePath);

            // 情况1：文件不存在
            if (!file.exists()) {
                System.out.println("File not found: {}" + filePath);
                return new HashMap<>();
            }

            // 情况2：文件为空
            if (file.length() == 0) {
                System.out.println("Empty file: {}" + filePath);
                return new HashMap<>();
            }

            // 正常读取
            return objectMapper.readValue(file, new TypeReference<>() {});

        } catch (IOException e) {
            System.out.println("Failed to read JSON file: {}" + filePath);
            return Collections.emptyMap(); // 或抛出自定义运行时异常
        }
    }
}
