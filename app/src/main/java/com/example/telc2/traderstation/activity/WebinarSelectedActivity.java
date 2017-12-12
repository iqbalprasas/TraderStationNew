package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 12/8/2017.
 */

public class WebinarSelectedActivity extends AppCompatActivity {

    TextView titleWebinar, descWebinar;
    private Toolbar toolbar;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar_webinar_selected);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_webinar_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String s = getIntent().getStringExtra("title");
        titleWebinar = (TextView)findViewById(R.id.text_webinar_title_selected);
        titleWebinar.setText(s);
        descWebinar = (TextView) findViewById(R.id.text_webinar_desc_selected);
        s = getIntent().getStringExtra("desc");
        descWebinar.setText(s);
    }
}
