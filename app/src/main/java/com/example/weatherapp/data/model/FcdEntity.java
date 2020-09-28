package com.example.weatherapp.data.model;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class FcdEntity {
    @SerializedName("pr")
    @Expose
    private Double pr;
    @SerializedName("pp")
    @Expose
    private Double pp;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("tx")
    @Expose
    private Double tx;
    @SerializedName("wn")
    @Expose
    private String wn;
    @SerializedName("ca")
    @Expose
    private Double ca;
    @SerializedName("rise")
    @Expose
    private String rise;
    @SerializedName("dl")
    @Expose
    private Double dl;
    @SerializedName("tp")
    @Expose
    private Double tp;
    @SerializedName("tn")
    @Expose
    private Double tn;
    @SerializedName("p")
    @Expose
    private Double p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("mrise")
    @Expose
    private String mrise;
    @SerializedName("rh_avg")
    @Expose
    private Double rhAvg;
    @SerializedName("time_tag")
    @Expose
    private Double timeTag;
    @SerializedName("wsx")
    @Expose
    private Double wsx;
    @SerializedName("dt")
    @Expose
    private String dt;
    @SerializedName("mset")
    @Expose
    private String mset;
    @SerializedName("upt")
    @Expose
    private String upt;
    @SerializedName("uv")
    @Expose
    private String uv;
    @SerializedName("mp")
    @Expose
    private Double mp;
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

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Double getTx() {
        return tx;
    }

    public void setTx(Double tx) {
        this.tx = tx;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
    }

    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
    }

    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

    public Double getDl() {
        return dl;
    }

    public void setDl(Double dl) {
        this.dl = dl;
    }

    public Double getTp() {
        return tp;
    }

    public void setTp(Double tp) {
        this.tp = tp;
    }

    public Double getTn() {
        return tn;
    }

    public void setTn(Double tn) {
        this.tn = tn;
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

    public String getMrise() {
        return mrise;
    }

    public void setMrise(String mrise) {
        this.mrise = mrise;
    }

    public Double getRhAvg() {
        return rhAvg;
    }

    public void setRhAvg(Double rhAvg) {
        this.rhAvg = rhAvg;
    }

    public Double getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(Double timeTag) {
        this.timeTag = timeTag;
    }

    public Double getWsx() {
        return wsx;
    }

    public void setWsx(Double wsx) {
        this.wsx = wsx;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getMset() {
        return mset;
    }

    public void setMset(String mset) {
        this.mset = mset;
    }

    public String getUpt() {
        return upt;
    }

    public void setUpt(String upt) {
        this.upt = upt;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
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
