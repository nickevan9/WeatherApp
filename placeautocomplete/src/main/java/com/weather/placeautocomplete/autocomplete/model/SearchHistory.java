package com.weather.placeautocomplete.autocomplete.model;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;

public interface SearchHistory {
  String getPlaceId();

  CarmenFeature getCarmenFeature();
}
