package com.example.weatherapp.widget.customwidget.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.ActivityUtils;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.weather.FcdEntity;

import java.util.List;

public class NextDayAdapter extends RecyclerView.Adapter<NextDayAdapter.ViewHolder> {
    private List<FcdEntity> fcdEntityList;
    private LayoutInflater mInflater;
    private String timeZone;
    private Context context;


    private double min;
    private double max;

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

        if (!fcdEntityList.isEmpty()){
            FcdEntity fcdEntity = fcdEntityList.get(position);
            holder.bindItem(fcdEntity);
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public void applyData(List<FcdEntity> fcdEntityList, String timeZone,int max, int min){
        this.fcdEntityList = fcdEntityList;
        this.max = max;
        this.min = min;
        this.timeZone = timeZone;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTempMax;
        TextView tvTempMin;
        ImageView imgPbDaily;
//        LottieAnimationView laDaily;
        ImageView imgDaily;
        TextView tvDaily;
        ImageView imgRain;
        TextView tvRainPercent;
        LinearLayout lnDaily;
        RelativeLayout rlDaily;

        ViewHolder(View itemView) {
            super(itemView);

            tvTempMax = itemView.findViewById(R.id.tv_temp_max);
            tvTempMin = itemView.findViewById(R.id.tv_temp_min);
            imgPbDaily = itemView.findViewById(R.id.imgPbDaily);
//            laDaily = itemView.findViewById(R.id.la_daily);
            imgDaily = itemView.findViewById(R.id.img_daily);
            tvDaily = itemView.findViewById(R.id.tv_day_daily);
            imgRain = itemView.findViewById(R.id.img_rain);
            tvRainPercent = itemView.findViewById(R.id.tv_rain_percent);
            lnDaily = itemView.findViewById(R.id.linearDaily);
            rlDaily = itemView.findViewById(R.id.rl_item_daily);
        }

        @SuppressLint("SetTextI18n")
        public void bindItem(FcdEntity fcdEntity) {
            tvTempMax.setText(fcdEntity.getTx().intValue() + "°");
            tvTempMin.setText(fcdEntity.getTn().intValue() + "°");
            float factor = itemView.getContext().getResources().getDisplayMetrics().density;

            int marginLinear = ActivityUtils.convertDpToPixel(context,70);

            LinearLayout.LayoutParams paramLinear = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            paramLinear.height = (int) ((max - min)* 6 * factor + marginLinear);
            lnDaily.setLayoutParams(paramLinear);

            LinearLayout.LayoutParams paramRelative = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            int marginTop = (int)((max - fcdEntity.getTx()) * 6 * factor );
            int marginBottom = (int)((fcdEntity.getTn() - min) * 6 * factor );
            paramRelative.setMargins(0, marginTop,0, marginBottom);
            rlDaily.setLayoutParams(paramRelative);



//            laDaily.setAnimation(IconWeatherHelper.getLottieWeather(fcdEntity.getS()));
            imgDaily.setBackgroundResource(IconWeatherHelper.getDrawableAnimation(fcdEntity.getS()));
            AnimationDrawable anim = (AnimationDrawable) imgDaily.getBackground();
            anim.start();
            tvDaily.setText(TimeUtilsExt.convertTimeToDayOfWeek(fcdEntity.getDt(), timeZone));
            int source = IconWeatherHelper.getIconPrecipitation(fcdEntity.getRhAvg());
            imgRain.setImageResource(source);
            tvRainPercent.setText(fcdEntity.getPp().intValue() + "%");
        }

    }
}
