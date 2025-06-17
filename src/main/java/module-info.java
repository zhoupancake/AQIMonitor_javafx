module com.neu.aqimonitor {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.neu.aqimonitor to javafx.fxml;
    exports com.neu.aqimonitor;
}