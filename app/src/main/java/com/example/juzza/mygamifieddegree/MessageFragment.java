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


  // mainpage



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_message,container,false);




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"123123",Toast.LENGTH_LONG).show();
                Intent level3 = new Intent(getActivity(), level3.class);
                startActivity(level3);

            }
        });

        view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level3 = new Intent(getActivity(), level3.class);
                startActivity(level3);

            }
        });

        view.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level3 = new Intent(getActivity(), level3.class);
                startActivity(level3);

            }
        });
    }
}


