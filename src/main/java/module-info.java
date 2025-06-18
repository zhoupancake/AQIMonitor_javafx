module com.neu.aqimonitor_admin {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    exports com.neu.aqimonitor.entity.character to com.fasterxml.jackson.databind;
    exports com.neu.aqimonitor.entity.data to com.fasterxml.jackson.databind;
    opens com.neu.aqimonitor to javafx.fxml;
    exports com.neu.aqimonitor;
}