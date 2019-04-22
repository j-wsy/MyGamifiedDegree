package com.example.juzza.mygamifieddegree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterY3 extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapterY3(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                Term1Y3 term1Y3 = new Term1Y3();
                return term1Y3;

            case 1:
                Term2Y3 term2Y3 = new Term2Y3();
                return term2Y3;

            case 2:
                Term3Y3 term3Y3 = new Term3Y3();
                return term3Y3;
            default:
                return null;
        }
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;

    }

    @Override
    public int getCount() {

        return 3;
    }
}
