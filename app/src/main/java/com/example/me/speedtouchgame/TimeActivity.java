package com.example.me.speedtouchgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Button exit=(Button) findViewById(R.id.backButton);
        Button levelone=(Button) findViewById(R.id.levelone);
        Button leveltwo=(Button) findViewById(R.id.leveltwo);
        Button levelthree=(Button) findViewById(R.id.levelthree);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        levelone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        });

        leveltwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        });

        levelthree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                startActivity(intent);
            }
        });


    }
}
