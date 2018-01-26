package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 1/17/2018.
 */

public class EventSelectedActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar_event_selected);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_event_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
