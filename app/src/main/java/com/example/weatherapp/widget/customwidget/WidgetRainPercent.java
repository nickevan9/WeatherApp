package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class WidgetRainPercent extends RelativeLayout {

    private BarChart rainChart;
    private List<FchEntity> fchEntityList;
    private List<BarEntry> entryList;

    public WidgetRainPercent(Context context) {
        super(context);
        initView();
    }

    public WidgetRainPercent(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetRainPercent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.widget_rain_percent, this);
        rainChart = findViewById(R.id.chart_rain);

        entryList = new ArrayList<>();
        fchEntityList = new ArrayList<>();

        rainChart.getDescription().setEnabled(false);

        rainChart.setPinchZoom(false);

        rainChart.setDrawBarShadow(false);
        rainChart.setDrawGridBackground(false);


        XAxis xAxis = rainChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(12f);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(6);

        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                String hourOfDay = "";
                switch ((int) value) {
                    case 0:
                        hourOfDay = "00:00";
                        break;
                    case 1:
                        hourOfDay = "01:00";
                        break;
                    case 2:
                        hourOfDay = "02:00";
                        break;
                    case 3:
                        hourOfDay = "03:00";
                        break;
                    case 4:
                        hourOfDay = "04:00";
                        break;
                    case 5:
                        hourOfDay = "05:00";
                        break;
                    case 6:
                        hourOfDay = "06:00";
                        break;
                    case 7:
                        hourOfDay = "07:00";
                        break;
                    case 8:
                        hourOfDay = "08:00";
                        break;
                    case 9:
                        hourOfDay = "09:00";
                        break;
                    case 10:
                        hourOfDay = "10:00";
                        break;
                    case 11:
                        hourOfDay = "11:00";
                        break;
                    case 12:
                        hourOfDay = "12:00";
                        break;
                    case 13:
                        hourOfDay = "13:00";
                        break;
                    case 14:
                        hourOfDay = "14:00";
                        break;
                    case 15:
                        hourOfDay = "15:00";
                        break;
                    case 16:
                        hourOfDay = "16:00";
                        break;
                    case 17:
                        hourOfDay = "17:00";
                        break;
                    case 18:
                        hourOfDay = "18:00";
                        break;
                    case 19:
                        hourOfDay = "19:00";
                        break;
                    case 20:
                        hourOfDay = "20:00";
                        break;
                    case 21:
                        hourOfDay = "21:00";
                        break;
                    case 22:
                        hourOfDay = "22:00";
                        break;
                    case 23:
                        hourOfDay = "23:00";
                        break;
                    case 24:
                        hourOfDay = "24:00";
                        break;

                }

                return hourOfDay;
            }
        });


        YAxis axisLeft = rainChart.getAxisLeft();
        axisLeft.setLabelCount(8, false);
        axisLeft.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int valueNew = (int) value;
                return valueNew + "%";
            }
        });
        axisLeft.setTextColor(Color.WHITE);
        axisLeft.setTextSize(12f);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        axisLeft.setAxisMinimum(0f); // this

        YAxis axisRight = rainChart.getAxisRight();
        axisRight.setDrawLabels(false);
        axisRight.setEnabled(false);

        // replaces setStartAtZero(true)


        rainChart.getAxisLeft().setDrawGridLines(false);

        rainChart.animateY(1500);

        rainChart.getLegend().setEnabled(false);

    }

    public void applyData(List<FchEntity> fchEntities) {
        if (fchEntities.size() > 12) {
            fchEntityList.addAll(fchEntities.subList(0, 12));
        } else {
            fchEntityList.addAll(fchEntities);
        }

        for (int i = 0; i < 12; i++) {
            entryList.add(new BarEntry(i, fchEntityList.get(i).getRh().floatValue()));
        }

        BarDataSet set1;

        if (rainChart.getData() != null &&
                rainChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) rainChart.getData().getDataSetByIndex(0);
            set1.setValues(entryList);
            rainChart.getData().notifyDataChanged();
            rainChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(entryList, "Data Set");
            set1.setColors(Color.parseColor("#99000000"));
            set1.setDrawValues(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            rainChart.setData(data);
            rainChart.setFitBars(true);
        }
        rainChart.invalidate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RxBus.subscribe(RxBus.TAG_LIST_HOUR_ITEM,this, fchObject ->{
            List<FchEntity> fchEntityList = (List<FchEntity>) fchObject;
            applyData(fchEntityList);
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
