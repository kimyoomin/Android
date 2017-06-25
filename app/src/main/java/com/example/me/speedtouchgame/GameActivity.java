package com.example.me.speedtouchgame;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.CountDownTimer;

public class GameActivity extends AppCompatActivity {
    private int c=0;
    public void pluscount(){
        c++;
    }
    long playtime;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent=getIntent();
        String s=intent.getStringExtra("double");
        if(s.equals("one")==true){
            playtime = 10;
        }else if(s.equals("two")==true){
            playtime=30;
        }else if(s.equals("three")==true){
            playtime=60;
        }

        final ImageButton push=(ImageButton) findViewById(R.id.pushButton);
        final TextView result=(TextView) findViewById(R.id.count);

        push.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pluscount();
                result.setText(Integer.toString(c));
            }
        });

        timer=new CountDownTimer(playtime*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                Intent intent=new Intent(getApplicationContext(),EndActivity.class);
                intent.putExtra("count",c);
                intent.putExtra("playtime",playtime);
                startActivity(intent);
                finish();
            }
        }.start();

    }

}
