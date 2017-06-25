package com.example.me.speedtouchgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.*;

public class RankList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
        Intent intent=getIntent();
        ArrayList<String> arr=intent.getStringArrayListExtra("list");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);

        setList
    }

    @Override
    protected void onListItemClick(ListView)
}
