package com.example.telc2.traderstation.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.BrokerAdapter;
import com.example.telc2.traderstation.helper.ExpandableHeightGridView;
import com.example.telc2.traderstation.model.Broker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/15/2017.
 */

public class BrokerActivity extends AppCompatActivity {

    ExpandableHeightGridView gridBroker;
    private Toolbar toolbar;
    private ImageButton back;
    LinearLayout expandButton;
    RelativeLayout layoutBackground;
    int images[] = {R.drawable.seminar_web, R.drawable.seminar_web, R.drawable.seminar_web, R.drawable.seminar_web};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker);

        toolbar = (Toolbar) findViewById(R.id.toolbar_broker);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_broker);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        gridBroker = (ExpandableHeightGridView)findViewById(R.id.gridview_broker);
        gridBroker.setExpanded(true);
        // Create an object of CustomAdapter and set Adapter to GirdView
        BrokerAdapter brokerAdapter = new BrokerAdapter(BrokerActivity.this, images);
        gridBroker.setAdapter(brokerAdapter);
        // implement setOnItemClickListener event on GridView
        gridBroker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animation slideDown = AnimationUtils.loadAnimation(BrokerActivity.this, R.anim.anim_expand);

                //layoutBackground = (RelativeLayout) view.findViewById(R.id.layout_background);
                expandButton = (LinearLayout) view.findViewById(R.id.layout_expand_broker);
                if(expandButton.getVisibility()==View.GONE){
                    expandButton.setVisibility(View.VISIBLE);
                    expandButton.startAnimation(slideDown);
                }
                // set an Intent to Another Activity
                //Intent intent = new Intent(BrokerActivity.this, ReviewBrokerActivity.class);
                //startActivity(intent); // start Intent
            }
        });
    }

}
