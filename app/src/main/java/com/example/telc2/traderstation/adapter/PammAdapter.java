package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.PammSelectedActivity;
import com.example.telc2.traderstation.model.PAMM;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

/**
 * Created by iqbal on 12/22/2017.
 */

public class PammAdapter extends RecyclerView.Adapter<PammAdapter.HolderData> {

    private List<PAMM> pammList;

    public PammAdapter(List<PAMM> pammList) {
        this.pammList = pammList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pamm, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        PAMM pamm = pammList.get(position);
        holder.id = pamm.getId();
        holder.txName.setText(pamm.getName());
    }

    @Override
    public int getItemCount() {
        return pammList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        int id;
        TextView txName;
        LineGraphSeries<DataPoint> mSeries2;
        GraphView graph2;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txName = (TextView) itemView.findViewById(R.id.tx_name_pamm);
            graph2 = (GraphView) itemView.findViewById(R.id.graph_pamm);
            mSeries2 = new LineGraphSeries<>();
            mSeries2.setColor(Color.parseColor("#4AB240"));
            // styling grid/labels
            //graph2.getGridLabelRenderer().setGridColor(Color.BLACK);
            //graph2.getGridLabelRenderer().setHighlightZeroLines(false);
            //graph2.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
            //graph2.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
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
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(100);
            graph2.getViewport().setScalable(true);
            graph2.getViewport().setScalableY(true);
            graph2.addSeries(mSeries2);
            for (int i=0;i<10;i++){
                mSeries2.appendData(new DataPoint((i*5), i*5), true, 50);
            }
        }
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, PammSelectedActivity.class);
            context.startActivity(intent);
        }


    }

}
