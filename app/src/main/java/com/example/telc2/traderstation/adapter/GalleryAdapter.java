package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.AlbumFragment;
import com.example.telc2.traderstation.fragment.LatestFragment;

/**
 * Created by iqbal on 1/24/2018.
 */

public class GalleryAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;

    public GalleryAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LatestFragment tab1 = new LatestFragment();
                //AlbumFragment tab1 = new AlbumFragment();
                return tab1;
            case 1:
                AlbumFragment tab2 = new AlbumFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
