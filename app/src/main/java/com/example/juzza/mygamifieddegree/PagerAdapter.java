package com.example.juzza.mygamifieddegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Term1 term1 = new Term1();
                return term1;

            case 1:
                Term2 term2 = new Term2();
                return term2;

            case 2:
                Term3 term3 = new Term3();
                return term3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return mNoOfTabs;
    }
}
