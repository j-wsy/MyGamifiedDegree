package com.example.juzza.mygamifieddegree;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class RewardBoardFragment extends Fragment {

    ImageView newbie;
    ImageView Term1Yr1;
    ImageView Term2Yr1;
    ImageView Year1;
    ImageView Javaist;
    ImageView Jstar;
    ImageView Jxplorer;
    ImageView Jguro;
    ImageView Grouple;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_reward_board_new, container, false);

        DbHelper dbHelper = new DbHelper(getActivity());
        newbie = (ImageView) rootView.findViewById(R.id.badge1);
        Term1Yr1 =(ImageView) rootView.findViewById(R.id.badge2);
        Term2Yr1 = (ImageView)rootView.findViewById(R.id.badge3);
        Year1 = (ImageView)rootView.findViewById(R.id.badge4);
        Javaist = (ImageView)rootView.findViewById(R.id.badge5);
        Jstar = (ImageView)rootView.findViewById(R.id.badge6);
        Jxplorer = (ImageView)rootView.findViewById(R.id.badge7);
        Jguro =(ImageView) rootView.findViewById(R.id.badge8);
        Grouple = (ImageView)rootView.findViewById(R.id.badge9);

        newbie.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lock));
        Term1Yr1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Term2Yr1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Year1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Javaist.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Jstar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Jxplorer.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Jguro.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));
        Grouple.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.lock));

        /*newbie.setImageResource(getActivity(), R.drawable.lock);
        Term1Yr1.setImageResource(getActivity(),R.drawable.lock);
        Term2Yr1.setImageResource(getActivity(),R.drawable.lock);
        Year1.setImageResource(getActivity(),R.drawable.lock);
        Javaist.setImageResource(getActivity(),R.drawable.lock);
        Jstar.setImageResource(getActivity(),R.drawable.lock);
        Jxplorer.setImageResource(getActivity(),R.drawable.lock);
        Jguro.setImageResource(getActivity(),R.drawable.lock);
        Grouple.setImageResource(getActivity(),R.drawable.lock);*/

        newbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.newbie_badge_message));
            }
        });

        Term1Yr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.term1_yr1_badge_message));
            }
        });

        Term2Yr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.term2_yr1_badge_message));
            }
        });

        Year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.yr1_badge_message));
            }
        });

        Javaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.javaist_badge_message));
            }
        });

        Jstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.java_star_badge_message));
            }
        });

        Jxplorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.java_xplorer_badge_message));
            }
        });


        Jguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.java_guru_badge_message));
            }
        });

        Grouple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToast(getActivity().getString(R.string.groupie_badge_message));
            }
        });



        int b = 0;
        int c = 0;
        c = 24 - (dbHelper.getRemainingCoreCourses() + dbHelper.getRemainingElectiveCourses() + dbHelper.getRemainingGeneralCourses());

        if (c >= 1) {
            // newbie.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //newbie.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
            newbie.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.newbie));
        }


        if (c >= 3) {
            // Term1Yr1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            //Term1Yr1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
            Term1Yr1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.t1y1));
        }


        if (c >= 6) {
            // Term2Yr1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            // Term2Yr1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
            Term2Yr1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.t2y1));

        }


        if (c >= 9) {
            //Year1.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Year1.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.t3y1));
            //Year1.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        b = dbHelper.getIsCompleted("INFS1609");
        if (b == 1) {
            //   Javaist.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //Javaist.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));

            Javaist.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.javaist));

        }

        b = dbHelper.getIsCompleted("INFS3830");
        if (b == 1) {
            //Jstar.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));
            //Jstar.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));

            Jstar.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.javasuperstar));
        }

        b = dbHelper.getIsCompleted("INFS2605");
        if (b == 1) {
            //  Jxplorer.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Jxplorer.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.javaexplorer));
            // Jxplorer.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        b = dbHelper.getIsCompleted("INFS3605");
        if (b == 1) {
            //Jguro.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));

            Jguro.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.javaguru));
            // Jguro.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        b = dbHelper.getIsCompleted("INFS2608");
        if (b == 1) {
            // Grouple.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorYellow));


            Grouple.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.groupie));
            //  Grouple.setColorFilter(getApplicationContext().getResources().getColor(R.color.lightGrey));
        }

        return rootView;

    }

    public void displayToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

    /*public void showNewbieIntro(View view) {
        displayToast(getActivity().getString(R.string.newbie_badge_message));
    }

    public void showJavaistIntro(View view) {
        displayToast(getActivity().getString(R.string.javaist_badge_message));
    }


    public void showJavaXplorerIntro(View view) {
        displayToast(getActivity().getString(R.string.java_xplorer_badge_message));
    }

    public void showJavaStarIntro(View view) {
        displayToast(getActivity().getString(R.string.java_star_badge_message));
    }

    public void showJavaGuruIntro(View view) {
        displayToast(getActivity().getString(R.string.java_guru_badge_message));
    }

    public void showGroupieIntro(View view) {
        displayToast(getActivity().getString(R.string.groupie_badge_message));
    }

    public void showT1Y1Intro(View view) {
        displayToast(getActivity().getString(R.string.term1_yr1_badge_message));
    }


    public void showT2Y1Intro(View view) {
        displayToast(getActivity().getString(R.string.term2_yr1_badge_message));
    }

    public void showT3Y1Intro(View view) {
        displayToast(getActivity().getString(R.string.yr1_badge_message));
    }*/
}



