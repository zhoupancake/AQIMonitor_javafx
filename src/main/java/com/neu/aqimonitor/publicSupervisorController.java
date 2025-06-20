package com.neu.aqimonitor;

import com.neu.aqimonitor.entity.data.AirData;
import com.neu.aqimonitor.entity.data.City;
import com.neu.aqimonitor.entity.data.Report;
import com.neu.aqimonitor.util.AlertUtil;
import com.neu.aqimonitor.util.DataUtil;
import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.data.Information;
import com.neu.aqimonitor.entity.character.User;
import com.neu.aqimonitor.util.PathUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import static com.neu.aqimonitor.util.Back.pageJump;

public class publicSupervisorController {
    @FXML
    private TextField txtSpecificAddress;
    @FXML
    private ComboBox<String> cmbProvince,cmbCountry,cmbAQI;
    @FXML
    private TextArea txtFeedback;
    @FXML
    private Button btn_query;

    private static final Map<String, Integer> AQI_LEVEL_MAP =
            Map.of("六级", 6, "五级", 5, "四级", 4, "三级", 3, "二级", 2, "一级", 1);


    public void queryData() throws IOException {
            pageJump(btn_query, PathUtil.SUPERVISOR_QUERY_PATH);


    }

    private void setDialog(Stage dialog) {
    }


    private final Map<String, List<String>> provinceMap = new HashMap<>();
    private final Map<String,List<String>> AQIMap = new HashMap<>();

    @FXML
    public void initialize(){
        Map<String, List<String>> cities = getCities();
        for(String key : cities.keySet())
            provinceMap.put(key,cities.get(key));
        cmbProvince.setItems(FXCollections.observableArrayList(provinceMap.keySet()));
        cmbProvince.getSelectionModel().clearSelection();
        cmbProvince.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                List<String> citys = provinceMap.getOrDefault(newValue,List.of());
                cmbCountry.setItems(FXCollections.observableArrayList(citys));
                cmbCountry.getSelectionModel().clearSelection();
            }
        });

        AQIMap.put("一级",List.of());
        AQIMap.put("二级",List.of());
        AQIMap.put("三级",List.of());
        AQIMap.put("四级",List.of());
        AQIMap.put("五级",List.of());
        AQIMap.put("六级",List.of());
        cmbAQI.setItems(FXCollections.observableArrayList(AQIMap.keySet()));
        cmbAQI.getSelectionModel().clearSelection();

    }

    private Map<String, List<String>> getCities() {
        Map<String, List<String>> provinceToCities = new HashMap<>();
        // 遍历所有城市
        for (City city : DataUtil.cityMap.values()) {
            String province = city.getProvince();
            String cityName = city.getName();

            // 如果省份不存在于map中，先创建空列表
            if (!provinceToCities.containsKey(province)) {
                provinceToCities.put(province, new ArrayList<>());
            }

            // 将城市名添加到对应省份的列表中
            provinceToCities.get(province).add(cityName);
        }
        return provinceToCities;
    }

    public void submitData(){
        String province = cmbProvince.getValue();
        String country = cmbCountry.getValue();
        String AQI = cmbAQI.getValue();
        String specificAddress = txtSpecificAddress.getText();
        String feedback = txtFeedback.getText();
        Report report = new Report("Super_13495981447", 0, feedback,
                Integer.valueOf(findCityId(province,country)), specificAddress, AQI_LEVEL_MAP.get(AQI));
        DataUtil.reportMap.put(report.getId(), report);
        AlertUtil.showDialog("提交AQI数据","数据提交成功" );
    }

    private static String findCityId(String province, String cityName) {
        return DataUtil.cityMap.entrySet().stream()
                .filter(entry -> {
                    City city = entry.getValue();
                    return city.getProvince().equals(province)
                            && city.getName().equals(cityName);
                })
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null); // 找不到时返回null
    }
}
