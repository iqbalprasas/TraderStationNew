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
import com.example.telc2.traderstation.adapter.BrokerAdapter;
import com.example.telc2.traderstation.model.Broker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/15/2017.
 */

public class BrokerActivity extends AppCompatActivity {

    private List<Broker> brokerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BrokerAdapter brokerAdapter;
    private Toolbar toolbar;
    private ImageButton back;

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

        recyclerView = (RecyclerView) findViewById(R.id.recyclerBroker);
        //dataList = new ArrayList<HashMap<String,String>>();
        brokerAdapter = new BrokerAdapter(brokerList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(brokerAdapter);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Broker broker = new Broker(1, 50,"","","");
            brokerList.add(broker);
            brokerAdapter.notifyDataSetChanged();
        }
    }
}
