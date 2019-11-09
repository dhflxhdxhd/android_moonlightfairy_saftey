package com.soksok.moonlight_fairy;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Double lat;
    public Double lng;
    public static LocationListener context;
    LocationManager lm;

    private android.widget.ListView ListView;
    private ArrayAdapter<String> adapter;
    List<Object> Array = new ArrayList<>();

    //이메일 비밀번호 로그인 모듈 변수
    private FirebaseAuth mAuth;
    private FirebaseUser currentuser;
    private Button joinBtn;
    //현재 로그인 된 유저 정보를 담을 변수
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public String msg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance(); //이메일 비밀번호 로그인 모듈 변수

        //이메일
        final EditText emailTxt = (EditText) findViewById(R.id.editText);

        //비밀번호
        final EditText pwTxt = (EditText) findViewById(R.id.editText2);
        //LogIn
        final Button joinBtn = (Button) findViewById(R.id.button);
        //비밀번호 찾기
        Button FindPass = (Button) findViewById(R.id.button2);
        //회원가입하러가기
        Button SignUp = (Button) findViewById(R.id.button3);

        // LocationManager 참조 객체
        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        initFireBase();

        //로그인 버튼이 눌렸을 때
        joinBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String email = emailTxt.getText().toString();
                databaseReference.child("message").child("email").push().setValue(email);

                String password = pwTxt.getText().toString();
                loginStart(email, password);




                Log.d("TAG", "수신 시작");
                try{
                        // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                                5000, // 통지사이의 최소 시간간격 (miliSecond)
                                1, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);
                        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                                5000, // 통지사이의 최소 시간간격 (miliSecond)
                                1, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);
//                    else{
//                        Log.d("TAG", "위치정보 미수신중");
//                        lm.removeUpdates(mLocationListener);  //  미수신할때는 반드시 자원해체를 해주어야 한다.
//                    }
                }catch(SecurityException ex){
                }

            }

        });
//
    }





    public final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.

            Log.d("test", "onLocationChanged, location:" + location);
            double longitude = location.getLongitude(); //경도
            double latitude = location.getLatitude();   //위도
            double altitude = location.getAltitude();   //고도
            float accuracy = location.getAccuracy();    //정확도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.
            Log.d("LOOOOOOOOOO", "위치정보 : " + provider + "\n경도 : " + longitude + "\n위도 : " + latitude
                    + "\n고도 : " + altitude + "\n정확도 : "  + accuracy);

            lat = latitude; //위도
            lng = longitude; //경도


            //users 차일드에 값 추가
            databaseReference.child("Users").child("EV3lKvaf6oMJZGpOJQJmriqal5s1").child("lat").setValue(lat); // set value 나중에 수정
            databaseReference.child("Users").child("EV3lKvaf6oMJZGpOJQJmriqal5s1").child("lng").setValue(lng);
            databaseReference.child("Users").child("EV3lKvaf6oMJZGpOJQJmriqal5s1").child("UID").setValue("EV3lKvaf6oMJZGpOJQJmriqal5s1");

            //location 차일드에 값 추가
            databaseReference.child("location").child("lat").child("EV3lKvaf6oMJZGpOJQJmriqal5s1").setValue(lat); // set value 나중에 수정
            databaseReference.child("location").child("lng").child("EV3lKvaf6oMJZGpOJQJmriqal5s1").setValue(lng);
        }
        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d("test", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d("test", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d("test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }
    };

    private void initFireBase() {
        if(firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true); //파이어베이스 관련 젤 처음에 와야함
            databaseReference = firebaseDatabase.getReference("1234567"); // 레퍼런스 UID로..
        }
    }


    //public Boolean check;
    public void loginStart(String email, String password){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Toast.makeText(MainActivity.this,"mAuth. onComplete 함수" ,Toast.LENGTH_SHORT).show();

                if (!task.isSuccessful()) {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidCredentialsException e) {

// 이메일 유효성이랑 비밀번호 유효성 나누고 싶어요!

                        Toast.makeText(MainActivity.this, "존재하지 않는 이메일이거나 비밀번호입니다. ", Toast.LENGTH_SHORT).show();
                    } catch (FirebaseNetworkException e) {
                        Toast.makeText(MainActivity.this, "Firebase NetworkException", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Exception", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    // Log.d("!!!", "onComplete: "+ mAuth.getCurrentUser().getUid());
                    currentuser = mAuth.getCurrentUser();
                    passPush();
                    Toast.makeText(MainActivity.this, "로그인 성공" ,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, SubmainActivity.class);
                    startActivity(intent);

                }
            }
        });
    }

    void passPush() {


        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String uid = currentuser.getUid();
                        String token = task.getResult().getToken();




                        Map<String,Object> map = new HashMap<>();
                        map.put("pushtoken",token);
                        databaseReference.child("users").child(uid).updateChildren(map);

                    }
                });
    }
    //    /**
//     * Called if InstanceID token is updated. This may occur if the security of
//     * the previous token had been compromised. Note that this is called when the InstanceID token
//     * is initially generated so this is where you would retrieve the token.
//     */
//
    // 비밀번호 찾기
    public void FindPass(View view) {
        startActivity(new Intent ( MainActivity.this,FindPassActivity.class));
        finish();
    }

    public void SignUp(View view) {
        startActivity(new Intent ( MainActivity.this,SignUpActivity.class));
        finish();
    }

    public void Main(View view) {
        startActivity(new Intent ( MainActivity.this,SubmainActivity.class));
        finish();
    }

    //location
    public void onLocationChanged(Location location) {

    }

    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    public void onProviderEnabled(String provider) {

    }

    public void onProviderDisabled(String provider) {

    }

}
