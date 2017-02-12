package com.cenkerdemir.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void numberGoButtonClicked(View view) {
        EditText numberToCheckAsText = (EditText) findViewById(R.id.numberEditText);

       Integer numberToCheckAsInteger = Integer.parseInt(numberToCheckAsText.getText().toString());

        Number numberToCheck = new Number();
        numberToCheck.number = numberToCheckAsInteger;

        if (numberToCheck.isSquare() && numberToCheck.isTriangle()) {
            this.setTextForTextView("Your number is both triangular and square");
        }
        else if (numberToCheck.isSquare()) {
            this.setTextForTextView("Your number is a square number");
        }
        else if (numberToCheck.isTriangle()) {
            this.setTextForTextView("Your number is a triangular number");
        }
        else {
            this.setTextForTextView("Your number is neither triangular nor square");
        }
    }

    public void setTextForTextView(String text) {
        TextView tv = (TextView) findViewById(R.id.resultLabel);
        tv.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

