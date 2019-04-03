package com.example.juzza.mygamifieddegree;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Term1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Term1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Term1 extends Fragment {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerViewAdapter adapter;
    List<Course> courseList;
    List<Course> courseList2;
    List<Course> courseList3;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Term1.OnFragmentInteractionListener mListener;

    public Term1() {
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
    public static Term2 newInstance(String param1, String param2) {
        Term2 fragment = new Term2();
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
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        final DbHelper dbHelper = new DbHelper(getActivity());
        courseList = dbHelper.getAllCoreCourses();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),courseList);
        recyclerView.setAdapter(adapter);

        //Initialise second recyclerview
        courseList2 = new ArrayList<>();
        recyclerView2 = rootView.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(),2));
        courseList2 = dbHelper.getAllElectiveCourses();
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(getActivity(),courseList2);
        recyclerView2.setAdapter(adapter2);

        //Initialise spinner and third recyclerview
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.faculty));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Arts and Social Science"))
                {
                    courseList3 = new ArrayList<>();
                    recyclerView3 = rootView.findViewById(R.id.recyclerView3);
                    recyclerView3.setHasFixedSize(true);
                    recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    courseList3 = dbHelper.getArtsCourses();
                    RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getActivity(),courseList3);
                    recyclerView3.setAdapter(adapter3);
                } else {
                    courseList3 = new ArrayList<>();
                    recyclerView3 = rootView.findViewById(R.id.recyclerView3);
                    recyclerView3.setHasFixedSize(true);
                    recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    courseList3 = dbHelper.getScienceCourses();
                    RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getActivity(),courseList3);
                    recyclerView3.setAdapter(adapter3);
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
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
        if (context instanceof Term2.OnFragmentInteractionListener) {
            mListener = (Term1.OnFragmentInteractionListener) context;
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
