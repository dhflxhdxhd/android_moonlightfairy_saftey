package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AappInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aapp_information);
    }

    public void promise03(View view) {
        Intent intent = new Intent(this,Promise02contentActivity.class);
        startActivity(intent);
    }

    public void promise01(View view) {
        Intent intent = new Intent(this,Promise01contentActivity.class);
        startActivity(intent);
    }

    public void promise02(View view) {
        Intent intent = new Intent(this,Promise03contentActivity.class);
        startActivity(intent);
    }
}
