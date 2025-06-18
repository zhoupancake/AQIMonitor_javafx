package com.neu.aqimonitor;

import javafx.fxml.FXML;

public class PublicSupervisionViewController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    public void backToAdminMenu() {
        mainApp.showAdminMenuView();
    }
}
