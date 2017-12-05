package com.example.telc2.traderstation.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.model.MasaTenggang;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by iqbal on promotion8/promotion8/2017.
 */

public class AdapterMasaTenggang extends RecyclerView.Adapter<AdapterMasaTenggang.HolderData> {
    List<MasaTenggang> masaTenggangList;

    public AdapterMasaTenggang(List<MasaTenggang> masaTenggangList) {
        this.masaTenggangList = masaTenggangList;
    }

    @Override
    public AdapterMasaTenggang.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_masatenggang, parent, false);
        HolderData holderData = new HolderData(v);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        MasaTenggang masaTenggang = masaTenggangList.get(position);
        holder.txId.setText(masaTenggang.getId());
        holder.txBts.setText(masaTenggang.getBts());
        holder.txNama.setText(masaTenggang.getNama());
        holder.txNoHP.setText(masaTenggang.getNohp());
        holder.txInstansi.setText(masaTenggang.getInst());
        holder.txTglPinjam.setText(masaTenggang.getTglp());
        holder.txTglKembali.setText(masaTenggang.getTglk());
        holder.txJmlKunci.setText(masaTenggang.getJmlkunci());
    }


    @Override
    public int getItemCount() {
        return masaTenggangList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txId;
        public TextView txBts;
        public TextView txNama;
        public TextView txNoHP;
        public TextView txInstansi;
        public TextView txTglPinjam;
        public TextView txTglKembali;
        public TextView txJmlKunci;


        public HolderData(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txId = (TextView) itemView.findViewById(R.id.tx_sid);
            txBts = (TextView) itemView.findViewById(R.id.tx_bts);
            txNama = (TextView) itemView.findViewById(R.id.tx_nama);
            txNoHP = (TextView) itemView.findViewById(R.id.tx_nohp);
            txInstansi = (TextView) itemView.findViewById(R.id.tx_instansi);
            txTglPinjam = (TextView) itemView.findViewById(R.id.tx_tglp);
            txTglKembali = (TextView) itemView.findViewById(R.id.tx_tglk);
            txJmlKunci = (TextView) itemView.findViewById(R.id.tx_jmlkunci);
        }

        @Override
        public void onClick(View view) {
            //Log.d(TAG, "onClick " + getPosition() + " " + mItem);
            //Toast.makeText(view.getContext(), txNama.getText().toString(),Toast.LENGTH_SHORT).show();
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            new SendPostRequest().execute();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setMessage("Anda yakin ID "+txId.getText().toString()+" sudah selesai ?").setPositiveButton("Ya", dialogClickListener)
                    .setNegativeButton("Tidak", dialogClickListener).show();

        }

        public void removeAt(int position) {
            masaTenggangList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, masaTenggangList.size());
        }

        public class SendPostRequest extends AsyncTask<String, Void, String> {

            protected void onPreExecute(){}

            protected String doInBackground(String... arg0) {

                try {
                    URL url = new URL("http://128.199.68.188/TELKOMSEL/pages/delete_masatenggang_android.php");
                    JSONObject postDataParams = new JSONObject();
                    postDataParams.put("id", txId.getText().toString());
                    Log.e("params",postDataParams.toString());

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(15000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(getPostDataString(postDataParams));

                    writer.flush();
                    writer.close();
                    os.close();

                    int responseCode=conn.getResponseCode();

                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        BufferedReader in=new BufferedReader(new
                                InputStreamReader(
                                conn.getInputStream()));

                        StringBuffer sb = new StringBuffer("");
                        String line="";

                        while((line = in.readLine()) != null) {

                            sb.append(line);
                            break;
                        }

                        in.close();
                        return sb.toString();

                    }
                    else {
                        return new String("false : "+responseCode);
                    }
                }
                catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }

            }

            @Override
            protected void onPostExecute(String result) {
                if(result.equals("Berhasil dihapus")){
                    removeAt(getAdapterPosition());
                }
                Toast.makeText(itemView.getContext(), result,
                        Toast.LENGTH_LONG).show();
            }
        }

        public String getPostDataString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while(itr.hasNext()){

                String key= itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));

            }
            return result.toString();
        }
    }
}

