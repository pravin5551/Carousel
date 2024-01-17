package com.pravin.carousel;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class VideosAdapter extends RecyclerView.Adapter<VideoItemViewHolder> {

    private List<VideoDataClass> videos;
    private OnItemClickListener onItemClickListener;
    private int highlightedPosition = 0;  // Track the currently highlighted video position

    public VideosAdapter(List<VideoDataClass> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new VideoItemViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull VideoItemViewHolder holder, int position) {
        VideoDataClass video = videos.get(position);
        holder.getVideoTitle().setText(video.getTitle());

        // Set thumbnail and prepare ExoPlayer for the video (implementation omitted for brevity)
        holder.getVideoView().setVideoPath(video.getUrl());
        // Set the thumbnail image
        Glide.with(holder.itemView.getContext())
                .load(video.getImageUrl())
                .into(holder.getVideoThumbnail());


        // Highlight the currently visible video
        if (position == highlightedPosition) {
            holder.itemView.setScaleX(1.1f);  // Slightly increase size for highlighting
            holder.itemView.setScaleY(1.1f);
        } else {
            holder.itemView.setScaleX(1.0f);
            holder.itemView.setScaleY(1.0f);
        }

        // Add a subtle fade-in animation for smoother transitions
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(200);
        fadeIn.setFillAfter(true);
        holder.itemView.startAnimation(fadeIn);

        // Handle clicks on the entire video item (fullscreen logic omitted)
        // Handle clicks on the entire video item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void
            onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(video);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    // ... (other methods)

    // Update the highlighted position and notify adapter
    public void setCurrentHighlightedPosition(int position) {
        this.highlightedPosition = position;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

