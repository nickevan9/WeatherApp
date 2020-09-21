package com.example.weatherapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;

import com.example.weatherapp.R;
import com.example.weatherapp.app.TypefaceProvider;


public class CustomButton extends AppCompatButton {
    public CustomButton(Context context) {
        super(context, null, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    protected void initView (){
        Typeface myTypeface = TypefaceProvider.getTypeFace(getContext(), "Montserrat-Regular");
        setTypeface(myTypeface);

        setTransformationMethod(null);
    }

    @Override
    public boolean isInEditMode() {
        return true;
    }
}
