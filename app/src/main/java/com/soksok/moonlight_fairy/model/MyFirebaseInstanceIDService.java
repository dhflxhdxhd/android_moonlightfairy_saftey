//package com.soksok.moonlight_fairy.model;
//
//import android.util.Log;
//
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.messaging.FirebaseMessagingService;
//
//
//public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
//
//
//    private static final String TAG = "MyFirebaseIIDService";
//
//
//    public void onTokenRefresh() {
//
//        // Get updated InstanceID token.
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "Refreshed token: " + refreshedToken);
//        sendRegistrationToServer(refreshedToken);
//
//    }
//
//
//    private void sendRegistrationToServer(String token) {
//
//        // 내 푸쉬 서버로 토컨을 보내서 저장해 둔다. 실 서비스 시 직접 코딩을 해야 된다.
//        // 테스트 시에는비워 놔도 동작 확인이 된다.
//
//    }
//}