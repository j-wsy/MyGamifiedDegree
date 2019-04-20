package com.example.juzza.mygamifieddegree;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.widget.Toast;

public class CourseOverview extends AppCompatActivity implements Term1.OnFragmentInteractionListener, Term2.OnFragmentInteractionListener,Term3.OnFragmentInteractionListener{
    Toast toast;
    TabLayout tabLayout;
    static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_overview);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Term 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Term 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Term 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            ActionBar actionBar = getSupportActionBar();

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                position = tab.getPosition();
                toast.makeText(getApplicationContext(),"The tab position is "+ position,Toast.LENGTH_SHORT).show();

                setTitle("My Course Overview");

                actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFEE58")));
                actionBar.setTitle(Html.fromHtml("<font color='#000000'> MyDegree </font>"));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static int getTabNumber() {
        return position;
    }

}