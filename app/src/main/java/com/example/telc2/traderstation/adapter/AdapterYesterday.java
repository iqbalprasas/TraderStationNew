package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.ECSelectedActivity;
import com.example.telc2.traderstation.model.Yesterday;

import java.util.List;

/**
 * Created by TELC2 on 6/16/2017.
 */

public class AdapterYesterday extends RecyclerView.Adapter<AdapterYesterday.HolderData>{

    private List<Yesterday> yesterdayData;

    public AdapterYesterday(List<Yesterday> yesterdayData) {
        this.yesterdayData = yesterdayData;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_yesterday, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Yesterday yesterday = yesterdayData.get(position);
        holder.id = yesterday.getId();
        holder.txName.setText(yesterday.getName());
        holder.txTime.setText(yesterday.getTime());
        holder.txAct.setText(yesterday.getAct());
        holder.txCons.setText(yesterday.getCons());
        holder.txPrev.setText(yesterday.getPrev());
        holder.txCurrency = yesterday.getCurrency();
        holder.pgrRate.setProgress(yesterday.getRate());
    }

    @Override
    public int getItemCount() {
        return yesterdayData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public int id;
        public TextView txTime;
        public TextView txName;
        public TextView txAct;
        public TextView txCons;
        public TextView txPrev;
        public String txCurrency;
        public ImageView txFlag;
        public ProgressBar pgrRate;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txTime = (TextView) itemView.findViewById(R.id.tx_time);
            txName = (TextView) itemView.findViewById(R.id.tx_name);
            txAct = (TextView) itemView.findViewById(R.id.tx_act);
            txCons = (TextView) itemView.findViewById(R.id.tx_cons);
            txPrev = (TextView) itemView.findViewById(R.id.tx_prev);
            txFlag = (ImageView) itemView.findViewById(R.id.image_flag);
            pgrRate = (ProgressBar) itemView.findViewById(R.id.pgr_rate);
        }
        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, ECSelectedActivity.class);
            intent.putExtra("name", txName.getText().toString());
            intent.putExtra("rate", String.valueOf(pgrRate.getProgress()));
            context.startActivity(intent);
        }
    }

    public void updateList(List<Yesterday> list){
        yesterdayData = list;
        notifyDataSetChanged();
    }
}
