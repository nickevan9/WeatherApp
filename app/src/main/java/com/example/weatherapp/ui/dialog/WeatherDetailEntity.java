package com.example.weatherapp.ui.dialog;

public class WeatherDetailEntity {
    private Integer id;
    private String name;
    private Integer imageResource;
    private String detail;

    public WeatherDetailEntity(Integer id, String name, Integer imageResource, String detail) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
