package com.example.weatherapp.data.model.air;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class DetailAqiEntity {

    @SerializedName("pm25")
    @Expose
    private String particulateBigAqi;
    @SerializedName("pm10")
    @Expose
    private String particulateSmallAqi;
    @SerializedName("co")
    @Expose
    private String coAqi;
    @SerializedName("so2")
    @Expose
    private String sulfurDioxideAqi;
    @SerializedName("o3")
    @Expose
    private String ozoneAqi;
    @SerializedName("no2")
    @Expose
    private String nitrogenDioxideAqi;

    public String getParticulateBigAqi() {
        return particulateBigAqi;
    }

    public void setParticulateBigAqi(String particulateBigAqi) {
        this.particulateBigAqi = particulateBigAqi;
    }

    public String getParticulateSmallAqi() {
        return particulateSmallAqi;
    }

    public void setParticulateSmallAqi(String particulateSmallAqi) {
        this.particulateSmallAqi = particulateSmallAqi;
    }

    public String getCoAqi() {
        return coAqi;
    }

    public void setCoAqi(String coAqi) {
        this.coAqi = coAqi;
    }

    public String getSulfurDioxideAqi() {
        return sulfurDioxideAqi;
    }

    public void setSulfurDioxideAqi(String sulfurDioxideAqi) {
        this.sulfurDioxideAqi = sulfurDioxideAqi;
    }

    public String getOzoneAqi() {
        return ozoneAqi;
    }

    public void setOzoneAqi(String ozoneAqi) {
        this.ozoneAqi = ozoneAqi;
    }

    public String getNitrogenDioxideAqi() {
        return nitrogenDioxideAqi;
    }

    public void setNitrogenDioxideAqi(String nitrogenDioxideAqi) {
        this.nitrogenDioxideAqi = nitrogenDioxideAqi;
    }
}