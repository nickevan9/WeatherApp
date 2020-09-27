package com.example.weatherapp.widget.customwidget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.R;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.FchEntity;

import java.util.List;

public class NextHourAdapter extends RecyclerView.Adapter<NextHourAdapter.ViewHolder> {

    private List<FchEntity> fchEntityList;
    private LayoutInflater mInflater;
    private String timeZone;
    private Context context;

    public NextHourAdapter(Context context, List<FchEntity> fchEntityList, String timeZone) {
        this.fchEntityList = fchEntityList;
        this.timeZone = timeZone;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_hourly, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FchEntity fchEntity = fchEntityList.get(position);
        holder.bindItem(fchEntity);

    }

    public void applyData(List<FchEntity> fchEntityList,String timeZone){
        this.fchEntityList = fchEntityList;
        this.timeZone = timeZone;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return fchEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTempHourly;
        TextView tvTimeHourly;
        LottieAnimationView laHourly;

        ViewHolder(View itemView) {
            super(itemView);
            tvTempHourly = itemView.findViewById(R.id.tv_temp_hourly);
            tvTimeHourly = itemView.findViewById(R.id.tv_time_hourly);
            laHourly = itemView.findViewById(R.id.la_hourly);

        }

        public void bindItem(FchEntity fchEntity) {
            tvTimeHourly.setText(TimeUtilsExt.convertTimeStampToTimeAdapter(fchEntity.getDt(), timeZone));
            tvTempHourly.setText(context.getString(R.string.set_temp, fchEntity.getT().toString()));
            laHourly.setAnimation(IconWeatherHelper.getLottieWeather(fchEntity.getS()));
        }
    }
}
