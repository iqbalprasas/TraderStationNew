package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.TraderPerformanceAdapter;
import com.example.telc2.traderstation.model.TraderPerformance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/14/2017.
 */

public class TraderPerformanceActvity extends AppCompatActivity {

    private List<TraderPerformance> traderPerformanceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TraderPerformanceAdapter traderPerformanceAdapter;
    private Toolbar toolbar;
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_performance);

        toolbar = (Toolbar) findViewById(R.id.toolbar_tp);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_tp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerTp);
        //dataList = new ArrayList<HashMap<String,String>>();
        traderPerformanceAdapter = new TraderPerformanceAdapter(traderPerformanceList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(traderPerformanceAdapter);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            TraderPerformance traderPerformance = new TraderPerformance(1,"Username "+String.valueOf(i),75);
            traderPerformanceList.add(traderPerformance);
            traderPerformanceAdapter.notifyDataSetChanged();
        }
    }
}
