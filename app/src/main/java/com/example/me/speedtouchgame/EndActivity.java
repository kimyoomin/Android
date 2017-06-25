package com.example.me.speedtouchgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        final long playtime=intent.getLongExtra("playtime",0);
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
                Intent intent=new Intent(getApplicationContext(),SavingRankActivity.class);
                intent.putExtra("score",c);
                intent.putExtra("time",playtime);
                startActivity(intent);
                finish();
            }
        });
    }
}
