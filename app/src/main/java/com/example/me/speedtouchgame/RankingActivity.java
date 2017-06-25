package com.example.me.speedtouchgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RankingActivity extends AppCompatActivity {

   /* ArrayList<Integer> r1=new ArrayList<Integer>();
    ArrayList<Integer> r2=new ArrayList<Integer>();
            ArrayList<Integer> r3=new ArrayList<Integer>();

        public void addrank(int score,ArrayList<Integer> s){
            for(int i=0;i<s.size();i++){
                if(score>s.get(i)){
                    s.add(0,score);
                }else if(s.get(i)>=score&&score>=s.get(i)){
                    s.add(i+1,score);
                }
            }
            while(s.size()>4){
                s.remove(4);
            }
        }
    */

    int[] bestscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        bestscore=new int[3];

        SharedPreferences pref=getSharedPreferences("SaveState",0);
        bestscore[0]=pref.getInt("bs1",0);
        bestscore[1]=pref.getInt("bs2",0);
        bestscore[2]=pref.getInt("bs3",0);

        Intent intent=getIntent();
        long time=intent.getLongExtra("time",0);
        int score=intent.getIntExtra("score",0);




        if (time == 10) {
            if (score >= bestscore[0]) {
                bestscore[0] = score;
            }
        }else if (time == 30) {
            if (score >= bestscore[1]) {
                bestscore[1] = score;
            }
        }else if (time == 60) {
            if (score >= bestscore[2]) {
                bestscore[2] = score;
            }
        }

        Button one=(Button) findViewById(R.id.rankone);
        Button two=(Button) findViewById(R.id.ranktwo);
        Button three=(Button) findViewById(R.id.rankthree);
        Button exit=(Button) findViewById(R.id.backButton);
        Button clear=(Button) findViewById(R.id.clearButton);

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                bestscore[0]=0;
                bestscore[1]=0;
                bestscore[2]=0;
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
                intent.putExtra("time",10);
                intent.putExtra("best",bestscore[0]);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
                intent.putExtra("time",30);
                intent.putExtra("best",bestscore[1]);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankListActivity.class);
                intent.putExtra("time",60);
                intent.putExtra("best",bestscore[2]);
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
        protected void onPause(){
        super.onPause();
        SharedPreferences pref=getSharedPreferences("SaveState",0);
        SharedPreferences.Editor edit=pref.edit();
        edit.putInt("bs1",bestscore[0]);
        edit.putInt("bs2",bestscore[1]);
        edit.putInt("bs3",bestscore[2]);
        edit.commit();
    }

}
