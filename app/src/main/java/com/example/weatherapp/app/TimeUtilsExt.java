package com.example.weatherapp.app;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeUtilsExt {

    public static String convertTimeStampToLocalTime(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'hh:mm:ss");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa EEE");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }

    public static String convertTimeStampToTimeAdapter(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'hh:mm:ss");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }

    public static String convertTimeToDayOfWeek(String timeStamp, String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");

        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("eee");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }

    public static int endTimeProgress(long timeNow, long timeSunset, long timeSunRise) {
        if (timeNow >= timeSunset)
            return 100;
        double d1 = (timeNow - timeSunRise);
        double d2 = (timeSunset - timeSunRise);
        Double.isNaN(d2);
        d2 /= 100.0D;
        Double.isNaN(d1);
        return (int)Math.round(d1 / d2);
    }

    public static long formatStringToTime(String time ,String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("hh:mm");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(time));

        return dateTime.getMillis();
    }

    public static long formatTimeNow(String timeZone){
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("hh:mm");
        DateTime dateTime = DateTime.now();
        return dateTime.getMillis();
    }
}
