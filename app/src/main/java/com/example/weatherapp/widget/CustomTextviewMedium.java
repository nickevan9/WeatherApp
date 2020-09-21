package com.example.weatherapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.example.weatherapp.app.TypefaceProvider;
import androidx.appcompat.widget.AppCompatTextView;



public class CustomTextviewMedium extends AppCompatTextView {
    public CustomTextviewMedium(Context context) {
        super(context);
        initView();
    }

    public CustomTextviewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomTextviewMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    protected void initView() {
        Typeface myTypeface = TypefaceProvider.getTypeFace(getContext(), "Montserrat-Regular");
        setTypeface(myTypeface);

    }

    @Override
    public boolean isInEditMode() {
        return true;
    }
}