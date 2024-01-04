package com.pravin.carousel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideosAdapter adapter;
    private List<VideoDataClass> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new VideosAdapter(videos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Add some sample videos (replace with your actual data)
        videos.add(new VideoDataClass("1", "https://v1.cdnpk.net/videvo_files/video/premium/video0291/large_watermarked/_Retro2_preview.mp4", "https://thumbnail-url-1", "Video 1", 15));
        videos.add(new VideoDataClass("2", "https://v1.cdnpk.net/videvo_files/video/premium/video0291/large_watermarked/_Retro2_preview.mp4", "https://thumbnail-url-2", "Video 2", 20));
        videos.add(new VideoDataClass("3", "https://v1.cdnpk.net/videvo_files/video/premium/video0291/large_watermarked/_Retro2_preview.mp4", "https://thumbnail-url-3", "Video 3", 30));

        // Set up item decoration for spacing
        // ... (implement your desired spacing logic)

        // Handle clicks on video items to open fullscreen player
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(VideoDataClass video) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release ExoPlayer instances to avoid memory leaks
        for (int i = 0; i < adapter.getItemCount(); i++) {
            VideoItemViewHolder holder = (VideoItemViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
            if (holder != null) {
//                holder.releasePlayer();
            }
        }
    }
}
