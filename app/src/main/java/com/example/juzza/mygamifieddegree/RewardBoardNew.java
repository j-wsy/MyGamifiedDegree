package com.example.juzza.mygamifieddegree;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class RewardBoardNew extends AppCompatActivity {

    ImageView newbie;
    ImageView javaist;
    ImageView javaExplorer;
    ImageView javaStar;
    ImageView javaGuru;
    ImageView groupie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_board_new);

        newbie = findViewById(R.id.badge1);
        javaist = findViewById(R.id.badge2);
        javaExplorer = findViewById(R.id.badge3);
        javaStar = findViewById(R.id.badge4);
        javaGuru = findViewById(R.id.badge5);
        groupie = findViewById(R.id.badge6);



//Eric 8 Apr


    }
}
