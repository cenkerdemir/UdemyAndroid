package com.cenkerdemir.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000) { // destroyed when finished
            public void onTick(long millisecondsUntilDone) {
                //every tick while counting down
                Log.i("seconds left: ", String.valueOf(millisecondsUntilDone/1000));
            }

            public void onFinish() {
                //countdown is finished
                Log.i("countdown finished, ", "yes!");
            }

        }.start();

        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                // insert the code to be run every second

                Log.i("runnable has run!", "one second must have passed!");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
        */
    }
}
