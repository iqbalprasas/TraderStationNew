package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.ChatFragment;
import com.example.telc2.traderstation.fragment.ContactFragment;
import com.example.telc2.traderstation.fragment.MoreFragment;
import com.example.telc2.traderstation.fragment.TimelineFragment;
import com.example.telc2.traderstation.fragment.YesterdayFragment;

/**
 * Created by juvetic on broker6/13/17.
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
                ContactFragment tab1 = new ContactFragment();
                return tab1;
            case 1:
                ChatFragment tab2 = new ChatFragment();
                return tab2;
            case 2:
                TimelineFragment tab3 = new TimelineFragment();
                return tab3;
            case 3:
                MoreFragment tab4 = new MoreFragment();
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
