package com.example.juzza.mygamifieddegree;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AvatarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_avatar, container, false);

        final ImageView image = (ImageView)rootView.findViewById(R.id.avatarImage);

        image.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lion));
        CardView card1 =(CardView)rootView.findViewById(R.id.cardview1);
        CardView card2 =(CardView)rootView.findViewById(R.id.cardview2);
        CardView card3 =(CardView)rootView.findViewById(R.id.cardview3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.purplelion));
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.yellowlion));
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.bluelion));
            }
        });

        Button resetButton = (Button)rootView.findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.lion));
            }
        });
        return rootView;
    }

}
