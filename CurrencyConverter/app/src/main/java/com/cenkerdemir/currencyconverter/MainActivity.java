package com.cenkerdemir.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        EditText currencyText = (EditText) findViewById(R.id.currencyEditText);
        Double amount = Double.parseDouble(currencyText.getText().toString());
        Double conversionRate = 3.8;
        Double convertedAmount = amount * conversionRate;

        Toast.makeText(this, String.format("%.2f ", convertedAmount) + "Turkish Liras", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
