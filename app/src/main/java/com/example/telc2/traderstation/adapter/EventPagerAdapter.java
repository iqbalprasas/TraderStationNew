package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.FirstEventFragment;

/**
 * Created by iqbal on 12/13/2017.
 */

public class EventPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public EventPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstEventFragment tab1 = new FirstEventFragment();
                return tab1;
            case 1:
                FirstEventFragment tab2 = new FirstEventFragment();
                return tab2;
            case 2:
                FirstEventFragment tab3 = new FirstEventFragment();
                return tab3;
            case 3:
                FirstEventFragment tab4 = new FirstEventFragment();
                return tab4;
            case 4:
                FirstEventFragment tab5 = new FirstEventFragment();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
