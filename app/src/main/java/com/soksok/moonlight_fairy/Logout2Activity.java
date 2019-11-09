package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Logout2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout2);
    }


    public void Logout(View view) {
        Toast.makeText(Logout2Activity.this, "로그아웃되었습니다." ,Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
