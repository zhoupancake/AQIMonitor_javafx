package com.neu.aqimonitor;

import com.neu.aqimonitor.util.AlertUtil;
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


    public void queryData() throws IOException {
            pageJump(btn_query, PathUtil.SUPERVISOR_QUERY_PATH);


    }

    private void setDialog(Stage dialog) {
    }


    private Map<String, List<String>> provinceMap = new HashMap<>();
    private Map<String,List<String>> AQIMap = new HashMap<>();

    @FXML
    public void initialize(){
        provinceMap.put("辽宁省",List.of("沈阳市","大连市","鞍山市","抚顺市","本溪市"));
        provinceMap.put("四川省",List.of("成都市","自贡市","攀枝花市","绵阳市","乐山市"));
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

    public void submitData(){
        String province = cmbProvince.getValue();
        String country = cmbCountry.getValue();
        String AQI = cmbAQI.getValue();
        String specificAddress = txtSpecificAddress.getText();
        String feedback = txtFeedback.getText();
        String gridName = null;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = now.format(formatter);
        Information info = new Information(province,country,specificAddress,AQI,feedback,time,gridName);
        Map<String, Information> infoMap = FileUtil.readMapObject(PathUtil.INFORMATION_PATH);
        //根据具体地址填入
        infoMap.put(info.getAddress(), info);
        FileUtil.writeObject(PathUtil.INFORMATION_PATH,infoMap);
        AlertUtil.showDialog("提交AQI数据","数据提交成功" );
    }
}
