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
import com.example.telc2.traderstation.model.Comment;

import java.util.List;

/**
 * Created by iqbal on 1/19/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.HolderData> {
    private List<Comment> commentList;

    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_comment, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Comment comment = commentList.get(position);
        holder.txProfileName.setText(comment.getName());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txId;
        public TextView txProfileName;

        public HolderData(View itemView) {
            super(itemView);
            txProfileName = (TextView) itemView.findViewById(R.id.name_profile_comment);
        }
    }

    public void updateList(List<Comment> list){
        commentList = list;
        notifyDataSetChanged();
    }
}
