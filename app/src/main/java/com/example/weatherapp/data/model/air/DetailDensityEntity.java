package com.example.weatherapp.data.model.air;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailDensityEntity {

    @SerializedName("pm25")
    @Expose
    private String pm25;
    @SerializedName("pm10")
    @Expose
    private String pm10;
    @SerializedName("co")
    @Expose
    private String co;
    @SerializedName("so2")
    @Expose
    private String so2;
    @SerializedName("o3")
    @Expose
    private String o3;
    @SerializedName("no2")
    @Expose
    private String no2;

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

}
