package com.example.weatherapp.data.model.air;

import androidx.room.Embedded;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class AirEntity {

    @SerializedName("status")
    @Expose
    private String statusAir;

    @Embedded
    @SerializedName("data")
    @Expose
    private DataEntity dataEntity;

    public String getStatusAir() {
        return statusAir;
    }

    public void setStatusAir(String statusAir) {
        this.statusAir = statusAir;
    }

    public DataEntity getDataEntity() {
        return dataEntity;
    }

    public void setDataEntity(DataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }
}