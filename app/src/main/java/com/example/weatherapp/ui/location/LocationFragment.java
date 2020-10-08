package com.example.weatherapp.ui.location;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.R;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.ui.base.BaseFragment;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.ui.PlaceAutocompleteFragment;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.ui.PlaceSelectionListener;

import javax.inject.Inject;

public class LocationFragment extends BaseFragment implements LocationContract.View {


    private PlaceAutocompleteFragment autocompleteFragment;

    public static LocationFragment newInstance() {
        return new LocationFragment();
    }

    @Inject
    public LocationContract.Controller locationController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            PlaceOptions placeOptions = PlaceOptions.builder().backgroundColor(Color.WHITE).toolbarColor(Color.WHITE).statusbarColor(Color.WHITE).hint("Begin searching").build();

            autocompleteFragment = PlaceAutocompleteFragment.newInstance(BuildConfig.KEY_MAP_BOX, placeOptions);

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, autocompleteFragment, PlaceAutocompleteFragment.TAG);

            transaction.commit();
        } else {
            autocompleteFragment = (PlaceAutocompleteFragment) getChildFragmentManager().findFragmentByTag(PlaceAutocompleteFragment.TAG);
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
                locationController.getSingleWeather(lat, lon);

            }

            @Override
            public void onCancel() {
                FragmentUtils.findNavController(autocompleteFragment).popBackStack();

            }
        });
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_location;
    }

    @Override
    protected void dataCreate() {
        locationController.attachView(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void fragmentBackPressed() {

    }


    @Override
    public void onDetach() {
        super.onDetach();
        autocompleteFragment = null;
    }


    @Override
    public void insertDataSuccess() {

    }

    @Override
    public void loadDataFailed(String message) {

    }

    @Override
    public void showLoadingDB() {

    }

    @Override
    public void hideLoadingDB() {
        FragmentUtils.findNavController(autocompleteFragment).popBackStack();
//        FragmentUtils.findNavController(this).popBackStack();
    }

    @Override
    public void showLoadingAPI() {

    }

    @Override
    public void hideLoadingAPI() {

    }


}