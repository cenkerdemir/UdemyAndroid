package com.cenkerdemir.gridlayoutdemo;

import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view) {
        int id = view.getId();
        String ourId = "";
        ourId = getResources().getResourceEntryName(id);
        int resourceId = getResources().getIdentifier(ourId, "raw", getPackageName());

        MediaPlayer mPlayer = MediaPlayer.create(this, resourceId);
        mPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
