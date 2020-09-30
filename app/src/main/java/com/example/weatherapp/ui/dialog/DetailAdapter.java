package com.example.weatherapp.ui.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherapp.R;

import java.util.List;


public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private List<WeatherDetailEntity> weatherDetailEntities;
    private LayoutInflater mInflater;
    private String timeZone;
    private Context context;

    public DetailAdapter(Context context, List<WeatherDetailEntity> weatherDetailEntities, String timeZone) {
        this.weatherDetailEntities = weatherDetailEntities;
        this.timeZone = timeZone;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_daily, parent, false);
        return new DetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherDetailEntity weatherDetailEntity = weatherDetailEntities.get(position);
        holder.bindItem(weatherDetailEntity);
    }

    @Override
    public int getItemCount() {
        return weatherDetailEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDetail;
        ImageView imgDetail;


        ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name_detail);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            imgDetail = itemView.findViewById(R.id.img_detail);

        }

        @SuppressLint("SetTextI18n")
        public void bindItem(WeatherDetailEntity weatherDetailEntity) {
            tvName.setText(weatherDetailEntity.getName());
            tvDetail.setText(weatherDetailEntity.getDetail());
            imgDetail.setImageResource(weatherDetailEntity.getImageResource());
        }

    }
}
