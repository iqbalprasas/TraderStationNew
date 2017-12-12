package com.example.telc2.traderstation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.activity.WebinarSelectedActivity;
import com.example.telc2.traderstation.model.Webinar;

import java.util.List;

/**
 * Created by iqbal on 12/8/2017.
 */

public class AdapterWebinar extends RecyclerView.Adapter<AdapterWebinar.HolderData>{

    private List<Webinar> webinarData;

    public AdapterWebinar(List<Webinar> webinarData) {
        this.webinarData = webinarData;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_webinar, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Webinar webinar = webinarData.get(position);
        holder.id = webinar.getIdWebinar();
        holder.txTitle.setText(webinar.getTitle());
        holder.txDate.setText(webinar.getDate());
        holder.txDesc.setText(webinar.getDesc());
    }

    @Override
    public int getItemCount() {
        return webinarData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public String id;
        public TextView txTitle;
        public TextView txDate;
        public TextView txDesc;
        public ImageView txImg;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txTitle = (TextView) itemView.findViewById(R.id.text_webinar_title);
            txDate = (TextView) itemView.findViewById(R.id.text_webinar_date);
            txDesc = (TextView) itemView.findViewById(R.id.text_webinar_desc);
            txImg = (ImageView) itemView.findViewById(R.id.img_webinar);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, WebinarSelectedActivity.class);
            intent.putExtra("title", txTitle.getText().toString());
            intent.putExtra("desc", txDesc.getText().toString());
            context.startActivity(intent);
        }
    }

    public void updateList(List<Webinar> list){
        webinarData = list;
        notifyDataSetChanged();
    }

}
