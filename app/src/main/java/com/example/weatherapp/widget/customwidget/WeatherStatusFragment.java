package com.example.weatherapp.widget.customwidget;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.ui.dialog.WeatherDialog;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherStatusFragment extends Fragment {


    private static final String ARG_PARAM_FCH = "fch_entity";
    private static final String ARG_PARAM_FCD = "fcd_entity";
    private static final String ARG_PARAM_TIME_ZONE = "time_zone";

    // TODO: Rename and change types of parameters
    private FchEntity mParamFch;
    private FcdEntity mParamFcd;
    private String timeZone;

    private WidgetWeatherStatus widgetWeatherStatus;

    public WeatherStatusFragment() {
        // Required empty public constructor
    }


    public static WeatherStatusFragment newInstance(FchEntity fchEntity, FcdEntity fcdEntity,String timeZone) {
        WeatherStatusFragment fragment = new WeatherStatusFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_FCH, fchEntity);
        args.putSerializable(ARG_PARAM_FCD, fcdEntity);
        args.putString(ARG_PARAM_TIME_ZONE,timeZone);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamFch = (FchEntity) getArguments().getSerializable(ARG_PARAM_FCH);
            mParamFcd = (FcdEntity) getArguments().getSerializable(ARG_PARAM_FCD);
            timeZone = getArguments().getString(ARG_PARAM_TIME_ZONE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        widgetWeatherStatus = view.findViewById(R.id.wg_weather_status);


        widgetWeatherStatus.applyData(mParamFch,mParamFcd,timeZone);

        widgetWeatherStatus.setOnClickListener(view1 -> {
            new WeatherDialog(requireActivity(),mParamFch,timeZone);
        });
    }
}