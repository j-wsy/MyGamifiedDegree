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


   // ImageView newbie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_board_new);

//Eric 8 Apr

       // newbie = findViewById(R.id.badge1);
      //  newbie.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        getString(R.string.newbie_badge_message);
           // }
       // });

    }

    //Toast for pop up screen in RewardBoard, edited by Eric
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    /**
     * Shows a message that the newbie image was clicked.
     */
    public void showNewbieIntro(View view) {
        displayToast(getString(R.string.newbie_badge_message));
    }

    /**
     * Shows a message that the T1Y1 image was clicked.
     */
    public void showJavaistIntro(View view) {
        displayToast(getString(R.string.javaist_badge_message));
    }

    /**
     * Shows a message that the java xplorer image was clicked.
     */
    public void showJavaXplorerIntro(View view) {
        displayToast(getString(R.string.java_xplorer_badge_message));
    }

    /**
     * Shows a message that the java star image was clicked.
     */
    public void showJavaStarIntro(View view) {
        displayToast(getString(R.string.java_star_badge_message));
    }

    /**
     * Shows a message that the java guru image was clicked.
     */
    public void showJavaGuruIntro(View view) {
        displayToast(getString(R.string.java_guru_badge_message));
    }

    /**
     * Shows a message that the groupie image was clicked.
     */
    public void showGroupieIntro(View view) {
        displayToast(getString(R.string.groupie_badge_message));
    }



    /**
     * Shows a message that the T1Y1 image was clicked.
     */
    public void showT1Y1Intro(View view) {
        displayToast(getString(R.string.term1_yr1_badge_message));
    }

    /**
     * Shows a message that the T2Y1 image was clicked.
     */
    public void showT2Y1Intro(View view) {
        displayToast(getString(R.string.term2_yr1_badge_message));
    }

    /**
     * Shows a message that the T3Y1 image was clicked.
     */
    public void showT3Y1Intro(View view) {
        displayToast(getString(R.string.yr1_badge_message));
    }


}
