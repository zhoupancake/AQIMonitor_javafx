package com.neu.aqimonitor_admin.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
        try {
            File file = new File(filePath);

            // 配置ObjectMapper以美化输出
            ObjectWriter writer = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .with(SerializationFeature.INDENT_OUTPUT);

            // 写入文件
            writer.writeValue(file, map);

        } catch (IOException e) {
            System.err.println("Failed to write JSON file: " + filePath);
            throw e; // 可以选择重新抛出或处理异常
        }
    }

    public static <K, V> Map<K, V> readJsonFileToMap(String filePath, Class<K> keyType, Class<V> valueType) throws IOException {
        try {
            File file = new File(filePath);

            // 检查文件是否存在
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return new HashMap<>();
            }

            // 检查文件是否为空
            if (file.length() == 0) {
                System.out.println("Empty file: " + filePath);
                return new HashMap<>();
            }

            // 创建类型工厂构造具体的Map类型
            JavaType mapType = objectMapper.getTypeFactory()
                    .constructMapType(HashMap.class, keyType, valueType);

            // 读取并转换JSON
            return objectMapper.readValue(file, mapType);

        } catch (IOException e) {
            System.out.println("Failed to read JSON file: " + filePath);
            throw e; // 重新抛出异常或返回空Map，根据业务需求决定
        }
    }
}
