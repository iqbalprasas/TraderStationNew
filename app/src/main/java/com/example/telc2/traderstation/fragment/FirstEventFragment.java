package com.example.telc2.traderstation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.telc2.traderstation.R;
import com.example.telc2.traderstation.config.MyWebViewClient;
import java.util.HashMap;


/**
 * Created by iqbal on 12/13/2017.
 */

public class FirstEventFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    WebView webView;
    private SliderLayout sliderEvent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_first_event, container, false);

        sliderEvent = (SliderLayout)v.findViewById(R.id.slider_event);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("1", "https://www.tradersdna.com/wp-content/uploads/2014/10/elite-trader.jpg");
        url_maps.put("2", "https://www.tradersdna.com/wp-content/uploads/2014/08/Wall-street-trader.jpg");
        url_maps.put("3", "https://d2td6mzj4f4e1e.cloudfront.net/wp-content/uploads/sites/9/2016/10/QRetailAwards-286-620x330.jpg");
        url_maps.put("4", "https://www.financemagnates.com/wp-content/uploads/fxmag/2014/05/IMG_1639.jpg");
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
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

        webView = (WebView) v.findViewById(R.id.web_event);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
//                progressBar.setProgress(progress);
//                if (progress == 100) {
//                    progressBar.setVisibility(View.GONE);
//
//                } else {
//                    progressBar.setVisibility(View.VISIBLE);
//
//                }
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("https://www.youtube.com/embed/w2EogFoqHtY?autoplay=0&vq=small");
        return v;
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
