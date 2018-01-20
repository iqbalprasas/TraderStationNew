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
import com.example.telc2.traderstation.activity.BrokerActivity;
import com.example.telc2.traderstation.activity.CalendarActivity;
import com.example.telc2.traderstation.activity.CompetitionActivity;
import com.example.telc2.traderstation.activity.EAPerformanceActivity;
import com.example.telc2.traderstation.activity.EventActivity;
import com.example.telc2.traderstation.activity.GalleryActivity;
import com.example.telc2.traderstation.activity.PammActivity;
import com.example.telc2.traderstation.activity.RebateBrokerActivity;
import com.example.telc2.traderstation.activity.TraderPerformanceActvity;
import com.example.telc2.traderstation.activity.WebinarActivity;

/**
 * Created by iqbal on 11/back20/2017.
 */

public class MoreFragment extends Fragment{

    ImageButton btnTraderPerformance, btnEvent, btnWebinar, btnCalendar, btnCompetition,
            btnRebateBroker, btnBroker, btnEaPerformance, btnPamm, btnGallery;
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

        btnEvent = (ImageButton)v.findViewById(R.id.btn_more_event);
        btnTraderPerformance = (ImageButton) v.findViewById(R.id.btn_more_trader_performance);
        btnWebinar = (ImageButton) v.findViewById(R.id.btn_more_webinar);
        btnCalendar = (ImageButton) v.findViewById(R.id.btn_more_calendar);
        btnCompetition = (ImageButton) v.findViewById(R.id.btn_more_competition);
        btnRebateBroker = (ImageButton) v.findViewById(R.id.btn_more_rebate);
        btnBroker = (ImageButton) v.findViewById(R.id.btn_more_broker);
        btnEaPerformance = (ImageButton) v.findViewById(R.id.btn_more_ea_performance);
        btnPamm = (ImageButton) v.findViewById(R.id.btn_more_pamm);
        btnGallery = (ImageButton) v.findViewById(R.id.btn_more_gallery);

        btnTraderPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TraderPerformanceActvity.class);
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
        btnCompetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CompetitionActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnRebateBroker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RebateBrokerActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnBroker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BrokerActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnEaPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EAPerformanceActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnPamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PammActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GalleryActivity.class);
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
