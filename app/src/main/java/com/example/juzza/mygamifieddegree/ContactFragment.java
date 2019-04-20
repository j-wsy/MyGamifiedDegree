package com.example.juzza.mygamifieddegree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.app.ActionBar;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button mButtonCall = (Button) getView().findViewById(R.id.buttoncall);

        mButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String scphone = "02 9385 8500";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", scphone, null));
                startActivity(intent);
            }
        });


        Button mButtonEmail = (Button) getView().findViewById(R.id.buttonemail);

        mButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:studentcentral@unsw.edu.au"));
                startActivity(Intent.createChooser(emailIntent, "Contact UNSW Student Centre"));
            }
        });

    }

}
