package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 12/8/2017.
 */

public class WebinarSelectedActivity extends AppCompatActivity {

    TextView titleWebinar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_selected);

        String s = getIntent().getStringExtra("title");
        titleWebinar = (TextView)findViewById(R.id.text_webinar_title_selected);
        titleWebinar.setText(s);
    }
}
