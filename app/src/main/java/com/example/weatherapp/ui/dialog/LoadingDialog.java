package com.example.weatherapp.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.weatherapp.R;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog mDialog;
    private TextView tvStatusDialog;
    private View view;

    public AlertDialog getmDialog() {
        return mDialog;
    }


    public LoadingDialog(Activity activity) {
        this.activity = activity;

        view = activity.getLayoutInflater().inflate(R.layout.dialog_loading, null);

        tvStatusDialog = view.findViewById(R.id.tv_progress);


        mDialog = new AlertDialog.Builder(activity).create();
        mDialog.setView(view);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setCanceledOnTouchOutside(false);
    }

    public void startLoading(int statusLoading) {
        if (statusLoading == 0) {
            tvStatusDialog.setText(activity.getString(R.string.syncing_server));
        } else {
            tvStatusDialog.setText(activity.getString(R.string.syncing_database));
        }
        mDialog.show();
    }

    public void dismissDialog() {
        mDialog.dismiss();
    }


}
