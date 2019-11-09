package com.soksok.moonlight_fairy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.soksok.moonlight_fairy.model.NotificationModel;
import com.soksok.moonlight_fairy.model.UserModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SubmainActivity extends AppCompatActivity {

    MediaPlayer player;
    Button sirenBtn;
    Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);

       sirenBtn = (Button) findViewById(R.id.button17);
       stopBtn = (Button) findViewById(R.id.button16);

    sirenBtn.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick (View view){
        player = MediaPlayer.create(SubmainActivity.this, R.raw.siren);
        player.start();
    }
    });
            stopBtn.setOnClickListener(new View.OnClickListener()
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



    void sendFcm() {
        UserModel destinationuserModel = new UserModel();

        //EditText input_text = (EditText)findViewById(R.id.test);

        Gson gson = new Gson();
        NotificationModel notificationModel = new NotificationModel();

        String userName = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();

        notificationModel.to ="fWTUf0n1Yy0:APA91bEVpi3GZLD-IF1aHMKGjqPoaQomx6aPM3_EQaNZfC4BSToeeIM_jyJjZ4oj_hurfHLeK5E4OzFJamtuujUeoIYwSOlPAfjAOFfBeSHtdUNvSvvpQRamLhIgGPN9a-aMFXOX9CkY";

        notificationModel.notification.title = userName;
        notificationModel.notification.text = "300m 이내에서 도움을 요청하고 있습니다!!";
                //input_text.getText().toString() ;

        RequestBody requestBody = RequestBody.create( gson.toJson(notificationModel),MediaType.parse("application/json; charset=utf8"));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("Authorization", "key=AIzaSyBHDyanZS5NfT3Myg8mK7igjaULodQ1-XM")
                .url("https://fcm.googleapis.com/fcm/send")
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }


        });
    }

    void send1Fcm() {
        UserModel destinationuserModel = new UserModel();

        //EditText input_text = (EditText)findViewById(R.id.test);

        Gson gson = new Gson();
        NotificationModel notificationModel = new NotificationModel();

        String userName = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();

        notificationModel.to = "fWTUf0n1Yy0:APA91bEVpi3GZLD-IF1aHMKGjqPoaQomx6aPM3_EQaNZfC4BSToeeIM_jyJjZ4oj_hurfHLeK5E4OzFJamtuujUeoIYwSOlPAfjAOFfBeSHtdUNvSvvpQRamLhIgGPN9a-aMFXOX9CkY";
        notificationModel.notification.title = userName;
        notificationModel.notification.text = "살려주세요!!!!!!!!!!!!";
        //input_text.getText().toString() ;

        RequestBody requestBody = RequestBody.create( gson.toJson(notificationModel),MediaType.parse("application/json; charset=utf8"));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("Authorization", "key=AIzaSyBHDyanZS5NfT3Myg8mK7igjaULodQ1-XM")
                .url("https://fcm.googleapis.com/fcm/send")
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }


        });
    }

    void send2Fcm() {
        UserModel destinationuserModel = new UserModel();

        //EditText input_text = (EditText)findViewById(R.id.test);

        Gson gson = new Gson();
        NotificationModel notificationModel = new NotificationModel();

        String userName = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();

        notificationModel.to = "fWTUf0n1Yy0:APA91bEVpi3GZLD-IF1aHMKGjqPoaQomx6aPM3_EQaNZfC4BSToeeIM_jyJjZ4oj_hurfHLeK5E4OzFJamtuujUeoIYwSOlPAfjAOFfBeSHtdUNvSvvpQRamLhIgGPN9a-aMFXOX9CkY";
        notificationModel.notification.title = userName;
        notificationModel.notification.text = "절 좀 찾아주세요!! 당신의 손길이 필요합니다!!";
        //input_text.getText().toString() ;

        RequestBody requestBody = RequestBody.create( gson.toJson(notificationModel),MediaType.parse("application/json; charset=utf8"));
        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .addHeader("Authorization", "key=AIzaSyBHDyanZS5NfT3Myg8mK7igjaULodQ1-XM")
                .url("https://fcm.googleapis.com/fcm/send")
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }


        });
    }


    public void Sos1 (View view){

            sendFcm();

       /*Location locationA = new Location("point A");

       locationA.setLatitude(33.454588);
       locationA.setLongitude(126.563564);


       Location locationB = new Location("point B");

       locationB.setLatitude(33.4547661);
       locationB.setLongitude(126.5655786);

       float distance = locationA.distanceTo(locationB);

       Log.d("TAG", "거리정보 : " + distance + " m");
       Toast.makeText(SubmainActivity.this, "거리정보가 확인되었습니다.", Toast.LENGTH_SHORT).show();*/


            Intent intent = new Intent(this, DangerActivity.class);
             startActivity(intent);

        }
        public void Police1 (View view){
            send1Fcm();
            Intent intent = new Intent(this, DangerActivity.class);
            startActivity(intent);
        }



        public void Other1 (View view){

            send2Fcm();
            Intent intent = new Intent(this, DangerActivity.class);
            startActivity(intent);
        }

        public void GoMenu (View view){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }

    }




