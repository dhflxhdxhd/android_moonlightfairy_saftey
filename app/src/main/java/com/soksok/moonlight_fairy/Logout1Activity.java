package com.soksok.moonlight_fairy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

    public class Logout1Activity extends AppCompatActivity {
        private FirebaseAuth firebaseAuth;

        public Button logoutOkay;
        public Button logoutNo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_logout1);

            logoutOkay = (Button) findViewById(R.id.button19);
            logoutNo = (Button) findViewById(R.id.button20);

            firebaseAuth = FirebaseAuth.getInstance();
        }


        public void LogoutOkay(View view) {

            firebaseAuth.signOut();
            finish();
            Intent intent=new Intent(this,Logout2Activity.class);
            startActivity(intent);

        }


        public void LogoutNo(View view) {
            Intent intent=new Intent(this,SubmainActivity.class);
            startActivity(intent);
        }
    }


