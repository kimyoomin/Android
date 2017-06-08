package com.example.me.speedtouchgame;

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
        int c=intent.getIntExtra("count", 0);
        final TextView result=(TextView) findViewById(R.id.result);

        result.setText(Integer.toString(c));

        gomenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
