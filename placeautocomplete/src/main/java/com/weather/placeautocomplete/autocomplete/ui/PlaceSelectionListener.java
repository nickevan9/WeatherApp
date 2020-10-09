package com.weather.placeautocomplete.autocomplete.ui;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;

public interface PlaceSelectionListener {

  public void onPlaceSelected(CarmenFeature carmenFeature);

  public void onCancel();
}