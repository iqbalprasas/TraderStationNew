package com.example.telc2.traderstation.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.AdapterMasaTenggang;
import com.example.telc2.traderstation.model.MasaTenggang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasaTenggangKunciFragment extends Fragment {

    List<MasaTenggang> masaTenggangList = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterMasaTenggang adapterMasaTenggang;
    String myJSON;
    JSONArray data = null;
    String stream = null;

    public MasaTenggangKunciFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_masa_tenggang_kunci, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerMasaTenggang);

        adapterMasaTenggang = new AdapterMasaTenggang(masaTenggangList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterMasaTenggang);
        loadData();

        return v;
    }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result_masatenggang");

            for(int i=0;i<data.length();i++){
                JSONObject c = data.getJSONObject(i);
                String id = c.getString("id");
                String bts = c.getString("bts");
                String nama = c.getString("nama");
                String inst = c.getString("inst");
                String nohp = c.getString("nohp");
                String tglp = c.getString("tglp");
                String tglk = c.getString("tglk");
                String jmlkunci = c.getString("jmlkunci");

                MasaTenggang masaTenggang = new MasaTenggang(id, bts, nama, inst, nohp, tglp, tglk, jmlkunci);
                masaTenggangList.add(masaTenggang);
                adapterMasaTenggang.notifyDataSetChanged();
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
                    URL url = new URL("http://128.199.68.188/TELKOMSEL/pages/read_masatenggang_android.php");
                    //URL url = new URL("http://192.168.2.50/rrr/read_masatenggang.php");
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

}
