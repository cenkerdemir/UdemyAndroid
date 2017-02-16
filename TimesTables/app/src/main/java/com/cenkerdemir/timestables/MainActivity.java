package com.cenkerdemir.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTablesSeekBar = (SeekBar) findViewById(R.id.seekBar);
        timesTablesSeekBar.setMax(19);

        int position = timesTablesSeekBar.getProgress() + 1;
        showTimesTable(position);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                showTimesTable(i+1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void showTimesTable(int base) {
        ArrayList<Integer> timesTableArrayList = new ArrayList<Integer>();
        for (int i=0; i<10; i++ ) {
            timesTableArrayList.add(base * (i + 1));
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, timesTableArrayList);
        ListView timesTableListview = (ListView) findViewById(R.id.timesTableListView);
        timesTableListview.setAdapter(arrayAdapter);
    }
}
