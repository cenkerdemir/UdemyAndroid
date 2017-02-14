package com.cenkerdemir.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mPlayer;
    public AudioManager aManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(this, R.raw.creep);
        aManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //volume control
        int maxVolume = aManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = aManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("SeekBar's value: ", String.valueOf(i));
                aManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //navigation control
        int maxLength = mPlayer.getDuration();
        int currentPosition = mPlayer.getCurrentPosition();

        final SeekBar navigationControl = (SeekBar) findViewById(R.id.seekBarNav);
        navigationControl.setMax(maxLength);
        navigationControl.setProgress(currentPosition);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                navigationControl.setProgress(mPlayer.getCurrentPosition());
            }
        }, 0, 100);

        navigationControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void playSound(View view) {
        mPlayer.start();
    }

    public void pauseSound(View view) {
        mPlayer.pause();
    }
}
