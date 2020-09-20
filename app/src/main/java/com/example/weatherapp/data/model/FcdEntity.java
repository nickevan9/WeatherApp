package com.example.weatherapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FcdEntity {
    @SerializedName("pr")
    @Expose
    private Integer pr;
    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("tx")
    @Expose
    private Integer tx;
    @SerializedName("wn")
    @Expose
    private String wn;
    @SerializedName("ca")
    @Expose
    private Integer ca;
    @SerializedName("rise")
    @Expose
    private String rise;
    @SerializedName("dl")
    @Expose
    private Integer dl;
    @SerializedName("tp")
    @Expose
    private Integer tp;
    @SerializedName("tn")
    @Expose
    private Integer tn;
    @SerializedName("p")
    @Expose
    private Integer p;
    @SerializedName("s")
    @Expose
    private String s;
    @SerializedName("mrise")
    @Expose
    private String mrise;
    @SerializedName("rh_avg")
    @Expose
    private Integer rhAvg;
    @SerializedName("time_tag")
    @Expose
    private Integer timeTag;
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
    private Integer mp;
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

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Integer getTx() {
        return tx;
    }

    public void setTx(Integer tx) {
        this.tx = tx;
    }

    public String getWn() {
        return wn;
    }

    public void setWn(String wn) {
        this.wn = wn;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

    public Integer getDl() {
        return dl;
    }

    public void setDl(Integer dl) {
        this.dl = dl;
    }

    public Integer getTp() {
        return tp;
    }

    public void setTp(Integer tp) {
        this.tp = tp;
    }

    public Integer getTn() {
        return tn;
    }

    public void setTn(Integer tn) {
        this.tn = tn;
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

    public String getMrise() {
        return mrise;
    }

    public void setMrise(String mrise) {
        this.mrise = mrise;
    }

    public Integer getRhAvg() {
        return rhAvg;
    }

    public void setRhAvg(Integer rhAvg) {
        this.rhAvg = rhAvg;
    }

    public Integer getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(Integer timeTag) {
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

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
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
