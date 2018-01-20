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
import com.example.telc2.traderstation.activity.ChattingActivity;
import com.example.telc2.traderstation.model.Chat;

import java.util.List;

/**
 * Created by iqbal on 11/15/2017.
 */

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.HolderData>{

    private List<Chat> chatList;

    public AdapterChat(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Chat chat = chatList.get(position);
        holder.txChat.setText(chat.getChat());
        //holder.txProfilePhoto
        holder.txProfileName.setText(chat.getProfileName());
        holder.txNumChat.setText(chat.getNumChat());
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txIdChat;
        public ImageView txProfilePhoto;
        public TextView txProfileName;
        public TextView txChat;
        public TextView txNumChat;

        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txChat = (TextView) itemView.findViewById(R.id.highlight_profile_chat);
            txProfileName = (TextView) itemView.findViewById(R.id.name_profile_chat);
            txNumChat = (TextView) itemView.findViewById(R.id.num_profile_chat);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, ChattingActivity.class);
            intent.putExtra("profileName", txProfileName.getText().toString());
            context.startActivity(intent);
        }

    }

    public void updateList(List<Chat> list){
        chatList = list;
        notifyDataSetChanged();
    }

}
