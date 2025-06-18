package com.neu.aqimonitor;

import javafx.fxml.FXML;

public class AdminMenuViewController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    public void jumpToPublicSupervision() {
        mainApp.showPublicSupervisionView();
    }

    public void jumpToConfirmAQIList() {
        mainApp.showConfirmAQIListView();
    }
}
