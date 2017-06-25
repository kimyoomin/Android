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
        ArrayList<Integer> r1=new ArrayList<Integer>();
        ArrayList<Integer> r2=new ArrayList<Integer>();
        ArrayList<Integer> r3=new ArrayList<Integer>();

        TextView rank1=(TextView) findViewById(R.id.textView1);
        TextView rank2=(TextView) findViewById(R.id.textView2);
        TextView rank3=(TextView) findViewById(R.id.textView3);
        TextView rank4=(TextView) findViewById(R.id.textView4);

        Intent intent=getIntent();
        int time=intent.getIntExtra("time",0);

        if(time==10) {
            r1=intent.getIntegerArrayListExtra("r1");
            if (r1.size() == 0) {
                rank1.setText("No Rank");
            } else if (r1.size() == 1) {
                rank1.setText(r1.get(0));
                rank2.setText(r1.get(1));
                rank3.setText(r1.get(2));
                rank4.setText(r1.get(0));
            } else if (r1.size() == 2) {
                rank1.setText(r1.get(0));
                rank2.setText(r1.get(1));
            } else if (r1.size() == 3) {
                rank1.setText(r1.get(0));
                rank2.setText(r1.get(1));
                rank3.setText(r1.get(2));
            } else if (r1.size() == 4) {
                rank1.setText(r1.get(0));
                rank2.setText(r1.get(1));
                rank3.setText(r1.get(2));
                rank4.setText(r1.get(0));
            }
        }else if(time==30) {
            r2=intent.getIntegerArrayListExtra("r2");
            if (r2.size() == 0) {
                rank1.setText("No Rank");
            } else if (r2.size() == 1) {
                rank1.setText(r2.get(0));
            } else if (r2.size() == 2) {
                rank1.setText(r2.get(0));
                rank2.setText(r2.get(1));
            } else if (r2.size() == 3) {
                rank1.setText(r2.get(0));
                rank2.setText(r2.get(1));
                rank3.setText(r2.get(2));
            } else if (r1.size() == 4) {
                rank1.setText(r2.get(0));
                rank2.setText(r2.get(1));
                rank3.setText(r2.get(2));
                rank4.setText(r2.get(0));
            }
        }else if(time==60) {
            r3=intent.getIntegerArrayListExtra("r3");
            if (r3.size() == 0) {
                rank1.setText("No Rank");
            } else if (r3.size() == 1) {
                rank1.setText(r3.get(0));
            } else if (r3.size() == 2) {
                rank1.setText(r3.get(0));
                rank2.setText(r3.get(1));
            } else if (r3.size() == 3) {
                rank1.setText(r3.get(0));
                rank2.setText(r3.get(1));
                rank3.setText(r3.get(2));
            } else if (r3.size() == 4) {
                rank1.setText(r3.get(0));
                rank2.setText(r3.get(1));
                rank3.setText(r3.get(2));
                rank4.setText(r3.get(0));
            }
        }
    }



}
