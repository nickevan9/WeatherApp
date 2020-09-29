package com.example.weatherapp.data.model.air;

import androidx.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirEntity {

    @SerializedName("status")
    @Expose
    private String status;

    @Embedded
    @SerializedName("data")
    @Expose
    private DataEntity dataEntity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataEntity getDataEntity() {
        return dataEntity;
    }

    public void setDataEntity(DataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

}