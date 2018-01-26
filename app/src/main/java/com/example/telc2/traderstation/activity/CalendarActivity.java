package com.example.telc2.traderstation.activity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.CalendarPagerAdapter;

/**
 * Created by iqbal on 12/12/2017.
 */

public class CalendarActivity extends AppCompatActivity{

    Toolbar toolbar;
    ViewPager viewPager;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        viewPager = (ViewPager) findViewById(R.id.view_pager_calendar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_calendar);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_calendar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_calendar);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Yesterday");
        tabLayout.getTabAt(1).setText("Today");
        tabLayout.getTabAt(2).setText("Tomorrow");
        tabLayout.getTabAt(3).setText("This Week");

//        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
//        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        GradientDrawable drawable = new GradientDrawable();
//        drawable.setColor(Color.LTGRAY);
//        drawable.setSize(1, 1);
//        linearLayout.setDividerPadding(10);
//        linearLayout.setDividerDrawable(drawable);

        final CalendarPagerAdapter adapter = new CalendarPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
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
