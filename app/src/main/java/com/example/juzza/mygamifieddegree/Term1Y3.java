package com.example.juzza.mygamifieddegree;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Term1Y3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Term1Y3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Term1Y3 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    static RecyclerViewAdapterY3 adapter;
    static RecyclerViewAdapterY3 adapter2;
    static RecyclerViewAdapterY3 adapter3;
    static RecyclerViewAdapterY3 adapter4;
    List<Course> courseList;
    List<Course> courseList2;
    List<Course> courseList3;
    List<Course> courseList4;
    Dialog dialog;
    List<String> t2Avail;
    List<String> t2Unavail;
    Toast toast;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Term1Y3.OnFragmentInteractionListener mListener;

    public Term1Y3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Term2.
     */
    // TODO: Rename and change types and number of parameters
    public static Term1Y3 newInstance(String param1, String param2) {
        Term1Y3 fragment = new Term1Y3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_term1, container, false);

        //Initialise first recyclerview
        courseList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        final DbHelper dbHelper = new DbHelper(getActivity());
        courseList = dbHelper.getAllCoreCourses();
        adapter = new RecyclerViewAdapterY3(getActivity(), courseList);
        recyclerView.setAdapter(adapter);

        //Initialise second recyclerview
        courseList2 = new ArrayList<>();
        recyclerView2 = rootView.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList2 = dbHelper.getAllElectiveCourses();
        adapter2 = new RecyclerViewAdapterY3(getActivity(), courseList2);
        recyclerView2.setAdapter(adapter2);

        //Initialise fourth recyclerview
        courseList4 = new ArrayList<>();
        recyclerView4 = rootView.findViewById(R.id.recyclerView4);
        recyclerView4.setHasFixedSize(true);
        recyclerView4.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        courseList4 = dbHelper.getAllT1Y2Courses();
        adapter4 = new RecyclerViewAdapterY3(getActivity(), courseList4);
        recyclerView4.setAdapter(adapter4);

        //Initialise spinner and third recyclerview
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.faculty));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Arts and Social Science")) {
                    courseList3 = new ArrayList<>();
                    recyclerView3 = rootView.findViewById(R.id.recyclerView3);
                    recyclerView3.setHasFixedSize(true);
                    recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    courseList3 = dbHelper.getArtsCourses();
                    adapter3 = new RecyclerViewAdapterY3(getActivity(), courseList3);
                    recyclerView3.setAdapter(adapter3);
                } else {
                    courseList3 = new ArrayList<>();
                    recyclerView3 = rootView.findViewById(R.id.recyclerView3);
                    recyclerView3.setHasFixedSize(true);
                    recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    courseList3 = dbHelper.getScienceCourses();
                    adapter3 = new RecyclerViewAdapterY3(getActivity(), courseList3);
                    recyclerView3.setAdapter(adapter3);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Button
        final Button enrolButton = (Button) rootView.findViewById(R.id.enrolButton);
        enrolButton.setVisibility(View.INVISIBLE);
        int count = adapter4.getItemCount();
        if (count == 3) {
            enrolButton.setVisibility(View.VISIBLE);
        }
        enrolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DbHelper dbHelper = new DbHelper(getActivity());

                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.course_progress_year);
                ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                TextView remainingCourses = (TextView) dialog.findViewById(R.id.remainingCourses);
                String remainingDesc = dbHelper.getRemainingCoreCourses() + " core(s)  \n" + dbHelper.getRemainingElectiveCourses() + " elective(s)\n" + dbHelper.getRemainingGeneralCourses() + " gen ed(s)";
                remainingCourses.setText(remainingDesc);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                        final Dialog dialog2 = new Dialog(getActivity());
                        dialog2.setContentView(R.layout.badge_notif);
                        ImageView closeButton = (ImageView) dialog2.findViewById(R.id.closeButton);
                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog2.show();
                        closeButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                                enrolButton.setVisibility(View.INVISIBLE);
                            }
                        });

                        Button viewButton = (Button) dialog2.findViewById(R.id.viewButton);
                        viewButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(),RewardBoardNew.class);
                                startActivity(intent);
                            }
                        });

                        t2Unavail = dbHelper.getT2RemUnavail();
                        dbHelper.updateDisable(t2Unavail);
                        if (dbHelper.getIsCompleted("INFS1602") == 1) {
                            dbHelper.updatePrereq("INFS2621");
                            dbHelper.updatePrereq("INFS3603");
                            dbHelper.updatePrereq("INFS3617");
                            dbHelper.updatePrereq("INFS2631");
                            dbHelper.updatePrereq("INFS3632");
                            if (dbHelper.getIsCompleted("INFS1603") == 1) {
                                dbHelper.updatePrereq("INFS2603");
                            }
                        }

                        if (dbHelper.getIsCompleted("INFS1603") == 1) {
                            dbHelper.updatePrereq("INFS2608");
                            if (dbHelper.getIsCompleted("INFS1609") == 1) {
                                dbHelper.updatePrereq("INFS2605");
                            }
                        }

                        if (dbHelper.getIsCompleted("INFS2603") ==1) {
                            dbHelper.updatePrereq("INFS3604");
                        }

                        if (dbHelper.getIsCompleted("INFS3634") ==1) {
                            dbHelper.updatePrereq("INFS3605");
                        }

                        if (dbHelper.getIsCompleted("INFS2605") ==1) {
                            dbHelper.updatePrereq("INFS3634");
                        }

                        if (dbHelper.getIsCompleted("INFS2605") ==1) {
                            dbHelper.updatePrereq("INFS3830");
                            dbHelper.updatePrereq("INFS3873");
                        }
                        t2Avail = dbHelper.getT2RemAvail();
                        dbHelper.updateEnable(t2Avail);
                        Fragment fragment = (Fragment) (getActivity()).getSupportFragmentManager().getFragments().get(1);
                        FragmentTransaction fragmentTransaction = (getActivity()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.detach(fragment);
                        fragmentTransaction.attach(fragment);
                        fragmentTransaction.commit();
                    }


                    ;

                });

            }

            ;
        });

        return rootView;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

