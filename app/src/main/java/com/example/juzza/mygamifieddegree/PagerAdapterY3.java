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
                Term1Y3 term1 = new Term1Y3();
                return term1;

            case 1:
                Term2Y3 term2 = new Term2Y3();
                return term2;

            case 2:
                Term3Y3 term3 = new Term3Y3();
                return term3;
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
