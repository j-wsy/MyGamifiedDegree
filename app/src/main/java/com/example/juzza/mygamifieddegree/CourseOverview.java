package com.example.juzza.mygamifieddegree;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
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
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                position = tab.getPosition();
                viewPager.getAdapter().notifyDataSetChanged();
                /*toast.makeText(getApplicationContext(),"The tab position is "+ position,Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    int fragno = getSupportFragmentManager().getFragments().size();
                    toast.makeText(getApplicationContext(),"Fragment No: " + fragno, Toast.LENGTH_SHORT).show();
                }  else if (position == 1) {
                    int fragno = getSupportFragmentManager().getFragments().size();
                    toast.makeText(getApplicationContext(),"Fragment No: " + fragno, Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    int fragno = getSupportFragmentManager().getFragments().size();
                    toast.makeText(getApplicationContext(),"Fragment No: " + fragno, Toast.LENGTH_SHORT).show();
                }*/
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                viewPager.getAdapter().notifyDataSetChanged();


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