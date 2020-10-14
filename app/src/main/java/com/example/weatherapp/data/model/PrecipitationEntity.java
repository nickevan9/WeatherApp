package com.example.weatherapp.data.model;

public class PrecipitationEntity {
    private String name;
    private int rainPercent;

    public PrecipitationEntity() {
    }

    public PrecipitationEntity(String name, int rainPercent) {
        this.name = name;
        this.rainPercent = rainPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRainPercent() {
        return rainPercent;
    }

    public void setRainPercent(int rainPercent) {
        this.rainPercent = rainPercent;
    }


}
