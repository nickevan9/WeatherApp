package com.example.weatherapp.widget.customwidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.PrecipitationEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.widget.customwidget.adapter.LinearLayoutPagerManager;
import com.example.weatherapp.widget.customwidget.adapter.PrecipitationAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WidgetPrecipitation extends RelativeLayout {

    private RecyclerView rvRain;
    private PrecipitationAdapter precipitationAdapter;
    private String timeZone;

    private List<PrecipitationEntity> precipitationEntityList;

    private CompositeDisposable disposable;

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

        disposable = new CompositeDisposable();

        precipitationEntityList = new ArrayList<>();

        precipitationAdapter = new PrecipitationAdapter(getContext(), precipitationEntityList);

        rvRain = findViewById(R.id.rv_precipitation);

        LinearLayoutPagerManager layoutPagerManager = new LinearLayoutPagerManager(getContext(), LinearLayoutManager.HORIZONTAL, false, 4);

        rvRain.setLayoutManager(layoutPagerManager);
        rvRain.setHasFixedSize(true);
        rvRain.setAdapter(precipitationAdapter);
    }

    @SuppressLint("CheckResult")
    public void applyData(List<FchEntity> fchEntityList) {
        Observable.fromArray(fchEntityList).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(fchEntityList1 -> {
            int countEarlyMorning = 0;
            int countMorning = 0;
            int countNoon = 0;
            int countAfterNoon = 0;
            int countEvening = 0;
            int countNight = 0;

            int countPerEarlyMorning = 0;
            int countPerMorning = 0;
            int countPerNoon = 0;
            int countPerAfterNoon = 0;
            int countPerEvening = 0;
            int countPerNight = 0;

            List<PrecipitationEntity> list = new ArrayList<>();
            for (FchEntity fchEntity : fchEntityList1) {


                String timeConvert = TimeUtilsExt.convertTimeStampToTimeAdapter(fchEntity.getDt(), timeZone);

                switch (timeConvert) {

                    case "01:00":
                    case "02:00":
                    case "03:00":
                    case "04:00":
                        countPerEarlyMorning ++;
                        countEarlyMorning += fchEntity.getRh().intValue();
                        break;
                    case "05:00":
                    case "06:00":
                    case "07:00":
                    case "08:00":
                        countPerMorning ++;
                        countMorning += fchEntity.getRh().intValue();
                        break;
                    case "09:00":
                    case "10:00":
                    case "11:00":
                    case "12:00":
                        countPerNoon ++;
                        countNoon += fchEntity.getRh().intValue();
                        break;
                    case "13:00":
                    case "14:00":
                    case "15:00":
                    case "16:00":
                        countPerAfterNoon ++;
                        countAfterNoon += fchEntity.getRh().intValue();
                        break;
                    case "17:00":
                    case "18:00":
                    case "19:00":
                    case "20:00":
                        countPerEvening ++;
                        countEvening += fchEntity.getRh().intValue();
                        break;
                    case "21:00":
                    case "22:00":
                    case "23:00":
                    case "00:00":
                        countPerNight ++;
                        countNight += fchEntity.getRh().intValue();
                        break;
                }
            }

            countEarlyMorning = countEarlyMorning / countPerEarlyMorning;
            countMorning = countMorning / countPerMorning;
            countNoon = countNoon / countPerNoon;
            countAfterNoon = countAfterNoon / countPerAfterNoon;
            countEvening = countEvening / countPerEvening;
            countNight = countNight / countPerNight;

            String timeConvert1 = TimeUtilsExt.convertTimeStampToTimeAdapter(fchEntityList1.get(0).getDt(), timeZone);

            switch (timeConvert1) {

                case "01:00":
                case "02:00":
                case "03:00":
                case "04:00":
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    list.add(new PrecipitationEntity("Morning", countMorning));
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    list.add(new PrecipitationEntity("Night", countNight));

                    break;
                case "05:00":
                case "06:00":
                case "07:00":
                case "08:00":


                    list.add(new PrecipitationEntity("Morning", countMorning));
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    list.add(new PrecipitationEntity("Night", countNight));
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    break;
                case "09:00":
                case "10:00":
                case "11:00":
                case "12:00":
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    list.add(new PrecipitationEntity("Night", countNight));
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    list.add(new PrecipitationEntity("Morning", countMorning));
                    break;
                case "13:00":
                case "14:00":
                case "15:00":
                case "16:00":
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    list.add(new PrecipitationEntity("Night", countNight));
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    list.add(new PrecipitationEntity("Morning", countMorning));
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    break;
                case "17:00":
                case "18:00":
                case "19:00":
                case "20:00":
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    list.add(new PrecipitationEntity("Night", countNight));
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    list.add(new PrecipitationEntity("Morning", countMorning));
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    break;
                case "21:00":
                case "22:00":
                case "23:00":
                case "00:00":
                    list.add(new PrecipitationEntity("Night", countNight));
                    list.add(new PrecipitationEntity("Early Morning", countEarlyMorning));
                    list.add(new PrecipitationEntity("Morning", countMorning));
                    list.add(new PrecipitationEntity("Noon", countNoon));
                    list.add(new PrecipitationEntity("Afternoon", countAfterNoon));
                    list.add(new PrecipitationEntity("Evening", countEvening));
                    break;

            }


            return list;
        }).subscribe(new Observer<List<PrecipitationEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onNext(List<PrecipitationEntity> precipitationEntities) {
                precipitationAdapter.applyData(precipitationEntities);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });




    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        RxBus.subscribe(RxBus.TAG_TIME_ZONE, this, timeZoneObject -> {
            this.timeZone = (String) timeZoneObject;
        });

        RxBus.subscribe(RxBus.TAG_LIST_HOUR_ITEM, this, listHourEntity -> {
            List<FchEntity> fchEntityList = (List<FchEntity>) listHourEntity;
            applyData(fchEntityList);

        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
        disposable.clear();
    }
}
