package com.example.weatherapp.ui.place;

import com.mapbox.api.geocoding.v5.models.CarmenFeature;

interface ResultClickCallback {
    void onClick(CarmenFeature carmenFeature);
}