package com.example.me.speedtouchgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Button gomenu=(Button) findViewById(R.id.menuButton);
        Intent intent=getIntent();
        final int c=intent.getIntExtra("count", 0);
        final int playtime=intent.getIntExtra("playtime",0);
        final TextView result=(TextView) findViewById(R.id.result);

        result.setText(Integer.toString(c));

        gomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button save=(Button) findViewById(R.id.saverankButton);

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1=new Intent(getApplicationContext(),SavingRankActivity.class);
                intent1.putExtra("score",c);
                intent1.putExtra("level",playtime);
                startActivity(intent1);
                finish();
            }
        });
    }
}
