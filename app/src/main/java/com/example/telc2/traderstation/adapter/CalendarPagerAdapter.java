package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.YesterdayFragment;

/**
 * Created by iqbal on 12/12/2017.
 */

public class CalendarPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public CalendarPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                YesterdayFragment tab1 = new YesterdayFragment();
                return tab1;
            case 1:
                YesterdayFragment tab2 = new YesterdayFragment();
                return tab2;
            case 2:
                YesterdayFragment tab3 = new YesterdayFragment();
                return tab3;
            case 3:
                YesterdayFragment tab4 = new YesterdayFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
