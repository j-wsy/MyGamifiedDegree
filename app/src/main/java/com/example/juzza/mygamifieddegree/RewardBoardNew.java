package com.example.juzza.mygamifieddegree;

import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.support.v7.app.ActionBar;

public class RewardBoardNew extends AppCompatActivity {

    ImageView newbie;
    ImageView javaist;
    ImageView javaExplorer;
    ImageView javaStar;
    ImageView javaGuru;
    ImageView groupie;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_board_new);

        setTitle("My Reward Board");


        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFEE58")));
        actionBar.setTitle(Html.fromHtml("<font color='#000000'> MyDegree </font>"));

        newbie = findViewById(R.id.badge1);
        javaist = findViewById(R.id.badge2);
        javaExplorer = findViewById(R.id.badge3);
        javaStar = findViewById(R.id.badge4);
        javaGuru = findViewById(R.id.badge5);
        groupie = findViewById(R.id.badge6);






    }
}
