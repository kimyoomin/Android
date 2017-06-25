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
        final TextView three=(TextView) findViewById(R.id.three);
        final TextView two=(TextView) findViewById(R.id.two);
        final TextView one=(TextView) findViewById(R.id.one);
        final TextView start=(TextView) findViewById(R.id.start);

        CountDownTimer timer;
        Intent intent1=getIntent();
        final String s=intent1.getStringExtra("double");




        timer=new CountDownTimer(3010,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                three.setText("3");
                SystemClock.sleep(1000);
                two.setText("2");
                SystemClock.sleep(1000);
                one.setText("1");
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
