package com.example.telc2.traderstation.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

/**
 * Created by iqbal on 12/12/2017.
 */

public class ECSelectedActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler();
    private Runnable mTimer2;
    private LineGraphSeries<DataPoint> mSeries2,mSeriesLimit;
    private double graph2LastXValue = 5d;

    private Toolbar toolbar;
    private ImageButton back;
    double mLastRandom = 2;
    Random mRand;

    private TextView desc;
    private ProgressBar pgrRate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ec_selected);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_ec_selected);
        desc = (TextView) findViewById(R.id.tx_desc1_ec_selected);
        pgrRate = (ProgressBar) findViewById(R.id.pgr_rate_ec_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GraphView graph2 = (GraphView) findViewById(R.id.graph_ec_selected);
        mSeries2 = new LineGraphSeries<>();
        mSeriesLimit = new LineGraphSeries<>();
        mSeries2.setColor(R.color.colorPrimary);
        mSeriesLimit.setColor(Color.RED);
        graph2.addSeries(mSeries2);
        graph2.addSeries(mSeriesLimit);
        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(0);
        graph2.getViewport().setMaxX(50);

        mRand = new Random();

        String s = getIntent().getStringExtra("name");
        desc.setText(s);
        s = getIntent().getStringExtra("rate");
        pgrRate.setProgress(Integer.parseInt(s));
    }

    @Override
    public void onResume() {
        super.onResume();

        mTimer2 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue += 1d;
                mSeries2.appendData(new DataPoint(graph2LastXValue, getRandom()), true, 50);
                mSeriesLimit.appendData(new DataPoint(graph2LastXValue, 1), true, 50);
                mHandler.postDelayed(this, 500);
            }
        };
        mHandler.postDelayed(mTimer2, 1000);
    }

    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer2);
        super.onPause();
    }

    private double getRandom() {
        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
    }
}
