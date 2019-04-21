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

    ImageView newbie;
    ImageView Term1Yr1;
    ImageView Term2Yr1;
    ImageView Year1;
    ImageView Javaist;
    ImageView Jstar;
    ImageView Jxplorer;
    ImageView Jguro;
    ImageView Grouple;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_board_new);


        DbHelper dbHelper=new DbHelper(getApplicationContext());
        newbie=findViewById(R.id.badge1);
        Term1Yr1=findViewById(R.id.badge2);
        Term2Yr1=findViewById(R.id.badge3);
        Year1=findViewById(R.id.badge4);
        Javaist=findViewById(R.id.badge5);
        Jstar=findViewById(R.id.badge6);
        Jxplorer=findViewById(R.id.badge7);
        Jguro=findViewById(R.id.badge8);
        Grouple=findViewById(R.id.badge9);


        newbie.setImageResource(R.drawable.lock);
        Term1Yr1.setImageResource(R.drawable.lock);
        Term2Yr1.setImageResource(R.drawable.lock);
        Year1.setImageResource(R.drawable.lock);
        Javaist.setImageResource(R.drawable.lock);
        Jstar.setImageResource(R.drawable.lock);
        Jxplorer.setImageResource(R.drawable.lock);
        Jguro.setImageResource(R.drawable.lock);
        Grouple.setImageResource(R.drawable.lock);


         int b=0;
         int c=0;
         c= 24 -(dbHelper.getRemainingCoreCourses()+dbHelper.getRemainingElectiveCourses()+dbHelper.getRemainingGeneralCourses());

        if(c>=1) {
           // newbie.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //newbie.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
            newbie.setImageResource(R.drawable.newbie);
        }



        if(c>=3) {
           // Term1Yr1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            //Term1Yr1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
            Term1Yr1.setImageResource(R.drawable.t1y1);
        }


        if(c>=6) {
           // Term2Yr1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
           // Term2Yr1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));


            Term2Yr1.setImageResource(R.drawable.t2y1);
        }


        if(c>=9) {
            //Year1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Year1.setImageResource(R.drawable.t3y1);
            //Year1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

         b=dbHelper.getIsCompleted("INFS1609");
        if(b==1) {
         //   Javaist.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //Javaist.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));

            Javaist.setImageResource(R.drawable.javaist);

        }

        b=dbHelper.getIsCompleted("INFS3830");
        if(b==1) {
            //Jstar.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //Jstar.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));

            Jstar.setImageResource(R.drawable.javasuperstar);
        }

        b=dbHelper.getIsCompleted("INFS2605");
        if(b==1) {
          //  Jxplorer.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

           Jxplorer.setImageResource(R.drawable.javaexplorer);
            // Jxplorer.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        b=dbHelper.getIsCompleted("INFS3605");
        if(b==1) {
            //Jguro.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Jguro.setImageResource(R.drawable.javaguru);
            // Jguro.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        b=dbHelper.getIsCompleted("INFS2608");
        if(b==1) {
           // Grouple.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Grouple.setImageResource(R.drawable.groupie);
            //  Grouple.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

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
