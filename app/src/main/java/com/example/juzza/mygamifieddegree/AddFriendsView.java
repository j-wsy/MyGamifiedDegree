package com.example.juzza.mygamifieddegree;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFriendsView extends Fragment {

    RecyclerView recyclerViewFA;
    List<Friend> friendList;
    Button button9;

    static RecyclerViewAdapterFA adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_add_friends_view, container, false);
        button9 = rootView.findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new FriendsView()).commit();

            }
        });

        //Initialise first recyclerview
        friendList = new ArrayList<>();
        recyclerViewFA = rootView.findViewById(R.id.recyclerViewFA);
        recyclerViewFA.setHasFixedSize(true);
        recyclerViewFA.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        final DbHelperF dbHelperF = new DbHelperF(getActivity());
        friendList = dbHelperF.getAllFriends();
        adapter = new RecyclerViewAdapterFA(getActivity(), friendList);
        recyclerViewFA.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

}

