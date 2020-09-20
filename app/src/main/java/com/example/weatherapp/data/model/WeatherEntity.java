package com.example.weatherapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherEntity {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("d_id")
    @Expose
    private Integer dId;
    @SerializedName("warning")
    @Expose
    private WarningEntity warning;
    @SerializedName("cc")
    @Expose
    private CcEntity cc;
    @SerializedName("fch")
    @Expose
    private List<FchEntity> fch = null;
    @SerializedName("fcd")
    @Expose
    private List<FcdEntity> fcd = null;
    @SerializedName("loc")
    @Expose
    private LocEntity loc;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("update")
    @Expose
    private Double update;
    @SerializedName("extra")
    @Expose
    private ExtraEntity extra;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public WarningEntity getWarning() {
        return warning;
    }

    public void setWarning(WarningEntity warning) {
        this.warning = warning;
    }

    public CcEntity getCc() {
        return cc;
    }

    public void setCc(CcEntity cc) {
        this.cc = cc;
    }

    public List<FchEntity> getFch() {
        return fch;
    }

    public void setFch(List<FchEntity> fch) {
        this.fch = fch;
    }

    public List<FcdEntity> getFcd() {
        return fcd;
    }

    public void setFcd(List<FcdEntity> fcd) {
        this.fcd = fcd;
    }

    public LocEntity getLoc() {
        return loc;
    }

    public void setLoc(LocEntity loc) {
        this.loc = loc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Double getUpdate() {
        return update;
    }

    public void setUpdate(Double update) {
        this.update = update;
    }

    public ExtraEntity getExtra() {
        return extra;
    }

    public void setExtra(ExtraEntity extra) {
        this.extra = extra;
    }

}
