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
import com.example.telc2.traderstation.adapter.AdapterWebinar;
import com.example.telc2.traderstation.model.Webinar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/8/2017.
 */

public class WebinarActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton back;
    private List<Webinar> webinarList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterWebinar adapterWebinar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar);

        toolbar = (Toolbar) findViewById(R.id.toolbar_webinar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_webinar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerWebinar);
        //dataList = new ArrayList<HashMap<String,String>>();
        adapterWebinar = new AdapterWebinar(webinarList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WebinarActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterWebinar);
        loadDataDummy();

    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Webinar webinar = new Webinar("1","","Judul","12 December 2017","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            webinarList.add(webinar);
            adapterWebinar.notifyDataSetChanged();
        }
    }
}
