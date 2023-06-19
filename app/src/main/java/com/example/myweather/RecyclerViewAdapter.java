package com.example.myweather;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Activity activity;

    ArrayList<WeatherModel> posts;

    public RecyclerViewAdapter(Activity activity, ArrayList<WeatherModel> posts) {
        this.activity = activity;
        this.posts = posts;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView timeTv,dateTv, cityTv, tempTv, descTv, windTv, humidityTv, pressureTv;

        EditText locationEt;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTv = itemView.findViewById(R.id.dateTv);
            timeTv= itemView.findViewById(R.id.timeTv);
            cityTv = itemView.findViewById(R.id.cityTv);
            tempTv = itemView.findViewById(R.id.tempTv);
            descTv = itemView.findViewById(R.id.descTv);
            windTv = itemView.findViewById(R.id.windTv);
            humidityTv = itemView.findViewById(R.id.humidityTv);
            pressureTv = itemView.findViewById(R.id.pressureTv);
            imageView = itemView.findViewById(R.id.imageView);
            locationEt = itemView.findViewById(R.id.locationEt);
        }
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View listItem = layoutInflater.inflate(R.layout.activity_weather,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.dateTv.setText(posts.get(position).getDt());

        holder.timeTv.setText(posts.get(position).getTime());

        holder.tempTv.setText(posts.get(position).getTemp());

        String imageUrl = posts.get(position).getImageUrl();

        if (imageUrl != null && imageUrl.length() > 0) {
            Picasso.get().load(imageUrl).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    public void setPosts(ArrayList<WeatherModel> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }
}


