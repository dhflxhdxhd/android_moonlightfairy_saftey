package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button finish = (Button) findViewById(R.id.button32);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,SubmainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Accident(View view) {
        Intent intent=new Intent(this,AccidentPageActivity.class);
        startActivity(intent);
    }

    public void Phonebook(View view) {
        Intent intent=new Intent(this,PhoneBookActivity.class);
        startActivity(intent);
    }

    public void Notice(View view) {
        Intent intent=new Intent(this,NoticeOpenPageActivity.class);
        startActivity(intent);
    }



    public void Promise(View view) {
        Intent intent=new Intent(this,AappInformationActivity.class);
        startActivity(intent);
    }

    public void Logout(View view) {
        Intent intent=new Intent(this,Logout1Activity.class);
        startActivity(intent);
    }

    public void Escape(View view) {
        Intent intent=new Intent(this,CurrentActivity.class);
        startActivity(intent);
    }
}
