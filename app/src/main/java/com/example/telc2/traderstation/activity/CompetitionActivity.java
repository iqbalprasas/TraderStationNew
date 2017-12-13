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
import com.example.telc2.traderstation.adapter.TopTraderAdapter;
import com.example.telc2.traderstation.model.TopTrader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/13/2017.
 */

public class CompetitionActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton back;
    List<TopTrader> topTradersList = new ArrayList<>();
    RecyclerView recyclerView;
    TopTraderAdapter adapterTopTraders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        toolbar = (Toolbar) findViewById(R.id.toolbar_competition);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_competition);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        recyclerView = (RecyclerView)findViewById(R.id.recyclerTopTrader);
        //dataList = new ArrayList<HashMap<String,String>>();
        adapterTopTraders = new TopTraderAdapter(topTradersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CompetitionActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterTopTraders);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            TopTrader topTrader = new TopTrader(1,"","Username "+String.valueOf(i),85,"","","","","","","","");
            topTradersList.add(topTrader);
            adapterTopTraders.notifyDataSetChanged();
        }
    }
}
