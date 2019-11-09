package com.soksok.moonlight_fairy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Agree2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree2);

        Button agreeBtn = (Button)findViewById(R.id.button10);

        agreeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("달빛요정");
        builder.setMessage("회원가입에 성공하였습니다.");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent ( Agree2Activity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.\n 회원가입창으로 돌아갑니다.",Toast.LENGTH_LONG).show();

// 시간차를 두면 더 좋겠다......
                        Intent intent = new Intent ( Agree2Activity.this,SignUpActivity.class);
                        startActivity(intent);
                    }

                }
                );
        builder.show();
    }
}



