package com.example.juzza.mygamifieddegree;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class Avatar extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        final ImageView image = (ImageView)findViewById(R.id.avatarImage);
        image.setBackgroundResource(R.drawable.lion);
        CardView card1 =(CardView)findViewById(R.id.cardview1);
        CardView card2 =(CardView)findViewById(R.id.cardview2);
        CardView card3 =(CardView)findViewById(R.id.cardview3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setBackgroundResource(R.drawable.purplelion);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setBackgroundResource(R.drawable.yellowlion);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setBackgroundResource(R.drawable.bluelion);
            }
        });

    }
}
