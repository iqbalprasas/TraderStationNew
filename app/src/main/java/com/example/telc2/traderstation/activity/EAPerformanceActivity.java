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
import com.example.telc2.traderstation.adapter.EAPerformanceAdapter;
import com.example.telc2.traderstation.model.EAPerformance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/19/2017.
 */

public class EAPerformanceActivity extends AppCompatActivity {

    private List<EAPerformance> eaPerformanceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EAPerformanceAdapter eaPerformanceAdapter;
    private Toolbar toolbar;
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ea_performance);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ea);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_ea);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerEa);
        //dataList = new ArrayList<HashMap<String,String>>();
        eaPerformanceAdapter = new EAPerformanceAdapter(eaPerformanceList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eaPerformanceAdapter);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            EAPerformance eaPerformance = new EAPerformance(1,"Username "+String.valueOf(i));
            eaPerformanceList.add(eaPerformance);
            eaPerformanceAdapter.notifyDataSetChanged();
        }
    }
}
