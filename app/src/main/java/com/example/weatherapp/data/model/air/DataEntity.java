package com.example.weatherapp.data.model.air;

import androidx.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataEntity {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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