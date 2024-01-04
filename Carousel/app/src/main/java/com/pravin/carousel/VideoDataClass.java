package com.pravin.carousel;

public class VideoDataClass {

    private String id; // Unique identifier for the video
    private String url; // The URL of the video stream
    private String imageUrl; // URL of the video thumbnail image
    private String title; // Title of the video
    private int duration; // Video duration in seconds (optional)

    public VideoDataClass(String id, String url, String imageUrl, String title, int duration) {
        this.id = id;
        this.url = url;
        this.imageUrl = imageUrl;
        this.title = title;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    // You can add other methods as needed, such as formatting the duration
}

