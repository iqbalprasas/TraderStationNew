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
import com.example.telc2.traderstation.adapter.AdapterStatusSurat;
import com.example.telc2.traderstation.model.StatusSurat;

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
public class StatusSuratFragment extends Fragment {

    List<StatusSurat> statusSuratList = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterStatusSurat adapterStatusSurat;
    String myJSON;
    JSONArray data = null;
    String stream = null;

    public StatusSuratFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_status_surat, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerStatusSurat);

        adapterStatusSurat = new AdapterStatusSurat(statusSuratList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterStatusSurat);
        loadData();

        return v;
    }

    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            data = jsonObj.getJSONArray("result_surat");

            for(int i=0;i<data.length();i++){
                JSONObject c = data.getJSONObject(i);
                String id = c.getString("id");
                String tglp = c.getString("tglp");
                String tglk = c.getString("tglk");
                String jmlkunci = c.getString("jmlkunci");
                String status = c.getString("status");

                //HashMap<String,String> listdata = new HashMap<String,String>();

                StatusSurat statusSurat = new StatusSurat(id, tglp, tglk, jmlkunci, status);
                statusSuratList.add(statusSurat);
                adapterStatusSurat.notifyDataSetChanged();
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
                    URL url = new URL("http://128.199.68.188/TELKOMSEL/pages/read_surat_android.php");
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
