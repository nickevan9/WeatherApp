package com.example.weatherapp.app;

import android.content.Context;

import com.example.weatherapp.R;

public class IconWeatherHelper {

    public static int getIconWeather(String code, Context context) {
        String nameImage = code + ".png";
        int resId = context.getResources().getIdentifier(nameImage,"drawable",context.getPackageName());
        return resId;
    }

    public static String getLottieWeather(String code){
        String lotiieDirection = "";
        switch (code){
            case "d000":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d100":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d200":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d210":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d211":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d212":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d220":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "d221":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d222":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d240":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d300":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d310":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d311":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d312":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d320":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d321":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d322":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d340":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d400":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d411":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d412":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d420":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d421":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d422":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d431":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d432":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d440":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d500":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "d600":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n000":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n100":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n200":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n210":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n211":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n212":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n220":
                lotiieDirection = "lottieweather/4792-weather-stormshowersday.json";
            case "n221":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n222":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n240":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n300":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n310":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n311":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n312":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n320":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n321":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n322":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n340":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n400":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n411":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n412":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n420":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n421":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n422":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n431":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n432":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n440":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n500":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            case "n600":
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";
            default:
                lotiieDirection =  "lottieweather/4792-weather-stormshowersday.json";

        }
        return lotiieDirection;
    }

    public static int getIconPrecipitation(double paramDouble) {
        int drawable;
        if (0.0D <= paramDouble && paramDouble <= 10.0D) {
            drawable = R.drawable.rain_ico_0;
        } else if (paramDouble <= 20.0D) {
            drawable = R.drawable.rain_ico_10;
        } else if (paramDouble <= 30.0D) {
            drawable = R.drawable.rain_ico_20;
        } else if (paramDouble <= 40.0D) {
            drawable = R.drawable.rain_ico_30;
        } else if (paramDouble <= 50.0D) {
            drawable = R.drawable.rain_ico_40;
        } else if (paramDouble <= 60.0D) {
            drawable = R.drawable.rain_ico_50;
        } else if (paramDouble <= 70.0D) {
            drawable = R.drawable.rain_ico_60;
        } else if (paramDouble <= 80.0D) {
            drawable = R.drawable.rain_ico_70;
        } else if (paramDouble <= 90.0D) {
            drawable = R.drawable.rain_ico_80;
        } else if (paramDouble < 100.0D) {
            drawable = R.drawable.rain_ico_90;
        } else {
            drawable = R.drawable.rain_ico_100;
        }
        return drawable;
    }
}
