package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.TraderPerformance;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;


/**
 * Created by iqbal on 12/14/2017.
 */

public class TraderPerformanceAdapter extends RecyclerView.Adapter<TraderPerformanceAdapter.HeroViewHolder> {
    private List<TraderPerformance> traderPerformanceList;
    private Context context;

    private static int currentPosition = -1;

    public TraderPerformanceAdapter(List<TraderPerformance> traderPerformanceList, Context context) {
        this.traderPerformanceList = traderPerformanceList;
        this.context = context;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tp, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
        TraderPerformance traderPerformance = traderPerformanceList.get(position);
        holder.txName.setText(traderPerformance.getUsername());
        holder.expandLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.anim_expand);

            //toggling visibility
            holder.expandLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.expandLayout.startAnimation(slideDown);

            holder.btnExpand.setVisibility(View.GONE);
        }

        holder.btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the position of the item to expand it
                currentPosition = position;
                //reloding the list
                notifyDataSetChanged();
            }
        });

        holder.btnExpandUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPosition = -1;
                //reloding the list
                notifyDataSetChanged();
                holder.btnExpand.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return traderPerformanceList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemSelectedListener {
        TextView txName;
        ImageButton btnExpand;
        ImageButton btnExpandUp;
        LinearLayout expandLayout;
        LineGraphSeries<DataPoint> mSeries2,mSeriesLimit;
        GraphView graph2;
        String [] periods = {"Monthly","Weekly"};

        HeroViewHolder(View itemView) {
            super(itemView);

            txName = (TextView) itemView.findViewById(R.id.tx_username_tp);
            btnExpand = (ImageButton) itemView.findViewById(R.id.btn_expand_tp);
            btnExpandUp = (ImageButton) itemView.findViewById(R.id.btn_expand_tp_up);
            expandLayout = (LinearLayout) itemView.findViewById(R.id.expand_layout_tp);
            graph2 = (GraphView) itemView.findViewById(R.id.graph_tp);
            mSeries2 = new LineGraphSeries<>();
            mSeriesLimit = new LineGraphSeries<>();

            //Getting the instance of Spinner and applying OnItemSelectedListener on it
            Spinner spin = (Spinner) itemView.findViewById(R.id.spin_tp);
            spin.setOnItemSelectedListener(this);

            //Creating the ArrayAdapter instance having the bank name list
            ArrayAdapter aa = new ArrayAdapter(itemView.getContext(),R.layout.black_spinner_item, periods);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);

            mSeries2.setColor(Color.parseColor("#4AB240"));
            mSeriesLimit.setColor(Color.RED);
            // styling grid/labels
            //graph2.getGridLabelRenderer().setGridColor(Color.BLACK);
            //graph2.getGridLabelRenderer().setHighlightZeroLines(false);
            graph2.getGridLabelRenderer().setGridColor(Color.WHITE);
            graph2.getGridLabelRenderer().setHorizontalLabelsVisible(false);
            graph2.getGridLabelRenderer().setVerticalLabelsVisible(false);
//            graph2.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
//            graph2.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
            graph2.getGridLabelRenderer().reloadStyles();
            graph2.getViewport().setBackgroundColor(Color.WHITE);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setMinX(0);
            graph2.getViewport().setMaxX(50);
            graph2.getViewport().setScalable(true);
            graph2.getViewport().setScalableY(true);
            graph2.addSeries(mSeries2);
            graph2.addSeries(mSeriesLimit);
            mSeriesLimit.appendData(new DataPoint(0, 37), true, 50);
            mSeriesLimit.appendData(new DataPoint(50, 37), true, 50);
            mSeries2.appendData(new DataPoint(0, 20), true, 50);
            mSeries2.appendData(new DataPoint(10, 25), true, 50);
            mSeries2.appendData(new DataPoint(20, 15), true, 50);
            mSeries2.appendData(new DataPoint(30, 40), true, 50);
            mSeries2.appendData(new DataPoint(40, 35), true, 50);
            mSeries2.appendData(new DataPoint(50, 50), true, 50);
        }

        //Performing action onItemSelected and onNothing selected
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
            //Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    }
}
