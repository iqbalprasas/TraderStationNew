package com.example.telc2.traderstation.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.AlbumSelectedActivity;
import com.example.telc2.traderstation.model.Latest;

import java.util.List;

/**
 * Created by iqbal on 1/24/2018.
 */

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.HolderData> {

    private List<Latest> latestList;

    public LatestAdapter(List<Latest> latestList) {
        this.latestList = latestList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_latest, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Latest latest = latestList.get(position);
        holder.id = latest.getId();
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AlbumSelectedActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return latestList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        public String id;
        public Button btnView;

        public HolderData(View itemView) {
            super(itemView);
            btnView = (Button) itemView.findViewById(R.id.btn_view_gallery);
        }


    }

    public void updateList(List<Latest> list){
        latestList = list;
        notifyDataSetChanged();
    }
}
