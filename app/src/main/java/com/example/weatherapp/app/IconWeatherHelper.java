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

    public static int getDrawableAnimation(String code){
        int drawable = 0;
        switch (code){
            case "d000":
                drawable = R.drawable.ic_weather_clear_day;
                break;
            case "d100":
                drawable = R.drawable.ic_weather_partly_cloudy_day;
                break;
            case "d200":
                drawable = R.drawable.ic_weather_partly_cloudy_day;
                break;
            case "d210":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d211":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d212":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d220":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d221":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d222":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d240":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d300":
                drawable = R.drawable.ic_weather_partly_cloudy_day;
                break;
            case "d310":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d311":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d312":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d320":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d321":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d322":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d340":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d400":
                drawable = R.drawable.ic_weather_cloudy;
                break;
            case "d411":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d412":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d420":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d421":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d422":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d430":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d431":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "d432":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "d440":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "d500":
                drawable = R.drawable.ic_weather_partly_cloudy_day;
                break;
            case "d600":
                drawable = R.drawable.ic_weather_fog;
                break;
            case "n000":
                drawable = R.drawable.ic_weather_clear_night;
                break;
            case "n100":
                drawable = R.drawable.ic_weather_partly_cloudy_night;
                break;
            case "n200":
                drawable = R.drawable.ic_weather_partly_cloudy_night;
                break;
            case "n210":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n211":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n212":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n220":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n221":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n222":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n240":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n300":
                drawable = R.drawable.ic_weather_partly_cloudy_night;
                break;
            case "n310":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n311":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n312":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n320":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n321":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n322":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n340":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n400":
                drawable = R.drawable.ic_weather_cloudy;
                break;
            case "n411":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n412":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n420":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n421":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n422":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n430":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n431":
                drawable = R.drawable.ic_weather_sleet;
                break;
            case "n432":
                drawable = R.drawable.ic_weather_snow;
                break;
            case "n440":
                drawable = R.drawable.ic_weather_rain;
                break;
            case "n500":
                drawable = R.drawable.ic_weather_partly_cloudy_night;
                break;
            case "n600":
                drawable = R.drawable.ic_weather_fog;
                break;
            default:
                drawable = R.drawable.ic_weather_clear_day;
                break;
        }
        return drawable;
    }

    public static int getDrawableAnimationLarge(String code){
        int drawable = 0;
        switch (code){
            case "d000":
                drawable = R.drawable.ic_weather_large_sun_day;
                break;
            case "d100":
                drawable = R.drawable.ic_weather_large_partly_cloudy;
                break;
            case "d200":
                drawable = R.drawable.ic_weather_large_partly_cloudy;
                break;
            case "d210":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d211":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d212":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d220":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d221":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d222":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d240":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d300":
                drawable = R.drawable.ic_weather_large_partly_cloudy;
                break;
            case "d310":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d311":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d312":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d320":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d321":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d322":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d340":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d400":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "d411":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d412":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d420":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d421":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d422":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d430":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d431":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "d432":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "d440":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "d500":
                drawable = R.drawable.ic_weather_large_partly_cloudy;
                break;
            case "d600":
                drawable = R.drawable.ic_weather_large_fog;
                break;
            case "n000":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n100":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n200":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n210":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n211":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n212":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n220":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n221":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n222":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n240":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n300":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n310":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n311":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n312":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n320":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n321":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n322":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n340":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n400":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n411":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n412":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n420":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n421":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n422":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n430":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n431":
                drawable = R.drawable.ic_weather_large_sleet;
                break;
            case "n432":
                drawable = R.drawable.ic_weather_large_snow;
                break;
            case "n440":
                drawable = R.drawable.ic_weather_large_rain;
                break;
            case "n500":
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
            case "n600":
                drawable = R.drawable.ic_weather_large_fog;
                break;
            default:
                drawable = R.drawable.ic_weather_large_cloudy;
                break;
        }
        return drawable;
    }


    public static int getBackgroundWeather(String code){
        int drawable = 0;
        switch (code){
            case "d000":
                drawable = R.drawable.bg_sunny;
                break;
            case "d100":
                drawable = R.drawable.bg_cloudy_day;
                break;
            case "d200":
                drawable = R.drawable.bg_cloudy_day;
                break;
            case "d210":
                drawable = R.drawable.bg_rain;
                break;
            case "d211":
                drawable = R.drawable.bg_sleet;
                break;
            case "d212":
                drawable = R.drawable.bg_snow;
                break;
            case "d220":
                drawable = R.drawable.bg_rain;
                break;
            case "d221":
                drawable = R.drawable.bg_sleet;
                break;
            case "d222":
                drawable = R.drawable.bg_snow;
                break;
            case "d240":
                drawable = R.drawable.bg_rain;
                break;
            case "d300":
                drawable = R.drawable.bg_cloudy_day;
                break;
            case "d310":
                drawable = R.drawable.bg_rain;
                break;
            case "d311":
                drawable = R.drawable.bg_sleet;
                break;
            case "d312":
                drawable = R.drawable.bg_snow;
                break;
            case "d320":
                drawable = R.drawable.bg_rain;
                break;
            case "d321":
                drawable = R.drawable.bg_sleet;
                break;
            case "d322":
                drawable = R.drawable.bg_snow;
                break;
            case "d340":
                drawable = R.drawable.bg_rain;
                break;
            case "d400":
                drawable = R.drawable.bg_cloudy_day;
                break;
            case "d411":
                drawable = R.drawable.bg_sleet;
                break;
            case "d412":
                drawable = R.drawable.bg_snow;
                break;
            case "d420":
                drawable = R.drawable.bg_rain;
                break;
            case "d421":
                drawable = R.drawable.bg_sleet;
                break;
            case "d422":
                drawable = R.drawable.bg_snow;
                break;
            case "d430":
                drawable = R.drawable.bg_rain;
                break;
            case "d431":
                drawable = R.drawable.bg_sleet;
                break;
            case "d432":
                drawable = R.drawable.bg_snow;
                break;
            case "d440":
                drawable = R.drawable.bg_rain;
                break;
            case "d500":
                drawable = R.drawable.bg_cloudy_day;
                break;
            case "d600":
                drawable = R.drawable.bg_fog;
                break;
            case "n000":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n100":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n200":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n210":
                drawable = R.drawable.bg_rain;
                break;
            case "n211":
                drawable = R.drawable.bg_sleet;
                break;
            case "n212":
                drawable = R.drawable.bg_snow;
                break;
            case "n220":
                drawable = R.drawable.bg_rain;
                break;
            case "n221":
                drawable = R.drawable.bg_sleet;
                break;
            case "n222":
                drawable = R.drawable.bg_snow;
                break;
            case "n240":
                drawable = R.drawable.bg_rain;
                break;
            case "n300":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n310":
                drawable = R.drawable.bg_rain;
                break;
            case "n311":
                drawable = R.drawable.bg_sleet;
                break;
            case "n312":
                drawable = R.drawable.bg_snow;
                break;
            case "n320":
                drawable = R.drawable.bg_rain;
                break;
            case "n321":
                drawable = R.drawable.bg_sleet;
                break;
            case "n322":
                drawable = R.drawable.bg_snow;
                break;
            case "n340":
                drawable = R.drawable.bg_rain;
                break;
            case "n400":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n411":
                drawable = R.drawable.bg_sleet;
                break;
            case "n412":
                drawable = R.drawable.bg_snow;
                break;
            case "n420":
                drawable = R.drawable.bg_rain;
                break;
            case "n421":
                drawable = R.drawable.bg_sleet;
                break;
            case "n422":
                drawable = R.drawable.bg_snow;
                break;
            case "n430":
                drawable = R.drawable.bg_rain;
                break;
            case "n431":
                drawable = R.drawable.bg_sleet;
                break;
            case "n432":
                drawable = R.drawable.bg_snow;
                break;
            case "n440":
                drawable = R.drawable.bg_rain;
                break;
            case "n500":
                drawable = R.drawable.bg_cloudy_night;
                break;
            case "n600":
                drawable = R.drawable.bg_fog;
                break;
            default:
                drawable = R.drawable.bg_cloudy_day;
                break;
        }
        return drawable;
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
