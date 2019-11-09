package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

// 이메일  , 비밀번호 유효성 검사

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth; //이메일 로그인 변수
    private FirebaseUser currentUser; // 현재 로그인된 유저정보를 담을 변수.
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance(); //onCreate() 메소드에서 FirebaseAuth 인스턴스를 초기화.

        //이름
        final EditText nameTxt = (EditText) findViewById(R.id.editText3);
        //이메일
        final EditText emailTxt = (EditText) findViewById(R.id.editText4);
        //비밀번호
        final EditText pwTxt = (EditText) findViewById(R.id.editText5);
        //버튼
        Button joinBtn = (Button) findViewById(R.id.button4);
        btn = findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //버튼이 눌렀을 때
        joinBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = nameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String password = pwTxt.getText().toString();


                // Toast.makeText(SignUpActivity.this, name + "님" + email + "로 회원가입 성공하셨습니다.", Toast.LENGTH_SHORT).show();


                //가입 성공했을 때 -> 로그인 창으로 가기

                //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                //startActivityForResult(signInIntent, 100);Toast.makeText(AuthActivity.this,"btn",Toast.LENGTH_SHORT).show();
                //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                // startActivityForResult(signInIntent, 100);

                SignUpStart(name, email, password);

            }
        });
    }


    public void SignUpStart(final String name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (!task.isSuccessful()) {
                            try {
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                Toast.makeText(SignUpActivity.this, "비밀번호가 간단해요..", Toast.LENGTH_SHORT).show();
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                Toast.makeText(SignUpActivity.this, "email 형식에 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                            } catch (FirebaseAuthUserCollisionException e) {
                                Toast.makeText(SignUpActivity.this, "이미존재하는 email 입니다.", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(SignUpActivity.this, "다시 확인해주세요..", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            currentUser = mAuth.getCurrentUser();

                           // Toast.makeText(SignUpActivity.this, "가입 성공  " + name + currentUser.getEmail() + "/" + currentUser.getUid(), Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(SignUpActivity.this, Agree1Activity.class));
                            finish();
                        }
                    }
                });

    }
}


