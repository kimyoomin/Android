package com.example.me.speedtouchgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class SavingRankActivity extends AppCompatActivity {
    ArrayList<Integer> s1=new ArrayList<Integer>(10);
    ArrayList<Integer> s2=new ArrayList<Integer>(10);
    ArrayList<Integer> s3=new ArrayList<Integer>(10);
    ArrayList<String> n1=new ArrayList<String>(10);
    ArrayList<String> n2=new ArrayList<String>(10);
    ArrayList<String> n3=new ArrayList<String>(10);
    ArrayList<String> r1=new ArrayList<String>(10);
    ArrayList<String> r2=new ArrayList<String>(10);
    ArrayList<String> r3=new ArrayList<String>(10);


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
        while(s.size()>10 && n.size()>10){
            s.remove(10);
            n.remove(10);
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
        setContentView(R.layout.activity_saving_rank);
        Intent intent=getIntent();
        final int score=intent.getIntExtra("score", 0);
        final int level=intent.getIntExtra("level",0);

        if(savedInstanceState != null){
            s1=savedInstanceState.getIntegerArrayList("s1");
            s2=savedInstanceState.getIntegerArrayList("s2");
            s3=savedInstanceState.getIntegerArrayList("s3");
            n1=savedInstanceState.getStringArrayList("n1");
            n2=savedInstanceState.getStringArrayList("n2");
            n3=savedInstanceState.getStringArrayList("n3");
        }

        Button ok=(Button) findViewById(R.id.okButton);
        EditText name=(EditText) findViewById(R.id.nameText);
        final String s = name.toString();

        Rank r=new Rank(s,score);
        if(level==10){
            addrank(r,s1,n1);
            makestringarray(s1,n1,r1);
        }if(level==30){
            addrank(r,s2,n2);
            makestringarray(s2,n2,r2);
        }if(level==60){
            addrank(r,s3,n3);
            makestringarray(s3,n3,r3);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankingActivity.class);
                intent.putExtra("r1",r1);
                intent.putExtra("r2",r2);
                intent.putExtra("r3",r3);
                intent.putExtra("time",level);
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
    }
}
