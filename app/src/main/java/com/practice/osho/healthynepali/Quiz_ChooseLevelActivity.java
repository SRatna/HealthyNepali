package com.practice.osho.healthynepali;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Quiz_ChooseLevelActivity extends AppCompatActivity {

    ImageView basicCard;
    ImageView intermediateCard;
    ImageView toughCard;
    private final int Q_NO=8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_choose_level);

        basicCard=(ImageView)findViewById(R.id.basicCard);
        intermediateCard=(ImageView)findViewById(R.id.intermediateCard);
        toughCard=(ImageView)findViewById(R.id.toughCard);

        basicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent(0);
            }
        });
        intermediateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent(Q_NO);

            }
        });
        toughCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent(Q_NO*2);
            }
        });
    }

    public void callIntent(int i){
        Intent intent=new Intent(this,Quiz_MainActivity.class);
        intent.putExtra("Qno",i);
        startActivity(intent);
    }


}
