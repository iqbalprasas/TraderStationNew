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

import com.example.telc2.traderstation.model.TopTrader;

import java.util.List;

/**
 * Created by iqbal on 12/13/2017.
 */

public class TopTraderAdapter extends RecyclerView.Adapter<TopTraderAdapter.HolderData> {
    private List<TopTrader> topTraderData;

    public TopTraderAdapter(List<TopTrader> topTraderData) {
        this.topTraderData = topTraderData;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_top_trader, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        TopTrader topTrader = topTraderData.get(position);
        holder.id = topTrader.getId();
        holder.txName.setText(topTrader.getUsername());
//        holder.txProfit.setText(topTrader.getProfit());
//        holder.txGain.setText(topTrader.getGain());
//        holder.txBalance.setText(topTrader.getBalance());
//        holder.txEquity.setText(topTrader.getEquity());
//        holder.txOpen.setText(topTrader.getOpen());
//        holder.txClose.setText(topTrader.getClose());
    }

    @Override
    public int getItemCount() {
        return topTraderData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public int id;
        public TextView txProfit;
        public TextView txName;
        public TextView txGain;
        public TextView txBalance;
        public TextView txEquity;
        public TextView txOpen;
        public TextView txClose;
        public ImageView imgFlag;
        public ImageView imgProfile;
        //public ProgressBar pgrRate;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txProfit = (TextView) itemView.findViewById(R.id.tx_profit_comp);
            txName = (TextView) itemView.findViewById(R.id.tx_username_comp);
            txGain = (TextView) itemView.findViewById(R.id.tx_gain_comp);
            txBalance = (TextView) itemView.findViewById(R.id.tx_balance_comp);
            txEquity = (TextView) itemView.findViewById(R.id.tx_equity_comp);
            txOpen = (TextView) itemView.findViewById(R.id.tx_ot_comp);
            txClose = (TextView) itemView.findViewById(R.id.tx_ct_comp);
            imgFlag = (ImageView) itemView.findViewById(R.id.img_flag_comp);
            imgProfile = (ImageView) itemView.findViewById(R.id.img_profile_comp);
        }
        @Override
        public void onClick(View view) {
//            Context context = view.getContext();
//            Intent intent = new Intent(context, ECSelectedActivity.class);
//            intent.putExtra("name", txName.getText().toString());
//            intent.putExtra("rate", String.valueOf(pgrRate.getProgress()));
//            context.startActivity(intent);
        }
    }

    public void updateList(List<TopTrader> list){
        topTraderData = list;
        notifyDataSetChanged();
    }
}
