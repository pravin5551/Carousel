package com.pravin.carousel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideosAdapter adapter;
    private List<VideoDataClass> videos = new ArrayList<VideoDataClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new VideosAdapter(videos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Add sample videos (replace with your actual data)
        videos.add(new VideoDataClass("1", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&w=1200", "Video 1", 15));
        videos.add(new VideoDataClass("2", "https://drive.google.com/file/d/1B-W5zsoEp2xnFxcR6cfliiov92bJL1sf/view", "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&w=1200", "Video 2", 20));
        videos.add(new VideoDataClass("3", "https://drive.google.com/file/d/1B-W5zsoEp2xnFxcR6cfliiov92bJL1sf/view", "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&w=1200", "Video 3", 30));

        // Handle clicks on video items to open fullscreen player
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(VideoDataClass video) {
                // Open fullscreen player with the selected video
                Toast.makeText(MainActivity.this, "Clicked on " + video.getTitle(), Toast.LENGTH_SHORT).show();
                // ... (implement fullscreen player logic)
            }
        });

        // Add a scroll listener for smooth scrolling and highlighting
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
                    adapter.setCurrentHighlightedPosition(firstVisiblePosition);
                }
            }
        });
    }

    // ... (other methods)
}
