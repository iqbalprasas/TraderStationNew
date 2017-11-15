package com.example.telc2.traderstation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
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
        holder.txIdTimeline.setText(timeline.getIdTimeline());
        holder.txTime.setText(timeline.getTime());
        //holder.txProfilePhoto
        holder.txProfileName.setText(timeline.getProfileName());
        //holder.txPostPhoto
        holder.txDesc.setText(timeline.getDesc());
        holder.txNumLike.setText(timeline.getNumLike());
        holder.txNumDislike.setText(timeline.getNumDislike());
        holder.txNumComment.setText(timeline.getNumComment());
        holder.txNumShare.setText(timeline.getNumShare());
    }

    @Override
    public int getItemCount() {
        return timelineList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txIdTimeline;
        public ImageView txProfilePhoto;
        public TextView txProfileName;
        public ImageView txPostPhoto;
        public TextView txTime;
        public TextView txDesc;
        public TextView txNumLike;
        public TextView txNumDislike;
        public TextView txNumComment;
        public TextView txNumShare;

        public HolderData(View itemView) {
            super(itemView);
            txTime = (TextView) itemView.findViewById(R.id.time_profile_timeline);
            txIdTimeline = (TextView) itemView.findViewById(R.id.id_id_timeline);
            txProfileName = (TextView) itemView.findViewById(R.id.name_profile_timeline);
            txProfilePhoto = (ImageView) itemView.findViewById(R.id.img_profile_timeline);
            txPostPhoto = (ImageView) itemView.findViewById(R.id.img_post_timeline);
            txDesc = (TextView) itemView.findViewById(R.id.desc_profile_timeline);
            txNumLike = (TextView) itemView.findViewById(R.id.id_like_timeline);
            txNumDislike = (TextView) itemView.findViewById(R.id.id_dislike_timeline);
            txNumComment = (TextView) itemView.findViewById(R.id.id_comment_timeline);
            txNumShare = (TextView) itemView.findViewById(R.id.id_share_timeline);
        }
    }

    public void updateList(List<Timeline> list){
        timelineList = list;
        notifyDataSetChanged();
    }
}
