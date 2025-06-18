package com.neu.aqimonitor.entity.data;

import java.io.Serializable;

public class Data implements Serializable {
    private String SO2;
    private String CO;
    private String PM;

    public Data(String SO2, String CO, String PM) {
        this.SO2 = SO2;
        this.CO = CO;
        this.PM = PM;
    }

    public String getSO2() {
        return SO2;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getPM() {
        return PM;
    }

    public void setPM(String PM) {
        this.PM = PM;
    }
}
