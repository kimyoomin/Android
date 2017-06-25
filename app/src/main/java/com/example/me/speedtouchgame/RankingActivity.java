package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {
    ArrayList<Integer> s1=new ArrayList<Integer>();
    ArrayList<Integer> s2=new ArrayList<Integer>();
    ArrayList<Integer> s3=new ArrayList<Integer>();
    ArrayList<String> n1=new ArrayList<String>();
    ArrayList<String> n2=new ArrayList<String>();
    ArrayList<String> n3=new ArrayList<String>();
    ArrayList<String> r1=new ArrayList<String>();
    ArrayList<String> r2=new ArrayList<String>();
    ArrayList<String> r3=new ArrayList<String>();


    public void addrank(Rank r,ArrayList<Integer> s,ArrayList<String> n){
        for(int i=0;i<10;i++){
            if(r.score>s.get(i)){
                s.add(0,r.score);
                n.add(0,r.name);
            }else if(s.get(i)>=r.score&&r.score>=s.get(i)){
                s.add(i+1,r.score);
                n.add(i+1,r.name);
            }
        }
        while(s.size()>4 && n.size()>4){
            s.remove(4);
            n.remove(4);
        }
    }
    public void makestringarray(ArrayList<Integer> s,ArrayList<String> n,ArrayList<String> r){
        for(int i=0;i<s.size();i++){
            int k=i+1;
            r.add(k+".  "+n.get(i)+"     "+s.get(i));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        if(savedInstanceState != null){
            s1=savedInstanceState.getIntegerArrayList("s1");
            s2=savedInstanceState.getIntegerArrayList("s2");
            s3=savedInstanceState.getIntegerArrayList("s3");
            n1=savedInstanceState.getStringArrayList("n1");
            n2=savedInstanceState.getStringArrayList("n2");
            n3=savedInstanceState.getStringArrayList("n3");
            r1=savedInstanceState.getStringArrayList("r1");
            r2=savedInstanceState.getStringArrayList("r2");
            r3=savedInstanceState.getStringArrayList("r3");
        }

        Intent intent=getIntent();
        int level=intent.getIntExtra("time",0);
        int score=intent.getIntExtra("score",0);
        String s=intent.getStringExtra("name");


        Rank r=new Rank(s,score);

        if(level==10){
            addrank(r,s1,n1);
        }if(level==30){
            addrank(r,s2,n2);
        }if(level==60){
            addrank(r,s3,n3);
        }

        makestringarray(s1,n1,r1);
        makestringarray(s2,n2,r2);
        makestringarray(s3,n3,r3);

        Button one=(Button) findViewById(R.id.rankone);
        Button two=(Button) findViewById(R.id.ranktwo);
        Button three=(Button) findViewById(R.id.rankthree);
        Button exit=(Button) findViewById(R.id.backButton);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
                intent.putExtra("list",r1);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
                intent.putExtra("list",r2);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
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

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("s1",s1);
        outState.putIntegerArrayList("s2",s2);
        outState.putIntegerArrayList("s3",s3);
        outState.putStringArrayList("n1",n1);
        outState.putStringArrayList("n2",n2);
        outState.putStringArrayList("n3",n3);
        outState.putStringArrayList("r1",r1);
        outState.putStringArrayList("r2",r2);
        outState.putStringArrayList("r3",r3);
    }
}
