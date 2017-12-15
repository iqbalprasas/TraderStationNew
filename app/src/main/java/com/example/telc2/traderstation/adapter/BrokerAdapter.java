package com.example.telc2.traderstation.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.ReviewBrokerActivity;
import com.example.telc2.traderstation.model.Broker;
import java.util.List;

/**
 * Created by iqbal on 12/15/2017.
 */

public class BrokerAdapter extends RecyclerView.Adapter<BrokerAdapter.HolderData> {
    private List<Broker> brokerList;

    public BrokerAdapter(List<Broker> brokerList) {
        this.brokerList = brokerList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_broker, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Broker broker = brokerList.get(position);
        holder.id = broker.getId();
        holder.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ReviewBrokerActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brokerList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        public int id;
        public Button btnReview;

        public HolderData(View itemView) {
            super(itemView);
            btnReview = (Button) itemView.findViewById(R.id.btn_review_broker);
        }


    }

    public void updateList(List<Broker> list){
        brokerList = list;
        notifyDataSetChanged();
    }
}
