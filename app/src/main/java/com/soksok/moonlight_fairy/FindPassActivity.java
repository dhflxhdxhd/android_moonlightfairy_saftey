package com.soksok.moonlight_fairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.app.ProgressDialog;

/*import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;*/
import androidx.annotation.NonNull;
// import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
// import android.os.Handler;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindPassActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "FindPassActivity";

    private EditText editTextUserName;
    private EditText editTextUserEmail;
    public Button buttonFind;
    public Button buttonSignIn;
    // private ProgressDialog progressDialog;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pass);

        editTextUserEmail = (EditText) findViewById(R.id.editText7);
        buttonFind = (Button) findViewById(R.id.button6);
        buttonSignIn = (Button) findViewById(R.id.button7);
        mAuth = FirebaseAuth.getInstance();
       // mHandler = new Handler();
        progressDialog = new ProgressDialog(this);



        buttonFind.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == buttonFind){
            progressDialog.setMessage("처리중입니다. 잠시 기다려 주세요...");
            progressDialog.show();
            //비밀번호 재설정 이메일 보내기
            String emailAddress = editTextUserEmail.getText().toString().trim();
            mAuth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(FindPassActivity.this, "이메일을 보냈습니다.", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                            Toast.makeText(FindPassActivity.this, "메일 보내기 실패!", Toast.LENGTH_LONG).show();
                        }
                            progressDialog.dismiss();
                        }
                    });

        }
    }



    public void SignIn3(View view) {
        Intent intent = new Intent ( this,MainActivity.class);
        startActivity(intent);
    }
}



