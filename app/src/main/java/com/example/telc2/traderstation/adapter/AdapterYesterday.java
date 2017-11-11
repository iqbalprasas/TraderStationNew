package com.example.telc2.traderstation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
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
        holder.txName.setText(yesterday.getName());
        holder.txTime.setText(yesterday.getTime());
        holder.txRate.setText(yesterday.getRate());
        holder.txAct.setText(yesterday.getAct());
        holder.txCons.setText(yesterday.getCons());
        holder.txPrev.setText(yesterday.getPrev());
        holder.txCurrency.setText(yesterday.getCurrency());
    }

    @Override
    public int getItemCount() {
        return yesterdayData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txTime;
        public TextView txName;
        public TextView txRate;
        public TextView txAct;
        public TextView txCons;
        public TextView txPrev;
        public TextView txCurrency;
        public ImageView txFlag;

        public HolderData(View itemView) {
            super(itemView);
            txTime = (TextView) itemView.findViewById(R.id.tx_time);
            txName = (TextView) itemView.findViewById(R.id.tx_name);
            txRate = (TextView) itemView.findViewById(R.id.tx_rate);
            txAct = (TextView) itemView.findViewById(R.id.tx_act);
            txCons = (TextView) itemView.findViewById(R.id.tx_cons);
            txPrev = (TextView) itemView.findViewById(R.id.tx_prev);
            txCurrency = (TextView) itemView.findViewById(R.id.tx_currency);
            txFlag = (ImageView) itemView.findViewById(R.id.image_flag);
        }
    }
}
