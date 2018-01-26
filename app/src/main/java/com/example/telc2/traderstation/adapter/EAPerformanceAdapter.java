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
import com.example.telc2.traderstation.model.EAPerformance;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

/**
 * Created by iqbal on 12/19/2017.
 */

public class EAPerformanceAdapter extends RecyclerView.Adapter<EAPerformanceAdapter.HeroViewHolder> {
    private List<EAPerformance> eaPerformanceList;
    private Context context;

    private static int currentPosition = -1;

    public EAPerformanceAdapter(List<EAPerformance> eaPerformanceList, Context context) {
        this.eaPerformanceList = eaPerformanceList;
        this.context = context;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ep, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
        EAPerformance eaPerformance = eaPerformanceList.get(position);
        holder.txName.setText(eaPerformance.getUsername());
        //holder.pgrRate.setProgress(eaPerformance.getRate());
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

//                if(currentPosition == position){
//                    //holder.expandLayout.setVisibility(View.GONE);
//                    currentPosition = -1;
//                }else{
//                    //getting the position of the item to expand it
//                    currentPosition = position;
//                }
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
        return eaPerformanceList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView txName;
        ImageButton btnExpand;
        ImageButton btnExpandUp;
        LinearLayout expandLayout;
        LineGraphSeries<DataPoint> mSeries2;
        GraphView graph2;

        HeroViewHolder(View itemView) {
            super(itemView);

            txName = (TextView) itemView.findViewById(R.id.tx_username_ea);
            btnExpand = (ImageButton) itemView.findViewById(R.id.btn_expand_ea);
            btnExpandUp = (ImageButton) itemView.findViewById(R.id.btn_expand_ea_up);
            expandLayout = (LinearLayout) itemView.findViewById(R.id.expand_layout_ea);
            graph2 = (GraphView) itemView.findViewById(R.id.graph_ea);
            mSeries2 = new LineGraphSeries<>();

            mSeries2.setColor(Color.parseColor("#4AB240"));
            graph2.getGridLabelRenderer().setGridColor(Color.BLACK);
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
            graph2.getViewport().setScalable(true);
            graph2.getViewport().setScalableY(true);
            graph2.addSeries(mSeries2);
            mSeries2.appendData(new DataPoint(10, 25), true, 50);
            mSeries2.appendData(new DataPoint(20, 15), true, 50);
            mSeries2.appendData(new DataPoint(30, 40), true, 50);
            mSeries2.appendData(new DataPoint(40, 35), true, 50);
            mSeries2.appendData(new DataPoint(50, 50), true, 50);
        }
    }
}
