package com.cenkerdemir.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int selectedNumber;

    public void guessClicked(View view) {

        EditText numberText = (EditText) findViewById(R.id.guessText);
        Integer number = Integer.parseInt(numberText.getText().toString());

        if (number > selectedNumber) {
            showToast("Lower");
        }
        else if (number < selectedNumber) {
            showToast("Higher");
        }
        else {
            showToast("You got it! Try the new number now?");
            Random rand = new Random();
            selectedNumber = rand.nextInt(20) + 1;
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();

        selectedNumber = rand.nextInt(20) + 1;
    }
}
