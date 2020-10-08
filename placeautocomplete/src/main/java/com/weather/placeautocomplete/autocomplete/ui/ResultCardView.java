package com.weather.placeautocomplete.autocomplete.ui;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.weather.placeautocomplete.R;


public class ResultCardView extends ResultView {

  public ResultCardView(@NonNull Context context) {
    this(context, null);
  }

  public ResultCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, -1);
  }

  public ResultCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  void inflateView(Context context) {
    inflate(context, R.layout.mapbox_view_card_results, this);
  }
}
