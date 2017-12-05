package com.example.telc2.traderstation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.telc2.traderstation.fragment.BlokirVendorFragment;
import com.example.telc2.traderstation.fragment.DataPeminjamFragment;
import com.example.telc2.traderstation.fragment.FormPeminjamanFragment;
import com.example.telc2.traderstation.fragment.KirimEmailFragment;
import com.example.telc2.traderstation.fragment.KotakMasukFragment;
import com.example.telc2.traderstation.fragment.MasaTenggangKunciFragment;
import com.example.telc2.traderstation.fragment.StatusKunciFragment;
import com.example.telc2.traderstation.fragment.StatusSuratFragment;

/**
 * Created by juvetic on broker6/14/17.
 */

public class AdminPagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;

    public AdminPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FormPeminjamanFragment tab1 = new FormPeminjamanFragment();
                return tab1;
            case 1:
                StatusKunciFragment tab2 = new StatusKunciFragment();
                return tab2;
            case 2:
                StatusSuratFragment tab3 = new StatusSuratFragment();
                return tab3;
            case 3:
                KotakMasukFragment tab4 = new KotakMasukFragment();
                return tab4;
            case 4:
                MasaTenggangKunciFragment tab5 = new MasaTenggangKunciFragment();
                return tab5;
            case 5:
                DataPeminjamFragment tab7 = new DataPeminjamFragment();
                return tab7;
            case 6:
                KirimEmailFragment tab8 = new KirimEmailFragment();
                return tab8;
            case 7:
                BlokirVendorFragment tab9 = new BlokirVendorFragment();
                return tab9;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
