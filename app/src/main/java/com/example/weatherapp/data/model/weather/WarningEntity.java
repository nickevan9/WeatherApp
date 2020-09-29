package com.example.weatherapp.data.model.weather;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WarningEntity {
    @SerializedName("f0")
    @Expose
    private String f0;
    @SerializedName("fs0")
    @Expose
    private String fs0;
    @SerializedName("f1")
    @Expose
    private Double f1;
    @SerializedName("dtfrom")
    @Expose
    private String dtfrom;
    @SerializedName("dtuntil")
    @Expose
    private String dtuntil;
    @SerializedName("dtfromu")
    @Expose
    private String dtfromu;
    @SerializedName("dtuntilu")
    @Expose
    private String dtuntilu;
    @SerializedName("attr")
    @Expose
    private String attr;
    @SerializedName("nws")
    @Expose
    private String nws;
    @SerializedName("text")
    @Expose
    private String text;

    public String getF0() {
        return f0;
    }

    public void setF0(String f0) {
        this.f0 = f0;
    }

    public String getFs0() {
        return fs0;
    }

    public void setFs0(String fs0) {
        this.fs0 = fs0;
    }

    public Double getF1() {
        return f1;
    }

    public void setF1(Double f1) {
        this.f1 = f1;
    }

    public String getDtfrom() {
        return dtfrom;
    }

    public void setDtfrom(String dtfrom) {
        this.dtfrom = dtfrom;
    }

    public String getDtuntil() {
        return dtuntil;
    }

    public void setDtuntil(String dtuntil) {
        this.dtuntil = dtuntil;
    }

    public String getDtfromu() {
        return dtfromu;
    }

    public void setDtfromu(String dtfromu) {
        this.dtfromu = dtfromu;
    }

    public String getDtuntilu() {
        return dtuntilu;
    }

    public void setDtuntilu(String dtuntilu) {
        this.dtuntilu = dtuntilu;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getNws() {
        return nws;
    }

    public void setNws(String nws) {
        this.nws = nws;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
