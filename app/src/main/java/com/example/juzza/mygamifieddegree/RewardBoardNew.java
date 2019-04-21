package com.example.juzza.mygamifieddegree;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class RewardBoardNew extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_board_new);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showNewbieIntro(View view) {
        displayToast(getString(R.string.newbie_badge_message));
    }

    public void showJavaistIntro(View view) {
        displayToast(getString(R.string.javaist_badge_message));
    }


    public void showJavaXplorerIntro(View view) {
        displayToast(getString(R.string.java_xplorer_badge_message));
    }

    public void showJavaStarIntro(View view) {
        displayToast(getString(R.string.java_star_badge_message));
    }

    public void showJavaGuruIntro(View view) {
        displayToast(getString(R.string.java_guru_badge_message));
    }

    public void showGroupieIntro(View view) {
        displayToast(getString(R.string.groupie_badge_message));
    }

    public void showT1Y1Intro(View view) {
        displayToast(getString(R.string.term1_yr1_badge_message));
    }


    public void showT2Y1Intro(View view) {
        displayToast(getString(R.string.term2_yr1_badge_message));
    }

    public void showT3Y1Intro(View view) {
        displayToast(getString(R.string.yr1_badge_message));
    }


}
