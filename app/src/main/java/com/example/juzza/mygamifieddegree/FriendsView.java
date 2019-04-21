package com.example.juzza.mygamifieddegree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class FriendsView extends Fragment {

    RecyclerView recyclerViewF;
    List<Friend> friendList;
    static RecyclerViewAdapterF adapter;
    TextView NameF;
    ProgressBar ScoreF;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_friends_view, container, false);


        NameF = rootView.findViewById(R.id.friendName);
        ScoreF = rootView.findViewById(R.id.progressBar);
        final DbHelper dbHelper = new DbHelper(getActivity());
        int remainingCore = dbHelper.getRemainingCoreCourses();
        int remainingElective = dbHelper.getRemainingElectiveCourses();
        int remainingGen = dbHelper.getRemainingGeneralCourses();
        int total = remainingCore + remainingElective + remainingGen;
        ScoreF.setProgress(24 - total);


        //Initialise first recyclerview
        friendList = new ArrayList<>();
        recyclerViewF = rootView.findViewById(R.id.recyclerViewF);
        recyclerViewF.setHasFixedSize(true);
        recyclerViewF.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        final DbHelperF dbHelperF = new DbHelperF(getActivity());
        friendList = dbHelperF.getAllFriendsAdded();
        adapter = new RecyclerViewAdapterF(getActivity(), friendList);
        recyclerViewF.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

}


