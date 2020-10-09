package com.example.weatherapp.ui.place;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.R;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.loadingdata.LoadingContract;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.ui.PlaceAutocompleteFragment;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.ui.PlaceSelectionListener;

import javax.inject.Inject;

public class PlaceActivity extends AppCompatActivity implements PlaceContract.View {

    private PlaceAutocompleteFragment autocompleteFragment;

    @Inject
    public PlaceContract.Controller placeController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);


        if (savedInstanceState == null) {
            PlaceOptions placeOptions = PlaceOptions.builder()
                    .backgroundColor(Color.WHITE)
                    .toolbarColor(Color.WHITE)
                    .statusbarColor(Color.WHITE)
                    .hint("Begin searching...")
                    .build();

            autocompleteFragment = PlaceAutocompleteFragment.newInstance(
                    BuildConfig.KEY_MAP_BOX,
                    placeOptions
            );

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, autocompleteFragment, PlaceAutocompleteFragment.TAG);
            transaction.commit();
        } else {
            autocompleteFragment = (PlaceAutocompleteFragment) getSupportFragmentManager().findFragmentByTag(PlaceAutocompleteFragment.TAG);
        }

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(CarmenFeature carmenFeature) {
//                Intent intent = new Intent();
//                intent.putExtra("dataPlace", carmenFeature.center());
//                setResult(Activity.RESULT_OK, intent);
//                finish();
                Double lat = carmenFeature.center().latitude();
                Double lon = carmenFeature.center().longitude();
                placeController.getSingleWeather(lat, lon);
            }


            @Override
            public void onCancel() {
                finish();
            }
        });

        placeController.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        autocompleteFragment = null;
    }

    @Override
    public void loadDataSuccess(String message) {

    }

    @Override
    public void loadDataFailed(String message) {

    }

    @Override
    public void showLoadingDB() {

    }

    @Override
    public void hideLoadingDB() {

    }

    @Override
    public void showLoadingAPI() {

    }

    @Override
    public void hideLoadingAPI() {
        finish();
    }
}