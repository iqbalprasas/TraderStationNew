package com.example.telc2.traderstation.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.GalleryAdapter;
import com.example.telc2.traderstation.fragment.AlbumFragment;
import com.example.telc2.traderstation.fragment.LatestFragment;

/**
 * Created by iqbal on 12/29/2017.
 */

public class GalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton back;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar_gallery);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_gallery);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager_gallery);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_gallery);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Latest");
        tabLayout.getTabAt(1).setText("Album");

        final GalleryAdapter adapter = new GalleryAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
