package com.example.weatherapp.data.model.air;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class DetailDensityEntity {

    @SerializedName("pm25")
    @Expose
    private String particulateBig;
    @SerializedName("pm10")
    @Expose
    private String particulateSmall;
    @SerializedName("co")
    @Expose
    private String co;
    @SerializedName("so2")
    @Expose
    private String sulfurDioxide;
    @SerializedName("o3")
    @Expose
    private String ozone;
    @SerializedName("no2")
    @Expose
    private String nitrogenDioxide;

    public String getParticulateBig() {
        return particulateBig;
    }

    public void setParticulateBig(String particulateBig) {
        this.particulateBig = particulateBig;
    }

    public String getParticulateSmall() {
        return particulateSmall;
    }

    public void setParticulateSmall(String particulateSmall) {
        this.particulateSmall = particulateSmall;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getSulfurDioxide() {
        return sulfurDioxide;
    }

    public void setSulfurDioxide(String sulfurDioxide) {
        this.sulfurDioxide = sulfurDioxide;
    }

    public String getOzone() {
        return ozone;
    }

    public void setOzone(String ozone) {
        this.ozone = ozone;
    }

    public String getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(String nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }
}
