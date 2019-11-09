package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Agree1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree1);
    }

    public void Agree1(View view) {
        Intent intent = new Intent ( this,Agree2Activity.class);
        startActivity(intent);
    }
}
