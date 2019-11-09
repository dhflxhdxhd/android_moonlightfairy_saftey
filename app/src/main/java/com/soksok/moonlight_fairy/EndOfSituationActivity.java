package com.soksok.moonlight_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndOfSituationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_situation);
    }

    public void Ok1(View view) {
        Intent intent = new Intent ( this,SubmainActivity.class);
        startActivity(intent);
    }
}
