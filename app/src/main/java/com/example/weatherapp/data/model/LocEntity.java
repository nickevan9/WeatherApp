package com.example.weatherapp.data.model;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class LocEntity {
    @SerializedName("lid")
    @Expose
    private Long lid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("adm1")
    @Expose
    private String adm1;
    @SerializedName("cc")
    @Expose
    private String cc;
    @SerializedName("tzname")
    @Expose
    private String tzname;
    @SerializedName("now")
    @Expose
    private String now;
    @SerializedName("tz")
    @Expose
    private String tz;
    @SerializedName("tzoffset")
    @Expose
    private Double tzoffset;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdm1() {
        return adm1;
    }

    public void setAdm1(String adm1) {
        this.adm1 = adm1;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTzname() {
        return tzname;
    }

    public void setTzname(String tzname) {
        this.tzname = tzname;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public Double getTzoffset() {
        return tzoffset;
    }

    public void setTzoffset(Double tzoffset) {
        this.tzoffset = tzoffset;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

}
