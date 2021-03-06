package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

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
        String s=intent.getStringExtra("playtime");
        if(s.equals("one")==true){
            playtime = 10;
        }else if(s.equals("two")==true){
            playtime=30;
        }else if(s.equals("three")==true){
            playtime=60;
        }

        final ImageButton push=(ImageButton) findViewById(R.id.pushButton);

        push.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pluscount();
                //result.setText(Integer.toString(c));
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
