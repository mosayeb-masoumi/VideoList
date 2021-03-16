package com.example.videolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    List<String> links;
    Context context;


    public VideoAdapter(List<String> links, Context context) {
        this.links = links;
        this.context = context;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        String model = links.get(position);
        holder.bindData(model,position);
        holder.setOnVideoHolderListener(listener, model, position , context);
    }



    private VideoItemInteraction listener = null;
    public void setListener(VideoItemInteraction listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return links.size();
    }
}
