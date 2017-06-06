package com.example.me.speedtouchgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private int c=0;
    public void pluscount(){
        c++;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageButton push=(ImageButton) findViewById(R.id.pushButton);
        final TextView result=(TextView) findViewById(R.id.count);

        push.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pluscount();
                result.setText(Integer.toString(c));
            }
        });
    }

}
