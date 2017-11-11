package com.example.telc2.traderstation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.DataPeminjam;

import java.util.List;

/**
 * Created by iqbal on 8/7/2017.
 */

public class AdapterDataPeminjam extends RecyclerView.Adapter<AdapterDataPeminjam.HolderData>{
    List<DataPeminjam> dataPeminjamList;

    public AdapterDataPeminjam(List<DataPeminjam> dataPeminjamListList) {
        this.dataPeminjamList = dataPeminjamListList;
    }

    @Override
    public AdapterDataPeminjam.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_datapeminjam, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        DataPeminjam dataPeminjam = dataPeminjamList.get(position);
        holder.txSignId.setText(dataPeminjam.getId());
        holder.txnama.setText(dataPeminjam.getTglPinjam());
        holder.txNoHP.setText(dataPeminjam.getNohp());
        holder.txNoID.setText(dataPeminjam.getNoid());
        holder.txInstansi.setText(dataPeminjam.getInstansi());
        holder.txPekerjaan.setText(dataPeminjam.getPekerjaan());
        holder.txKdSite.setText(dataPeminjam.getKdsite());
        holder.txTglPinjam.setText(dataPeminjam.getTglPinjam());
        holder.txTglKembali.setText(dataPeminjam.getTglKembali());
        holder.txJmlKunci.setText(dataPeminjam.getJmlKunci());
        holder.txSuratVendor.setText(dataPeminjam.getSurat());
    }

    @Override
    public int getItemCount() {
        return dataPeminjamList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{

        public TextView txSignId;
        public TextView txnama;
        public TextView txNoHP;
        public TextView txNoID;
        public TextView txInstansi;
        public TextView txPekerjaan;
        public TextView txKdSite;
        public TextView txTglPinjam;
        public TextView txTglKembali;
        public TextView txJmlKunci;
        public TextView txSuratVendor;

        public HolderData(View itemView) {
            super(itemView);
            txSignId = (TextView) itemView.findViewById(R.id.tx_signid);
            txnama = (TextView) itemView.findViewById(R.id.tx_nama);
            txNoHP = (TextView) itemView.findViewById(R.id.tx_nohp);
            txNoID = (TextView) itemView.findViewById(R.id.tx_noid);
            txInstansi = (TextView) itemView.findViewById(R.id.tx_instansi);
            txPekerjaan = (TextView) itemView.findViewById(R.id.tx_pekerjaan);
            txKdSite = (TextView) itemView.findViewById(R.id.tx_kdsite);
            txTglPinjam = (TextView) itemView.findViewById(R.id.tx_tglp);
            txTglKembali = (TextView) itemView.findViewById(R.id.tx_tglk);
            txJmlKunci = (TextView) itemView.findViewById(R.id.tx_jmlkunci);
            txSuratVendor = (TextView) itemView.findViewById(R.id.tx_suratvendor);
        }
    }
}
