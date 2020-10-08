package com.weather.placeautocomplete.autocomplete.data.converter;


import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;

public final class CarmenFeatureConverter {

  private CarmenFeatureConverter() {
    // class shouldn't be initialized
  }

  @TypeConverter
  public static CarmenFeature toCarmenFeature(String serializedCarmenFeature) {
    return serializedCarmenFeature == null ? null : CarmenFeature.fromJson(serializedCarmenFeature);
  }

  @TypeConverter
  public static String fromCarmenFeature(@NonNull CarmenFeature carmenFeature) {
    return carmenFeature.toJson();
  }
}
