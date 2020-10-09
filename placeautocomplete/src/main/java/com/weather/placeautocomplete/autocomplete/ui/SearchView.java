package com.weather.placeautocomplete.autocomplete.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.weather.placeautocomplete.R;


public class SearchView extends LinearLayout implements ImageButton.OnClickListener, TextWatcher,
        LifecycleObserver {

  @Nullable
  private QueryListener queryListener;

  private final ImageView backButton;
  private final ImageView clearButton;
  private final EditText searchEditText;

  public SearchView(@NonNull Context context) {
    this(context, null);
  }

  public SearchView(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, -1);
  }

  public SearchView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    inflate(context, R.layout.mapbox_view_search, this);
    backButton = findViewById(R.id.button_search_back);
    clearButton = findViewById(R.id.button_search_clear);
    searchEditText = findViewById(R.id.edittext_search);
    initialize();
  }

  private void initialize() {
    backButton.setOnClickListener(this);
    clearButton.setOnClickListener(this);
    searchEditText.addTextChangedListener(this);
    ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
  }

  @Override
  public void onClick(View view) {
    if (view.getId() == R.id.button_search_back) {

    } else {
      searchEditText.getText().clear();
    }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy() {
    queryListener = null;
  }

  public void setHint(String hint) {
    searchEditText.setHint(hint);
  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    if (queryListener != null) {
      queryListener.onQueryChange(charSequence);
    }
    clearButton.setVisibility(charSequence.length() > 0 ? View.VISIBLE : INVISIBLE);
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    // Not used
  }

  @Override
  public void afterTextChanged(Editable editable) {
  }

  public void setQueryListener(@Nullable QueryListener queryListener) {
    this.queryListener = queryListener;
  }

  public interface QueryListener {
    void onQueryChange(CharSequence charSequence);
  }

}