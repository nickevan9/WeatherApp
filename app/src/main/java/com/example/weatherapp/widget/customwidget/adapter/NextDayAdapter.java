package com.example.weatherapp.widget.customwidget.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.R;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.weather.FcdEntity;

import java.util.List;

public class NextDayAdapter extends RecyclerView.Adapter<NextDayAdapter.ViewHolder> {
    private List<FcdEntity> fcdEntityList;
    private LayoutInflater mInflater;
    private String timeZone;
    private Context context;

    public NextDayAdapter(Context context, List<FcdEntity> fcdEntityList, String timeZone) {
        this.fcdEntityList = fcdEntityList;
        this.timeZone = timeZone;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_daily, parent, false);
        return new NextDayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FcdEntity fcdEntity = fcdEntityList.get(position);
        holder.bindItem(fcdEntity);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public void applyData(List<FcdEntity> fcdEntityList, String timeZone){
        this.fcdEntityList = fcdEntityList;
        this.timeZone = timeZone;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTempMax;
        TextView tvTempMin;
        ImageView imgPbDaily;
        LottieAnimationView laDaily;
        TextView tvDaily;
        ImageView imgRain;
        TextView tvRainPercent;

        ViewHolder(View itemView) {
            super(itemView);

            tvTempMax = itemView.findViewById(R.id.tv_temp_max);
            tvTempMin = itemView.findViewById(R.id.tv_temp_min);
            imgPbDaily = itemView.findViewById(R.id.imgPbDaily);
            laDaily = itemView.findViewById(R.id.la_daily);
            tvDaily = itemView.findViewById(R.id.tv_day_daily);
            imgRain = itemView.findViewById(R.id.img_rain);
            tvRainPercent = itemView.findViewById(R.id.tv_rain_percent);
        }

        @SuppressLint("SetTextI18n")
        public void bindItem(FcdEntity fcdEntity) {
            tvTempMax.setText(fcdEntity.getTx().intValue() + "°");
            tvTempMin.setText(fcdEntity.getTn().intValue() + "°");

            float factor = itemView.getContext().getResources().getDisplayMetrics().density;
            LinearLayout.LayoutParams paramImg = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            paramImg.height = (int) ((fcdEntity.getTx() - fcdEntity.getTn()) * 8 * factor);
            paramImg.width = (int) (5 * factor);
            imgPbDaily.setLayoutParams(paramImg);

            laDaily.setAnimation(IconWeatherHelper.getLottieWeather(fcdEntity.getS()));
            tvDaily.setText(TimeUtilsExt.convertTimeToDayOfWeek(fcdEntity.getDt(), timeZone));
            int source = IconWeatherHelper.getIconPrecipitation(fcdEntity.getPr());
            imgRain.setImageResource(source);
            tvRainPercent.setText(fcdEntity.getPr().intValue() + "%");
        }

    }
}
