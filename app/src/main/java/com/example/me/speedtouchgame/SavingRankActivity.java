package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SavingRankActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_rank);
        Intent intent=getIntent();
        final int score=intent.getIntExtra("score", 0);
        final int level=intent.getIntExtra("level",0);



        Button ok=(Button) findViewById(R.id.okButton);
        EditText name=(EditText) findViewById(R.id.nameText);
        final String s = name.toString();



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RankingActivity.class);
                intent.putExtra("name",s);
                intent.putExtra("score",score);
                intent.putExtra("time",level);
                startActivity(intent);
                finish();
            }
        });
    }


}
