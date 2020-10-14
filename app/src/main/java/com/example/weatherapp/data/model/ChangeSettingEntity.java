package com.example.weatherapp.data.model;

public class ChangeSettingEntity {
    private TypeSetting typeSetting;
    private Integer imageDrawable;

    public ChangeSettingEntity() {
    }

    public ChangeSettingEntity(TypeSetting typeSetting, Integer imageDrawable) {
        this.typeSetting = typeSetting;
        this.imageDrawable = imageDrawable;
    }

    public TypeSetting getTypeSetting() {
        return typeSetting;
    }

    public void setTypeSetting(TypeSetting typeSetting) {
        this.typeSetting = typeSetting;
    }

    public Integer getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(Integer imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}

enum TypeSetting {
    Widget,
    Notification
}