package com.example.telc2.traderstation.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 11/15/2017.
 */

public class SearchResultActivity extends AppCompatActivity {

    private TextView hasil;
    private String key;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        hasil = (TextView)findViewById(R.id.textViewTes);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            key = intent.getStringExtra("key");
            Toast.makeText(SearchResultActivity.this, query, Toast.LENGTH_LONG).show();
            hasil.setText(key+" "+query);
        }
    }

}
