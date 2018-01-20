package com.example.telc2.traderstation.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.config.MyWebViewClient;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by iqbal on 12/27/2017.
 */

public class PammSelectedActivity extends AppCompatActivity {

    WebView webView;
    Toolbar toolbar;
    ImageButton back;
    LineGraphSeries<DataPoint> mSeries2;
    GraphView graph2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pamm_selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar_pamm_selected);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_pamm_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        graph2 = (GraphView)findViewById(R.id.graph_pamm);
        mSeries2 = new LineGraphSeries<>();
        mSeries2.setColor(Color.parseColor("#4AB240"));
        // styling grid/labels
        //graph2.getGridLabelRenderer().setGridColor(Color.BLACK);
        //graph2.getGridLabelRenderer().setHighlightZeroLines(false);
        //graph2.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        //graph2.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graph2.getGridLabelRenderer().setGridColor(Color.WHITE);
        graph2.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        graph2.getGridLabelRenderer().setVerticalLabelsVisible(true);
//            graph2.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
//            graph2.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph2.getGridLabelRenderer().reloadStyles();
        graph2.getViewport().setBackgroundColor(Color.WHITE);
        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(0);
        graph2.getViewport().setMaxX(50);
        graph2.getViewport().setMinY(0);
        graph2.getViewport().setMaxY(100);
//        graph2.getViewport().setScalable(true);
//        graph2.getViewport().setScalableY(true);
        graph2.addSeries(mSeries2);
        mSeries2.appendData(new DataPoint(0, 3), true, 100);
        for (int i=1;i<=20;i++){
            mSeries2.appendData(new DataPoint((i*5), i*5), true, 100);
        }

        webView = (WebView) findViewById(R.id.web_table_pamm);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalFadingEdgeEnabled(false);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
//                progressBar.setProgress(progress);
//                if (progress == 100) {
//                    progressBar.setVisibility(View.GONE);
//
//                } else {
//                    progressBar.setVisibility(View.VISIBLE);
//
//                }
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("http://slbnuruliman.sch.id/tes/table_tes2.php");
    }
}
