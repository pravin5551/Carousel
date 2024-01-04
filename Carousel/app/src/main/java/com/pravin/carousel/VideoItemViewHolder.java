package com.pravin.carousel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.SimpleExoPlayer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageButton;
import android.widget.VideoView;

public class VideoItemViewHolder extends RecyclerView.ViewHolder {

    private VideoView videoView;
    private ImageView videoThumbnail;
    private TextView videoTitle;
    private ImageButton likeButton, commentButton, shareButton;
    private SimpleExoPlayer exoPlayer;

    public VideoItemViewHolder(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.videoView);
        videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
        videoTitle = itemView.findViewById(R.id.videoTitle);
        likeButton = itemView.findViewById(R.id.likeButton);
        commentButton = itemView.findViewById(R.id.commentButton);
        shareButton = itemView.findViewById(R.id.shareButton);

        // Initialize ExoPlayer here
        exoPlayer = new SimpleExoPlayer.Builder(itemView.getContext()).build();
    }

    // Methods to play/pause video, handle clicks, etc.

    public VideoView getVideoView() {
        return videoView;
    }

    public ImageView getVideoThumbnail() {
        return videoThumbnail;
    }

    public TextView getVideoTitle() {
        return videoTitle;
    }

    public ImageButton getLikeButton() {
        return likeButton;
    }

    public ImageButton getCommentButton() {
        return commentButton;
    }

    public ImageButton getShareButton() {
        return shareButton;
    }

    public SimpleExoPlayer getExoPlayer() {
        return exoPlayer;
    }
}

