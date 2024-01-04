package com.pravin.carousel;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class VideosAdapter extends RecyclerView.Adapter<VideoItemViewHolder> {

    public List<VideoDataClass> videos;
    private OnItemClickListener onItemClickListener;

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

    @Override
    public void onBindViewHolder(@NonNull VideoItemViewHolder holder, int position) {
        VideoDataClass video = videos.get(position);
        holder.getVideoTitle().setText(video.getTitle());

        // Set thumbnail and prepare ExoPlayer for the video
        // ...

        // Implement logic for playing/pausing video based on visibility
        // ...

        // Handle clicks on like, comment, and share buttons
        // ...

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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }




    @Override
    public int getItemCount() {
        return videos.size();
    }
}

