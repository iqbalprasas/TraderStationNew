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
import com.example.telc2.traderstation.activity.TimelineSelectedActivity;
import com.example.telc2.traderstation.model.Timeline;

import java.util.List;

/**
 * Created by iqbal on 11/14/2017.
 */

public class AdapterTimeline extends RecyclerView.Adapter<AdapterTimeline.HolderData> {
    private List<Timeline> timelineList;

    public AdapterTimeline(List<Timeline> timelineList) {
        this.timelineList = timelineList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_timeline, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Timeline timeline = timelineList.get(position);
        holder.txTime.setText(timeline.getTime());
        //holder.txProfilePhoto
        holder.txProfileName.setText(timeline.getProfileName());
        //holder.txPostPhoto
        holder.txStatus.setText(timeline.getStatus());
        if(!holder.txStatus.getText().equals("News")){
            holder.txPostPhoto.setVisibility(View.GONE);
            holder.txDesc1.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return timelineList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txIdTimeline;
        public ImageView txProfilePhoto;
        public TextView txProfileName;
        public ImageView txPostPhoto;
        public TextView txTime;
        public TextView txDesc;
        public TextView txDesc1;
        public TextView txStatus;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txTime = (TextView) itemView.findViewById(R.id.time_profile_timeline);
            txProfileName = (TextView) itemView.findViewById(R.id.name_profile_timeline);
            txProfilePhoto = (ImageView) itemView.findViewById(R.id.img_profile_timeline);
            txPostPhoto = (ImageView) itemView.findViewById(R.id.img_post_timeline);
            txDesc = (TextView) itemView.findViewById(R.id.desc_profile_timeline);
            txDesc1 = (TextView) itemView.findViewById(R.id.desc_profile_timeline1);
            txStatus = (TextView) itemView.findViewById(R.id.tx_status_timeline);
         }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, TimelineSelectedActivity.class);
            intent.putExtra("isImgExist",txStatus.getText().toString());
            context.startActivity(intent);
        }
    }

    public void updateList(List<Timeline> list){
        timelineList = list;
        notifyDataSetChanged();
    }
}
