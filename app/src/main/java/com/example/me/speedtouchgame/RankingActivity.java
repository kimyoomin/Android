package com.example.me.speedtouchgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.*;

public class RankingActivity extends AppCompatActivity {
    ArrayList<String> r1=new ArrayList<String>(10);
    ArrayList<String> r2=new ArrayList<String>(10);
    ArrayList<String> r3=new ArrayList<String>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Intent intent=getIntent();
        r1=intent.getStringArrayListExtra("r1");
        r2=intent.getStringArrayListExtra("r2");
        r3=intent.getStringArrayListExtra("r3");

        Button one=(Button) findViewById(R.id.rankone);
        Button two=(Button) findViewById(R.id.ranktwo);
        Button three=(Button) findViewById(R.id.rankthree);
        Button exit=(Button) findViewById(R.id.backButton);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankList.class);
                intent.putExtra("list",r1);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankList.class);
                intent.putExtra("list",r2);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankList.class);
                intent.putExtra("list",r3);
                startActivity(intent);
            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
