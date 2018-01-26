package com.example.telc2.traderstation.adapter;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.Broker;
import com.example.telc2.traderstation.model.RebateBroker;

import java.util.List;

/**
 * Created by iqbal on 12/15/2017.
 */

public class RebateBrokerAdapter extends RecyclerView.Adapter<RebateBrokerAdapter.HolderData> {

    private List<RebateBroker> rebateBrokerList;

    public RebateBrokerAdapter(List<RebateBroker> rebateBrokerList) {
        this.rebateBrokerList = rebateBrokerList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rebate_broker, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        RebateBroker rebateBroker = rebateBrokerList.get(position);
        holder.id = rebateBroker.getId();
    }

    @Override
    public int getItemCount() {
        return rebateBrokerList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        public int id;
        public ImageView imgBroker;
        public TextView txRebate;
        public Button btnJoin;

        public HolderData(View itemView) {
            super(itemView);
            txRebate = (TextView) itemView.findViewById(R.id.tx_rebate_rb);
            imgBroker = (ImageView) itemView.findViewById(R.id.img_broker_rb);
            btnJoin = (Button) itemView.findViewById(R.id.btn_join_rb);
            btnJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    btnJoin.setBackground(v.getResources().getDrawable(R.drawable.button_join_rb_2));
                                    btnJoin.setText("Joined");
                                    btnJoin.setClickable(false);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Are You sure want to join ?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                }
            });
        }


    }

    public void updateList(List<RebateBroker> list){
        rebateBrokerList = list;
        notifyDataSetChanged();
    }
}
