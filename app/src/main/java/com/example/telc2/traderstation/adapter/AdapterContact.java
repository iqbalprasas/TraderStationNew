package com.example.telc2.traderstation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.Contact;

import java.util.List;

/**
 * Created by iqbal on 11/15/2017.
 */

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.HolderData>{

    private List<Contact> contactList;

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Contact contact = contactList.get(position);
        holder.txContactName.setText(contact.getContactName());
        //holder.txContactPhoto
        holder.txContactStatus.setText(contact.getContactStatus());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txIdContact;
        public ImageView txContactPhoto;
        public TextView txContactName;
        public TextView txContactStatus;

        public HolderData(View itemView) {
            super(itemView);
            txContactName = (TextView) itemView.findViewById(R.id.name_profile_contact);
            txContactStatus = (TextView) itemView.findViewById(R.id.status_profile_contact);
        }
    }

    public void updateList(List<Contact> list){
        contactList = list;
        notifyDataSetChanged();
    }
}
