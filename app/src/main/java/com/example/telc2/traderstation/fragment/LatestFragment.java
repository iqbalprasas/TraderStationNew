package com.example.telc2.traderstation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.LatestAdapter;
import com.example.telc2.traderstation.model.Latest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbal on 12/29/2017.
 */

public class LatestFragment extends Fragment {

    private List<Latest> latestList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LatestAdapter latestAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /** Inflating the layout for this fragment **/
        View v = inflater.inflate(R.layout.fragment_latest_gallery, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerLatest);
        //dataList = new ArrayList<HashMap<String,String>>();
        latestAdapter = new LatestAdapter(latestList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(latestAdapter);
        loadDataDummy();
        return v;
    }

    public void loadDataDummy(){
        for (int i = 0;i<10;i++){
            Latest latest = new Latest(String.valueOf(i),"User "+String.valueOf(i));
            latestList.add(latest);
            latestAdapter.notifyDataSetChanged();
        }
    }
}
