package com.example.telc2.traderstation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.CalendarActivity;
import com.example.telc2.traderstation.activity.EventActivity;
import com.example.telc2.traderstation.activity.TraderPerformance;
import com.example.telc2.traderstation.activity.WebinarActivity;

/**
 * Created by iqbal on 11/back20/2017.
 */

public class MoreFragment extends Fragment{

    Button btnTraderPerformance, btnEvent, btnWebinar, btnCalendar;
    private Toolbar toolbar;
    private ImageButton searctTt;

    public MoreFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_more, container, false);
        setHasOptionsMenu(true);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_menu);
        searctTt = (ImageButton) toolbar.findViewById(R.id.btn_search_tt);

        btnEvent = (Button)v.findViewById(R.id.btn_more_event);
        btnTraderPerformance = (Button) v.findViewById(R.id.btn_more_trader_performance);
        btnWebinar = (Button) v.findViewById(R.id.btn_more_webinar);
        btnCalendar = (Button) v.findViewById(R.id.btn_more_calendar);
        btnTraderPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Trader Performance clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), TraderPerformance.class);
                getActivity().startActivity(intent);
            }
        });
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EventActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnWebinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebinarActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CalendarActivity.class);
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
