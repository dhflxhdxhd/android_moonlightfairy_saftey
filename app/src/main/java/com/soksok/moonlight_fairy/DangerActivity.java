package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DangerActivity extends AppCompatActivity {
    MediaPlayer player;
    Button siren1Btn;
    Button stop1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danger);

        siren1Btn = (Button) findViewById(R.id.button25);
        stop1Btn = (Button) findViewById(R.id.button18);

        siren1Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                player = MediaPlayer.create(DangerActivity.this, R.raw.siren);
                player.start();
            }
        });
        stop1Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                player.stop();
                player.reset();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player != null){
            player.release();
            player = null;

        }
    }


    public void Finish1(View view) {
        Intent intent = new Intent ( this,EndOfSituationActivity.class);
        startActivity(intent);
    }

    public void CallNumber(View view) {
        Intent intent = new Intent ( this,PhoneBookActivity.class);
        startActivity(intent);
    }
}
