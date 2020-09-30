package com.example.weatherapp.data.model.air;

import androidx.room.Embedded;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class DataEntity {

    @SerializedName("name")
    @Expose
    private String nameData;
    @SerializedName("lat")
    @Expose
    private String latAir;
    @SerializedName("lng")
    @Expose
    private String lngAir;
    @SerializedName("aqi")
    @Expose
    private Integer aqi;
    @Embedded
    @SerializedName("detail_density")
    @Expose
    private DetailDensityEntity detailDensityEntity;
    @Embedded
    @SerializedName("detail_aqi")
    @Expose
    private DetailAqiEntity detailAqiEntity;
    @SerializedName("update_time")
    @Expose
    private String updateTime;

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData = nameData;
    }

    public String getLatAir() {
        return latAir;
    }

    public void setLatAir(String latAir) {
        this.latAir = latAir;
    }

    public String getLngAir() {
        return lngAir;
    }

    public void setLngAir(String lngAir) {
        this.lngAir = lngAir;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public DetailDensityEntity getDetailDensityEntity() {
        return detailDensityEntity;
    }

    public void setDetailDensityEntity(DetailDensityEntity detailDensityEntity) {
        this.detailDensityEntity = detailDensityEntity;
    }

    public DetailAqiEntity getDetailAqiEntity() {
        return detailAqiEntity;
    }

    public void setDetailAqiEntity(DetailAqiEntity detailAqiEntity) {
        this.detailAqiEntity = detailAqiEntity;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}