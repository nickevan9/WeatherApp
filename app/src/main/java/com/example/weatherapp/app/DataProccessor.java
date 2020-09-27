package com.example.weatherapp.app;

import android.content.Context;
import android.content.SharedPreferences;

import static com.example.weatherapp.app.Constant.KEY_FIRST_TIME_LAUNCH;

public class DataProccessor {

    private static Context context;

    public DataProccessor(Context context){
        this.context = context;
    }

    public final static String PREFS_NAME = "appname_prefs";

    public boolean sharedPreferenceExist(String key)
    {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        if(!prefs.contains(key)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void setInt( String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getInt(key, 0);
    }

    public static void setStr(String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStr(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(key,"DNF");
    }

    public static void setFirstTimeLaunch( boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_FIRST_TIME_LAUNCH, value);
        editor.apply();
    }

    public static boolean getFirstTimeLaunch() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getBoolean(KEY_FIRST_TIME_LAUNCH,true);
    }
}