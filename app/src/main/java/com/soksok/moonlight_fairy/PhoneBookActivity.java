package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);
        Button btn1 = findViewById(R.id.button7);
        Button btn2 = findViewById(R.id.button8);
        Button btn3 = findViewById(R.id.button9);
        Button btn4 = findViewById(R.id.button10);
        Button btn5 = findViewById(R.id.button11);
        Button btn6 = findViewById(R.id.button12);
        Button btn7 = findViewById(R.id.button13);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:112"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:119"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:122"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:117"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:118"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:111"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:125"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });
    }
}
