package com.example.weatherapp.widget.customwidget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.data.model.PrecipitationEntity;

import java.util.List;

public class PrecipitationAdapter extends RecyclerView.Adapter<PrecipitationAdapter.ViewHolder> {

    private List<PrecipitationEntity> precipitationEntityList;
    private Context context;
    private LayoutInflater mInflater;

    public PrecipitationAdapter(Context context, List<PrecipitationEntity> precipitationEntities) {
        this.precipitationEntityList = precipitationEntities;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_precipitation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!precipitationEntityList.isEmpty()) {
            PrecipitationEntity precipitationEntity = precipitationEntityList.get(position);
            holder.bindItem(precipitationEntity);
        }
    }

    public void applyData(List<PrecipitationEntity> precipitationEntity) {
        this.precipitationEntityList = precipitationEntity;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return precipitationEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvRainPercent;
        public ImageView imgRain;
        public TextView tvPart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRainPercent = itemView.findViewById(R.id.tv_rain_percent);
            imgRain = itemView.findViewById(R.id.img_rain);
            tvPart = itemView.findViewById(R.id.tv_part);
        }

        public void bindItem(PrecipitationEntity precipitationEntity) {

            tvRainPercent.setText(precipitationEntity.getRainPercent() + "%");
            int source = IconWeatherHelper.getIconPrecipitation(precipitationEntity.getRainPercent());
            imgRain.setImageResource(source);

            tvPart.setText(precipitationEntity.getName());
        }
    }
}


