package com.example.weatherapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FchEntity {
    @SerializedName("pr")
    @Expose
    private Integer pr;
    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("upt")
    @Expose
    private String upt;
    @SerializedName("wn")
    @Expose
    private String wn;
    @SerializedName("uv")
    @Expose
    private Integer uv;
    @SerializedName("c")
    @Expose
    private Integer c;
    @SerializedName("tp")
    @Expose
    private Integer tp;
    @SerializedName("p")
    @Expose
    private Integer p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("ws")
    @Expose
    private Double ws;
    @SerializedName("t")
    @Expose
    private Integer t;
    @SerializedName("time_tag")
    @Expose
    private Integer timeTag;
    @SerializedName("v")
    @Expose
    private Integer v;
    @SerializedName("tf")
    @Expose
    private Integer tf;
    @SerializedName("dt")
    @Expose
    private String dt;
    @SerializedName("rh")
    @Expose
    private Integer rh;
    @SerializedName("td")
    @Expose
    private Double td;
    @SerializedName("txt")
    @Expose
    private String txt;
    @SerializedName("dts")
    @Expose
    private Integer dts;

    public Integer getPr() {
        return pr;
    }

    public void setPr(Integer pr) {
        this.pr = pr;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
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

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getTp() {
        return tp;
    }

    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
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

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Integer getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(Integer timeTag) {
        this.timeTag = timeTag;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getTf() {
        return tf;
    }

    public void setTf(Integer tf) {
        this.tf = tf;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
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

    public Integer getDts() {
        return dts;
    }

    public void setDts(Integer dts) {
        this.dts = dts;
    }
}
