package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.FormPeminjamanFragment;
import com.example.telc2.traderstation.fragment.StatusKunciFragment;
import com.example.telc2.traderstation.fragment.StatusSuratFragment;
import com.example.telc2.traderstation.fragment.YesterdayFragment;
import com.example.telc2.traderstation.model.Yesterday;

/**
 * Created by juvetic on 6/13/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
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
            case 4:
                YesterdayFragment tab5 = new YesterdayFragment();
                return tab5;
            case 5:
                YesterdayFragment tab6 = new YesterdayFragment();
                return tab6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
