package com.example.weatherapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CcEntity {
    @SerializedName("pr")
    @Expose
    private Double pr;
    @SerializedName("prestend")
    @Expose
    private Double prestend;
    @SerializedName("c")
    @Expose
    private Double c;
    @SerializedName("dist")
    @Expose
    private Double dist;
    @SerializedName("wn")
    @Expose
    private String wn;
    @SerializedName("p")
    @Expose
    private Double p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("station")
    @Expose
    private String station;
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
    @SerializedName("uv")
    @Expose
    private Double uv;
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

    public Double getPrestend() {
        return prestend;
    }

    public void setPrestend(Double prestend) {
        this.prestend = prestend;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getDist() {
        return dist;
    }

    public void setDist(Double dist) {
        this.dist = dist;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
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

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
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
