package com.example.activityandintent;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String M_TAg ="activityTest"; //定义字符串常量


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(M_TAg,"MainActivity oCreate()invoked");
    }
    protected void onStart() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onStart() invoked!");
    }
    protected void onResunme() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onResunme() invoked!");
    }

    protected void onRestart() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onRestart() invoked!");
    }

    protected void onPause() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onPause() invoked!");
    }
    protected void onStop() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onStop() invoked!");
    }

    protected void onDestroy() {
        super.onStart();
        Log.i(M_TAg,"MainActivity onDestroy() invoked!");
    }

    public void goToSecondActivity(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);//指定跳转意图;
        startActivity(intent);
    }
    public void goToThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);

    }
    public void goToFourthActivity(View view) {
        Intent intent = new Intent(this, fouth_Activity.class);
        startActivity(intent);

    }
}