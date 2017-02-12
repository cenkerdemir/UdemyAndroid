package com.cenkerdemir.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        Integer number = 0;

        public boolean isTriangular(){
            Integer x = 1;
            while (x*(x+1) <= number*2) {
                if (x*(x+1) == number*2) {
                    return true;
                }
                x++;
            }
            return false;
        }

        public boolean isSquare(){
            Integer x = 1;
            while (x*x <= number) {
                if (x*x == number) {
                    return true;
                }
                x++;
            }
            return false;
        }
    }

    public void numberGoButtonClicked(View view) {
        String message = "";

        EditText numberToCheckAsText = (EditText) findViewById(R.id.numberEditText);

        try {
            Integer numberToCheckAsInteger = Integer.parseInt(numberToCheckAsText.getText().toString());

            Number numberToCheck = new Number();
            numberToCheck.number = numberToCheckAsInteger;

            if (numberToCheck.isSquare() && numberToCheck.isTriangular()) {
                message = "Your number is both triangular and square";
            } else if (numberToCheck.isSquare()) {
                message = "Your number is a square number";
            } else if (numberToCheck.isTriangular()) {
                message = "Your number is a triangular number";
            } else {
                message = "Your number is neither triangular nor square";
            }
        }
        catch (Exception e) {
            message = "Please enter a number";
            Log.i("error occured", e.getMessage());
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}

