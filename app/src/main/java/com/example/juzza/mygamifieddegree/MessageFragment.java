package com.example.juzza.mygamifieddegree;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MessageFragment extends Fragment {


    Toast toast;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_message, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level3 = new Intent(getActivity(), CourseOverview.class);
                startActivity(level3);

            }
        });


        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final DbHelper dbHelper = new DbHelper(getActivity());
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingElective = dbHelper.getRemainingElectiveCourses();
                int remainingGen = dbHelper.getRemainingGeneralCourses();
                int total = remainingCore + remainingElective + remainingGen;

                if (total <= 15) {
                    Intent intent = new Intent(getActivity(), CourseOverviewY2.class);
                    startActivity(intent);
                }

                else{
                    toast.makeText(getActivity(), "This stage is locked. Please complete your Year 1 enrolment", Toast.LENGTH_SHORT).show();
                }

            }

        });

        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final DbHelper dbHelper = new DbHelper(getActivity());
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingElective = dbHelper.getRemainingElectiveCourses();
                int remainingGen = dbHelper.getRemainingGeneralCourses();
                int total = remainingCore + remainingElective + remainingGen;

                if (total <= 6) {
                    Intent intent = new Intent(getActivity(), CourseOverviewY3.class);
                    startActivity(intent);
                }

                else{
                    toast.makeText(getActivity(), "This stage is locked. Please complete your Year 2 enrolment", Toast.LENGTH_SHORT).show();
                }

            }

        });

        /*
        final DbHelper dbHelper = new DbHelper(getActivity());
        int remainingCore = dbHelper.getRemainingCoreCourses();
        int remainingElective = dbHelper.getRemainingElectiveCourses();
        int remainingGen = dbHelper.getRemainingGeneralCourses();
        int total = remainingCore + remainingElective + remainingGen;

        if (total == 9) {

            view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), CourseOverviewY2.class);
                    startActivity(intent);
                }

            });
        }else {
            toast.makeText(getActivity(), "This stage is locked. Please complete your Year 1 enrolment", Toast.LENGTH_SHORT).show();
        }

        if (total == 18) {

            view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), CourseOverviewY2.class);
                    startActivity(intent);
                }

            });
        } else {
            toast.makeText(getActivity(),"This stage is locked. Please complete your Year 2 enrolment",Toast.LENGTH_SHORT).show();
        }

        */
        }
    }




