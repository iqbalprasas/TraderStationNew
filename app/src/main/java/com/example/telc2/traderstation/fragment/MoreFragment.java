package com.example.telc2.traderstation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.TraderPerformance;

/**
 * Created by iqbal on 11/20/2017.
 */

public class MoreFragment extends Fragment{

    Button btnTraderPerformance;

    public MoreFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_more, container, false);
        setHasOptionsMenu(true);
        btnTraderPerformance = (Button) v.findViewById(R.id.btn_more_trader_performance);
        btnTraderPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Trader Performance clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), TraderPerformance.class);
                getActivity().startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.search).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

}
