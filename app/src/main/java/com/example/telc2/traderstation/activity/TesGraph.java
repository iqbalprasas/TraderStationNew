//package com.example.telc2.traderstation.activity;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.graphics.DashPathEffect;
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//
//import com.example.telc2.traderstation.R;
//import com.github.mikephil.charting.animation.Easing;
//import com.github.mikephil.charting.charts.LineChart;
//import com.github.mikephil.charting.components.LimitLine;
//import com.github.mikephil.charting.components.YAxis;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.highlight.Highlight;
//import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
//import com.github.mikephil.charting.listener.ChartTouchListener;
//import com.github.mikephil.charting.listener.OnChartGestureListener;
//import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
//import com.github.mikephil.charting.utils.ColorTemplate;
//import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.Viewport;
//import com.jjoe64.graphview.series.DataPoint;
//import com.jjoe64.graphview.series.LineGraphSeries;
//
//import java.util.ArrayList;
//import java.util.Random;
//
///**
// * Created by iqbal on competition11/bg_buttong_long21/2017.
// */
//
//public class TesGraph extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {
//
//    private final Handler mHandler = new Handler();
//    private Runnable mTimer2;
//    private LineGraphSeries<DataPoint> mSeries2,mSeriesLimit;
//    private double graph2LastXValue = 5d;
//
//    private LineChart mChart;
//    private LineDataSet set1;
//    private LineData data;
//    private ArrayList<ILineDataSet> dataSets;
//    int index = 5;
//    private Toolbar toolbar;
//    private ImageButton back;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trader_performance);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar_tp);
//        back = (ImageButton)toolbar.findViewById(R.id.btn_back_tp);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        GraphView graph2 = (GraphView) findViewById(R.id.graph_tp_tes);
//        mSeries2 = new LineGraphSeries<>();
//        mSeriesLimit = new LineGraphSeries<>();
//        mSeries2.setColor(R.color.colorPrimary);
//        mSeriesLimit.setColor(Color.RED);
//        graph2.addSeries(mSeries2);
//        graph2.addSeries(mSeriesLimit);
//        graph2.getViewport().setXAxisBoundsManual(true);
//        graph2.getViewport().setMinX(0);
//        graph2.getViewport().setMaxX(50);
//
//        mChart = (LineChart) findViewById(R.id.linechart);
//        mChart.setOnChartGestureListener(this);
//        mChart.setOnChartValueSelectedListener(this);
//        mChart.setDrawGridBackground(false);
//        // enable touch gestures
//        mChart.setTouchEnabled(true);
//
//        // enable scaling and dragging
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//
//        setData();
//        addEntry();
//        LimitLine upper_limit = new LimitLine(130f, "Limit");
//        upper_limit.setLineWidth(4f);
//        upper_limit.enableDashedLine(10f, 10f, 0f);
//        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        upper_limit.setTextSize(10f);
//        YAxis leftAxis = mChart.getAxisLeft();
//        // reset all limit lines to avoid overlapping lines
//        leftAxis.removeAllLimitLines();
//        leftAxis.addLimitLine(upper_limit);
//        leftAxis.setAxisMaxValue(220f);
//        leftAxis.setAxisMinValue(-50f);
//        //leftAxis.setYOffset(20f);
//        leftAxis.enableGridDashedLine(10f, 10f, 0f);
//        leftAxis.setDrawZeroLine(false);
//        leftAxis.setDrawLimitLinesBehindData(true);
//        mChart.getAxisRight().setEnabled(false);
//
//        mChart.setVisibleXRangeMaximum(50);
//
//        mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
//
//        //  dont forget to refresh the drawing
//        mChart.invalidate();
//    }
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        mTimer2 = new Runnable() {
//            @Override
//            public void run() {
//                graph2LastXValue += 1d;
//                mSeries2.appendData(new DataPoint(graph2LastXValue, getRandom()), true, 50);
//                mSeriesLimit.appendData(new DataPoint(graph2LastXValue, 1), true, 50);
//                mHandler.postDelayed(this, 500);
//            }
//        };
//        mHandler.postDelayed(mTimer2, 1000);
//    }
//
//    @Override
//    public void onPause() {
//        mHandler.removeCallbacks(mTimer2);
//        super.onPause();
//    }
//
//    private DataPoint[] generateData() {
//        int count = 30;
//        DataPoint[] values = new DataPoint[count];
//        for (int i=0; i<count; i++) {
//            double x = i;
//            double f = mRand.nextDouble()*0.15+0.3;
//            double y = Math.sin(i*f+2) + mRand.nextDouble()*0.3;
//            DataPoint v = new DataPoint(x, y);
//            values[i] = v;
//        }
//        return values;
//    }
//
//    double mLastRandom = 2;
//    Random mRand = new Random();
//    private double getRandom() {
//        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
//    }
//
//
//    private void setData() {
//        ArrayList<String> xVals = setXAxisValues();
//
//        ArrayList<Entry> yVals = setYAxisValues();
//
//        // create a dataset and give it a type
//        set1 = new LineDataSet(yVals, "Data");
//
//        set1.setFillAlpha(110);
//        // set1.setFillColor(Color.RED);
//
//        // set the line to be drawn like this "- - - - - -"
//        //   set1.enableDashedLine(10f, 5f, 0f);
//        // set1.enableDashedHighlightLine(10f, 5f, 0f);
//        set1.setColor(Color.BLACK);
//        set1.setCircleColor(Color.BLACK);
//        set1.setLineWidth(1f);
//        set1.setCircleRadius(3f);
//        set1.setDrawCircleHole(false);
//        set1.setValueTextSize(9f);
//        set1.setDrawFilled(true);
//
//        dataSets = new ArrayList<ILineDataSet>();
//        dataSets.add(set1); // add the datasets
//
//        // create a data object with the datasets
//        data = new LineData(xVals, dataSets);
//
//        // set data
//        mChart.setData(data);
//
//    }
//
//    private void addEntry() {
//        while(index<=30) {
//            if((index%2)==0) {
//                data.addEntry(new Entry(30, index), 0);
//            }else{
//                data.addEntry(new Entry(65, index), 0);
//            }
//            data.addXValue(String.valueOf(index*10));
//            data.notifyDataChanged();
//            mChart.notifyDataSetChanged();
//            mChart.invalidate();
//            index++;
//        }
//    }
//
//    private ArrayList<String> setXAxisValues(){
//        ArrayList<String> xVals = new ArrayList<String>();
//        xVals.add("search10");
//        xVals.add("back20");
//        xVals.add("google30");
//        xVals.add("google30.rebate_broker5");
//        xVals.add("40");
//
//        return xVals;
//    }
//
//    private ArrayList<Entry> setYAxisValues(){
//        ArrayList<Entry> yVals = new ArrayList<Entry>();
//        yVals.add(new Entry(60, 0));
//        yVals.add(new Entry(48, 1));
//        yVals.add(new Entry(70.5f, 2));
//        yVals.add(new Entry(100, 3));
//        yVals.add(new Entry(180.9f, 4));
//
//        return yVals;
//    }
//
//    @Override
//    public void onChartGestureStart(MotionEvent me,
//                                    ChartTouchListener.ChartGesture
//                                            lastPerformedGesture) {
//
//        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
//    }
//
//    @Override
//    public void onChartGestureEnd(MotionEvent me,
//                                  ChartTouchListener.ChartGesture
//                                          lastPerformedGesture) {
//
//        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);
//
//        // un-highlight values after the gesture is finished and no single-tap
//        if(lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
//            // or highlightTouch(null) for callback to onNothingSelected(...)
//            mChart.highlightValues(null);
//    }
//
//    @Override
//    public void onChartLongPressed(MotionEvent me) {
//        Log.i("LongPress", "Chart longpressed.");
//    }
//
//    @Override
//    public void onChartDoubleTapped(MotionEvent me) {
//        Log.i("DoubleTap", "Chart double-tapped.");
//    }
//
//    @Override
//    public void onChartSingleTapped(MotionEvent me) {
//        Log.i("SingleTap", "Chart single-tapped.");
//    }
//
//    @Override
//    public void onChartFling(MotionEvent me1, MotionEvent me2,
//                             float velocityX, float velocityY) {
//        Log.i("Fling", "Chart flinged. VeloX: "
//                + velocityX + ", VeloY: " + velocityY);
//    }
//
//    @Override
//    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
//        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
//    }
//
//    @Override
//    public void onChartTranslate(MotionEvent me, float dX, float dY) {
//        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
//    }
//
//    @Override
//    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//        Log.i("Entry selected", e.toString());
//        Log.i("LOWHIGH", "low: " + mChart.getLowestVisibleXIndex()
//                + ", high: " + mChart.getHighestVisibleXIndex());
//
//        Log.i("MIN MAX", "xmin: " + mChart.getXChartMin()
//                + ", xmax: " + mChart.getXChartMax()
//                + ", ymin: " + mChart.getYChartMin()
//                + ", ymax: " + mChart.getYChartMax());
//    }
//
//    @Override
//    public void onNothingSelected() {
//        Log.i("Nothing selected", "Nothing selected.");
//    }
//}
