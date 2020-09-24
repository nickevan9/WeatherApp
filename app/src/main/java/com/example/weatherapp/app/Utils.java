package com.example.weatherapp.app;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Utils {

    public static String convertTimeStampToLocalTime(String timeStamp, String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'hh:mm:ss");
        DateTime dateTime = new DateTime(dateFormat.parseDateTime(timeStamp));

        DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm aa EEE");
        String timeAfter = fmt.print(dateTime);
        return timeAfter;
    }
}
