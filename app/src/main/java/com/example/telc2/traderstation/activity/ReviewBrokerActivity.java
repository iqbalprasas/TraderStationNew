package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 12/15/2017.
 */

public class ReviewBrokerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_broker);

        toolbar = (Toolbar) findViewById(R.id.toolbar_review_broker);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_review_broker);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
