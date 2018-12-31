package com.example.dell.androidramp_up;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        progressBar = findViewById(R.id.progressVV);
        videoView = findViewById(R.id.videoView);
        Button play = findViewById(R.id.playVideo);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        String uriPath = "https://www.demonuts.com/Demonuts/smallvideo.mp4";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        videoView.start();
                        progressBar.setVisibility(View.GONE);
                    }
                }, 2000);
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
