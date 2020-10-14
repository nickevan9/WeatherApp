package com.example.weatherapp.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.app.RxBus;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity  extends DaggerAppCompatActivity {

    public DataProccessor dataProccessor;

    protected abstract void initView();

    protected abstract void dataCreate();
    public CompositeDisposable disposable ;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        disposable = new CompositeDisposable();
        dataProccessor = new DataProccessor(this);
        dataCreate();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.unregister(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        RxBus.unregister(this);
        disposable.clear();
    }
}
