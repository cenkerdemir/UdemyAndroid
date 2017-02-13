package com.cenkerdemir.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView oceanVideoView = (VideoView) findViewById(R.id.waterVideoView);
        oceanVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.water);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(oceanVideoView);

        oceanVideoView.setMediaController(mediaController);

        oceanVideoView.start();
    }
}
