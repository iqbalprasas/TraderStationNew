package com.example.telc2.traderstation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
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
    private Toolbar toolbar;
    private ImageButton searctTt;
    private LinearLayout linearFilter;

    public TimelineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_timeline, container, false);

        setHasOptionsMenu(true);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_menu);
        searctTt = (ImageButton) toolbar.findViewById(R.id.btn_search_tt);

        checkAll = (CheckBox)v.findViewById(R.id.checkBoxAll);
        checkStatus = (CheckBox)v.findViewById(R.id.checkBoxStatus);
        checkTrading = (CheckBox)v.findViewById(R.id.checkBoxTrading);
        checkNews = (CheckBox)v.findViewById(R.id.checkBoxNews);
        checkArticle = (CheckBox)v.findViewById(R.id.checkBoxArticle);
        checkAnalysis = (CheckBox)v.findViewById(R.id.checkBoxAnalysis);
        linearFilter = (LinearLayout) v.findViewById(R.id.layout_filter);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab_timeline);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New Post", Snackbar.LENGTH_LONG)
                        .setAction("Select", null).show();
            }
        });

        linearFilter.setVisibility(v.GONE);

//        checkAll.setVisibility(v.GONE);
//        checkStatus.setVisibility(v.GONE);
//        checkTrading.setVisibility(v.GONE);
//        checkNews.setVisibility(v.GONE);
//        checkArticle.setVisibility(v.GONE);
//        checkAnalysis.setVisibility(v.GONE);

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
                if(linearFilter.getVisibility()==v.VISIBLE){
                    Animation slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.anim_close);
                    linearFilter.startAnimation(slideUp);
                    linearFilter.setVisibility(v.GONE);
                }else {
                    linearFilter.setVisibility(v.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.anim_expand);

                    //adding sliding effect
                    linearFilter.startAnimation(slideDown);
                }

//                if(checkAll.getVisibility()==v.VISIBLE){
//                    checkAll.setVisibility(v.GONE);
//                    checkStatus.setVisibility(v.GONE);
//                    checkTrading.setVisibility(v.GONE);
//                    checkNews.setVisibility(v.GONE);
//                    checkArticle.setVisibility(v.GONE);
//                    checkAnalysis.setVisibility(v.GONE);
//                }else {
//                    checkAll.setVisibility(v.VISIBLE);
//                    checkStatus.setVisibility(v.VISIBLE);
//                    checkTrading.setVisibility(v.VISIBLE);
//                    checkNews.setVisibility(v.VISIBLE);
//                    checkArticle.setVisibility(v.VISIBLE);
//                    checkAnalysis.setVisibility(v.VISIBLE);
//                }
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
        Timeline timeline;
        for (int i = 0;i<10;i++){
            if((i % 2) == 0){
                timeline = new Timeline("Profile Name "+String.valueOf(i),"News",String.valueOf(i*2)+" minutes ago");
            }else{
                timeline = new Timeline("Profile Name "+String.valueOf(i),"Personal Status",String.valueOf(i*2)+" minutes ago");
            }
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
