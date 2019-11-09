package com.soksok.moonlight_fairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EscapePage1Activity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;


    private Button EscapeOkay;
    private Button EscapeNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape_page1);

        EscapeOkay = (Button) findViewById(R.id.button16);
        EscapeNo = (Button) findViewById(R.id.button17);

        firebaseAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View v) {

        //회원탈퇴를 클릭하면 회원정보를 삭제한다. 삭제전에 컨펌창을 하나 띄워야 겠다.
        Button view = null;

        if(view == EscapeOkay ) {
            AlertDialog.Builder alert_confirm = new AlertDialog.Builder(EscapePage1Activity.this);
            alert_confirm.setMessage("정말 계정을 삭제 할까요?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {

                @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            user.delete()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(EscapePage1Activity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                            finish();

                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        }
                                    });
                        }
                    }
            );
            alert_confirm.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(EscapePage1Activity.this, "취소", Toast.LENGTH_LONG).show();
                }
            });
            alert_confirm.show();
        }
    }

    public void EscapeNo(View view) {
        Intent intent = new Intent ( this,MainActivity.class);
        startActivity(intent);
    }
}


// 회원탈퇴 확인 필요.
