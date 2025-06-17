module com.neu.aqimonitor {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.neu.aqimonitor.controller to javafx.fxml;
    opens com.neu.aqimonitor to javafx.graphics;
    exports com.neu.aqimonitor.controller;
}