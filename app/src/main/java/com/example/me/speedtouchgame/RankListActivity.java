package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class RankListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
        ArrayList<Integer> r=new ArrayList<Integer>();

        TextView rank1=(TextView) findViewById(R.id.textView1);

        Intent intent=getIntent();
        long time=intent.getLongExtra("time",0);
        int score=intent.getIntExtra("best",-1);

        rank1.setText(Integer.toString(score));


       /* r=intent.getIntegerArrayListExtra("r1");
        if (r.size() == 0) {
            rank1.setText("No Rank");
        } else if (r.size() == 1) {
            rank1.setText(r.get(0));
            rank2.setText(r.get(1));
            rank3.setText(r.get(2));
            rank4.setText(r.get(0));
        } else if (r.size() == 2) {
            rank1.setText(r.get(0));
            rank2.setText(r.get(1));
        } else if (r.size() == 3) {
            rank1.setText(r.get(0));
            rank2.setText(r.get(1));
            rank3.setText(r.get(2));
        } else if (r.size() == 4) {
            rank1.setText(r.get(0));
            rank2.setText(r.get(1));
            rank3.setText(r.get(2));
            rank4.setText(r.get(0));
        }
*/

    }



}
