package com.example.telc2.traderstation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.StatusSurat;

import java.util.List;

/**
 * Created by juvetic on broker6/16/17.
 */

public class AdapterStatusSurat extends RecyclerView.Adapter<AdapterStatusSurat.HolderData>{

    List<StatusSurat> statusSuratList;

    public AdapterStatusSurat(List<StatusSurat> statusSuratList) {
        this.statusSuratList = statusSuratList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_statsurat, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        StatusSurat statusSurat = statusSuratList.get(position);
        holder.txSignId.setText(statusSurat.getSignId());
        holder.txTglPinjam.setText(statusSurat.getTglPinjam());
        holder.txTglKembali.setText(statusSurat.getTglKembali());
        holder.txJmlKunci.setText(statusSurat.getJmlKunci());
        holder.txStatusSurat.setText(statusSurat.getStatusSurat());
    }

    @Override
    public int getItemCount() {
        return statusSuratList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txSignId;
        public TextView txTglPinjam;
        public TextView txTglKembali;
        public TextView txJmlKunci;
        public TextView txStatusSurat;

        public HolderData(View itemView) {
            super(itemView);
            txSignId = (TextView) itemView.findViewById(R.id.tx_signid);
            txTglPinjam = (TextView) itemView.findViewById(R.id.tx_tgl_pinjam_surat);
            txTglKembali = (TextView) itemView.findViewById(R.id.tx_tglkembali_surat);
            txJmlKunci = (TextView) itemView.findViewById(R.id.tx_jmlkuncisurat);
            txStatusSurat = (TextView) itemView.findViewById(R.id.tx_statussurat);
        }
    }
}