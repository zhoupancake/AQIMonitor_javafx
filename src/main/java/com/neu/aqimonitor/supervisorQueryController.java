package com.neu.aqimonitor;

//需求未知

import com.neu.aqimonitor.util.FileUtil;
import com.neu.aqimonitor.entity.data.Information;
import com.neu.aqimonitor.util.PathUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.util.HashMap;
import java.util.Map;

import static com.neu.aqimonitor.util.Back.pageJump;

public class supervisorQueryController {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Information,String> colProvince,colCountry,colAddress,colAQI,colTime;

    @FXML
    private Button btn_back;

    private ObservableList tableList = FXCollections.observableArrayList();
    private Map infoMap = new HashMap();
    //初始化方法
    @FXML
    public void initialize(){
        tableView.setItems(tableList);

        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAQI.setCellValueFactory(new PropertyValueFactory<>("AQI"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        //从文件中读取所有对象数据
        infoMap = FileUtil.readMapObject(PathUtil.INFORMATION_PATH);
        tableList.addAll(infoMap.values());

        //设置表格为可编辑表格
        tableView.setEditable(true);
        //设置允许编辑的单元格类型
        colAQI.setCellFactory(TextFieldTableCell.forTableColumn());
        //处理点击单元格之后的事件
        colAQI.setOnEditCommit(event->{
            Information info = event.getRowValue();
            String newAQI = event.getNewValue();
            //更新数据到文件里
            info.setAQI(newAQI);
            infoMap.put(info.getAddress(),info);
            FileUtil.writeObject(PathUtil.INFORMATION_PATH,infoMap);
        });

    }


    public void backToSubmit(){
        pageJump(btn_back,PathUtil.PUBLIC_SUPERVISOR_PATH);

    }

}
