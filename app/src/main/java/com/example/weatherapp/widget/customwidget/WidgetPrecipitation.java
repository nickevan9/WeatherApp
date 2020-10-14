package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.PrecipitationEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.widget.customwidget.adapter.LinearLayoutPagerManager;
import com.example.weatherapp.widget.customwidget.adapter.PrecipitationAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class WidgetPrecipitation extends RelativeLayout {

    private RecyclerView rvRain;
    private PrecipitationAdapter precipitationAdapter;
    private String timeZone;

    private List<PrecipitationEntity> precipitationEntityList;

    public WidgetPrecipitation(Context context) {
        super(context);
        initView();
    }

    public WidgetPrecipitation(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetPrecipitation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.widget_precipitation, this);
        timeZone = "";

        precipitationEntityList = new ArrayList<>();

        precipitationAdapter = new PrecipitationAdapter(getContext(), precipitationEntityList);

        rvRain = findViewById(R.id.rv_precipitation);

        LinearLayoutPagerManager layoutPagerManager = new LinearLayoutPagerManager(getContext(), LinearLayoutManager.HORIZONTAL, false, 4);

        rvRain.setLayoutManager(layoutPagerManager);
        rvRain.setHasFixedSize(true);
        rvRain.setAdapter(precipitationAdapter);
        rvRain.setNestedScrollingEnabled(true);
    }

    public void applyData(List<PrecipitationEntity> precipitationEntityList) {
        precipitationAdapter.applyData(precipitationEntityList);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        RxBus.subscribe(RxBus.TAG_TIME_ZONE, this, timeZoneObject -> {
            this.timeZone = (String) timeZoneObject;
        });

        RxBus.subscribe(RxBus.TAG_LIST_HOUR_ITEM, this, listHourEntity -> {
            List<FchEntity> fchEntityList = (List<FchEntity>) listHourEntity;
            Observable.fromArray(fchEntityList).flatMap(Observable::fromIterable).filter(fchEntity -> false)
                    .toList().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<List<FchEntity>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onSuccess(@NonNull List<FchEntity> fchEntities) {

                }

                @Override
                public void onError(@NonNull Throwable e) {

                }
            });
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
