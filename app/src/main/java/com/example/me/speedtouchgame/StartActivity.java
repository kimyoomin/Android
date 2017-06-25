package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final TextView start=(TextView) findViewById(R.id.start);

        CountDownTimer timer;
        Intent intent1=getIntent();
        final String s=intent1.getStringExtra("double");




        timer=new CountDownTimer(1100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                SystemClock.sleep(1000);
                start.setText("start");
            }
            @Override
            public void onFinish() {
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra("playtime",s);
                startActivity(intent);
                finish();
            }
        }.start();


    }
}
