package com.example.weatherapp.app;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;


public class HourAxisValueFormatter implements IAxisValueFormatter {

    private final BarLineChartBase<?> chart;

    public HourAxisValueFormatter(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        String hourOfDay = "";
        switch ((int) value){
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
}
