package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.adapter.ShopAdapter;
import com.example.telc2.traderstation.helper.ExpandableHeightGridView;

import java.util.HashMap;

/**
 * Created by iqbal on 1/29/2018.
 */

public class ShopActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private Toolbar toolbar;
    ImageButton back;
    ImageView btnKeranjang;
    private SliderLayout sliderShop;
    ExpandableHeightGridView gridShop;
    boolean discount[] = {false,true,false,true};
    boolean ls[] =  {true,false,true,false};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        sliderShop = (SliderLayout)findViewById(R.id.slider_shop);
        toolbar = (Toolbar) findViewById(R.id.toolbar_shop);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_shop);
        btnKeranjang = (ImageView)toolbar.findViewById((R.id.btn_keranjang_shop));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShopActivity.this, "Keranjang", Toast.LENGTH_SHORT).show();
            }
        });

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("1", "https://blitz-ea.com/assets/img/logo-besar.png");
        url_maps.put("2", "https://blitz-ea.com/assets/img/product/silver.jpg");
        url_maps.put("3", "https://blitz-ea.com/assets/img/logo-besar.png");
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(ShopActivity.this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderShop.addSlider(textSliderView);
        }
        sliderShop.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderShop.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderShop.setCustomAnimation(new DescriptionAnimation());
        sliderShop.setDuration(4000);
        sliderShop.addOnPageChangeListener(this);

        gridShop = (ExpandableHeightGridView)findViewById(R.id.gridview_shop);
        gridShop.setExpanded(true);
        // Create an object of CustomAdapter and set Adapter to GirdView
        ShopAdapter shopAdapter = new ShopAdapter(ShopActivity.this, discount,ls);
        gridShop.setAdapter(shopAdapter);
        // implement setOnItemClickListener event on GridView
        gridShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                //Intent intent = new Intent(BrokerActivity.this, ReviewBrokerActivity.class);
                //startActivity(intent); // start Intent
            }
        });
    }

    @Override
    public void onStop() {
        sliderShop.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
