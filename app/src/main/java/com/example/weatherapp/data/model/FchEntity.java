package com.example.weatherapp.data.model;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class FchEntity {
    @SerializedName("pr")
    @Expose
    private Double pr;
    @SerializedName("pp")
    @Expose
    private Double pp;
    @SerializedName("upt")
    @Expose
    private String upt;
    @SerializedName("wn")
    @Expose
    private String wn;
    @SerializedName("uv")
    @Expose
    private Double uv;
    @SerializedName("c")
    @Expose
    private Double c;
    @SerializedName("tp")
    @Expose
    private Double tp;
    @SerializedName("p")
    @Expose
    private Double p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("ws")
    @Expose
    private Double ws;
    @SerializedName("t")
    @Expose
    private Double t;
    @SerializedName("time_tag")
    @Expose
    private Double timeTag;
    @SerializedName("v")
    @Expose
    private Double v;
    @SerializedName("tf")
    @Expose
    private Double tf;
    @SerializedName("dt")
    @Expose
    private String dt;
    @SerializedName("rh")
    @Expose
    private Double rh;
    @SerializedName("td")
    @Expose
    private Double td;
    @SerializedName("txt")
    @Expose
    private String txt;
    @SerializedName("dts")
    @Expose
    private Double dts;

    public Double getPr() {
        return pr;
    }

    public void setPr(Double pr) {
        this.pr = pr;
    }

    public Double getPp() {
        return pp;
    }

    public void setPp(Double pp) {
        this.pp = pp;
    }

    public String getUpt() {
        return upt;
    }

    public void setUpt(String upt) {
        this.upt = upt;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getTp() {
        return tp;
    }

    public void setTp(Double tp) {
        this.tp = tp;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Double getWs() {
        return ws;
    }

    public void setWs(Double ws) {
        this.ws = ws;
    }

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    public Double getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(Double timeTag) {
        this.timeTag = timeTag;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    public Double getTf() {
        return tf;
    }

    public void setTf(Double tf) {
        this.tf = tf;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double getTd() {
        return td;
    }

    public void setTd(Double td) {
        this.td = td;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Double getDts() {
        return dts;
    }

    public void setDts(Double dts) {
        this.dts = dts;
    }
}
