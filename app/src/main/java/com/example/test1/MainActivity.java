package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sPref;
    private SharedPreferences.Editor editor;
    private int totalCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sPref = getPreferences(Context.MODE_PRIVATE);
        editor = sPref.edit();
        totalCount = sPref.getInt("count",0);
        totalCount++;
        editor.putInt("count",totalCount);
        editor.commit();


        if(totalCount == 3) {
            Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_LONG).show();
            totalCount = sPref.getInt("count",0);
            totalCount = 0;
            editor.putInt("count",totalCount);
            editor.commit();
        }
    }
}