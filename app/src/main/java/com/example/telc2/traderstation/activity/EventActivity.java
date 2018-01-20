package com.example.telc2.traderstation.activity;

import android.content.Intent;
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
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.EventPagerAdapter;

/**
 * Created by iqbal on 12/13/2017.
 */

public class EventActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton back;
    TextView btnJoin1, btnJoin2, btnJoin3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        toolbar = (Toolbar) findViewById(R.id.toolbar_event);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_event);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnJoin1 = (TextView) findViewById(R.id.btn_join_event1);
        btnJoin2 = (TextView) findViewById(R.id.btn_join_event2);
        btnJoin3 = (TextView) findViewById(R.id.btn_join_event3);

        btnJoin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, EventSelectedActivity.class);
                startActivity(intent);
            }
        });

        btnJoin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, EventSelectedActivity.class);
                startActivity(intent);
            }
        });

        btnJoin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, EventSelectedActivity.class);
                startActivity(intent);
            }
        });

    }
}
