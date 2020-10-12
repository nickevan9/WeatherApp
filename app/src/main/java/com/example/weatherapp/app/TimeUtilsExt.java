package com.example.weatherapp.app;

import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimeUtilsExt {

    public static String convertTimeStampToLocalTime(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa EEE");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }
    public static String convertTimeStampToLocalTime2(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }


    public static String convertTimeStampToTimeAdapter(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
        return fmt.print(dateTime);
    }

    public static String convertTimeStampToTime12Hour(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa");
        return fmt.print(dateTime);
    }

    public static String convertTimeToDayOfWeek(String timeStamp, String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("EEE");
        String timeAfter = fmt.withLocale(Locale.ENGLISH).print(dateTime);
        return timeAfter;
    }

    public static int endTimeProgress(long timeNow,  long timeSunRise,long timeSunset) {
        if (timeNow >= timeSunset)
            return 100;
        double d1 = (timeNow - timeSunRise);
        double d2 = (timeSunset - timeSunRise);
        Double.isNaN(d2);
        d2 /= 100.0D;
        Double.isNaN(d1);
        return (int)Math.round(d1 / d2);
    }

    public static long formatStringToTime(String time ,String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("HH:mm");
        DateTime dateTimeNow = DateTime.now();


        DateTime dateTime = new DateTime(dateFormat.parseDateTime(time))
                .withYear(dateTimeNow.getYear())
                .withMonthOfYear(dateTimeNow.getMonthOfYear())
                .withDayOfMonth(dateTimeNow.getDayOfMonth());


        return dateTime.getMillis();
    }

    public static long formatTimeNow(String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("HH:mm");
        DateTime dateTime = DateTime.now();
        return dateTime.getMillis();
    }

    public static String formatTimeNowHour(String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("HH:mm");
        DateTime dateTime = DateTime.now();
        return dateFormat.print(dateTime);
    }

    public static List<FchEntity> mapTimeToNow(List<FchEntity> fchEntityList,String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        List<FchEntity> listRemove = new ArrayList<>();
        DateTime dateTimeNow = DateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        for (FchEntity fchEntity : fchEntityList){
            DateTime dateTime = new DateTime(dateFormat.parseDateTime(fchEntity.getDt()));
            if (dateTimeNow.getMillis() > dateTime.getMillis()){
                listRemove.add(fchEntity);
            }
        }
        fchEntityList.removeAll(listRemove);
        return fchEntityList;
    }

    public static List<FcdEntity> mapDateToNow(List<FcdEntity> fcdEntityList, String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTime dateTimeNow = DateTime.now();
        List<FcdEntity> listRemove = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
        for (FcdEntity fcdEntity : fcdEntityList){
            DateTime dateTime = new DateTime(dateFormat.parseDateTime(fcdEntity.getDt()));
            if (dateTimeNow.getDayOfYear() > dateTime.getDayOfYear()){
                listRemove.add(fcdEntity);
            }
        }
        fcdEntityList.removeAll(listRemove);
        return fcdEntityList;
    }
}

