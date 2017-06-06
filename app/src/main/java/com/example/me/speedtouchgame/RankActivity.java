package com.example.me.speedtouchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        Button one=(Button) findViewById(R.id.rankone);
        Button two=(Button) findViewById(R.id.ranktwo);
        Button three=(Button) findViewById(R.id.rankthree);
        Button exit=(Button) findViewById(R.id.backButton);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
