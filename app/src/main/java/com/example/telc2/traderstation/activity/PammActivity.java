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
import com.example.telc2.traderstation.adapter.PammAdapter;
import com.example.telc2.traderstation.model.PAMM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/22/2017.
 */

public class PammActivity extends AppCompatActivity {
    private List<PAMM> pammList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PammAdapter pammAdapter;
    private Toolbar toolbar;
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pamm);

        toolbar = (Toolbar) findViewById(R.id.toolbar_pamm);

        //setSupportActionBar(toolbar);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_pamm);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerPamm);
        //dataList = new ArrayList<HashMap<String,String>>();
        pammAdapter = new PammAdapter(pammList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pammAdapter);
        loadDataDummy();
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            PAMM pamm = new PAMM(1,"PAMM "+String.valueOf(i));
            pammList.add(pamm);
            pammAdapter.notifyDataSetChanged();
        }
    }
}
