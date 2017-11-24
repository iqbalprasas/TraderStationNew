package com.example.telc2.traderstation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.AdapterTimeline;
import com.example.telc2.traderstation.model.Timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 11/13/2017.
 */

public class TimelineFragment extends Fragment implements SearchView.OnQueryTextListener {

    List<Timeline> timelineList = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterTimeline adapterTimeline;
    private CheckBox checkAll, checkStatus, checkTrading, checkNews,checkArticle, checkAnalysis;
    private Button filter;
    private SearchView searchView;

    public TimelineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_timeline, container, false);

        setHasOptionsMenu(true);

        checkAll = (CheckBox)v.findViewById(R.id.checkBoxAll);
        checkStatus = (CheckBox)v.findViewById(R.id.checkBoxStatus);
        checkTrading = (CheckBox)v.findViewById(R.id.checkBoxTrading);
        checkNews = (CheckBox)v.findViewById(R.id.checkBoxNews);
        checkArticle = (CheckBox)v.findViewById(R.id.checkBoxArticle);
        checkAnalysis = (CheckBox)v.findViewById(R.id.checkBoxAnalysis);

        checkAll.setVisibility(v.INVISIBLE);
        checkAll.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        checkStatus.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        checkTrading.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        checkNews.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        checkArticle.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        checkAnalysis.setLayoutParams(new LinearLayout.LayoutParams(0,0));

        filter = (Button)v.findViewById(R.id.button_filter_);

        searchView =(SearchView)v.findViewById(R.id.search_timeline);

        searchView.setOnQueryTextListener(this);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerTimeline);
        //dataList = new ArrayList<HashMap<String,String>>();
        adapterTimeline = new AdapterTimeline(timelineList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterTimeline);
        loadDataDummy();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    filter("Consumer");
                }else{
                    filter("");
                }
            }
        });

        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    filter("dfgfdgffd");
                }else{
                    filter("");
                }
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAll.getVisibility()==v.VISIBLE){
                    checkAll.setVisibility(v.INVISIBLE);
                    checkAll.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    checkStatus.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    checkTrading.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    checkNews.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    checkArticle.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                    checkAnalysis.setLayoutParams(new LinearLayout.LayoutParams(0,0));
                }else {
                    checkAll.setVisibility(v.VISIBLE);
                    checkAll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    checkStatus.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    checkTrading.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    checkNews.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    checkArticle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    checkAnalysis.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                }
            }
        });
//        checkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                filter("Consumer");
//            }
//        });
//        checkStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                filter("jklkddkdd");
//            }
//        });
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.search).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    public void filter(String text){
        List<Timeline> temp = new ArrayList();
        for(Timeline d: timelineList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getProfileName().contains(text)){
                temp.add(d);
            }
        }
        //update recyclerview
        adapterTimeline.updateList(temp);
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Timeline timeline = new Timeline("1","","Profile Name","","1 minute ago","lorem ipsum","","","","");
            timelineList.add(timeline);
            adapterTimeline.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        filter(query.toString());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(newText.equals("")){
            adapterTimeline.updateList(timelineList);
        }
        return false;
    }
}
