package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telc2.traderstation.R;

/**
 * Created by iqbal on 12/8/2017.
 */

public class WebinarSelectedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView titleWebinar, descWebinar;
    private Toolbar toolbar;
    ImageButton back;
    String[] country={"","Indonesia","United Kingdom","Japan","China"};

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

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spin_webinar);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        //Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub

    }
}
