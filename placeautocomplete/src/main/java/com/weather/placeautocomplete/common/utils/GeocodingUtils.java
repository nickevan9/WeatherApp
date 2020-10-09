package com.weather.placeautocomplete.common.utils;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;

public class GeocodingUtils {

  private GeocodingUtils() {
    // No Instances.
  }

  public static String removeNameFromAddress(CarmenFeature carmenFeature) {
    String address = carmenFeature.placeName();
    return address.replace((carmenFeature.text().concat(", ")), "");
  }
}