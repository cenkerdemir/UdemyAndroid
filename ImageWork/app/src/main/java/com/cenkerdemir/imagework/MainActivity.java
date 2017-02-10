package com.cenkerdemir.imagework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public boolean buttonClicked = false;

    public void catButtonClicked(View view) {
        ImageView catImageView = (ImageView) findViewById(R.id.catImageView);
        if (buttonClicked == false) {
            catImageView.setImageResource(R.drawable.cat2);
            buttonClicked = true;
        }
        else {
            catImageView.setImageResource(R.drawable.cat);
            buttonClicked = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
