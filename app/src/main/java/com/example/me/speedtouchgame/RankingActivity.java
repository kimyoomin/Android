package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Intent intent=getIntent();
        long time=intent.getLongExtra("time",0);
        int score=intent.getIntExtra("score",0);

        if(savedInstanceState != null){
            /*r1=savedInstanceState.getIntegerArrayList("r1");
            r2=savedInstanceState.getIntegerArrayList("r2");
            r3=savedInstanceState.getIntegerArrayList("r3");*/
            bestscore=savedInstanceState.getIntArray("best");
            if(time==10){
                if(score>=bestscore[0]) {
                    bestscore[0] = score;
                }
            }if(time==30){
                if(score>=bestscore[1]) {
                    bestscore[1] = score;
                }
            }if(time==60){
                if(score>=bestscore[2]) {
                    bestscore[2] = score;
                }
            }
        }

        if(time==10){
            if(score>=bestscore[0]) {
                bestscore[0] = score;
            }
        }if(time==30){
            if(score>=bestscore[1]) {
                bestscore[1] = score;
            }
        }if(time==60){
            if(score>=bestscore[2]) {
                bestscore[2] = score;
            }
        }


        Button one=(Button) findViewById(R.id.rankone);
        Button two=(Button) findViewById(R.id.ranktwo);
        Button three=(Button) findViewById(R.id.rankthree);
        Button exit=(Button) findViewById(R.id.backButton);
        TextView ss=(TextView) findViewById(R.id.result);

        ss.setText(Integer.toString(bestscore[0]));

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
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        /*outState.putIntegerArrayList("r1",r1);
        outState.putIntegerArrayList("r2",r2);
        outState.putIntegerArrayList("r3",r3);*/
        outState.putIntArray("best",bestscore);
    }

}
