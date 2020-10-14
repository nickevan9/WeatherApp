package com.example.weatherapp.widget.customwidget.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.ChangeSettingEntity;

public class ChangeSettingAdapter extends RecyclerView.Adapter<ChangeSettingAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgChangeSetting;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChangeSetting = itemView.findViewById(R.id.img_change_setting);
        }

        public void bindItem(ChangeSettingEntity changeSettingEntity){

        }
    }
}
