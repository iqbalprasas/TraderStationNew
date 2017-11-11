package com.example.telc2.traderstation.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.traderstation.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

/**
 * A simple {@link Fragment} subclass.
 */
public class KotakMasukFragment extends Fragment {

    Button refresh, download, setuju, tolak;
    TextView txid, txtglp, txtglk, txjmlkunci, txnama;
    String myJSON;
    JSONArray data = null;
    String link,stream,status = null;

    public KotakMasukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_kotak_masuk, container, false);
        refresh = (Button)v.findViewById(R.id.btn_refresh);
        download = (Button)v.findViewById(R.id.btn_download);
        setuju = (Button)v.findViewById(R.id.btn_setuju);
        tolak = (Button)v.findViewById(R.id.btn_tolak);
        txid = (TextView)v.findViewById(R.id.tx_signid);
        txtglp = (TextView)v.findViewById(R.id.tx_tgl_pinjam_surat);
        txtglk = (TextView)v.findViewById(R.id.tx_tglkembali_surat);
        txjmlkunci = (TextView)v.findViewById(R.id.tx_jmlkuncisurat);
        txnama = (TextView)v.findViewById(R.id.tx_nama);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(link));
                startActivity(myWebLink);
            }
        });

        setuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "1";
                new SendPostRequest().execute();
            }
        });

        tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "0";
                new SendPostRequest().execute();
            }
        });
    }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result_kotakmasuk");

            for(int i=0;i<1;i++){
                JSONObject c = data.getJSONObject(i);
                String id = c.getString("id");
                String nama = c.getString("nama");
                String tglp = c.getString("tglp");
                String tglk = c.getString("tglk");
                String jmlkunci = c.getString("jmlkunci");
                String status = c.getString("status");

                txid.setText(id);
                txtglp.setText(tglp);
                txtglk.setText(tglk);
                txjmlkunci.setText(jmlkunci);
                txnama.setText(nama);
                link = status;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void loadData() {

        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                try{
                    URL url = new URL("http://128.199.68.188/TELKOMSEL/pages/read_kotakmasuk_android.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Check the connection status
                    if(urlConnection.getResponseCode() == 200)
                    {
                        // if response code = 200 ok
                        InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                        // Read the BufferedInputStream
                        BufferedReader r = new BufferedReader(new InputStreamReader(in));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = r.readLine()) != null) {
                            sb.append(line);
                        }
                        stream = sb.toString();
                        // End reading...............

                        // Disconnect the HttpURLConnection
                        urlConnection.disconnect();
                    }
                    else
                    {
                        // Do something
                    }
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }finally {

                }
                // Return the data from specified url
                return stream;
            }

            @Override
            protected void onPostExecute(String result){
                myJSON=result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {
                URL url = new URL("http://128.199.68.188/TELKOMSEL/pages/save_status_android.php");

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("id", txid.getText().toString());
                postDataParams.put("status", status);
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
            Toast.makeText(getView().getContext(), result,
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
