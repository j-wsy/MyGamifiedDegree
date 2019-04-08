package com.example.juzza.mygamifieddegree;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.os.Bundle;

public class OverWorld extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_world);

        setTitle("MyOverWorld");

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFEE58")));
        actionBar.setTitle(Html.fromHtml("<font color='#000000'>MyDegree </font>"));

    }
}


