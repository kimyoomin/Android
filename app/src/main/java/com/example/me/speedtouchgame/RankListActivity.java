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
        Intent intent=getIntent();

        ArrayList<String> arr=new ArrayList<String>();
        arr=intent.getStringArrayListExtra("list");


        TextView rank1=(TextView) findViewById(R.id.textView1);
        TextView rank2=(TextView) findViewById(R.id.textView2);
        TextView rank3=(TextView) findViewById(R.id.textView3);
        TextView rank4=(TextView) findViewById(R.id.textView4);

        if(arr.size()==0){
            rank1.setText("No Rank");
        }else if(arr.size()==1) {
            rank1.setText(arr.get(0));
        }else if(arr.size()==2) {
            rank1.setText(arr.get(0));
            rank2.setText(arr.get(1));
        }else if(arr.size()==3){
            rank1.setText(arr.get(0));
            rank2.setText(arr.get(1));
            rank3.setText(arr.get(2));
        }else if(arr.size()==4){
            rank1.setText(arr.get(0));
            rank2.setText(arr.get(1));
            rank3.setText(arr.get(2));
            rank4.setText(arr.get(3));
        }
    }


}
