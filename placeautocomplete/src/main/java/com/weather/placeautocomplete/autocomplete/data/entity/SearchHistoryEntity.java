package com.weather.placeautocomplete.autocomplete.data.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.weather.placeautocomplete.autocomplete.model.SearchHistory;


@Entity(tableName = "searchhistory")
public class SearchHistoryEntity implements SearchHistory {

  public SearchHistoryEntity(@NonNull String placeId, CarmenFeature carmenFeature) {
    this.placeId = placeId;
    this.carmenFeature = carmenFeature;
  }

  @NonNull
  @PrimaryKey
  private String placeId;

  @ColumnInfo(name = "carmen_feature")
  private CarmenFeature carmenFeature;

  @Override
  @NonNull
  public String getPlaceId() {
    return placeId;
  }

  @Override
  public CarmenFeature getCarmenFeature() {
    return carmenFeature;
  }
}
