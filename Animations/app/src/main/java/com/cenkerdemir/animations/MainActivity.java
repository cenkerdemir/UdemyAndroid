package com.cenkerdemir.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView camel1 = (ImageView) findViewById(R.id.camel1);

        camel1.animate().translationXBy(1000f).translationYBy(1000f).rotationBy(3600).setDuration(2000);

        ImageView camel2 = (ImageView) findViewById(R.id.camel2);
        //camel2.animate().alpha(1f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView camel1 = (ImageView) findViewById(R.id.camel1);
        camel1.setTranslationX(-1000f);
        camel1.setTranslationY(-1000f);
    }
}
