package com.example.weatherapp.app;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class TypefaceProvider {
    private static final String TYPEFACE_FOLDER = "fonts";
    private static final String TYPEFACE_EXTENSION = ".ttf";


    private static Hashtable<String, Typeface> sTypeFaces = new Hashtable<String, Typeface>(4);

    public static Typeface getTypeFace(Context context, String fileName) {
        Typeface tempTypeface = sTypeFaces.get(fileName);

        if (tempTypeface == null) {
            String fontPath = TYPEFACE_FOLDER + '/' + fileName + TYPEFACE_EXTENSION;
            tempTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
            sTypeFaces.put(fileName, tempTypeface);
        }

        return tempTypeface;
    }
}
