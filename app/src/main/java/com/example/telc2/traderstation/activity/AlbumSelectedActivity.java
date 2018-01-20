package com.example.telc2.traderstation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.telc2.traderstation.R;

import java.util.HashMap;

/**
 * Created by iqbal on 1/2/2018.
 */

public class AlbumSelectedActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private Toolbar toolbar;
    ImageButton back;
    private SliderLayout sliderEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_selected);

        sliderEvent = (SliderLayout)findViewById(R.id.slider_album_selected);
        toolbar = (Toolbar) findViewById(R.id.toolbar_album_selected);
        back = (ImageButton)toolbar.findViewById(R.id.btn_back_album_selected);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("1", "https://www.tradersdna.com/wp-content/uploads/2014/10/elite-trader.jpg");
        url_maps.put("2", "https://www.tradersdna.com/wp-content/uploads/2014/08/Wall-street-trader.jpg");
        url_maps.put("3", "https://d2td6mzj4f4e1e.cloudfront.net/wp-content/uploads/sites/9/2016/10/QRetailAwards-286-620x330.jpg");
        url_maps.put("4", "https://www.financemagnates.com/wp-content/uploads/fxmag/2014/05/IMG_1639.jpg");
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(AlbumSelectedActivity.this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderEvent.addSlider(textSliderView);
        }
        sliderEvent.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderEvent.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderEvent.setCustomAnimation(new DescriptionAnimation());
        sliderEvent.setDuration(4000);
        sliderEvent.addOnPageChangeListener(this);
    }

    @Override
    public void onStop() {
        sliderEvent.stopAutoCycle();
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
